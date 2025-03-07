package me.colingrimes.colosseum.weapon.bow.implementation;

import me.colingrimes.colosseum.Colosseum;
import me.colingrimes.colosseum.weapon.bow.BaseBow;

import javax.annotation.Nonnull;

public class DoppelBow extends BaseBow {

	public DoppelBow(@Nonnull Colosseum plugin) {
		super("doppel", "&d&lDoppel", "&7Duplicate yourself.");
	}

	@Override
	public boolean isEnabled() {
		return false;
	}
}
