package me.colingrimes.primoria.weapon.bow.implementation;

import me.colingrimes.primoria.Primoria;
import me.colingrimes.primoria.weapon.bow.BaseBow;
import me.colingrimes.primoria.weapon.bow.BowEventInfo;
import me.colingrimes.primoria.weapon.bow.CustomBow;
import me.colingrimes.midnight.display.Display;
import me.colingrimes.midnight.util.misc.Random;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.entity.ProjectileHitEvent;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;

// TODO - make it so there's a bossbar and it randomly switches bows depending on player
public class MimicBow extends BaseBow {

	private final Primoria plugin;
	private final List<CustomBow> mimicableBows = new ArrayList<>();
	private final List<String> mimicableBowIds = List.of(
			"anchor",
			"cannoneer",
			"grapple",
			"healer",
			"homing",
			"ricochet",
			"rider",
			"sniper",
			"summoner",
			"teleportation",
			"trap",
			"triplet",
			"void"
	);

	public MimicBow(@Nonnull Primoria plugin) {
		super("mimic", "&a&lM&b&li&c&lm&d&li&e&lc", "&7Activates a random ability.");
		this.plugin = plugin;
	}

	@Override
	public void activate(@Nonnull EntityShootBowEvent event, @Nonnull BowEventInfo info) {
		getRandomBow(info.shooter()).activate(event, info);
	}

	@Override
	public void activate(@Nonnull ProjectileHitEvent event, @Nonnull BowEventInfo info) {
		getRandomBow(info.shooter()).activate(event, info);
	}

	@Override
	public void activate(@Nonnull EntityDamageByEntityEvent event, @Nonnull BowEventInfo info) {
		getRandomBow(info.shooter()).activate(event, info);
	}

	@Nonnull
	private CustomBow getRandomBow(@Nonnull Entity entity) {
		if (mimicableBows.isEmpty()) {
			mimicableBows.addAll(plugin.getBows().stream().filter(b -> mimicableBowIds.contains(b.getId())).toList());
		}

		CustomBow bow = Random.item(mimicableBows);
		if (entity instanceof Player player) {
			Display.actionBar(bow.getName()).show(player, 1);
		}
		return bow;
	}
}
