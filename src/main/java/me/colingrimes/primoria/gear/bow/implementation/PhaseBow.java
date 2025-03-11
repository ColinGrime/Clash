package me.colingrimes.primoria.gear.bow.implementation;

import me.colingrimes.midnight.message.Message;
import me.colingrimes.primoria.Primoria;
import me.colingrimes.primoria.config.GearSettings;
import me.colingrimes.primoria.gear.GearGrade;
import me.colingrimes.primoria.gear.bow.BowGear;

import javax.annotation.Nonnull;

public class PhaseBow extends BowGear {

	public PhaseBow(@Nonnull Primoria plugin) {
		super(plugin, "phase");
	}

	@Nonnull
	@Override
	public Message<?> getName() {
		return GearSettings.BOW_PHASE_NAME;
	}

	@Nonnull
	@Override
	public Message<?> getDescription() {
		return GearSettings.BOW_PHASE_DESC;
	}

	@Nonnull
	@Override
	public GearGrade getGrade() {
		return GearGrade.B;
	}

	@Override
	public boolean isEnabled() {
		return false;
	}
}
