package me.colingrimes.clash.gear.bow.implementation;

import me.colingrimes.clash.Clash;
import me.colingrimes.clash.config.GearSettings;
import me.colingrimes.clash.gear.util.GearGrade;
import me.colingrimes.clash.gear.bow.BowGear;
import me.colingrimes.clash.gear.bow.BowInfo;
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

	public SummonerBow(@Nonnull Clash plugin) {
		super(plugin, "summoner", GearSettings.BOW_SUMMONER_NAME, GearSettings.BOW_SUMMONER_DESC, GearGrade.F);
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
