package me.colingrimes.colosseum.weapon;

import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;

public interface Weapon {

	/**
	 * Gets the ID of the weapon
	 *
	 * @return the weapon ID
	 */
	@Nonnull
	String getId();

	/**
	 * Gets the colored name of the weapon.
	 *
	 * @return the bow's name
	 */
	@Nonnull
	String getName();

	/**
	 * Gets the colored lore of the weapon.
	 *
	 * @return the bow's lore
	 */
	@Nonnull
	String[] getLore();

	/**
	 * Gets the custom weapon.
	 *
	 * @return the custom weapon
	 */
	@Nonnull
	ItemStack getWeapon();
}
