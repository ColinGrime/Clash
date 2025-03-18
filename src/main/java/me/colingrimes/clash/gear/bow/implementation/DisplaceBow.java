package me.colingrimes.clash.gear.bow.implementation;

import me.colingrimes.clash.Clash;
import me.colingrimes.clash.config.GearSettings;
import me.colingrimes.clash.gear.util.GearGrade;
import me.colingrimes.clash.gear.bow.BowGear;

import javax.annotation.Nonnull;

public class DisplaceBow extends BowGear {

	public DisplaceBow(@Nonnull Clash plugin) {
		super(plugin, "displace", GearSettings.BOW_DISPLACE_NAME, GearSettings.BOW_DISPLACE_DESC, GearGrade.C);
	}

	@Override
	public boolean isEnabled() {
		return false;
	}
}
