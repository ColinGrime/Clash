package me.colingrimes.primoria.gear.bow.implementation;

import me.colingrimes.midnight.message.Message;
import me.colingrimes.primoria.Primoria;
import me.colingrimes.primoria.config.GearSettings;
import me.colingrimes.primoria.gear.GearGrade;
import me.colingrimes.primoria.gear.bow.BowGear;
import me.colingrimes.primoria.model.OldBlock;
import me.colingrimes.primoria.gear.bow.BowInfo;
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

	public TrapBow(@Nonnull Primoria plugin) {
		super(plugin, "trap");
	}

	@Nonnull
	@Override
	public Message<?> getName() {
		return GearSettings.BOW_TRAP_NAME;
	}

	@Nonnull
	@Override
	public Message<?> getDescription() {
		return GearSettings.BOW_TRAP_DESC;
	}

	@Nonnull
	@Override
	public GearGrade getGrade() {
		return GearGrade.A;
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
