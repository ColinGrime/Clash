package me.colingrimes.clash.gear.bow.implementation;

import me.colingrimes.clash.Clash;
import me.colingrimes.clash.config.GearSettings;
import me.colingrimes.clash.gear.util.GearGrade;
import me.colingrimes.clash.gear.bow.BowGear;

import javax.annotation.Nonnull;

public class DisruptorBow extends BowGear {

	public DisruptorBow(@Nonnull Clash plugin) {
		super(plugin, "disruptor", GearSettings.BOW_DISRUPTOR_NAME, GearSettings.BOW_DISRUPTOR_DESC, GearGrade.A);
	}

	@Override
	public boolean isEnabled() {
		return false;
	}
}
