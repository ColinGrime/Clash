package me.colingrimes.clash.gear.bow.implementation;

import me.colingrimes.clash.Clash;
import me.colingrimes.clash.config.GearSettings;
import me.colingrimes.clash.gear.util.GearGrade;
import me.colingrimes.clash.gear.bow.BowGear;
import me.colingrimes.clash.gear.bow.BowInfo;
import me.colingrimes.midnight.util.bukkit.Entities;
import org.bukkit.entity.EntityType;
import org.bukkit.event.entity.ProjectileHitEvent;

import javax.annotation.Nonnull;

public class CannoneerBow extends BowGear {

	public CannoneerBow(@Nonnull Clash plugin) {
		super(plugin, "cannoneer", GearSettings.BOW_CANNONEER_NAME, GearSettings.BOW_CANNONEER_DESC, GearGrade.B);
	}

	@Override
	public double getCooldown() {
		return 5;
	}

	@Override
	public boolean activate(@Nonnull ProjectileHitEvent event, @Nonnull BowInfo bow) {
		for (int i=0; i<3; i++) {
			Entities.spawn(EntityType.TNT, bow.arrowLocation());
		}
		return true;
	}
}
