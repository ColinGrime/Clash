package me.colingrimes.primoria.command.primoria.weapon;

import me.colingrimes.midnight.command.Command;
import me.colingrimes.midnight.command.handler.util.CommandProperties;
import me.colingrimes.primoria.Primoria;

import javax.annotation.Nonnull;

public class PrimoriaWeapon implements Command<Primoria> {

	@Override
	public void configureProperties(@Nonnull CommandProperties properties) {
		properties.setAliases("weapons", "w");
	}
}
