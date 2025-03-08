package me.colingrimes.primoria.weapon.bow.implementation;

import me.colingrimes.primoria.Primoria;
import me.colingrimes.primoria.weapon.bow.BaseBow;

import javax.annotation.Nonnull;

public class MagnetBow extends BaseBow {

	public MagnetBow(@Nonnull Primoria plugin) {
		super("magnet", "&a&lMagnet", "&7Pulls nearby enemies toward the impact point.");
	}

	@Override
	public boolean isEnabled() {
		return false;
	}
}
