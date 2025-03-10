package me.colingrimes.primoria.gear.bow.implementation;

import me.colingrimes.midnight.message.Message;
import me.colingrimes.primoria.Primoria;
import me.colingrimes.primoria.config.GearSettings;
import me.colingrimes.primoria.gear.bow.BowGear;

import javax.annotation.Nonnull;

public class DoppelBow extends BowGear {

	public DoppelBow(@Nonnull Primoria plugin) {
		super(plugin, "doppel");
	}

	@Nonnull
	@Override
	public Message<?> getName() {
		return GearSettings.BOW_DOPPEL_NAME;
	}

	@Nonnull
	@Override
	public Message<?> getDescription() {
		return GearSettings.BOW_DOPPEL_DESC;
	}

	@Override
	public boolean isEnabled() {
		return false;
	}
}
