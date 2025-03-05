package me.colingrimes.colosseum.weapon.bow.implementation;

import me.colingrimes.colosseum.weapon.bow.BaseBow;

public class CorruptBow extends BaseBow {

	public CorruptBow() {
		super("corrupt", "&c&lCorrupt", "&7Decay &oeverything&r.");
	}

	@Override
	public boolean isEnabled() {
		return false;
	}
}
