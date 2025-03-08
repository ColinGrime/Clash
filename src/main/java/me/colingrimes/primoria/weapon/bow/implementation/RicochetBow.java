package me.colingrimes.primoria.weapon.bow.implementation;

import me.colingrimes.primoria.Primoria;
import me.colingrimes.primoria.weapon.bow.BaseBow;
import me.colingrimes.primoria.weapon.bow.BowEventInfo;
import me.colingrimes.midnight.util.Common;
import me.colingrimes.midnight.util.misc.Random;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.util.Vector;

import javax.annotation.Nonnull;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class RicochetBow extends BaseBow implements Listener {

	private final Map<Arrow, Integer> ricochetArrows = new HashMap<>();

	public RicochetBow(@Nonnull Primoria plugin) {
		super("ricochet", "&e&lRicochet", "&7Arrows bounce off surfaces.");
		Common.register(plugin, this);
	}

	@Override
	public void activate(@Nonnull ProjectileHitEvent event, @Nonnull BowEventInfo info) {
		info.arrow().remove();

		Vector direction = info.location().getDirection().multiply(Random.decimal(0.6, 0.7)).add(new Vector(0, 0.1, 0));
		Arrow newArrow = info.world().spawnArrow(info.location(), direction, (float) direction.length(),0);

		int ricochets = ricochetArrows.getOrDefault(info.arrow(), 1);
		ricochetArrows.remove(info.arrow());
		if (ricochets < 5) {
			ricochetArrows.put(newArrow, ricochets);
		}
	}

	@EventHandler
	public void onProjectileHit(@Nonnull ProjectileHitEvent event) {
		if (event.getEntity() instanceof Arrow arrow && ricochetArrows.containsKey(arrow)) {
			LivingEntity entity = (LivingEntity) event.getEntity().getShooter();
			activate(event, new BowEventInfo(Objects.requireNonNull(entity), arrow));
		}
	}
}
