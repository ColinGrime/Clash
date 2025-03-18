package me.colingrimes.clash.gear.bow.implementation;

import me.colingrimes.clash.Clash;
import me.colingrimes.clash.config.GearSettings;
import me.colingrimes.clash.gear.util.GearGrade;
import me.colingrimes.clash.gear.bow.BowGear;
import me.colingrimes.clash.gear.bow.BowInfo;
import org.bukkit.event.entity.ProjectileHitEvent;

import javax.annotation.Nonnull;

public class TeleportationBow extends BowGear {

	public TeleportationBow(@Nonnull Clash plugin) {
		super(plugin, "teleportation", GearSettings.BOW_TELEPORTATION_NAME, GearSettings.BOW_TELEPORTATION_DESC, GearGrade.A);
	}

	@Override
	public double getCooldown() {
		return 10;
	}

	@Override
	public boolean activate(@Nonnull ProjectileHitEvent event, @Nonnull BowInfo bow) {
		bow.shooter().teleport(bow.arrowLocation().setDirection(bow.shooter().getLocation().getDirection()));
		return true;
	}
}
