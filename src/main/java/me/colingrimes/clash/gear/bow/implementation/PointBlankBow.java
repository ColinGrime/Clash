package me.colingrimes.clash.gear.bow.implementation;

import me.colingrimes.midnight.message.Message;
import me.colingrimes.clash.Clash;
import me.colingrimes.clash.config.GearSettings;
import me.colingrimes.clash.gear.util.GearGrade;
import me.colingrimes.clash.gear.bow.BowGear;

import javax.annotation.Nonnull;

public class PointBlankBow extends BowGear {

	public PointBlankBow(@Nonnull Clash plugin) {
		super(plugin, "point_blank");
	}

	@Nonnull
	@Override
	public Message<?> getName() {
		return GearSettings.BOW_POINT_BLANK_NAME;
	}

	@Nonnull
	@Override
	public Message<?> getDescription() {
		return GearSettings.BOW_POINT_BLANK_DESC;
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
