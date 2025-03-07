package me.colingrimes.colosseum.weapon.bow.implementation;

import me.colingrimes.colosseum.Colosseum;
import me.colingrimes.colosseum.weapon.bow.BaseBow;

import javax.annotation.Nonnull;

public class ClusterBow extends BaseBow {

	public ClusterBow(@Nonnull Colosseum plugin) {
		super("cluster", "&c&lCluster", "&7Fire a cluster on impact!");
	}

	@Override
	public boolean isEnabled() {
		return false;
	}
}
