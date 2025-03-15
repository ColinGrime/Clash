package me.colingrimes.clash.gear.bow.implementation;

import me.colingrimes.midnight.message.Message;
import me.colingrimes.clash.Clash;
import me.colingrimes.clash.config.GearSettings;
import me.colingrimes.clash.gear.util.GearGrade;
import me.colingrimes.clash.gear.bow.BowGear;
import me.colingrimes.clash.gear.bow.BowInfo;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.entity.ProjectileHitEvent;

import javax.annotation.Nonnull;

public class RiderBow extends BowGear {

	public RiderBow(@Nonnull Clash plugin) {
		super(plugin, "rider");
	}

	@Nonnull
	@Override
	public Message<?> getName() {
		return GearSettings.BOW_RIDER_NAME;
	}

	@Nonnull
	@Override
	public Message<?> getDescription() {
		return GearSettings.BOW_RIDER_DESC;
	}

	@Nonnull
	@Override
	public GearGrade getGrade() {
		return GearGrade.B;
	}

	@Override
	public double getCooldown() {
		return 10;
	}

	@Override
	public boolean removeArrow() {
		return false;
	}

	@Override
	public boolean activate(@Nonnull EntityShootBowEvent event, @Nonnull BowInfo bow) {
		bow.arrow().addPassenger(bow.shooter());
		return true;
	}

	@Override
	public boolean activate(@Nonnull ProjectileHitEvent event, @Nonnull BowInfo bow) {
		bow.arrow().remove();
		return false;
	}
}
