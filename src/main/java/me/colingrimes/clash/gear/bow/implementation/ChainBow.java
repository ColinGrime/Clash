package me.colingrimes.clash.gear.bow.implementation;

import me.colingrimes.clash.Clash;
import me.colingrimes.clash.config.GearSettings;
import me.colingrimes.clash.gear.util.GearGrade;
import me.colingrimes.clash.gear.bow.BowGear;

import javax.annotation.Nonnull;

public class ChainBow extends BowGear {

	public ChainBow(@Nonnull Clash plugin) {
		super(plugin, "chain", GearSettings.BOW_CHAIN_NAME, GearSettings.BOW_CHAIN_DESC, GearGrade.D);
	}

	@Override
	public boolean isEnabled() {
		return false;
	}
}
