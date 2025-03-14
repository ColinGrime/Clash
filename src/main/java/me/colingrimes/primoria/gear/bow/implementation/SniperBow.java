package me.colingrimes.primoria.gear.bow.implementation;

import me.colingrimes.midnight.message.Message;
import me.colingrimes.primoria.Primoria;
import me.colingrimes.primoria.config.GearSettings;
import me.colingrimes.primoria.gear.util.GearGrade;
import me.colingrimes.primoria.gear.bow.BowGear;
import me.colingrimes.primoria.gear.bow.BowInfo;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.util.Vector;

import javax.annotation.Nonnull;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class SniperBow extends BowGear {

	private final Set<UUID> players = new HashSet<>();

	public SniperBow(@Nonnull Primoria plugin) {
		super(plugin, "sniper");
	}

	@Nonnull
	@Override
	public Message<?> getName() {
		return GearSettings.BOW_SNIPER_NAME;
	}

	@Nonnull
	@Override
	public Message<?> getDescription() {
		return GearSettings.BOW_SNIPER_DESC;
	}

	@Nonnull
	@Override
	public GearGrade getGrade() {
		return GearGrade.A;
	}

	@Override
	public boolean activate(@Nonnull PlayerInteractEvent event, @Nonnull BowInfo bow) {
		if (!event.getAction().name().startsWith("LEFT_CLICK")) {
			return false;
		}

		Player player = event.getPlayer();
		if (!players.contains(player.getUniqueId())) {
			player.setWalkSpeed(-1F);
			players.add(player.getUniqueId());
		} else {
			player.setWalkSpeed(0.2F);
			players.remove(player.getUniqueId());
		}
		return true;
	}

	@Override
	public boolean activate(@Nonnull EntityShootBowEvent event, @Nonnull BowInfo bow) {
		Vector velocity = bow.arrow().getVelocity();
		if (players.contains(bow.shooter().getUniqueId())) {
			velocity = velocity.multiply(10);
		}

		if (isFullyDraw(velocity)) {
			bow.arrow().setVelocity(velocity.multiply(5));
			Location eye = bow.shooter().getEyeLocation();
			bow.world().spawnParticle(Particle.SONIC_BOOM, eye.add(eye.getDirection().normalize()), 1);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean activate(@Nonnull ProjectileHitEvent event, @Nonnull BowInfo bow) {
		if (isFullyDraw(bow.arrow().getVelocity())) {
			bow.world().spawnParticle(Particle.CRIT, bow.arrowLocation(), 20);
			return true;
		} else {
			return false;
		}
	}

	private boolean isFullyDraw(@Nonnull Vector velocity) {
		return Math.abs(velocity.getX()) >= 2 || Math.abs(velocity.getY()) >= 2 || Math.abs(velocity.getZ()) >= 2;
	}
}
