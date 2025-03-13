package me.colingrimes.primoria.gear.bow.implementation;

import me.colingrimes.midnight.message.Message;
import me.colingrimes.midnight.util.Common;
import me.colingrimes.primoria.Primoria;
import me.colingrimes.primoria.config.GearSettings;
import me.colingrimes.primoria.gear.GearGrade;
import me.colingrimes.primoria.gear.bow.BowGear;
import me.colingrimes.primoria.gear.bow.BowInfo;
import org.bukkit.Material;
import org.bukkit.entity.Arrow;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;

import javax.annotation.Nonnull;
import java.util.HashMap;
import java.util.Map;

public class BurrowBow extends BowGear implements Listener {

	private final Map<Arrow, Integer> arrows = new HashMap<>();

	public BurrowBow(@Nonnull Primoria plugin) {
		super(plugin, "burrow");
		Common.register(plugin, this);
	}

	@Nonnull
	@Override
	public Message<?> getName() {
		return GearSettings.BOW_BURROW_NAME;
	}

	@Nonnull
	@Override
	public Message<?> getDescription() {
		return GearSettings.BOW_BURROW_DESC;
	}

	@Nonnull
	@Override
	public GearGrade getGrade() {
		return GearGrade.C;
	}

	@Override
	public boolean activate(@Nonnull ProjectileHitEvent event, @Nonnull BowInfo bow) {
		if (event.getHitBlock() == null) {
			arrows.remove(bow.arrow());
			return false;
		}

		bow.removeArrow();
		event.getHitBlock().setType(Material.AIR);

		Arrow arrow = bow.world().spawnArrow(bow.arrowLocation(), bow.arrowDirection(), 0, 0);
		arrow.setVelocity(bow.arrow().getVelocity());

		int times = arrows.getOrDefault(bow.arrow(), 0) + 1;
		arrows.remove(bow.arrow());
		if (times < 10) {
			arrows.put(arrow, times);
		}
		return true;
	}

	@EventHandler
	public void onProjectileHit(@Nonnull ProjectileHitEvent event) {
		BowInfo bow = BowInfo.of(event);
		if (bow != null && arrows.containsKey((Arrow) event.getEntity())) {
			activate(event, bow);
		}
	}
}
