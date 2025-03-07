package me.colingrimes.colosseum.weapon.bow.implementation;

import me.colingrimes.colosseum.Colosseum;
import me.colingrimes.colosseum.weapon.bow.BaseBow;

import javax.annotation.Nonnull;

public class PointBlankBow extends BaseBow {

	public PointBlankBow(@Nonnull Colosseum plugin) {
		super("point_blank", "&c&lPoint Blank", "&7Arrows deal significantly more damage at close range.");
	}

	@Override
	public boolean isEnabled() {
		return false;
	}
}
