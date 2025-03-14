package me.colingrimes.primoria.gear.bow.implementation;

import me.colingrimes.midnight.message.Message;
import me.colingrimes.primoria.Primoria;
import me.colingrimes.primoria.config.GearSettings;
import me.colingrimes.primoria.gear.util.GearGrade;
import me.colingrimes.primoria.gear.bow.BowGear;
import me.colingrimes.primoria.gear.bow.BowInfo;
import org.bukkit.event.entity.ProjectileHitEvent;

import javax.annotation.Nonnull;

public class TeleportationBow extends BowGear {

	public TeleportationBow(@Nonnull Primoria plugin) {
		super(plugin, "teleportation");
	}

	@Nonnull
	@Override
	public Message<?> getName() {
		return GearSettings.BOW_TELEPORTATION_NAME;
	}

	@Nonnull
	@Override
	public Message<?> getDescription() {
		return GearSettings.BOW_TELEPORTATION_DESC;
	}

	@Nonnull
	@Override
	public GearGrade getGrade() {
		return GearGrade.A;
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
