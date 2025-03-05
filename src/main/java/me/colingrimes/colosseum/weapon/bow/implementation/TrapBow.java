package me.colingrimes.colosseum.weapon.bow.implementation;

import me.colingrimes.colosseum.model.OldBlock;
import me.colingrimes.colosseum.util.Util;
import me.colingrimes.colosseum.weapon.bow.BaseBow;
import me.colingrimes.colosseum.weapon.bow.BowEventInfo;
import me.colingrimes.midnight.scheduler.Scheduler;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;

public class TrapBow extends BaseBow {

	public TrapBow() {
		super("trap", "&a&lTrap", "&7Trap your enemies.");
	}

	@Override
	public void activate(@Nonnull EntityDamageByEntityEvent event, @Nonnull BowEventInfo info) {
		event.setCancelled(true);

		Location location = info.location();
		List<Location> trapLocations = Util.getLocationsBetween(location.clone().add(2, 2, 2), location.clone().add(-1, 0, -1));
		List<OldBlock> oldBlocks = new ArrayList<>();

		trapLocations.stream()
				.filter(trapLocation -> trapLocation.getBlock().getType() == Material.AIR
						&& !(trapLocation.getBlockX() == location.getBlockX()
						&& trapLocation.getBlockY() == location.getBlockY()
						&& trapLocation.getBlockZ() == location.getBlockZ()))
				.forEach(trapLocation -> {
					Block block = trapLocation.getBlock();
					oldBlocks.add(new OldBlock(block));

					if (trapLocation.getBlockY() == location.getBlockY() + 1) {
						block.setType(Material.OBSIDIAN);
					} else {
						block.setType(Material.GLASS);
					}
				});

		Scheduler.sync().runLater(() -> {
			for (OldBlock oldBlock : oldBlocks) {
				oldBlock.revert();
			}
		}, 5 * 20L);
	}
}
