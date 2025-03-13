package me.colingrimes.primoria.gear.bow.implementation;

import me.colingrimes.midnight.message.Message;
import me.colingrimes.primoria.Primoria;
import me.colingrimes.primoria.config.GearSettings;
import me.colingrimes.primoria.gear.GearGrade;
import me.colingrimes.primoria.gear.bow.BowGear;
import me.colingrimes.primoria.gear.bow.BowInfo;
import me.colingrimes.midnight.scheduler.Scheduler;
import me.colingrimes.midnight.util.bukkit.Entities;
import me.colingrimes.midnight.util.bukkit.Locations;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Entity;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import javax.annotation.Nonnull;
import java.util.List;

public class HealerBow extends BowGear {

	public HealerBow(@Nonnull Primoria plugin) {
		super(plugin, "healer");
	}

	@Nonnull
	@Override
	public Message<?> getName() {
		return GearSettings.BOW_HEALER_NAME;
	}

	@Nonnull
	@Override
	public Message<?> getDescription() {
		return GearSettings.BOW_HEALER_DESC;
	}

	@Nonnull
	@Override
	public GearGrade getGrade() {
		return GearGrade.B;
	}

	@Override
	public boolean activate(@Nonnull ProjectileHitEvent event, @Nonnull BowInfo bow) {
		List<Location> locations = Locations.between(bow.arrowLocation().clone().add(2,0,2), bow.arrowLocation().clone().add(-1,0,-1));
		Scheduler.sync().runRepeating(() -> {
			locations.forEach(loc -> bow.world().spawnParticle(Particle.HEART, loc, 1));

			// Gives the entity regeneration / saturation over the radius.
			for (Entity entity : Entities.nearby(bow.arrowLocation(), 2)) {
				if (entity.equals(bow.shooter())) {
					bow.shooter().addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 20, 2));
					bow.shooter().addPotionEffect(new PotionEffect(PotionEffectType.SATURATION, 1, 0));
					break;
				}
			}
		}, 0L, 5L, 10 * 20L);
		return true;
	}
}
