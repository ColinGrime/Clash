package me.colingrimes.primoria.weapon.bow.implementation;

import me.colingrimes.primoria.Primoria;
import me.colingrimes.primoria.weapon.bow.BaseBow;

import javax.annotation.Nonnull;

public class CorruptBow extends BaseBow {

	public CorruptBow(@Nonnull Primoria plugin) {
		super("corrupt", "&c&lCorrupt", "&7Decay &oeverything&r.");
	}

	@Override
	public boolean isEnabled() {
		return false;
	}
}
