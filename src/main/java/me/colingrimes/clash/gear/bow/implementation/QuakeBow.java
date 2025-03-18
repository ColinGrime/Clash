package me.colingrimes.clash.gear.bow.implementation;

import me.colingrimes.clash.Clash;
import me.colingrimes.clash.config.GearSettings;
import me.colingrimes.clash.gear.util.GearGrade;
import me.colingrimes.clash.gear.bow.BowGear;

import javax.annotation.Nonnull;

public class QuakeBow extends BowGear {

	public QuakeBow(@Nonnull Clash plugin) {
		super(plugin, "quake", GearSettings.BOW_QUAKE_NAME, GearSettings.BOW_QUAKE_DESC, GearGrade.B);
	}

	@Override
	public boolean isEnabled() {
		return false;
	}
}
