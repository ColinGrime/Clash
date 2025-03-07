package me.colingrimes.colosseum.weapon.bow.implementation;

import me.colingrimes.colosseum.Colosseum;
import me.colingrimes.colosseum.weapon.bow.BaseBow;
import me.colingrimes.colosseum.weapon.bow.BowEventInfo;
import me.colingrimes.midnight.scheduler.Scheduler;
import me.colingrimes.midnight.util.bukkit.Entities;
import me.colingrimes.midnight.util.bukkit.Locations;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.util.Vector;

import javax.annotation.Nonnull;

public class HomingBow extends BaseBow {

	public HomingBow(@Nonnull Colosseum plugin) {
		super("homing", "&a&lHoming", "&7Landing an arrow on the ground fires a second homing arrow.");
	}

	@Override
	public void activate(@Nonnull ProjectileHitEvent event, @Nonnull BowEventInfo info) {
		for (Entity entity : Entities.nearby(info.location(), 10)) {
			if (entity instanceof LivingEntity && !entity.equals(event.getEntity().getShooter())) {
				Arrow arrow = info.world().spawnArrow(info.location(), new Vector(0, 0.3, 0), 1.5f, 0);
				Scheduler.sync().runLater(() -> {
					arrow.remove();
					info.world().spawnArrow(arrow.getLocation(), Locations.direction(arrow.getLocation(), entity.getLocation()), 2f, 0);
				}, 5L);
				break;
			}
		}
	}
}
