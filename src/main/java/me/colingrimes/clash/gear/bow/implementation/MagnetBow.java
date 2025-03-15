package me.colingrimes.clash.gear.bow.implementation;

import me.colingrimes.midnight.message.Message;
import me.colingrimes.clash.Clash;
import me.colingrimes.clash.config.GearSettings;
import me.colingrimes.clash.gear.util.GearGrade;
import me.colingrimes.clash.gear.bow.BowGear;

import javax.annotation.Nonnull;

public class MagnetBow extends BowGear {

	public MagnetBow(@Nonnull Clash plugin) {
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
