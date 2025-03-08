package me.colingrimes.primoria.weapon.bow.implementation;

import me.colingrimes.primoria.Primoria;
import me.colingrimes.primoria.weapon.bow.BaseBow;

import javax.annotation.Nonnull;

public class PhaseBow extends BaseBow {

	public PhaseBow(@Nonnull Primoria plugin) {
		super("phase", "&d&lPhase", "&7Arrows phase through walls and obstacles.");
	}

	@Override
	public boolean isEnabled() {
		return false;
	}
}
