package me.colingrimes.clash.gear.bow.implementation;

import me.colingrimes.clash.Clash;
import me.colingrimes.clash.config.GearSettings;
import me.colingrimes.clash.gear.util.GearGrade;
import me.colingrimes.clash.gear.bow.BowGear;
import me.colingrimes.clash.model.OldBlock;
import me.colingrimes.clash.gear.bow.BowInfo;
import me.colingrimes.midnight.scheduler.Scheduler;
import me.colingrimes.midnight.util.bukkit.Entities;
import me.colingrimes.midnight.util.bukkit.Locations;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.util.BoundingBox;

import javax.annotation.Nonnull;
import java.util.*;
import java.util.stream.Collectors;

public class VoidBow extends BowGear {

	public VoidBow(@Nonnull Clash plugin) {
		super(plugin, "void", GearSettings.BOW_VOID_NAME, GearSettings.BOW_VOID_DESC, GearGrade.A);
	}

	@Override
	public double getCooldown() {
		return 5;
	}

	@Override
	public boolean activate(@Nonnull ProjectileHitEvent event, @Nonnull BowInfo bow) {
		Location location = bow.arrowLocation();
		Optional<LivingEntity> entity = Entities.find(LivingEntity.class, location, 2);
		if (entity.isPresent()) {
			BoundingBox box = entity.get().getBoundingBox();
			location = new Location(bow.world(), box.getCenterX() - 1, entity.get().getLocation().getY(), box.getCenterZ() - 1);
		}

		Location bottomLocation = location.clone().add(2, 0, 2);
		bottomLocation.setY(0);

		Queue<Block> voidBlocks = Locations.between(location, bottomLocation)
				.stream()
				.map(Location::getBlock)
				.filter(block -> block.getType() != Material.AIR)
				.collect(Collectors.toCollection(LinkedList::new));
		Stack<OldBlock> oldBlocks = new Stack<>();

		Scheduler.sync().runRepeating((task) -> {
			for (int i=0; i<12; i++) {
				if (!voidBlocks.isEmpty()) {
					Block block = voidBlocks.poll();
					oldBlocks.push(new OldBlock(block));
					block.setType(Material.AIR);
				} else if (!oldBlocks.isEmpty()) {
					oldBlocks.pop().revert();
				} else {
					task.stop();
					return;
				}
			}
		}, 0L, 5L);
		return true;
	}

	@Override
	public boolean activate(@Nonnull EntityDamageByEntityEvent event, @Nonnull BowInfo bow) {
		event.setCancelled(true);
		return false;
	}
}
