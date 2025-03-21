package me.colingrimes.clash.command.gear.combine;

import me.colingrimes.midnight.command.Command;
import me.colingrimes.midnight.command.handler.util.ArgumentList;
import me.colingrimes.midnight.command.handler.util.CommandProperties;
import me.colingrimes.midnight.command.handler.util.Sender;
import me.colingrimes.clash.Clash;
import me.colingrimes.midnight.menu.Gui;
import me.colingrimes.midnight.menu.pattern.MultiPattern;
import me.colingrimes.midnight.util.bukkit.Items;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;

import javax.annotation.Nonnull;

public class GearCombine implements Command<Clash> {

	@Override
	public void execute(@Nonnull Clash plugin, @Nonnull Sender sender, @Nonnull ArgumentList args) {
		new GearCombineGui(plugin, sender.player()).open();
	}

	@Override
	public void configureProperties(@Nonnull CommandProperties properties) {
		properties.setPlayerRequired(true);
	}

	private static class GearCombineGui extends Gui {
		private final Clash plugin;
		private final Player player;

		public GearCombineGui(@Nonnull Clash plugin, @Nonnull Player player) {
			super(player, "Gear Combine", 5);
			this.plugin = plugin;
			this.player = player;
		}

		@Override
		public void draw() {
			MultiPattern.create()
					.mask("BBBBBBBBB")
					.mask("BB0BCB0BB")
					.mask("BBBBBBBBB")
					.mask("BBBB0BBBB")
					.mask("BBBBBB000")
					.item('B', Material.BLACK_STAINED_GLASS_PANE)
					.item('C', Items.of(Material.NETHERITE_UPGRADE_SMITHING_TEMPLATE).hide().build())
					.bind('C', ClickType.LEFT, e -> e.getWhoClicked().sendMessage("Test"))
					.fill(this);
		}
	}
}
