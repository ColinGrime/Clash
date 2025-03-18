package me.colingrimes.clash.gear.bow.implementation;

import me.colingrimes.clash.Clash;
import me.colingrimes.clash.config.GearSettings;
import me.colingrimes.clash.gear.util.GearGrade;
import me.colingrimes.clash.gear.bow.BowGear;

import javax.annotation.Nonnull;

public class DoppelBow extends BowGear {

	public DoppelBow(@Nonnull Clash plugin) {
		super(plugin, "doppel", GearSettings.BOW_DOPPEL_NAME, GearSettings.BOW_DOPPEL_DESC, GearGrade.B);
	}

	@Override
	public boolean isEnabled() {
		return false;
	}
}
