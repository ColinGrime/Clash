package me.colingrimes.primoria.gear.bow.implementation;

import me.colingrimes.midnight.message.Message;
import me.colingrimes.primoria.Primoria;
import me.colingrimes.primoria.config.GearSettings;
import me.colingrimes.primoria.gear.bow.BowInfo;
import me.colingrimes.primoria.gear.bow.BowGear;
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
public class MimicBow extends BowGear {

	private final Primoria plugin;
	private final List<BowGear> mimicableBows = new ArrayList<>();
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
		super(plugin, "mimic");
		this.plugin = plugin;
	}

	@Nonnull
	@Override
	public Message<?> getName() {
		return GearSettings.BOW_MIMIC_NAME;
	}

	@Nonnull
	@Override
	public Message<?> getDescription() {
		return GearSettings.BOW_MIMIC_DESC;
	}

	@Override
	public void activate(@Nonnull EntityShootBowEvent event, @Nonnull BowInfo bow) {
		getRandomBow(bow.shooter()).activate(event, bow);
	}

	@Override
	public void activate(@Nonnull ProjectileHitEvent event, @Nonnull BowInfo bow) {
		getRandomBow(bow.shooter()).activate(event, bow);
	}

	@Override
	public void activate(@Nonnull EntityDamageByEntityEvent event, @Nonnull BowInfo bow) {
		getRandomBow(bow.shooter()).activate(event, bow);
	}

	@Nonnull
	private BowGear getRandomBow(@Nonnull Entity entity) {
		if (mimicableBows.isEmpty()) {
			mimicableBows.addAll(plugin.getBows().stream().filter(b -> mimicableBowIds.contains(b.getId())).toList());
		}

		BowGear bow = Random.item(mimicableBows);
		if (entity instanceof Player player) {
			Display.actionBar(bow.getName().toText()).show(player, 1);
		}
		return bow;
	}
}
