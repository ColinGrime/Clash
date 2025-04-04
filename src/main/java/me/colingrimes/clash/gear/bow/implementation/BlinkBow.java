package me.colingrimes.clash.gear.bow.implementation;

import me.colingrimes.clash.Clash;
import me.colingrimes.clash.config.GearSettings;
import me.colingrimes.clash.gear.util.GearGrade;
import me.colingrimes.clash.gear.bow.BowGear;

import javax.annotation.Nonnull;

public class BlinkBow extends BowGear {

	public BlinkBow(@Nonnull Clash plugin) {
		super(plugin, "blink", GearSettings.BOW_BLINK_NAME, GearSettings.BOW_BLINK_DESC, GearGrade.A);
	}

	@Override
	public boolean isEnabled() {
		return false;
	}
}
