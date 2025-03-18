package me.colingrimes.clash.gear.bow.implementation;

import me.colingrimes.clash.Clash;
import me.colingrimes.clash.config.GearSettings;
import me.colingrimes.clash.gear.util.GearGrade;
import me.colingrimes.clash.gear.bow.BowGear;

import javax.annotation.Nonnull;

public class SonarBow extends BowGear {

	public SonarBow(@Nonnull Clash plugin) {
		super(plugin, "sonar", GearSettings.BOW_SONAR_NAME, GearSettings.BOW_SONAR_DESC, GearGrade.B);
	}

	@Override
	public boolean isEnabled() {
		return false;
	}
}
