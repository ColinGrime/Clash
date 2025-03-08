package me.colingrimes.primoria.weapon.bow.implementation;

import me.colingrimes.primoria.Primoria;
import me.colingrimes.primoria.weapon.bow.BaseBow;

import javax.annotation.Nonnull;

public class SemtexBow extends BaseBow {

	public SemtexBow(@Nonnull Primoria plugin) {
		super("semtex", "&c&lSemtex", "&7Arrows stick to enemies and explode after a delay.");
	}

	@Override
	public boolean isEnabled() {
		return false;
	}
}
