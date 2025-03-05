package me.colingrimes.colosseum.weapon.bow.implementation;

import me.colingrimes.colosseum.weapon.bow.BaseBow;

public class BunkerBow extends BaseBow {

	public BunkerBow() {
		super("bunker", "&a&lBunker", "&7Activate the barrier!");
	}

	@Override
	public boolean isEnabled() {
		return false;
	}
}
