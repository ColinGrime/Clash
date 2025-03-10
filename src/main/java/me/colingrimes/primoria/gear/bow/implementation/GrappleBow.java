package me.colingrimes.primoria.gear.bow.implementation;

import me.colingrimes.midnight.message.Message;
import me.colingrimes.primoria.Primoria;
import me.colingrimes.primoria.config.GearSettings;
import me.colingrimes.primoria.gear.bow.BowGear;
import me.colingrimes.primoria.gear.bow.BowInfo;
import me.colingrimes.midnight.cache.Cooldown;
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

public class GrappleBow extends BowGear implements Listener {

	private final Cooldown<UUID> noFallDamage = Cooldown.create(Duration.ofSeconds(5));

	public GrappleBow(@Nonnull Primoria plugin) {
		super(plugin, "grapple");
		Common.register(plugin, this);
	}

	@Nonnull
	@Override
	public Message<?> getName() {
		return GearSettings.BOW_GRAPPLE_NAME;
	}

	@Nonnull
	@Override
	public Message<?> getDescription() {
		return GearSettings.BOW_GRAPPLE_DESC;
	}

	@Override
	public void activate(@Nonnull ProjectileHitEvent event, @Nonnull BowInfo bow) {
		Vector direction = Locations.direction(bow.shooterLocation(), bow.arrowLocation());
		double speed = Math.abs(bow.arrow().getVelocity().length()) * 2.5;

		Vector launchVelocity = direction.multiply(speed);
		launchVelocity.setY(Math.min(launchVelocity.getY(), 1.8));
		launchVelocity.setY(Math.max(launchVelocity.getY(), 0.5));

		bow.shooter().setVelocity(launchVelocity);
		noFallDamage.add(bow.shooter().getUniqueId());
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
