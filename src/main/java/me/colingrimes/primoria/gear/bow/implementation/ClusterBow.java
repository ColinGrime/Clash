package me.colingrimes.primoria.gear.bow.implementation;

import me.colingrimes.midnight.message.Message;
import me.colingrimes.midnight.util.misc.Random;
import me.colingrimes.primoria.Primoria;
import me.colingrimes.primoria.config.GearSettings;
import me.colingrimes.primoria.gear.util.GearGrade;
import me.colingrimes.primoria.gear.bow.BowGear;
import me.colingrimes.primoria.gear.bow.BowInfo;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.util.Vector;

import javax.annotation.Nonnull;

public class ClusterBow extends BowGear {

	public ClusterBow(@Nonnull Primoria plugin) {
		super(plugin, "cluster");
	}

	@Nonnull
	@Override
	public Message<?> getName() {
		return GearSettings.BOW_CLUSTER_NAME;
	}

	@Nonnull
	@Override
	public Message<?> getDescription() {
		return GearSettings.BOW_CLUSTER_DESC;
	}

	@Nonnull
	@Override
	public GearGrade getGrade() {
		return GearGrade.F;
	}

	@Override
	public boolean activate(@Nonnull ProjectileHitEvent event, @Nonnull BowInfo bow) {
		bow.arrow().remove();
		for (int i=0; i<20; i++) {
			bow.world().spawnArrow(bow.arrowLocation(), new Vector(0, 1, 0), (float) Random.decimal(0.8, 1.2), 10);
		}
		return true;
	}
}
