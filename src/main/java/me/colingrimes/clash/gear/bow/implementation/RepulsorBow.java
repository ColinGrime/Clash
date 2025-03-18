package me.colingrimes.clash.gear.bow.implementation;

import me.colingrimes.clash.Clash;
import me.colingrimes.clash.config.GearSettings;
import me.colingrimes.clash.gear.util.GearGrade;
import me.colingrimes.clash.gear.bow.BowGear;

import javax.annotation.Nonnull;

public class RepulsorBow extends BowGear {

	public RepulsorBow(@Nonnull Clash plugin) {
		super(plugin, "repulsor", GearSettings.BOW_REPULSOR_NAME, GearSettings.BOW_REPULSOR_DESC, GearGrade.B);
	}

	@Override
	public boolean isEnabled() {
		return false;
	}
}
