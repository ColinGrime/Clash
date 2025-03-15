package me.colingrimes.clash.command.gear.show;

import me.colingrimes.midnight.command.Command;
import me.colingrimes.midnight.command.handler.util.ArgumentList;
import me.colingrimes.midnight.command.handler.util.CommandProperties;
import me.colingrimes.midnight.command.handler.util.Sender;
import me.colingrimes.clash.Clash;

import javax.annotation.Nonnull;

public class GearShow implements Command<Clash> {

	@Override
	public void execute(@Nonnull Clash plugin, @Nonnull Sender sender, @Nonnull ArgumentList args) {
		new GearGui(plugin, sender.player()).open();
	}

	@Override
	public void configureProperties(@Nonnull CommandProperties properties) {
		properties.setPlayerRequired(true);
	}
}
