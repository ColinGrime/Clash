package me.colingrimes.colosseum.weapon.bow.implementation;

import me.colingrimes.colosseum.weapon.bow.BaseBow;

public class EmberBow extends BaseBow {

	public EmberBow() {
		super("ember", "&c&lEmber", "&7Set the world ablaze.");
	}

	@Override
	public boolean isEnabled() {
		return false;
	}
}
