package me.colingrimes.colosseum.weapon.bow.implementation;

import me.colingrimes.colosseum.Colosseum;
import me.colingrimes.colosseum.weapon.bow.BaseBow;

import javax.annotation.Nonnull;

public class BlinkBow extends BaseBow {

	public BlinkBow(@Nonnull Colosseum plugin) {
		super("blink", "&b&lBlink", "&7Teleport to safety!");
	}

	@Override
	public boolean isEnabled() {
		return false;
	}
}
