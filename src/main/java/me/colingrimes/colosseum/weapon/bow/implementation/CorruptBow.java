package me.colingrimes.colosseum.weapon.bow.implementation;

import me.colingrimes.colosseum.Colosseum;
import me.colingrimes.colosseum.weapon.bow.BaseBow;

import javax.annotation.Nonnull;

public class CorruptBow extends BaseBow {

	public CorruptBow(@Nonnull Colosseum plugin) {
		super("corrupt", "&c&lCorrupt", "&7Decay &oeverything&r.");
	}

	@Override
	public boolean isEnabled() {
		return false;
	}
}
