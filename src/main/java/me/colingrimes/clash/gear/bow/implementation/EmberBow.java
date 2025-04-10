package me.colingrimes.clash.gear.bow.implementation;

import me.colingrimes.clash.Clash;
import me.colingrimes.clash.config.GearSettings;
import me.colingrimes.clash.gear.util.GearGrade;
import me.colingrimes.clash.gear.bow.BowGear;
import me.colingrimes.clash.gear.bow.BowInfo;
import me.colingrimes.midnight.scheduler.Scheduler;
import me.colingrimes.midnight.util.bukkit.Items;
import me.colingrimes.midnight.util.misc.Random;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.entity.Item;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.util.Vector;

import javax.annotation.Nonnull;
import java.util.UUID;

// TODO - think about adding cases for leaves/water/snow/ice/packedice/set fire on all blocks
public class EmberBow extends BowGear {

	private final Material[] materials = { Material.BLAZE_POWDER, Material.FIRE_CORAL, Material.FIRE_CORAL_FAN, Material.NETHER_WART };

	public EmberBow(@Nonnull Clash plugin) {
		super(plugin, "ember", GearSettings.BOW_EMBER_NAME, GearSettings.BOW_EMBER_DESC, GearGrade.A);
	}

	@Override
	public double getCooldown() {
		return 10;
	}

	@Override
	public boolean activate(@Nonnull ProjectileHitEvent event, @Nonnull BowInfo bow) {
		for (int i=0; i<20; i++) {
			Item item = bow.world().dropItem(bow.arrowLocation(), Items.of(Random.item(materials)).nbt("random", UUID.randomUUID().toString()).build());
			double x = (Math.random() - 0.5);
			double y = Math.random() + 0.1;
			double z = (Math.random() - 0.5);
			item.setVelocity(new Vector(x, y, z));
			item.setVisualFire(true);
			item.setPickupDelay(Integer.MAX_VALUE);

			Scheduler.sync().runRepeating((task) -> {
				double newY = item.getLocation().getY();
				if (item.isInWater() || newY - Math.floor(newY) < 0.00001) {
					bow.world().createExplosion(item.getLocation(), 1F, true, false);
					bow.world().spawnParticle(Particle.FLAME, item.getLocation(), 20, 0, 0, 0, 0.2F);
					item.remove();
					task.stop();
				}
			}, 2L, 2L);
		}
		return true;
	}
}
