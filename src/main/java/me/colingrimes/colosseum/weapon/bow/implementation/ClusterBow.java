package me.colingrimes.colosseum.weapon.bow.implementation;

import me.colingrimes.colosseum.weapon.bow.BaseBow;

public class ClusterBow extends BaseBow {

	public ClusterBow() {
		super("cluster", "&c&lCluster", "&7Fire a cluster on impact!");
	}

	@Override
	public boolean isEnabled() {
		return false;
	}
}
