package me.colingrimes.colosseum.weapon.bow.implementation;

import me.colingrimes.colosseum.Colosseum;
import me.colingrimes.colosseum.weapon.bow.BaseBow;

import javax.annotation.Nonnull;

public class DisruptorBow extends BaseBow {

	public DisruptorBow(@Nonnull Colosseum plugin) {
		super("disruptor", "&d&lDisruptor", "&7Completely disable an enemy weapon.");
	}

	@Override
	public boolean isEnabled() {
		return false;
	}
}
