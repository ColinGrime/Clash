package me.colingrimes.colosseum.weapon.bow.implementation;

import me.colingrimes.colosseum.weapon.bow.BaseBow;
import me.colingrimes.midnight.scheduler.Scheduler;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.ProjectileHitEvent;

import javax.annotation.Nonnull;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class AnchorBow extends BaseBow {

	private final Map<Player, AnchorData> anchors = new HashMap<>();

	public AnchorBow() {
		super("anchor", "&c&lAnchor", "&7Pin enemies to the groud.");
		this.startAnchors();
	}

	@Override
	public void activate(@Nonnull ProjectileHitEvent event) {
		Location location = null;
		if (event.getHitBlock() != null) {
			location = event.getHitBlock().getLocation();
		} else if (event.getHitEntity() != null) {
			location = event.getHitEntity().getLocation();
		}

		if (location != null) {
			anchors.put((Player) event.getEntity().getShooter(), new AnchorData(location.add(0, 1, 0)));
			event.getEntity().remove();
		}
	}

	private void startAnchors() {
		Scheduler.sync().runRepeating(() -> {
			Iterator<Map.Entry<Player, AnchorData>> iterator = anchors.entrySet().iterator();
			while (iterator.hasNext()) {
				AnchorData anchor = iterator.next().getValue();
				if (anchor.time > 10) {
					iterator.remove();
					continue;
				}

				for (Entity entity : anchor.location.getWorld().getNearbyEntities(anchor.location, 3, 3, 3)) {
					if (entity instanceof LivingEntity livingEntity) {
						livingEntity.teleport(anchor.location.setDirection(livingEntity.getLocation().getDirection()));
						livingEntity.damage(1);
					}
				}

				anchor.location.getWorld().spawnEntity(anchor.location, EntityType.EVOKER_FANGS);
				anchor.time += 1;
			}
		}, 0L, 10L);
	}

	private static class AnchorData {
		private final Location location;
		private int time = 0;

		public AnchorData(@Nonnull Location location) {
			this.location = location;
		}
	}
}
