package me.colingrimes.colosseum.weapon.bow.implementation;

import me.colingrimes.colosseum.Colosseum;
import me.colingrimes.colosseum.weapon.bow.BaseBow;

import javax.annotation.Nonnull;

public class MagnetBow extends BaseBow {

	public MagnetBow(@Nonnull Colosseum plugin) {
		super("magnet", "&a&lMagnet", "&7Pulls nearby enemies toward the impact point.");
	}

	@Override
	public boolean isEnabled() {
		return false;
	}
}
