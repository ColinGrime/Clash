package me.colingrimes.clash.gear.bow.implementation;

import me.colingrimes.clash.Clash;
import me.colingrimes.clash.config.GearSettings;
import me.colingrimes.clash.gear.util.GearGrade;
import me.colingrimes.clash.gear.bow.BowGear;

import javax.annotation.Nonnull;

public class SemtexBow extends BowGear {

	public SemtexBow(@Nonnull Clash plugin) {
		super(plugin, "semtex", GearSettings.BOW_SEMTEX_NAME, GearSettings.BOW_SEMTEX_DESC, GearGrade.B);
	}

	@Override
	public boolean isEnabled() {
		return false;
	}
}
