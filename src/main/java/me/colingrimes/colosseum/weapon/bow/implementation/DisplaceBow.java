package me.colingrimes.colosseum.weapon.bow.implementation;

import me.colingrimes.colosseum.weapon.bow.BaseBow;

public class DisplaceBow extends BaseBow {

	public DisplaceBow() {
		super("displace", "&d&lDisplace", "&7Arrows swap positions with &oany &rentity on hit.");
	}

	@Override
	public boolean isEnabled() {
		return false;
	}
}
