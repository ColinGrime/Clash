package me.colingrimes.colosseum.weapon.bow.implementation;

import me.colingrimes.colosseum.weapon.bow.BaseBow;
import me.colingrimes.colosseum.weapon.bow.BowEventInfo;
import org.bukkit.Location;
import org.bukkit.entity.Arrow;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.util.Vector;

import javax.annotation.Nonnull;

public class TripletBow extends BaseBow {

	public TripletBow() {
		super("triplet", "&b&lTriplet", "&7Shoots three arrows simultaneously!");
	}

	@Override
	public void activate(@Nonnull EntityShootBowEvent event, @Nonnull BowEventInfo info) {
		fireArrow(info, 3);
		fireArrow(info, -3);
	}

	/**
	 * Sets the new yaw and launches the additional arrow.
	 *
	 * @param info the bow event info
	 * @param yaw the new yaw value
	 */
	private void fireArrow(@Nonnull BowEventInfo info, int yaw) {
		Location arrowLocation = info.location();
		arrowLocation.setYaw(arrowLocation.getYaw() + yaw);

		Vector velocity = arrowLocation.getDirection();
		double speed = info.arrow().getVelocity().length();

		info.shooter().launchProjectile(Arrow.class, velocity.multiply(speed));
	}
}
