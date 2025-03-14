package me.colingrimes.primoria.gear.bow.implementation;

import me.colingrimes.midnight.message.Message;
import me.colingrimes.primoria.Primoria;
import me.colingrimes.primoria.config.GearSettings;
import me.colingrimes.primoria.gear.util.GearGrade;
import me.colingrimes.primoria.gear.bow.BowGear;

import javax.annotation.Nonnull;

public class BunkerBow extends BowGear {

	public BunkerBow(@Nonnull Primoria plugin) {
		super(plugin, "bunker");
	}

	@Nonnull
	@Override
	public Message<?> getName() {
		return GearSettings.BOW_BUNKER_NAME;
	}

	@Nonnull
	@Override
	public Message<?> getDescription() {
		return GearSettings.BOW_BUNKER_DESC;
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
