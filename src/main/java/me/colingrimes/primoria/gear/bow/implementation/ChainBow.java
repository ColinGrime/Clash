package me.colingrimes.primoria.gear.bow.implementation;

import me.colingrimes.midnight.message.Message;
import me.colingrimes.primoria.Primoria;
import me.colingrimes.primoria.config.GearSettings;
import me.colingrimes.primoria.gear.bow.BowGear;

import javax.annotation.Nonnull;

public class ChainBow extends BowGear {

	public ChainBow(@Nonnull Primoria plugin) {
		super(plugin, "chain");
	}

	@Nonnull
	@Override
	public Message<?> getName() {
		return GearSettings.BOW_CHAIN_NAME;
	}

	@Nonnull
	@Override
	public Message<?> getDescription() {
		return GearSettings.BOW_CHAIN_DESC;
	}

	@Override
	public boolean isEnabled() {
		return false;
	}
}
