package me.colingrimes.primoria.weapon.bow.implementation;

import me.colingrimes.primoria.Primoria;
import me.colingrimes.primoria.weapon.bow.BaseBow;

import javax.annotation.Nonnull;

public class HexBow extends BaseBow {

	public HexBow(@Nonnull Primoria plugin) {
		super("hex", "&d&lHex", "&7Arrows apply a random negative effect on hit.");
	}

	@Override
	public boolean isEnabled() {
		return false;
	}
}
