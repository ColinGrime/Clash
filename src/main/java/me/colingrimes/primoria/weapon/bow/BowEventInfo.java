package me.colingrimes.primoria.weapon.bow;

import com.google.common.base.Preconditions;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class BowEventInfo {

	private final LivingEntity shooter;
	private final Arrow arrow;
	private final Entity damaged;

	public BowEventInfo(@Nonnull LivingEntity shooter) {
		this(shooter, null);
	}

	public BowEventInfo(@Nonnull LivingEntity shooter, @Nullable Arrow arrow) {
		this(shooter, arrow, null);
	}

	public BowEventInfo(@Nonnull LivingEntity shooter, @Nullable Arrow arrow, @Nullable Entity damaged) {
		this.shooter = shooter;
		this.arrow = arrow;
		this.damaged = damaged;
	}

	@Nonnull
	public LivingEntity shooter() {
		return shooter;
	}

	@Nonnull
	public Arrow arrow() {
		Preconditions.checkNotNull(arrow, "Arrow is null.");
		return arrow;
	}

	/**
	 * Gets the location of the arrow.
	 *
	 * @return the arrow's location
	 */
	@Nonnull
	public Location location() {
		Preconditions.checkNotNull(arrow, "Arrow is null.");
		Preconditions.checkNotNull(arrow.getLocation(), "Arrow's location is null.");
		return arrow.getLocation().clone();
	}

	/**
	 * Gets the world of the event.
	 *
	 * @return the event world
	 */
	@Nonnull
	public World world() {
		Preconditions.checkNotNull(shooter.getLocation(), "Shooter's location is null.");
		Preconditions.checkNotNull(shooter.getLocation().getWorld(), "Shooter's world is null.");
		return shooter.getLocation().getWorld();
	}

	/**
	 * Gets the entity that was damaged by the arrow.
	 *
	 * @return the damaged entity
	 */
	@Nonnull
	public Entity damaged() {
		Preconditions.checkNotNull(damaged, "Damaged entity is null.");
		return damaged;
	}
}
