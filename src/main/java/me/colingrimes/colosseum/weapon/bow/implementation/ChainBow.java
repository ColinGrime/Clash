package me.colingrimes.colosseum.weapon.bow.implementation;

import me.colingrimes.colosseum.Colosseum;
import me.colingrimes.colosseum.weapon.bow.BaseBow;

import javax.annotation.Nonnull;

public class ChainBow extends BaseBow {

	public ChainBow(@Nonnull Colosseum plugin) {
		super("chain", "&e&lChain", "&7Chain enemy hits.");
	}

	@Override
	public boolean isEnabled() {
		return false;
	}
}
