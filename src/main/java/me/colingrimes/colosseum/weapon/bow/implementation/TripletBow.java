package me.colingrimes.colosseum.weapon.bow.implementation;

import me.colingrimes.colosseum.weapon.bow.BaseBow;
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
	public void activate(@Nonnull EntityShootBowEvent event) {
		fireArrow(event, 3);
		fireArrow(event, -3);
	}

	/**
	 * Sets the new yaw and launches the additional arrow.
	 *
	 * @param event the event
	 * @param yaw the new yaw value
	 */
	private void fireArrow(@Nonnull EntityShootBowEvent event, int yaw) {
		Location arrowLocation = event.getEntity().getLocation().clone();
		arrowLocation.setYaw(arrowLocation.getYaw() + yaw);

		Vector velocity = arrowLocation.getDirection();
		double speed = event.getProjectile().getVelocity().length();

		event.getEntity().launchProjectile(Arrow.class, velocity.multiply(speed));
	}
}
