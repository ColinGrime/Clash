package me.colingrimes.primoria.weapon.bow.implementation;

import me.colingrimes.primoria.Primoria;
import me.colingrimes.primoria.weapon.bow.BaseBow;
import me.colingrimes.primoria.weapon.bow.BowEventInfo;
import me.colingrimes.midnight.cache.Cooldown;
import me.colingrimes.midnight.plugin.MidnightPlugin;
import me.colingrimes.midnight.util.Common;
import me.colingrimes.midnight.util.bukkit.Locations;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.util.Vector;

import javax.annotation.Nonnull;
import java.time.Duration;
import java.util.UUID;

public class GrappleBow extends BaseBow implements Listener {

	private final Cooldown<UUID> noFallDamage = Cooldown.create(Duration.ofSeconds(5));

	public GrappleBow(@Nonnull Primoria plugin) {
		super("grapple", "&e&lGrapple", "&7Pulls you toward where the arrow lands.");
		Common.register(MidnightPlugin.get(), this);
	}

	@Override
	public void activate(@Nonnull ProjectileHitEvent event, @Nonnull BowEventInfo info) {
		Vector direction = Locations.direction(info.shooter().getLocation(), info.location());
		double speed = Math.abs(info.arrow().getVelocity().length()) * 2.5;

		Vector launchVelocity = direction.multiply(speed);
		launchVelocity.setY(Math.min(launchVelocity.getY(), 1.8));
		launchVelocity.setY(Math.max(launchVelocity.getY(), 0.5));

		info.shooter().setVelocity(launchVelocity);
		noFallDamage.add(info.shooter().getUniqueId());
	}

	@EventHandler
	public void onEntityDamage(@Nonnull EntityDamageEvent event) {
		UUID uuid = event.getEntity().getUniqueId();
		if (event.getCause() == EntityDamageEvent.DamageCause.FALL && noFallDamage.onCooldown(uuid)) {
			event.setCancelled(true);
			noFallDamage.cancel(uuid);
		}
	}
}
