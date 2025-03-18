package me.colingrimes.clash.gear.bow.implementation;

import me.colingrimes.clash.Clash;
import me.colingrimes.clash.config.GearSettings;
import me.colingrimes.clash.gear.util.GearGrade;
import me.colingrimes.clash.gear.bow.BowGear;

import javax.annotation.Nonnull;

public class HexBow extends BowGear {

	public HexBow(@Nonnull Clash plugin) {
		super(plugin, "hex", GearSettings.BOW_HEX_NAME, GearSettings.BOW_HEX_DESC, GearGrade.B);
	}

	@Override
	public boolean isEnabled() {
		return false;
	}
}
