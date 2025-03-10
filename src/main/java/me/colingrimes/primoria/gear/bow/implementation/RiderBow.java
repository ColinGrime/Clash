package me.colingrimes.primoria.gear.bow.implementation;

import me.colingrimes.midnight.message.Message;
import me.colingrimes.primoria.Primoria;
import me.colingrimes.primoria.config.GearSettings;
import me.colingrimes.primoria.gear.bow.BowGear;
import me.colingrimes.primoria.gear.bow.BowInfo;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.entity.ProjectileHitEvent;

import javax.annotation.Nonnull;

public class RiderBow extends BowGear {

	public RiderBow(@Nonnull Primoria plugin) {
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

	@Override
	public void activate(@Nonnull EntityShootBowEvent event, @Nonnull BowInfo bow) {
		bow.arrow().addPassenger(bow.shooter());
	}

	@Override
	public void activate(@Nonnull ProjectileHitEvent event, @Nonnull BowInfo bow) {
		bow.arrow().remove();
	}
}
