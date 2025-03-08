package me.colingrimes.primoria.weapon.bow.implementation;

import me.colingrimes.primoria.Primoria;
import me.colingrimes.primoria.weapon.bow.BaseBow;

import javax.annotation.Nonnull;

public class ChainBow extends BaseBow {

	public ChainBow(@Nonnull Primoria plugin) {
		super("chain", "&e&lChain", "&7Chain enemy hits.");
	}

	@Override
	public boolean isEnabled() {
		return false;
	}
}
