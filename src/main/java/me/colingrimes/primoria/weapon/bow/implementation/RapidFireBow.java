package me.colingrimes.primoria.weapon.bow.implementation;

import me.colingrimes.primoria.Primoria;
import me.colingrimes.primoria.weapon.bow.BaseBow;
import me.colingrimes.primoria.weapon.bow.BowEventInfo;
import org.bukkit.entity.Arrow;
import org.bukkit.event.player.PlayerInteractEvent;

import javax.annotation.Nonnull;

public class RapidFireBow extends BaseBow {

	public RapidFireBow(@Nonnull Primoria plugin) {
		super("rapid_fire", "&c&lRapid Fire", "&7BRRRRRRRRRRR!!");
	}

	@Override
	public void activate(@Nonnull PlayerInteractEvent event, @Nonnull BowEventInfo info) {
		info.shooter().launchProjectile(Arrow.class, info.shooter().getLocation().getDirection());
	}
}
