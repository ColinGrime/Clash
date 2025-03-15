package me.colingrimes.clash.gear.bow.implementation;

import me.colingrimes.midnight.message.Message;
import me.colingrimes.clash.Clash;
import me.colingrimes.clash.config.GearSettings;
import me.colingrimes.clash.gear.util.GearGrade;
import me.colingrimes.clash.gear.bow.BowGear;
import me.colingrimes.clash.gear.bow.BowInfo;
import org.bukkit.Location;
import org.bukkit.entity.Arrow;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.util.Vector;

import javax.annotation.Nonnull;

public class TripletBow extends BowGear {

	public TripletBow(@Nonnull Clash plugin) {
		super(plugin, "triplet");
	}

	@Nonnull
	@Override
	public Message<?> getName() {
		return GearSettings.BOW_TRIPLET_NAME;
	}

	@Nonnull
	@Override
	public Message<?> getDescription() {
		return GearSettings.BOW_TRIPLET_DESC;
	}

	@Nonnull
	@Override
	public GearGrade getGrade() {
		return GearGrade.C;
	}

	@Override
	public double getCooldown() {
		return 1;
	}

	@Override
	public boolean activate(@Nonnull EntityShootBowEvent event, @Nonnull BowInfo bow) {
		fireArrow(bow, 3);
		fireArrow(bow, -3);
		return true;
	}

	/**
	 * Sets the new yaw and launches the additional arrow.
	 *
	 * @param info the bow event info
	 * @param yaw the new yaw value
	 */
	private void fireArrow(@Nonnull BowInfo info, int yaw) {
		Location location = info.shooter().getLocation();
		location.setYaw(location.getYaw() + yaw);

		Vector velocity = location.getDirection();
		double speed = info.arrow().getVelocity().length();

		info.shooter().launchProjectile(Arrow.class, velocity.multiply(speed));
	}
}
