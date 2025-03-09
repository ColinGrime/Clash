package me.colingrimes.primoria.weapon.bow.implementation;

import me.colingrimes.midnight.util.misc.Random;
import me.colingrimes.primoria.Primoria;
import me.colingrimes.primoria.weapon.bow.BaseBow;
import me.colingrimes.primoria.weapon.bow.BowEventInfo;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.util.Vector;

import javax.annotation.Nonnull;

public class ClusterBow extends BaseBow {

	public ClusterBow(@Nonnull Primoria plugin) {
		super("cluster", "&c&lCluster", "&7Fire a cluster on impact!");
	}

	@Override
	public void activate(@Nonnull ProjectileHitEvent event, @Nonnull BowEventInfo info) {
		info.arrow().remove();
		for (int i=0; i<20; i++) {
			info.world().spawnArrow(info.location(), new Vector(0, 1, 0), (float) Random.decimal(0.8, 1.2), 10);
		}
	}
}
