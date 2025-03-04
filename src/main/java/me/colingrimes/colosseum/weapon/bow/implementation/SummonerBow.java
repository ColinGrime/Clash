package me.colingrimes.colosseum.weapon.bow.implementation;

import me.colingrimes.colosseum.weapon.bow.BaseBow;
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

	public SummonerBow() {
		super("summoner", "&a&lSummoner", "&7Spawns random passive mobs on hit.");
	}

	@Override
	public void activate(@Nonnull ProjectileHitEvent event) {
		int animals = Random.number(2, 4);
		for (int i=0; i<animals; i++) {
			EntityType animal = RANDOM_ANIMALS[Random.number(RANDOM_ANIMALS.length)];
			event.getEntity().getWorld().spawnEntity(event.getEntity().getLocation(), animal);
		}
	}
}
