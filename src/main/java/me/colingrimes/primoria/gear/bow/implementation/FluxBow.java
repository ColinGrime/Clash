package me.colingrimes.primoria.gear.bow.implementation;

import me.colingrimes.midnight.message.Message;
import me.colingrimes.primoria.Primoria;
import me.colingrimes.primoria.config.GearSettings;
import me.colingrimes.primoria.gear.GearGrade;
import me.colingrimes.primoria.gear.bow.BowGear;

import javax.annotation.Nonnull;

public class FluxBow extends BowGear {

	public FluxBow(@Nonnull Primoria plugin) {
		super(plugin, "flux");
	}

	@Nonnull
	@Override
	public Message<?> getName() {
		return GearSettings.BOW_FLUX_NAME;
	}

	@Nonnull
	@Override
	public Message<?> getDescription() {
		return GearSettings.BOW_FLUX_DESC;
	}

	@Nonnull
	@Override
	public GearGrade getGrade() {
		return GearGrade.D;
	}

	@Override
	public boolean isEnabled() {
		return false;
	}
}
