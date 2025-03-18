package me.colingrimes.clash.gear.bow.implementation;

import me.colingrimes.clash.Clash;
import me.colingrimes.clash.config.GearSettings;
import me.colingrimes.clash.gear.util.GearGrade;
import me.colingrimes.clash.gear.bow.BowGear;
import me.colingrimes.clash.gear.bow.BowInfo;
import org.bukkit.event.entity.ProjectileHitEvent;

import javax.annotation.Nonnull;

public class ShatterBow extends BowGear {

	public ShatterBow(@Nonnull Clash plugin) {
		super(plugin, "shatter", GearSettings.BOW_SHATTER_NAME, GearSettings.BOW_SHATTER_DESC, GearGrade.B);
	}

	@Override
	public double getCooldown() {
		return 5;
	}

	@Override
	public boolean activate(@Nonnull ProjectileHitEvent event, @Nonnull BowInfo bow) {
		bow.world().createExplosion(bow.arrowLocation(), 6F, true);
		return true;
	}
}
