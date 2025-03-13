package me.colingrimes.primoria.gear.bow.implementation;

import me.colingrimes.midnight.message.Message;
import me.colingrimes.primoria.Primoria;
import me.colingrimes.primoria.config.GearSettings;
import me.colingrimes.primoria.gear.GearGrade;
import me.colingrimes.primoria.gear.bow.BowGear;
import me.colingrimes.primoria.gear.bow.BowInfo;
import me.colingrimes.midnight.util.bukkit.Entities;
import me.colingrimes.midnight.util.misc.Random;
import org.bukkit.entity.EntityType;
import org.bukkit.event.entity.ProjectileHitEvent;

import javax.annotation.Nonnull;

public class SummonerBow extends BowGear {

	private final EntityType[] RANDOM_ANIMALS = {
			EntityType.PIG,
			EntityType.COW,
			EntityType.SHEEP,
			EntityType.CHICKEN,
			EntityType.HORSE,
			EntityType.DONKEY,
			EntityType.LLAMA
	};

	public SummonerBow(@Nonnull Primoria plugin) {
		super(plugin, "summoner");
	}

	@Nonnull
	@Override
	public Message<?> getName() {
		return GearSettings.BOW_SUMMONER_NAME;
	}

	@Nonnull
	@Override
	public Message<?> getDescription() {
		return GearSettings.BOW_SUMMONER_DESC;
	}

	@Nonnull
	@Override
	public GearGrade getGrade() {
		return GearGrade.F;
	}

	@Override
	public boolean activate(@Nonnull ProjectileHitEvent event, @Nonnull BowInfo bow) {
		int animals = Random.number(2, 4);
		for (int i=0; i<animals; i++) {
			Entities.spawn(Random.item(RANDOM_ANIMALS), bow.arrowLocation());
		}
		return true;
	}
}
