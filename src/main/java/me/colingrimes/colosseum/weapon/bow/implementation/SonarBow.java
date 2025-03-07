package me.colingrimes.colosseum.weapon.bow.implementation;

import me.colingrimes.colosseum.Colosseum;
import me.colingrimes.colosseum.weapon.bow.BaseBow;

import javax.annotation.Nonnull;

public class SonarBow extends BaseBow {

	public SonarBow(@Nonnull Colosseum plugin) {
		super("sonar", "&a&lSonar", "&7Arrows send out a sonar wave, revealing hidden players.");
	}

	@Override
	public boolean isEnabled() {
		return false;
	}
}
