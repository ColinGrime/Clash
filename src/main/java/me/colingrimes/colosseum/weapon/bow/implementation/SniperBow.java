package me.colingrimes.colosseum.weapon.bow.implementation;

import me.colingrimes.colosseum.weapon.bow.BaseBow;
import org.bukkit.Particle;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.util.Vector;

import javax.annotation.Nonnull;

public class SniperBow extends BaseBow {

	public SniperBow() {
		super("sniper", "&c&lSniper", "&7Fully charged shots never miss.");
	}

	@Override
	public void activate(@Nonnull EntityShootBowEvent event) {
		Vector velocity = event.getProjectile().getVelocity();
		if (isFullyDraw(velocity)) {
			event.getProjectile().setVelocity(velocity.multiply(5));
		}
	}

	@Override
	public void activate(@Nonnull ProjectileHitEvent event) {
		if (isFullyDraw(event.getEntity().getVelocity())) {
			event.getEntity().getWorld().spawnParticle(Particle.CRIT, event.getEntity().getLocation(), 20);
		}
	}

	private boolean isFullyDraw(@Nonnull Vector velocity) {
		return Math.abs(velocity.getX()) >= 2 || Math.abs(velocity.getY()) >= 2 || Math.abs(velocity.getZ()) >= 2;
	}
}
