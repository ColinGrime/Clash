package me.colingrimes.primoria.gear.bow.implementation;

import me.colingrimes.midnight.message.Message;
import me.colingrimes.primoria.Primoria;
import me.colingrimes.primoria.config.GearSettings;
import me.colingrimes.primoria.gear.GearGrade;
import me.colingrimes.primoria.gear.bow.BowGear;
import me.colingrimes.primoria.gear.bow.BowInfo;
import me.colingrimes.midnight.util.Common;
import me.colingrimes.midnight.util.misc.Random;
import org.bukkit.entity.Arrow;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.util.Vector;

import javax.annotation.Nonnull;
import java.util.HashMap;
import java.util.Map;

public class RicochetBow extends BowGear implements Listener {

	private final Map<Arrow, Integer> arrows = new HashMap<>();

	public RicochetBow(@Nonnull Primoria plugin) {
		super(plugin, "ricochet");
		Common.register(plugin, this);
	}

	@Nonnull
	@Override
	public Message<?> getName() {
		return GearSettings.BOW_RICOCHET_NAME;
	}

	@Nonnull
	@Override
	public Message<?> getDescription() {
		return GearSettings.BOW_RICOCHET_DESC;
	}

	@Nonnull
	@Override
	public GearGrade getGrade() {
		return GearGrade.F;
	}

	@Override
	public void activate(@Nonnull ProjectileHitEvent event, @Nonnull BowInfo bow) {
		bow.removeArrow();

		Vector direction = bow.arrowDirection().multiply(Random.decimal(0.6, 0.7)).add(new Vector(0, 0.1, 0));
		Arrow newArrow = bow.world().spawnArrow(bow.arrowLocation(), direction, (float) direction.length(),0);

		int times = arrows.getOrDefault(bow.arrow(), 0) + 1;
		arrows.remove(bow.arrow());
		if (times < 10) {
			arrows.put(newArrow, times);
		}
	}

	@EventHandler
	public void onProjectileHit(@Nonnull ProjectileHitEvent event) {
		if (event.getEntity() instanceof Arrow arrow && arrows.containsKey(arrow)) {
			activate(event, new BowInfo(null, arrow));
		}
	}
}
