package me.colingrimes.colosseum.weapon.bow.implementation;

import me.colingrimes.colosseum.Colosseum;
import me.colingrimes.colosseum.weapon.bow.BaseBow;

import javax.annotation.Nonnull;

public class HexBow extends BaseBow {

	public HexBow(@Nonnull Colosseum plugin) {
		super("hex", "&d&lHex", "&7Arrows apply a random negative effect on hit.");
	}

	@Override
	public boolean isEnabled() {
		return false;
	}
}
