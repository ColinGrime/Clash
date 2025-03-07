package me.colingrimes.colosseum.weapon.bow.implementation;

import me.colingrimes.colosseum.Colosseum;
import me.colingrimes.colosseum.weapon.bow.BaseBow;

import javax.annotation.Nonnull;

public class ShatterBow extends BaseBow {

	public ShatterBow(@Nonnull Colosseum plugin) {
		super("shatter", "&c&lShatter", "&7Arrows explode on impact!");
	}

	@Override
	public boolean isEnabled() {
		return false;
	}
}
