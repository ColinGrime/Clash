package me.colingrimes.primoria.command.primoria;

import me.colingrimes.midnight.command.Command;
import me.colingrimes.midnight.command.handler.util.CommandProperties;

import javax.annotation.Nonnull;

public class Primoria implements Command<me.colingrimes.primoria.Primoria> {

	@Override
	public void configureProperties(@Nonnull CommandProperties properties) {
		properties.setAliases("prim");
	}
}
