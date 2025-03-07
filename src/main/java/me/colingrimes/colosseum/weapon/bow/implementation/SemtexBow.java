package me.colingrimes.colosseum.weapon.bow.implementation;

import me.colingrimes.colosseum.Colosseum;
import me.colingrimes.colosseum.weapon.bow.BaseBow;

import javax.annotation.Nonnull;

public class SemtexBow extends BaseBow {

	public SemtexBow(@Nonnull Colosseum plugin) {
		super("semtex", "&c&lSemtex", "&7Arrows stick to enemies and explode after a delay.");
	}

	@Override
	public boolean isEnabled() {
		return false;
	}
}
