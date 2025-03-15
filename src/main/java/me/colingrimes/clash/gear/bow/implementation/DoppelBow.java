package me.colingrimes.clash.gear.bow.implementation;

import me.colingrimes.midnight.message.Message;
import me.colingrimes.clash.Clash;
import me.colingrimes.clash.config.GearSettings;
import me.colingrimes.clash.gear.util.GearGrade;
import me.colingrimes.clash.gear.bow.BowGear;

import javax.annotation.Nonnull;

public class DoppelBow extends BowGear {

	public DoppelBow(@Nonnull Clash plugin) {
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
