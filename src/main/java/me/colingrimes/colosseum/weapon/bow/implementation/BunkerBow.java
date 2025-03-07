package me.colingrimes.colosseum.weapon.bow.implementation;

import me.colingrimes.colosseum.Colosseum;
import me.colingrimes.colosseum.weapon.bow.BaseBow;

import javax.annotation.Nonnull;

public class BunkerBow extends BaseBow {

	public BunkerBow(@Nonnull Colosseum plugin) {
		super("bunker", "&a&lBunker", "&7Activate the barrier!");
	}

	@Override
	public boolean isEnabled() {
		return false;
	}
}
