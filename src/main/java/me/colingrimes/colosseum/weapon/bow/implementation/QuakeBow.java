package me.colingrimes.colosseum.weapon.bow.implementation;

import me.colingrimes.colosseum.weapon.bow.BaseBow;

public class QuakeBow extends BaseBow {

	public QuakeBow() {
		super("quake", "&b&lQuake", "&7Creates a small shockwave where the arrow lands.");
	}

	@Override
	public boolean isEnabled() {
		return false;
	}
}
