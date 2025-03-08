package me.colingrimes.primoria.command.primoria.weapon.show;

import me.colingrimes.midnight.command.Command;
import me.colingrimes.midnight.command.handler.util.ArgumentList;
import me.colingrimes.midnight.command.handler.util.CommandProperties;
import me.colingrimes.midnight.command.handler.util.Sender;
import me.colingrimes.primoria.Primoria;

import javax.annotation.Nonnull;

public class WeaponShow implements Command<Primoria> {

	@Override
	public void execute(@Nonnull Primoria plugin, @Nonnull Sender sender, @Nonnull ArgumentList args) {
		new WeaponGui(plugin, sender.player()).open();
	}

	@Override
	public void configureProperties(@Nonnull CommandProperties properties) {
		properties.setPlayerRequired(true);
	}
}
