package me.colingrimes.colosseum.weapon.bow.implementation;

import me.colingrimes.colosseum.weapon.bow.BaseBow;
import me.colingrimes.midnight.plugin.MidnightPlugin;
import me.colingrimes.midnight.util.Common;
import me.colingrimes.midnight.util.misc.Random;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.util.Vector;

import javax.annotation.Nonnull;
import java.util.HashMap;
import java.util.Map;

public class RicochetBow extends BaseBow implements Listener {

	private final Map<Entity, Integer> ricochetArrows = new HashMap<>();

	public RicochetBow() {
		super("ricochet", "&e&lRicochet", "&7Arrows bounce off surfaces.");
		Common.register(MidnightPlugin.get(), this);
	}

	@Override
	public void activate(@Nonnull ProjectileHitEvent event) {
		Entity arrow = event.getEntity();
		arrow.remove();

		Location location = arrow.getLocation();
		Vector velocity = location.getDirection().multiply(Random.decimal(0.6, 0.7)).add(new Vector(0, 0.1, 0));
		Entity newArrow = location.getWorld().spawnArrow(location, velocity, (float) velocity.length(),0);

		int ricochets = ricochetArrows.getOrDefault(arrow, 1);
		ricochetArrows.remove(arrow);
		if (ricochets < 5) {
			ricochetArrows.put(newArrow, ricochets);
		}
	}

	@EventHandler
	public void onRicochetArrowHit(@Nonnull ProjectileHitEvent event) {
		if (ricochetArrows.containsKey(event.getEntity())) {
			activate(event);
		}
	}
}
