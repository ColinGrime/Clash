package me.colingrimes.clash.gear.bow.implementation;

import me.colingrimes.clash.Clash;
import me.colingrimes.clash.config.GearSettings;
import me.colingrimes.clash.gear.bow.BowInfo;
import me.colingrimes.clash.gear.util.GearGrade;
import me.colingrimes.clash.gear.bow.BowGear;
import me.colingrimes.midnight.util.bukkit.Entities;
import me.colingrimes.midnight.util.bukkit.Vectors;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.ProjectileHitEvent;

import javax.annotation.Nonnull;

public class RepulsorBow extends BowGear {

	public RepulsorBow(@Nonnull Clash plugin) {
		super(plugin, "repulsor", GearSettings.BOW_REPULSOR_NAME, GearSettings.BOW_REPULSOR_DESC, GearGrade.B);
	}

	@Override
	public boolean activate(@Nonnull ProjectileHitEvent event, @Nonnull BowInfo bow) {
		bow.world().playSound(bow.arrowLocation(), Sound.ENTITY_GENERIC_EXPLODE, 1f, 1f);
		for (Entity entity : Entities.nearby(bow.arrowLocation(), 10)) {
			entity.setVelocity(Vectors.direction(bow.arrowLocation().clone().subtract(0, 1, 0), entity.getLocation()).multiply(2));
		}
		return true;
	}

	@Override
	public boolean activate(@Nonnull EntityDamageByEntityEvent event, @Nonnull BowInfo bow) {
		event.setCancelled(true);
		return false;
	}
}
