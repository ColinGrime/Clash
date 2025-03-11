package me.colingrimes.primoria.gear.bow.implementation;

import me.colingrimes.midnight.message.Message;
import me.colingrimes.primoria.Primoria;
import me.colingrimes.primoria.config.GearSettings;
import me.colingrimes.primoria.gear.GearGrade;
import me.colingrimes.primoria.gear.bow.BowGear;
import me.colingrimes.primoria.gear.bow.BowInfo;
import me.colingrimes.midnight.util.bukkit.Entities;
import org.bukkit.entity.EntityType;
import org.bukkit.event.entity.ProjectileHitEvent;

import javax.annotation.Nonnull;

public class CannoneerBow extends BowGear {

	public CannoneerBow(@Nonnull Primoria plugin) {
		super(plugin, "cannoneer");
	}

	@Nonnull
	@Override
	public Message<?> getName() {
		return GearSettings.BOW_CANNONEER_NAME;
	}

	@Nonnull
	@Override
	public Message<?> getDescription() {
		return GearSettings.BOW_CANNONEER_DESC;
	}

	@Nonnull
	@Override
	public GearGrade getGrade() {
		return GearGrade.B;
	}

	@Override
	public void activate(@Nonnull ProjectileHitEvent event, @Nonnull BowInfo bow) {
		for (int i=0; i<3; i++) {
			Entities.spawn(EntityType.TNT, bow.arrowLocation());
		}
	}
}
