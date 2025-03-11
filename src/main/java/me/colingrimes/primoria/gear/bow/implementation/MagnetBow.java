package me.colingrimes.primoria.gear.bow.implementation;

import me.colingrimes.midnight.message.Message;
import me.colingrimes.primoria.Primoria;
import me.colingrimes.primoria.config.GearSettings;
import me.colingrimes.primoria.gear.GearGrade;
import me.colingrimes.primoria.gear.bow.BowGear;

import javax.annotation.Nonnull;

public class MagnetBow extends BowGear {

	public MagnetBow(@Nonnull Primoria plugin) {
		super(plugin, "magnet");
	}

	@Nonnull
	@Override
	public Message<?> getName() {
		return GearSettings.BOW_MAGNET_NAME;
	}

	@Nonnull
	@Override
	public Message<?> getDescription() {
		return GearSettings.BOW_MAGNET_DESC;
	}

	@Nonnull
	@Override
	public GearGrade getGrade() {
		return GearGrade.A;
	}

	@Override
	public boolean isEnabled() {
		return false;
	}
}
