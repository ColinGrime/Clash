package me.colingrimes.primoria.weapon.bow.implementation;

import me.colingrimes.primoria.Primoria;
import me.colingrimes.primoria.weapon.bow.BaseBow;

import javax.annotation.Nonnull;

public class RepulsorBow extends BaseBow {

	public RepulsorBow(@Nonnull Primoria plugin) {
		super("repulsor", "&b&lRepulsor", "&7Create a shockwave that blasts enemies away.");
	}

	@Override
	public boolean isEnabled() {
		return false;
	}
}
