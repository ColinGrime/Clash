package me.colingrimes.primoria.weapon.bow.implementation;

import me.colingrimes.primoria.Primoria;
import me.colingrimes.primoria.weapon.bow.BaseBow;

import javax.annotation.Nonnull;

public class DisruptorBow extends BaseBow {

	public DisruptorBow(@Nonnull Primoria plugin) {
		super("disruptor", "&d&lDisruptor", "&7Completely disable an enemy weapon.");
	}

	@Override
	public boolean isEnabled() {
		return false;
	}
}
