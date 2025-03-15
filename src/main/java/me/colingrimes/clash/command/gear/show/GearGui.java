package me.colingrimes.clash.command.gear.show;

import me.colingrimes.midnight.menu.Gui;
import me.colingrimes.clash.Clash;
import me.colingrimes.clash.gear.bow.BowGear;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;

import javax.annotation.Nonnull;
import java.util.List;

public class GearGui extends Gui {

	private final Clash plugin;
	private final Player player;

	public GearGui(@Nonnull Clash plugin, @Nonnull Player player) {
		super(player, "Gear", (int) Math.ceil(plugin.getBows().size() / 9.0));
		this.plugin = plugin;
		this.player = player;
	}

	@Override
	public void draw() {
		List<BowGear> bows = plugin.getBows();
		for (int i=0; i<bows.size(); i++) {
			BowGear bow = bows.get(i);
			getSlot(i).setItem(bow.getGear()).bind(ClickType.LEFT, __ -> player.getInventory().addItem(bow.getGear()));
		}
	}
}
