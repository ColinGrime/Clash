package me.colingrimes.primoria.weapon.bow.implementation;

import me.colingrimes.primoria.Primoria;
import me.colingrimes.primoria.weapon.bow.BaseBow;

import javax.annotation.Nonnull;

public class BunkerBow extends BaseBow {

	public BunkerBow(@Nonnull Primoria plugin) {
		super("bunker", "&a&lBunker", "&7Activate the barrier!");
	}

	@Override
	public boolean isEnabled() {
		return false;
	}
}
