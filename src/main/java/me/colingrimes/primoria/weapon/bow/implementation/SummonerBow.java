package me.colingrimes.primoria.weapon.bow.implementation;

import me.colingrimes.primoria.Primoria;
import me.colingrimes.primoria.weapon.bow.BaseBow;
import me.colingrimes.primoria.weapon.bow.BowEventInfo;
import me.colingrimes.midnight.util.bukkit.Entities;
import me.colingrimes.midnight.util.misc.Random;
import org.bukkit.entity.EntityType;
import org.bukkit.event.entity.ProjectileHitEvent;

import javax.annotation.Nonnull;

public class SummonerBow extends BaseBow {

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
		super("summoner", "&a&lSummoner", "&7Spawns random passive mobs on hit.");
	}

	@Override
	public void activate(@Nonnull ProjectileHitEvent event, @Nonnull BowEventInfo info) {
		int animals = Random.number(2, 4);
		for (int i=0; i<animals; i++) {
			Entities.spawn(Random.item(RANDOM_ANIMALS), info.location());
		}
	}
}
