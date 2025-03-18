package me.colingrimes.clash.gear;

import me.colingrimes.clash.gear.util.GearGrade;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.Event;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;
import java.time.Duration;

public interface Gear {

	/**
	 * Gets the ID of the custom gear.
	 *
	 * @return the gear ID
	 */
	@Nonnull
	String getId();

	/**
	 * Gets the colored name of the custom gear.
	 *
	 * @return the gear's name
	 */
	@Nonnull
	String getName();

	/**
	 * Gets the colored description of the custom gear.
	 *
	 * @return the gear's description
	 */
	@Nonnull
	String getDescription();

	/**
	 * Gets the gear's grade.
	 *
	 * @return the grade of gear
	 */
	@Nonnull
	GearGrade getGrade();

	/**
	 * Gets the custom gear.
	 *
	 * @return the custom gear
	 */
	@Nonnull
	ItemStack getGear();

	/**
	 * Gets the gear's cooldown time when activated.
	 * <p>
	 * Set to -1 for no cooldown.
	 *
	 * @return the cooldown time in seconds
	 */
	default double getCooldown() {
		return -1;
	}

	/**
	 * Checks if the specified entity is on cooldown from using this gear.
	 *
	 * @param entity the entity to check
	 * @return true if the entity is on cooldown
	 */
	boolean onCooldown(@Nonnull LivingEntity entity);

	/**
	 * Gets the amount of time left on the cooldown for the specified entity.
	 *
	 * @param entity the entity to check
	 * @return the duration left of the entity
	 */
	@Nonnull
	Duration getTimeLeft(@Nonnull LivingEntity entity);

	/**
	 * Activates the gear's special ability.
	 * Gears will only activate if the right event is passed into it.
	 *
	 * @param event the event associated with the gear's activation
	 * @return true if the gear was succesfully activated
	 */
	boolean activate(@Nonnull Event event);

	/**
	 * Gets whether the custom gear is enabled.
	 * Disabled gear will not be loaded.
	 *
	 * @return true if the gear is enabled
	 */
	default boolean isEnabled() {
		return true;
	}
}
