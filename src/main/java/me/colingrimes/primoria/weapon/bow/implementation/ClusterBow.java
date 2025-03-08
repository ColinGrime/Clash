package me.colingrimes.primoria.weapon.bow.implementation;

import me.colingrimes.primoria.Primoria;
import me.colingrimes.primoria.weapon.bow.BaseBow;

import javax.annotation.Nonnull;

public class ClusterBow extends BaseBow {

	public ClusterBow(@Nonnull Primoria plugin) {
		super("cluster", "&c&lCluster", "&7Fire a cluster on impact!");
	}

	@Override
	public boolean isEnabled() {
		return false;
	}
}
