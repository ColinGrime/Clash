package me.colingrimes.primoria.weapon.bow.implementation;

import me.colingrimes.primoria.Primoria;
import me.colingrimes.primoria.weapon.bow.BaseBow;

import javax.annotation.Nonnull;

public class SonarBow extends BaseBow {

	public SonarBow(@Nonnull Primoria plugin) {
		super("sonar", "&a&lSonar", "&7Arrows send out a sonar wave, revealing hidden players.");
	}

	@Override
	public boolean isEnabled() {
		return false;
	}
}
