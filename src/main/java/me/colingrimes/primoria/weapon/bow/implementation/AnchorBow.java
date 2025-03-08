package me.colingrimes.primoria.weapon.bow.implementation;

import me.colingrimes.primoria.Primoria;
import me.colingrimes.primoria.weapon.bow.BaseBow;
import me.colingrimes.primoria.weapon.bow.BowEventInfo;
import me.colingrimes.midnight.scheduler.Scheduler;
import me.colingrimes.midnight.util.bukkit.Entities;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.entity.ProjectileHitEvent;

import javax.annotation.Nonnull;

// TODO - add border support
public class AnchorBow extends BaseBow {

	public AnchorBow(@Nonnull Primoria plugin) {
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
			Entities.spawn(EntityType.EVOKER_FANGS, anchorLocation);
			for (LivingEntity entity : Entities.nearby(LivingEntity.class, anchorLocation, 3)) {
				entity.teleport(anchorLocation.setDirection(entity.getLocation().getDirection()));
				entity.damage(1);
			}
		}, 0L, 10L, 5 * 20L);
	}
}
