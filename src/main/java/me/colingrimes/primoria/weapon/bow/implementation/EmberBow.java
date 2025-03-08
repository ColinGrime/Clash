package me.colingrimes.primoria.weapon.bow.implementation;

import me.colingrimes.primoria.Primoria;
import me.colingrimes.primoria.weapon.bow.BaseBow;
import me.colingrimes.primoria.weapon.bow.BowEventInfo;
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

// TODO - think about adding cases for leaves/water
public class EmberBow extends BaseBow {

	private final Material[] materials = { Material.FIRE_CORAL, Material.FIRE_CORAL_FAN, Material.NETHER_WART };

	public EmberBow(@Nonnull Primoria plugin) {
		super("ember", "&c&lEmber", "&7Set the world ablaze.");
	}

	@Override
	public void activate(@Nonnull ProjectileHitEvent event, @Nonnull BowEventInfo info) {
		info.arrow().remove();
		for (int i=0; i<20; i++) {
			Item item = info.world().dropItem(info.location(), Items.of(Random.item(materials)).nbt("random", UUID.randomUUID().toString()).build());
			double x = (Math.random() - 0.5);
			double y = Math.random() + 0.1;
			double z = (Math.random() - 0.5);
			item.setVelocity(new Vector(x, y, z));
			item.setVisualFire(true);
			item.setPickupDelay(Integer.MAX_VALUE);

			Scheduler.sync().runRepeating((task) -> {
				double newY = item.getLocation().getY();
				if (item.isInWater() || newY - Math.floor(newY) < 0.00001) {
					info.world().createExplosion(item.getLocation(), 1F, true, false);
					info.world().spawnParticle(Particle.FLAME, item.getLocation(), 20, 0, 0, 0, 0.2F);
					item.remove();
					task.stop();
				}
			}, 2L, 2L);
		}
	}
}
