package me.colingrimes.colosseum.weapon.bow.implementation;

import me.colingrimes.colosseum.Colosseum;
import me.colingrimes.colosseum.weapon.bow.BaseBow;

import javax.annotation.Nonnull;

public class FluxBow extends BaseBow {

	public FluxBow(@Nonnull Colosseum plugin) {
		super("flux", "&d&lFlux", "&7Arrows randomly change trajectory mid-flight.");
	}

	@Override
	public boolean isEnabled() {
		return false;
	}
}
