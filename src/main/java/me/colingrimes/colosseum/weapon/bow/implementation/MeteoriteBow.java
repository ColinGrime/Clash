package me.colingrimes.colosseum.weapon.bow.implementation;

import me.colingrimes.colosseum.Colosseum;
import me.colingrimes.colosseum.weapon.bow.BaseBow;
import me.colingrimes.colosseum.weapon.bow.BowEventInfo;
import me.colingrimes.midnight.scheduler.Scheduler;
import me.colingrimes.midnight.util.misc.Random;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.entity.*;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.util.Vector;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;

public class MeteoriteBow extends BaseBow {

	private final Material[] materials = {Material.BLACKSTONE, Material.BASALT, Material.CRYING_OBSIDIAN, Material.OBSIDIAN};

	public MeteoriteBow(@Nonnull Colosseum plugin) {
		super("meteorite", "&c&lMeteorite Missile", "&7Rain destruction.");
	}

	@Override
	public boolean isEnabled() {
		return false;
	}

	@Override
	public void activate(@Nonnull ProjectileHitEvent event, @Nonnull BowEventInfo info) {
		info.arrow().remove();
		spawnMeteor(info.location());
	}

	/**
	 * Spawns a meteriote at the given location.
	 *
	 * @param location the location to spawn the meteriote
	 */
	private void spawnMeteor(@Nonnull Location location) {
		int count = 100;
		double spread = 5;

		List<FallingBlock> fallingBlocks = new ArrayList<>();
		for (int i=0; i<count; i++) {
			double offsetX = (Math.random() - 0.5) * spread;
			double offsetY = (Math.random() - 0.5) * spread;
			double offsetZ = (Math.random() - 0.5) * spread;
			Location meteorLocation = location.clone().add(0, 50, 0).add(offsetX, offsetY, offsetZ);
			Material meteorMaterial = Random.item(materials);
			FallingBlock fallingBlock = location.getWorld().spawnFallingBlock(meteorLocation, meteorMaterial.createBlockData());
			fallingBlock.setDropItem(false);
			fallingBlock.setHurtEntities(true);
			fallingBlocks.add(fallingBlock);
		}

		Scheduler.sync().runRepeating((task) -> {
			for (FallingBlock block : fallingBlocks) {
				if (block.getLocation().getY() > location.getY()) {
					block.getWorld().spawnParticle(Particle.EXPLOSION, block.getLocation(), 1, 0, 0, 0, 0.1F);
					continue;
				}

				location.getWorld().createExplosion(location, 20F, true);
				scatterGroundBlocks(location, 5);
				task.stop();
				return;
			}
		}, 0L, 1L);
	}

	private void scatterGroundBlocks(@Nonnull Location impactLocation, int radius) {
		for (int x=-radius; x<=radius; x++) {
			for (int y=-radius; y<=1; y++) {
				for (int z=-radius; z<=radius; z++) {
					Location location = impactLocation.clone().add(x, y, z);
					if (location.getBlock().getType().isSolid()) {
						spawnFlyingDebris(location, location.getBlock().getType());
						location.getBlock().setType(Material.AIR);
					}
				}
			}
		}
	}

	private void spawnFlyingDebris(@Nonnull Location location, @Nonnull Material blockType) {
		FallingBlock debris = location.getWorld().spawnFallingBlock(location, blockType.createBlockData());
		double x = (Math.random() - 0.5) * 2;
		double y = Math.random() * 1.5 + 0.5;
		double z = (Math.random() - 0.5) * 2;
		debris.setVelocity(new Vector(x, y, z));
	}
}
