package me.colingrimes.clash.gear.bow.implementation;

import me.colingrimes.midnight.message.Message;
import me.colingrimes.midnight.util.misc.Random;
import me.colingrimes.clash.Clash;
import me.colingrimes.clash.config.GearSettings;
import me.colingrimes.clash.gear.util.GearGrade;
import me.colingrimes.clash.gear.bow.BowGear;
import me.colingrimes.clash.gear.bow.BowInfo;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.util.Vector;

import javax.annotation.Nonnull;

public class ClusterBow extends BowGear {

	public ClusterBow(@Nonnull Clash plugin) {
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
	public double getCooldown() {
		return 3;
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
