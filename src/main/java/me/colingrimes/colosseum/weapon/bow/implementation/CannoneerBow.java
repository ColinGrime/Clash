package me.colingrimes.colosseum.weapon.bow.implementation;

import me.colingrimes.colosseum.Colosseum;
import me.colingrimes.colosseum.weapon.bow.BaseBow;
import me.colingrimes.colosseum.weapon.bow.BowEventInfo;
import me.colingrimes.midnight.util.bukkit.Entities;
import org.bukkit.entity.EntityType;
import org.bukkit.event.entity.ProjectileHitEvent;

import javax.annotation.Nonnull;

public class CannoneerBow extends BaseBow {

	public CannoneerBow(@Nonnull Colosseum plugin) {
		super("cannoneer", "&c&lCannoneer", "&7T-N-T");
	}

	@Override
	public void activate(@Nonnull ProjectileHitEvent event, @Nonnull BowEventInfo info) {
		for (int i=0; i<3; i++) {
			Entities.spawn(EntityType.TNT, info.location());
		}
	}
}
