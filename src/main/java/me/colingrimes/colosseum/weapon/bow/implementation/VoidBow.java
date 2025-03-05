package me.colingrimes.colosseum.weapon.bow.implementation;

import me.colingrimes.colosseum.model.OldBlock;
import me.colingrimes.colosseum.util.Util;
import me.colingrimes.colosseum.weapon.bow.BaseBow;
import me.colingrimes.colosseum.weapon.bow.BowEventInfo;
import me.colingrimes.midnight.scheduler.Scheduler;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.util.BoundingBox;

import javax.annotation.Nonnull;
import java.util.*;
import java.util.stream.Collectors;

public class VoidBow extends BaseBow {

	private final Map<Queue<Block>, Stack<OldBlock>> voidBlocks = new HashMap<>();

	public VoidBow() {
		super("void", "&c&lVoid", "&7Good bye.");
		this.startVoidAbility();
	}

	@Override
	public void activate(@Nonnull ProjectileHitEvent event, @Nonnull BowEventInfo info) {
		Location location = info.location();
		for (Entity entity : info.world().getNearbyEntities(location, 2, 2, 2)) {
			if (entity instanceof LivingEntity) {
				BoundingBox box = entity.getBoundingBox();
				location = new Location(info.world(), box.getCenterX() - 1, entity.getLocation().getY(), box.getCenterZ() - 1);
				break;
			}
		}

		Location bottomLocation = location.clone().add(2, 0, 2);
		bottomLocation.setY(0);

		Queue<Block> voidBlocks = Util.getLocationsBetween(location, bottomLocation)
				.stream()
				.map(Location::getBlock)
				.filter(block -> block.getType() != Material.AIR).collect(Collectors.toCollection(LinkedList::new));
		if (!voidBlocks.isEmpty()) {
			this.voidBlocks.put(voidBlocks, new Stack<>());
		}
	}

	@Override
	public void activate(@Nonnull EntityDamageByEntityEvent event, @Nonnull BowEventInfo info) {
		event.setCancelled(true);
	}

	private void startVoidAbility() {
		Scheduler.sync().runRepeating(() -> {
			var iterator = voidBlocks.entrySet().iterator();
			while (iterator.hasNext()) {
				var voidBlock = iterator.next();
				for (int i=0; i<12; i++) {
					if (!voidBlock.getKey().isEmpty()) {
						Block block = voidBlock.getKey().poll();
						voidBlock.getValue().push(new OldBlock(block));
						block.setType(Material.AIR);
					} else if (!voidBlock.getValue().isEmpty())
						voidBlock.getValue().pop().revert();
					else {
						iterator.remove();
						break;
					}
				}
			}
		}, 0L, 5L);
	}
}
