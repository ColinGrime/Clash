package me.colingrimes.colosseum.weapon.bow.implementation;

import me.colingrimes.colosseum.Colosseum;
import me.colingrimes.colosseum.weapon.bow.BaseBow;

import javax.annotation.Nonnull;

public class DisplaceBow extends BaseBow {

	public DisplaceBow(@Nonnull Colosseum plugin) {
		super("displace", "&d&lDisplace", "&7Arrows swap positions with &oany &rentity on hit.");
	}

	@Override
	public boolean isEnabled() {
		return false;
	}
}
