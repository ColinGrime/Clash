package me.colingrimes.clash.gear.bow.implementation;

import me.colingrimes.clash.Clash;
import me.colingrimes.clash.config.GearSettings;
import me.colingrimes.clash.gear.util.GearGrade;
import me.colingrimes.clash.gear.bow.BowGear;
import me.colingrimes.clash.gear.bow.BowInfo;
import me.colingrimes.midnight.scheduler.Scheduler;
import me.colingrimes.midnight.util.bukkit.Entities;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.entity.ProjectileHitEvent;

import javax.annotation.Nonnull;

// TODO - add border support
public class AnchorBow extends BowGear {

	public AnchorBow(@Nonnull Clash plugin) {
		super(plugin, "anchor", GearSettings.BOW_ANCHOR_NAME, GearSettings.BOW_ANCHOR_DESC, GearGrade.C);
	}

	@Override
	public double getCooldown() {
		return 10;
	}

	@Override
	public boolean activate(@Nonnull ProjectileHitEvent event, @Nonnull BowInfo bow) {
		Scheduler.sync().runRepeating(() -> {
			Entities.spawn(EntityType.EVOKER_FANGS, bow.arrowLocation());
			for (LivingEntity entity : Entities.nearby(LivingEntity.class, bow.arrowLocation(), 3)) {
				entity.teleport(bow.arrowLocation().setDirection(entity.getLocation().getDirection()));
				entity.damage(1);
			}
		}, 0L, 10L, 5 * 20L);
		return true;
	}
}
