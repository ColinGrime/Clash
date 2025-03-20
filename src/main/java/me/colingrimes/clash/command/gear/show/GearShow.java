package me.colingrimes.clash.command.gear.show;

import me.colingrimes.clash.gear.bow.BowGear;
import me.colingrimes.midnight.command.Command;
import me.colingrimes.midnight.command.handler.util.ArgumentList;
import me.colingrimes.midnight.command.handler.util.CommandProperties;
import me.colingrimes.midnight.command.handler.util.Sender;
import me.colingrimes.clash.Clash;
import me.colingrimes.midnight.menu.Gui;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;

import javax.annotation.Nonnull;
import java.util.List;

public class GearShow implements Command<Clash> {

	@Override
	public void execute(@Nonnull Clash plugin, @Nonnull Sender sender, @Nonnull ArgumentList args) {
		new GearShowGui(plugin, sender.player()).open();
	}

	@Override
	public void configureProperties(@Nonnull CommandProperties properties) {
		properties.setPlayerRequired(true);
	}

	private static class GearShowGui extends Gui {
		private final Clash plugin;
		private final Player player;

		public GearShowGui(@Nonnull Clash plugin, @Nonnull Player player) {
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
}
