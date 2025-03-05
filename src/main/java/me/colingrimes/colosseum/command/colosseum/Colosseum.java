package me.colingrimes.colosseum.command.colosseum;

import me.colingrimes.midnight.command.Command;
import me.colingrimes.midnight.command.handler.util.CommandProperties;

import javax.annotation.Nonnull;

public class Colosseum implements Command<me.colingrimes.colosseum.Colosseum> {

	@Override
	public void configureProperties(@Nonnull CommandProperties properties) {
		properties.setAliases("col");
	}
}
