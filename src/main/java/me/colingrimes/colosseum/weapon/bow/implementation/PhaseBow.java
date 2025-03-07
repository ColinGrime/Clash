package me.colingrimes.colosseum.weapon.bow.implementation;

import me.colingrimes.colosseum.Colosseum;
import me.colingrimes.colosseum.weapon.bow.BaseBow;

import javax.annotation.Nonnull;

public class PhaseBow extends BaseBow {

	public PhaseBow(@Nonnull Colosseum plugin) {
		super("phase", "&d&lPhase", "&7Arrows phase through walls and obstacles.");
	}

	@Override
	public boolean isEnabled() {
		return false;
	}
}
