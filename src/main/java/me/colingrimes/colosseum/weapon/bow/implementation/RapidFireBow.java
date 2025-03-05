package me.colingrimes.colosseum.weapon.bow.implementation;

import me.colingrimes.colosseum.weapon.bow.BaseBow;
import me.colingrimes.colosseum.weapon.bow.BowEventInfo;
import org.bukkit.entity.Arrow;
import org.bukkit.event.player.PlayerInteractEvent;

import javax.annotation.Nonnull;

public class RapidFireBow extends BaseBow {

	public RapidFireBow() {
		super("rapid_fire", "&c&lRapid Fire", "&7BRRRRRRRRRRR!!");
	}

	@Override
	public void activate(@Nonnull PlayerInteractEvent event, @Nonnull BowEventInfo info) {
		info.shooter().launchProjectile(Arrow.class, info.shooter().getLocation().getDirection());
	}
}
