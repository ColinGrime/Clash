package me.colingrimes.clash.gear.bow.implementation;

import me.colingrimes.clash.Clash;
import me.colingrimes.clash.config.GearSettings;
import me.colingrimes.clash.gear.util.GearGrade;
import me.colingrimes.clash.gear.bow.BowGear;

import javax.annotation.Nonnull;

public class CorruptBow extends BowGear {

	public CorruptBow(@Nonnull Clash plugin) {
		super(plugin, "corrupt", GearSettings.BOW_CORRUPT_NAME, GearSettings.BOW_CORRUPT_DESC, GearGrade.S);
	}

	@Override
	public boolean isEnabled() {
		return false;
	}
}
