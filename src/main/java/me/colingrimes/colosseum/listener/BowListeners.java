package me.colingrimes.colosseum.listener;

import me.colingrimes.colosseum.Colosseum;
import me.colingrimes.colosseum.weapon.bow.CustomBow;
import me.colingrimes.midnight.scheduler.Scheduler;
import me.colingrimes.midnight.util.io.Logger;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import javax.annotation.Nonnull;
import java.util.HashMap;
import java.util.Map;

public class BowListeners implements Listener {

	private final Colosseum plugin;
	private final Map<Entity, CustomBow> firedArrows = new HashMap<>();

	public BowListeners(@Nonnull Colosseum plugin) {
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
	public void onBowInteract(final PlayerInteractEvent event) {
		plugin.findBow(event.getItem()).ifPresent(b -> b.activate(event));
	}

	@EventHandler
	public void onBowFire(final EntityShootBowEvent event) {
		plugin.findBow(event.getBow()).ifPresent(bow -> {
			firedArrows.put(event.getProjectile(), bow);
			bow.activate(event);
		});
	}

	@EventHandler
	public void onArrowHit(final ProjectileHitEvent event) {
		if (event.getEntity() instanceof Arrow && firedArrows.containsKey(event.getEntity())) {
			firedArrows.get(event.getEntity()).activate(event);
		}
	}

	@EventHandler
	public void onEntityArrowHit(final EntityDamageByEntityEvent event) {
		if (event.getDamager() instanceof Arrow && firedArrows.containsKey(event.getDamager())) {
			firedArrows.get(event.getDamager()).activate(event);
			Scheduler.sync().runLater(() -> firedArrows.remove(event.getEntity()), 5L);
		}
	}
}