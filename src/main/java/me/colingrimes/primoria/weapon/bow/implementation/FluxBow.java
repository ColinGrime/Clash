package me.colingrimes.primoria.weapon.bow.implementation;

import me.colingrimes.primoria.Primoria;
import me.colingrimes.primoria.weapon.bow.BaseBow;

import javax.annotation.Nonnull;

public class FluxBow extends BaseBow {

	public FluxBow(@Nonnull Primoria plugin) {
		super("flux", "&d&lFlux", "&7Arrows randomly change trajectory mid-flight.");
	}

	@Override
	public boolean isEnabled() {
		return false;
	}
}
