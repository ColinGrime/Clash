package me.colingrimes.colosseum.weapon.bow.implementation;

import me.colingrimes.colosseum.weapon.bow.BaseBow;
import me.colingrimes.colosseum.weapon.bow.BowEventInfo;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.entity.ProjectileHitEvent;

import javax.annotation.Nonnull;

public class RiderBow extends BaseBow {

	public RiderBow() {
		super("rider", "&e&lRider", "&7Ride your arrow through the air!");
	}

	@Override
	public void activate(@Nonnull EntityShootBowEvent event, @Nonnull BowEventInfo info) {
		info.arrow().addPassenger(info.shooter());
	}

	@Override
	public void activate(@Nonnull ProjectileHitEvent event, @Nonnull BowEventInfo info) {
		info.arrow().remove();
	}
}
