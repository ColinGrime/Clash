package me.colingrimes.primoria.weapon.bow.implementation;

import me.colingrimes.primoria.Primoria;
import me.colingrimes.primoria.weapon.bow.BaseBow;

import javax.annotation.Nonnull;

public class DisplaceBow extends BaseBow {

	public DisplaceBow(@Nonnull Primoria plugin) {
		super("displace", "&d&lDisplace", "&7Arrows swap positions with &oany &rentity on hit.");
	}

	@Override
	public boolean isEnabled() {
		return false;
	}
}
