package me.colingrimes.primoria.weapon.bow.implementation;

import me.colingrimes.primoria.Primoria;
import me.colingrimes.primoria.weapon.bow.BaseBow;
import me.colingrimes.primoria.weapon.bow.BowEventInfo;
import org.bukkit.Location;
import org.bukkit.entity.Arrow;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.util.Vector;

import javax.annotation.Nonnull;

public class TripletBow extends BaseBow {

	public TripletBow(@Nonnull Primoria plugin) {
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
		Location location = info.shooter().getLocation();
		location.setYaw(location.getYaw() + yaw);

		Vector velocity = location.getDirection();
		double speed = info.arrow().getVelocity().length();

		info.shooter().launchProjectile(Arrow.class, velocity.multiply(speed));
	}
}
