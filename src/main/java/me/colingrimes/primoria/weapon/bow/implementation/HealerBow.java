package me.colingrimes.primoria.weapon.bow.implementation;

import me.colingrimes.primoria.Primoria;
import me.colingrimes.primoria.weapon.bow.BaseBow;
import me.colingrimes.primoria.weapon.bow.BowEventInfo;
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

public class HealerBow extends BaseBow {

	public HealerBow(@Nonnull Primoria plugin) {
		super("healer", "&d&lHealer", "&7Heals yourself where the arrow lands.");
	}

	@Override
	public void activate(@Nonnull ProjectileHitEvent event, @Nonnull BowEventInfo info) {
		List<Location> locations = Locations.between(info.location().add(2,0,2), info.location().add(-1,0,-1));
		Scheduler.sync().runRepeating(() -> {
			locations.forEach(loc -> info.world().spawnParticle(Particle.HEART, loc, 1));

			// Gives the entity regeneration / saturation over the radius.
			for (Entity entity : Entities.nearby(info.location(), 2)) {
				if (entity.equals(info.shooter())) {
					info.shooter().addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 20, 2));
					info.shooter().addPotionEffect(new PotionEffect(PotionEffectType.SATURATION, 1, 0));
					break;
				}
			}
		}, 0L, 5L, 10 * 20L);
	}
}
