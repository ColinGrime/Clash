package me.colingrimes.primoria.gear.bow.listener;

import me.colingrimes.primoria.Primoria;
import me.colingrimes.primoria.gear.bow.BowGear;
import me.colingrimes.midnight.scheduler.Scheduler;
import me.colingrimes.midnight.util.io.Logger;
import org.bukkit.entity.AbstractArrow;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerPickupArrowEvent;

import javax.annotation.Nonnull;
import java.util.HashMap;
import java.util.Map;

public class BowListeners implements Listener {

	private final Primoria plugin;
	private final Map<Arrow, BowGear> firedArrows = new HashMap<>();

	public BowListeners(@Nonnull Primoria plugin) {
		this.plugin = plugin;
		clearDeadArrows();
	}

	/**
	 * Clears dead arrow entities every 20 seconds.
	 */
	private void clearDeadArrows() {
		Scheduler.sync().runRepeating(() -> {
			firedArrows.keySet().removeIf(Entity::isDead);
			if (firedArrows.size() > 100) {
				firedArrows.keySet().forEach(Entity::remove);
				firedArrows.clear();
				Logger.log("Too many arrows are alive! Deleting all current arrows.");
			}
		}, 20 * 20L, 20 * 20L);
	}

	@EventHandler
	public void onPlayerInteract(@Nonnull PlayerInteractEvent event) {
		plugin.findBow(event.getItem()).ifPresent(b -> b.activate(event));
	}

	@EventHandler
	public void onEntityShootBow(@Nonnull EntityShootBowEvent event) {
		if (event.getProjectile() instanceof Arrow arrow) {
			plugin.findBow(event.getBow()).ifPresent(bow -> {
				arrow.setPickupStatus(AbstractArrow.PickupStatus.ALLOWED);
				bow.activate(event);
				firedArrows.put(arrow, bow);
			});
		}
	}

	@EventHandler
	public void onProjectileHit(@Nonnull ProjectileHitEvent event) {
		if (event.getEntity() instanceof Arrow arrow && firedArrows.containsKey(arrow)) {
			firedArrows.get(arrow).activate(event);
		}
	}

	@EventHandler
	public void onEntityDamageByEntity(@Nonnull EntityDamageByEntityEvent event) {
		if (event.getDamager() instanceof Arrow arrow && firedArrows.containsKey(arrow)) {
			firedArrows.get(arrow).activate(event);
		}
	}

	@EventHandler
	public void onPlayerPickupArrow(@Nonnull PlayerPickupArrowEvent event) {
		if (event.getArrow() instanceof Arrow arrow && firedArrows.containsKey(arrow)) {
			firedArrows.get(arrow).activate(event);
		}
	}
}
