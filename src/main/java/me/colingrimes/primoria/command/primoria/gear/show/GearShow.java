package me.colingrimes.primoria.command.primoria.gear.show;

import me.colingrimes.midnight.command.Command;
import me.colingrimes.midnight.command.handler.util.ArgumentList;
import me.colingrimes.midnight.command.handler.util.CommandProperties;
import me.colingrimes.midnight.command.handler.util.Sender;
import me.colingrimes.primoria.Primoria;

import javax.annotation.Nonnull;

public class GearShow implements Command<Primoria> {

	@Override
	public void execute(@Nonnull Primoria plugin, @Nonnull Sender sender, @Nonnull ArgumentList args) {
		new GearGui(plugin, sender.player()).open();
	}

	@Override
	public void configureProperties(@Nonnull CommandProperties properties) {
		properties.setPlayerRequired(true);
	}
}
