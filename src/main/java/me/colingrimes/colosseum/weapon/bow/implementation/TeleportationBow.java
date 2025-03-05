package me.colingrimes.colosseum.weapon.bow.implementation;

import me.colingrimes.colosseum.weapon.bow.BaseBow;
import me.colingrimes.colosseum.weapon.bow.BowEventInfo;
import org.bukkit.event.entity.ProjectileHitEvent;

import javax.annotation.Nonnull;

public class TeleportationBow extends BaseBow {

	public TeleportationBow() {
		super("teleportation", "&e&lTeleportation", "&7Teleport to your arrow’s landing spot.");
	}

	@Override
	public void activate(@Nonnull ProjectileHitEvent event, @Nonnull BowEventInfo info) {
		info.shooter().teleport(info.location().setDirection(info.shooter().getLocation().getDirection()));
	}
}
