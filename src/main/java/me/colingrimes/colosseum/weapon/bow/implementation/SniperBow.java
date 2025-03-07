package me.colingrimes.colosseum.weapon.bow.implementation;

import me.colingrimes.colosseum.Colosseum;
import me.colingrimes.colosseum.weapon.bow.BaseBow;
import me.colingrimes.colosseum.weapon.bow.BowEventInfo;
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

public class SniperBow extends BaseBow {

	private final Set<UUID> players = new HashSet<>();

	public SniperBow(@Nonnull Colosseum plugin) {
		super("sniper", "&c&lSniper", "&7Fully charged shots never miss.");
	}

	@Override
	public void activate(@Nonnull PlayerInteractEvent event, @Nonnull BowEventInfo info) {
		if (!event.getAction().name().startsWith("LEFT_CLICK")) {
			return;
		}

		Player player = event.getPlayer();
		if (!players.contains(player.getUniqueId())) {
			player.setWalkSpeed(-1F);
			players.add(player.getUniqueId());
		} else {
			player.setWalkSpeed(0.2F);
			players.remove(player.getUniqueId());
		}
	}

	@Override
	public void activate(@Nonnull EntityShootBowEvent event, @Nonnull BowEventInfo info) {
		Vector velocity = info.arrow().getVelocity();
		if (players.contains(info.shooter().getUniqueId())) {
			velocity = velocity.multiply(10);
		}

		if (isFullyDraw(velocity)) {
			info.arrow().setVelocity(velocity.multiply(5));
			Location eye = info.shooter().getEyeLocation();
			info.world().spawnParticle(Particle.SONIC_BOOM, eye.add(eye.getDirection().normalize()), 1);
		}
	}

	@Override
	public void activate(@Nonnull ProjectileHitEvent event, @Nonnull BowEventInfo info) {
		if (isFullyDraw(info.arrow().getVelocity())) {
			info.world().spawnParticle(Particle.CRIT, info.location(), 20);
		}
	}

	private boolean isFullyDraw(@Nonnull Vector velocity) {
		return Math.abs(velocity.getX()) >= 2 || Math.abs(velocity.getY()) >= 2 || Math.abs(velocity.getZ()) >= 2;
	}
}
