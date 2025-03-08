package me.colingrimes.primoria.weapon.bow.implementation;

import me.colingrimes.primoria.Primoria;
import me.colingrimes.primoria.weapon.bow.BaseBow;

import javax.annotation.Nonnull;

public class PointBlankBow extends BaseBow {

	public PointBlankBow(@Nonnull Primoria plugin) {
		super("point_blank", "&c&lPoint Blank", "&7Arrows deal significantly more damage at close range.");
	}

	@Override
	public boolean isEnabled() {
		return false;
	}
}
