package me.colingrimes.clash.gear.bow.implementation;

import me.colingrimes.midnight.message.Message;
import me.colingrimes.clash.Clash;
import me.colingrimes.clash.config.GearSettings;
import me.colingrimes.clash.gear.util.GearGrade;
import me.colingrimes.clash.gear.bow.BowGear;
import me.colingrimes.clash.gear.bow.BowInfo;
import org.bukkit.entity.Arrow;
import org.bukkit.event.player.PlayerInteractEvent;

import javax.annotation.Nonnull;

public class RapidFireBow extends BowGear {

	public RapidFireBow(@Nonnull Clash plugin) {
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
