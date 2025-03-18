package me.colingrimes.clash.gear.bow.implementation;

import me.colingrimes.clash.Clash;
import me.colingrimes.clash.config.GearSettings;
import me.colingrimes.clash.gear.util.GearGrade;
import me.colingrimes.clash.gear.bow.BowGear;

import javax.annotation.Nonnull;

public class PhaseBow extends BowGear {

	public PhaseBow(@Nonnull Clash plugin) {
		super(plugin, "phase", GearSettings.BOW_PHASE_NAME, GearSettings.BOW_PHASE_DESC, GearGrade.B);
	}

	@Override
	public boolean isEnabled() {
		return false;
	}
}
