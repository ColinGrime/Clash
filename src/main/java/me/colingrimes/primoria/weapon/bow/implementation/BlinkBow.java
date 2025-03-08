package me.colingrimes.primoria.weapon.bow.implementation;

import me.colingrimes.primoria.Primoria;
import me.colingrimes.primoria.weapon.bow.BaseBow;

import javax.annotation.Nonnull;

public class BlinkBow extends BaseBow {

	public BlinkBow(@Nonnull Primoria plugin) {
		super("blink", "&b&lBlink", "&7Teleport to safety!");
	}

	@Override
	public boolean isEnabled() {
		return false;
	}
}
