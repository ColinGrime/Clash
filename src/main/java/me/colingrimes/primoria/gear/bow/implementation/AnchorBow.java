package me.colingrimes.primoria.gear.bow.implementation;

import me.colingrimes.midnight.message.Message;
import me.colingrimes.primoria.Primoria;
import me.colingrimes.primoria.config.GearSettings;
import me.colingrimes.primoria.gear.util.GearGrade;
import me.colingrimes.primoria.gear.bow.BowGear;
import me.colingrimes.primoria.gear.bow.BowInfo;
import me.colingrimes.midnight.scheduler.Scheduler;
import me.colingrimes.midnight.util.bukkit.Entities;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.entity.ProjectileHitEvent;

import javax.annotation.Nonnull;

// TODO - add border support
public class AnchorBow extends BowGear {

	public AnchorBow(@Nonnull Primoria plugin) {
		super(plugin, "anchor");
	}

	@Nonnull
	@Override
	public Message<?> getName() {
		return GearSettings.BOW_ANCHOR_NAME;
	}

	@Nonnull
	@Override
	public Message<?> getDescription() {
		return GearSettings.BOW_ANCHOR_DESC;
	}

	@Nonnull
	@Override
	public GearGrade getGrade() {
		return GearGrade.C;
	}

	@Override
	public double getCooldown() {
		return 10;
	}

	@Override
	public boolean activate(@Nonnull ProjectileHitEvent event, @Nonnull BowInfo bow) {
		Location location;
		if (event.getHitBlock() != null) {
			location = event.getHitBlock().getLocation();
		} else if (event.getHitEntity() != null) {
			location = event.getHitEntity().getLocation();
		} else {
			return false;
		}

		Location anchorLocation = location.clone().add(0, 1, 0);
		Scheduler.sync().runRepeating(() -> {
			Entities.spawn(EntityType.EVOKER_FANGS, anchorLocation);
			for (LivingEntity entity : Entities.nearby(LivingEntity.class, anchorLocation, 3)) {
				entity.teleport(anchorLocation.setDirection(entity.getLocation().getDirection()));
				entity.damage(1);
			}
		}, 0L, 10L, 5 * 20L);
		return true;
	}
}
