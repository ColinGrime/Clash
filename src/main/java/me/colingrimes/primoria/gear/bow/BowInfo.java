package me.colingrimes.primoria.gear.bow;

import com.google.common.base.Preconditions;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.util.Vector;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class BowInfo {

	private final LivingEntity shooter;
	private final Arrow arrow;
	private final Entity damaged;

	public BowInfo(@Nullable LivingEntity shooter) {
		this(shooter, null);
	}

	public BowInfo(@Nullable LivingEntity shooter, @Nullable Arrow arrow) {
		this(shooter, arrow, null);
	}

	public BowInfo(@Nullable LivingEntity shooter, @Nullable Arrow arrow, @Nullable Entity damaged) {
		this.shooter = shooter;
		this.arrow = arrow;
		this.damaged = damaged;
	}

	/**
	 * Gets the shooter of the bow gear.
	 *
	 * @return the shooter
	 * @throws IllegalStateException if the arrow was spawned in without being attached to a shooter
	 */

	@Nonnull
	public LivingEntity shooter() {
		if (shooter == null) {
			throw new IllegalStateException("Shooter is not available.");
		}
		return shooter;
	}

	/**
	 * Gets the location of the shooter.
	 *
	 * @return the shooter's location
	 * @throws IllegalStateException if the arrow was spawned in without being attached to a shooter
	 */
	@Nonnull
	public Location shooterLocation() {
		return shooter().getLocation();
	}

	/**
	 * Gets the direction of the shooter.
	 *
	 * @return the shooter's direction
	 * @throws IllegalStateException if the arrow was spawned in without being attached to a shooter
	 */
	@Nonnull
	public Vector shooterDirection() {
		return shooter().getLocation().getDirection();
	}

	/**
	 * Gets the arrow of the bow gear.
	 *
	 * @return the arrow
	 * @throws IllegalStateException if no arrow has been shot yet from the bow gear
	 */
	@Nonnull
	public Arrow arrow() {
		if (arrow == null) {
			throw new IllegalStateException("Arrow is not available.");
		}
		return arrow;
	}

	/**
	 * Gets the location of the arrow.
	 *
	 * @return the arrow's location
	 * @throws IllegalStateException if no arrow has been shot yet from the bow gear
	 */
	@Nonnull
	public Location arrowLocation() {
		return arrow().getLocation();
	}

	/**
	 * Gets the direction of the arrow.
	 *
	 * @return the arrow's direction
	 * @throws IllegalStateException if no arrow has been shot yet from the bow gear
	 */
	@Nonnull
	public Vector arrowDirection() {
		return arrow().getLocation().getDirection();
	}

	/**
	 * Removes the shot arrow if present.
	 */
	public void removeArrow() {
		if (arrow != null) {
			arrow.remove();
		}
	}

	/**
	 * Gets the world of the event.
	 *
	 * @return the event world
	 * @throws IllegalStateException if both the {@code shooter} and {@code arrow} are invalid
	 */
	@Nonnull
	public World world() {
		if (shooter != null) {
			return Preconditions.checkNotNull(shooterLocation().getWorld(), "World is null.");
		} else if (arrow != null) {
			return Preconditions.checkNotNull(arrowLocation().getWorld(), "World is null.");
		} else {
			throw new IllegalStateException("Shooter and arrow are both not available.");
		}
	}

	/**
	 * Gets the entity that was damaged by the arrow.
	 *
	 * @return the damaged entity
	 * @throws IllegalStateException if no entity was damaged by the arrow
	 */
	@Nonnull
	public Entity damaged() {
		if (damaged == null) {
			throw new IllegalStateException("Damaged entity is not available.");
		}
		return damaged;
	}
}
