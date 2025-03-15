package me.colingrimes.clash.command.gear;

import me.colingrimes.midnight.command.Command;
import me.colingrimes.midnight.command.handler.util.CommandProperties;
import me.colingrimes.clash.Clash;

import javax.annotation.Nonnull;

public class Gear implements Command<Clash> {

	@Override
	public void configureProperties(@Nonnull CommandProperties properties) {
		properties.setAliases("gears");
	}
}
