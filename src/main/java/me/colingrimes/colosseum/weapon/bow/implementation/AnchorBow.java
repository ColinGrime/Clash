package me.colingrimes.colosseum.weapon.bow.implementation;

import me.colingrimes.colosseum.weapon.bow.BaseBow;
import me.colingrimes.colosseum.weapon.bow.BowEventInfo;
import me.colingrimes.midnight.scheduler.Scheduler;
import me.colingrimes.midnight.util.bukkit.Entities;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.entity.ProjectileHitEvent;

import javax.annotation.Nonnull;

public class AnchorBow extends BaseBow {

	public AnchorBow() {
		super("anchor", "&c&lAnchor", "&7Pin enemies to the groud.");
	}

	@Override
	public void activate(@Nonnull ProjectileHitEvent event, @Nonnull BowEventInfo info) {
		Location location;
		if (event.getHitBlock() != null) {
			location = event.getHitBlock().getLocation();
		} else if (event.getHitEntity() != null) {
			location = event.getHitEntity().getLocation();
		} else {
			return;
		}

		info.arrow().remove();
		Location anchorLocation = location.clone().add(0, 1, 0);

		Scheduler.sync().runRepeating(() -> {
			Entities.spawn(anchorLocation, EntityType.EVOKER_FANGS);
			for (Entity entity : Entities.nearby(anchorLocation, 3)) {
				if (entity instanceof LivingEntity livingEntity) {
					livingEntity.teleport(anchorLocation.setDirection(livingEntity.getLocation().getDirection()));
					livingEntity.damage(1);
				}
			}
		}, 0L, 10L, 5 * 20L);
	}
}
