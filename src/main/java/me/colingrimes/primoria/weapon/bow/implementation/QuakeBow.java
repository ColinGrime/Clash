package me.colingrimes.primoria.weapon.bow.implementation;

import me.colingrimes.primoria.Primoria;
import me.colingrimes.primoria.weapon.bow.BaseBow;

import javax.annotation.Nonnull;

public class QuakeBow extends BaseBow {

	public QuakeBow(@Nonnull Primoria plugin) {
		super("quake", "&b&lQuake", "&7Creates a small shockwave where the arrow lands.");
	}

	@Override
	public boolean isEnabled() {
		return false;
	}
}
