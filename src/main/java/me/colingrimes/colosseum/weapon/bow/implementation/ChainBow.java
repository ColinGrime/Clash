package me.colingrimes.colosseum.weapon.bow.implementation;

import me.colingrimes.colosseum.weapon.bow.BaseBow;

public class ChainBow extends BaseBow {

	public ChainBow() {
		super("chain", "&e&lChain", "&7Chain enemy hits.");
	}

	@Override
	public boolean isEnabled() {
		return false;
	}
}
