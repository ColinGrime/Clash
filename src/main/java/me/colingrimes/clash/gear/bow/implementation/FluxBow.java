package me.colingrimes.clash.gear.bow.implementation;

import me.colingrimes.clash.Clash;
import me.colingrimes.clash.config.GearSettings;
import me.colingrimes.clash.gear.util.GearGrade;
import me.colingrimes.clash.gear.bow.BowGear;

import javax.annotation.Nonnull;

public class FluxBow extends BowGear {

	public FluxBow(@Nonnull Clash plugin) {
		super(plugin, "flux", GearSettings.BOW_FLUX_NAME, GearSettings.BOW_FLUX_DESC, GearGrade.D);
	}

	@Override
	public boolean isEnabled() {
		return false;
	}
}
