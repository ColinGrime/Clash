package me.colingrimes.primoria.weapon.bow.implementation;

import me.colingrimes.primoria.Primoria;
import me.colingrimes.primoria.weapon.bow.BaseBow;
import me.colingrimes.primoria.weapon.bow.BowEventInfo;
import org.bukkit.event.entity.ProjectileHitEvent;

import javax.annotation.Nonnull;

public class TeleportationBow extends BaseBow {

	public TeleportationBow(@Nonnull Primoria plugin) {
		super("teleportation", "&e&lTeleportation", "&7Teleport to your arrow’s landing spot.");
	}

	@Override
	public void activate(@Nonnull ProjectileHitEvent event, @Nonnull BowEventInfo info) {
		info.shooter().teleport(info.location().setDirection(info.shooter().getLocation().getDirection()));
	}
}
