package me.colingrimes.colosseum.weapon.bow.implementation;

import me.colingrimes.colosseum.Colosseum;
import me.colingrimes.colosseum.weapon.bow.BaseBow;

import javax.annotation.Nonnull;

public class RepulsorBow extends BaseBow {

	public RepulsorBow(@Nonnull Colosseum plugin) {
		super("repulsor", "&b&lRepulsor", "&7Create a shockwave that blasts enemies away.");
	}

	@Override
	public boolean isEnabled() {
		return false;
	}
}
