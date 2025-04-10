package me.colingrimes.clash.gear.bow.implementation;

import me.colingrimes.clash.Clash;
import me.colingrimes.clash.config.GearSettings;
import me.colingrimes.clash.gear.util.GearGrade;
import me.colingrimes.clash.gear.bow.BowGear;
import me.colingrimes.clash.gear.bow.BowInfo;
import me.colingrimes.midnight.scheduler.Scheduler;
import me.colingrimes.midnight.util.bukkit.Entities;
import me.colingrimes.midnight.util.bukkit.Vectors;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.util.Vector;

import javax.annotation.Nonnull;

public class HomingBow extends BowGear {

	public HomingBow(@Nonnull Clash plugin) {
		super(plugin, "homing", GearSettings.BOW_HOMING_NAME, GearSettings.BOW_HOMING_DESC, GearGrade.C);
	}

	@Override
	public double getCooldown() {
		return 5;
	}

	@Override
	public boolean activate(@Nonnull ProjectileHitEvent event, @Nonnull BowInfo bow) {
		for (Entity entity : Entities.nearby(bow.arrowLocation(), 10)) {
			if (entity instanceof LivingEntity && !entity.equals(event.getEntity().getShooter())) {
				Arrow arrow = bow.world().spawnArrow(bow.arrowLocation(), new Vector(0, 0.3, 0), 1.5f, 0);
				Scheduler.sync().runLater(() -> {
					arrow.remove();
					bow.world().spawnArrow(arrow.getLocation(), Vectors.direction(arrow, entity), 2f, 0);
				}, 5L);
				break;
			}
		}
		return true;
	}
}
