package me.colingrimes.clash.gear.bow.implementation;

import me.colingrimes.clash.Clash;
import me.colingrimes.clash.config.GearSettings;
import me.colingrimes.clash.gear.util.GearGrade;
import me.colingrimes.clash.gear.bow.BowGear;

import javax.annotation.Nonnull;

public class BunkerBow extends BowGear {

	public BunkerBow(@Nonnull Clash plugin) {
		super(plugin, "bunker", GearSettings.BOW_BUNKER_NAME, GearSettings.BOW_BUNKER_DESC, GearGrade.B);
	}

	@Override
	public boolean isEnabled() {
		return false;
	}
}
