package me.colingrimes.colosseum.weapon.bow.implementation;

import me.colingrimes.colosseum.weapon.bow.BaseBow;

public class DisruptorBow extends BaseBow {

	public DisruptorBow() {
		super("disruptor", "&d&lDisruptor", "&7Completely disable an enemy weapon.");
	}

	@Override
	public boolean isEnabled() {
		return false;
	}
}
