package me.colingrimes.clash.gear.bow.implementation;

import me.colingrimes.clash.Clash;
import me.colingrimes.clash.config.GearSettings;
import me.colingrimes.clash.gear.util.GearGrade;
import me.colingrimes.clash.gear.bow.BowGear;
import me.colingrimes.clash.model.OldBlock;
import me.colingrimes.clash.gear.bow.BowInfo;
import me.colingrimes.midnight.scheduler.Scheduler;
import me.colingrimes.midnight.util.bukkit.Locations;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;

public class TrapBow extends BowGear {

	public TrapBow(@Nonnull Clash plugin) {
		super(plugin, "trap", GearSettings.BOW_TRAP_NAME, GearSettings.BOW_TRAP_DESC, GearGrade.A);
	}

	@Override
	public double getCooldown() {
		return 5;
	}

	@Override
	public boolean activate(@Nonnull EntityDamageByEntityEvent event, @Nonnull BowInfo bow) {
		event.setCancelled(true);

		Location location = bow.arrowLocation();
		List<Location> trapLocations = Locations.between(location.clone().add(2, 2, 2), location.clone().add(-1, 0, -1));
		List<OldBlock> oldBlocks = new ArrayList<>();

		for (Location trapLocation : trapLocations) {
			if (trapLocation.getBlock().getType() != Material.AIR || Locations.equal(trapLocation, location)) {
				continue;
			}

			Block block = trapLocation.getBlock();
			oldBlocks.add(new OldBlock(block));

			if (trapLocation.getBlockY() == location.getBlockY() + 1) {
				block.setType(Material.OBSIDIAN);
			} else {
				block.setType(Material.GLASS);
			}
		}

		Scheduler.sync().runLater(() -> oldBlocks.forEach(OldBlock::revert), 5 * 20L);
		return true;
	}
}
