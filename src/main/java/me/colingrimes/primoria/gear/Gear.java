package me.colingrimes.primoria.gear;

import me.colingrimes.midnight.message.Message;
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
	 * Gets the custom gear.
	 *
	 * @return the custom gear
	 */
	@Nonnull
	ItemStack getGear();

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
