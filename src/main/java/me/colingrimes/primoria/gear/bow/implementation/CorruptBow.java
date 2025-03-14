package me.colingrimes.primoria.gear.bow.implementation;

import me.colingrimes.midnight.message.Message;
import me.colingrimes.primoria.Primoria;
import me.colingrimes.primoria.config.GearSettings;
import me.colingrimes.primoria.gear.util.GearGrade;
import me.colingrimes.primoria.gear.bow.BowGear;

import javax.annotation.Nonnull;

public class CorruptBow extends BowGear {

	public CorruptBow(@Nonnull Primoria plugin) {
		super(plugin, "corrupt");
	}

	@Nonnull
	@Override
	public Message<?> getName() {
		return GearSettings.BOW_CORRUPT_NAME;
	}

	@Nonnull
	@Override
	public Message<?> getDescription() {
		return GearSettings.BOW_CORRUPT_DESC;
	}

	@Nonnull
	@Override
	public GearGrade getGrade() {
		return GearGrade.S;
	}

	@Override
	public boolean isEnabled() {
		return false;
	}
}
