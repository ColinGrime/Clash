package me.colingrimes.primoria.gear;

import me.colingrimes.midnight.message.Message;
import org.bukkit.event.Event;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;

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
	Message<?> getName();

	/**
	 * Gets the colored description of the custom gear.
	 *
	 * @return the gear's description
	 */
	@Nonnull
	Message<?> getDescription();

	/**
	 * Gets the gear's grade.
	 *
	 * @return the grade of gear
	 */
	@Nonnull
	GearGrade getGrade();

	/**
	 * Gets the gear's cooldown time when used.
	 * <p>
	 * Set to -1 for no cooldown.
	 *
	 * @return the cooldown time in ticks
	 */
	default int getCooldown() {
		return -1;
	}

	/**
	 * Gets the custom gear.
	 *
	 * @return the custom gear
	 */
	@Nonnull
	ItemStack getGear();

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
