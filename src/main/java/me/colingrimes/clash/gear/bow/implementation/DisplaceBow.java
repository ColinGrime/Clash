package me.colingrimes.clash.gear.bow.implementation;

import me.colingrimes.clash.Clash;
import me.colingrimes.clash.config.GearSettings;
import me.colingrimes.clash.gear.bow.BowInfo;
import me.colingrimes.clash.gear.util.GearGrade;
import me.colingrimes.clash.gear.bow.BowGear;
import org.bukkit.Location;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import javax.annotation.Nonnull;

public class DisplaceBow extends BowGear {

	public DisplaceBow(@Nonnull Clash plugin) {
		super(plugin, "displace", GearSettings.BOW_DISPLACE_NAME, GearSettings.BOW_DISPLACE_DESC, GearGrade.D);
	}

	@Override
	public boolean activate(@Nonnull EntityDamageByEntityEvent event, @Nonnull BowInfo bow) {
		Location shooterLocation = bow.shooterLocation();
		Location damagedLocation = bow.damaged().getLocation();
		bow.shooter().teleport(damagedLocation);
		bow.damaged().teleport(shooterLocation);
		return true;
	}
}
