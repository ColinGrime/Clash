package me.colingrimes.primoria.command.primoria.weapon.show;

import me.colingrimes.midnight.menu.Gui;
import me.colingrimes.primoria.Primoria;
import me.colingrimes.primoria.gear.bow.BowGear;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;

import javax.annotation.Nonnull;
import java.util.List;

public class WeaponGui extends Gui {

	private final Primoria plugin;
	private final Player player;

	public WeaponGui(@Nonnull Primoria plugin, @Nonnull Player player) {
		super(player, "Weapons", (int) Math.ceil(plugin.getBows().size() / 9.0));
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
