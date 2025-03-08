package me.colingrimes.primoria.weapon.bow.implementation;

import me.colingrimes.primoria.Primoria;
import me.colingrimes.primoria.weapon.bow.BaseBow;

import javax.annotation.Nonnull;

public class ShatterBow extends BaseBow {

	public ShatterBow(@Nonnull Primoria plugin) {
		super("shatter", "&c&lShatter", "&7Arrows explode on impact!");
	}

	@Override
	public boolean isEnabled() {
		return false;
	}
}
