package me.colingrimes.clash.gear.bow.implementation;

import me.colingrimes.clash.Clash;
import me.colingrimes.clash.config.GearSettings;
import me.colingrimes.clash.gear.util.GearGrade;
import me.colingrimes.clash.gear.bow.BowGear;

import javax.annotation.Nonnull;

public class MagnetBow extends BowGear {

	public MagnetBow(@Nonnull Clash plugin) {
		super(plugin, "magnet", GearSettings.BOW_MAGNET_NAME, GearSettings.BOW_MAGNET_DESC, GearGrade.A);
	}

	@Override
	public boolean isEnabled() {
		return false;
	}
}
