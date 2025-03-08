package me.colingrimes.primoria.weapon.bow.implementation;

import me.colingrimes.primoria.Primoria;
import me.colingrimes.primoria.weapon.bow.BaseBow;

import javax.annotation.Nonnull;

public class DoppelBow extends BaseBow {

	public DoppelBow(@Nonnull Primoria plugin) {
		super("doppel", "&d&lDoppel", "&7Duplicate yourself.");
	}

	@Override
	public boolean isEnabled() {
		return false;
	}
}
