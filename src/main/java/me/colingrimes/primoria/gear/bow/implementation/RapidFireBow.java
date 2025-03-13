package me.colingrimes.primoria.gear.bow.implementation;

import me.colingrimes.midnight.message.Message;
import me.colingrimes.primoria.Primoria;
import me.colingrimes.primoria.config.GearSettings;
import me.colingrimes.primoria.gear.GearGrade;
import me.colingrimes.primoria.gear.bow.BowGear;
import me.colingrimes.primoria.gear.bow.BowInfo;
import org.bukkit.entity.Arrow;
import org.bukkit.event.player.PlayerInteractEvent;

import javax.annotation.Nonnull;

public class RapidFireBow extends BowGear {

	public RapidFireBow(@Nonnull Primoria plugin) {
		super(plugin, "rapid_fire");
	}

	@Nonnull
	@Override
	public Message<?> getName() {
		return GearSettings.BOW_RAPID_FIRE_NAME;
	}

	@Nonnull
	@Override
	public Message<?> getDescription() {
		return GearSettings.BOW_RAPID_FIRE_DESC;
	}

	@Nonnull
	@Override
	public GearGrade getGrade() {
		return GearGrade.C;
	}

	@Override
	public boolean activate(@Nonnull PlayerInteractEvent event, @Nonnull BowInfo bow) {
		bow.shooter().launchProjectile(Arrow.class, bow.shooterDirection());
		return true;
	}
}
