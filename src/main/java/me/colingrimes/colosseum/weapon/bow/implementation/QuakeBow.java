package me.colingrimes.colosseum.weapon.bow.implementation;

import me.colingrimes.colosseum.Colosseum;
import me.colingrimes.colosseum.weapon.bow.BaseBow;

import javax.annotation.Nonnull;

public class QuakeBow extends BaseBow {

	public QuakeBow(@Nonnull Colosseum plugin) {
		super("quake", "&b&lQuake", "&7Creates a small shockwave where the arrow lands.");
	}

	@Override
	public boolean isEnabled() {
		return false;
	}
}
