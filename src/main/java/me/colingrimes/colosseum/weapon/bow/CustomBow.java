package me.colingrimes.colosseum.weapon.bow;

import me.colingrimes.colosseum.weapon.Weapon;
import me.colingrimes.midnight.util.bukkit.Items;
import org.bukkit.Material;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import javax.annotation.Nonnull;
import java.util.List;

public interface CustomBow extends Weapon {

	/**
	 * Gets the custom weapon.
	 *
	 * @return the custom weapon
	 */
	@Nonnull
	default ItemStack getWeapon() {
		ItemStack item = Items.of(Material.BOW)
				.name(getName())
				.lore(List.of(getLore()))
				.hide(true)
				.glow(true)
				.nbt("custom_bow", getId())
				.build();
		ItemMeta meta = item.getItemMeta();
		meta.setUnbreakable(true);
		item.setItemMeta(meta);
		return item;
	}

	/**
	 * Used to activate interaction abilities.
	 *
	 * @param event the player interact event
	 */
	default void activate(@Nonnull PlayerInteractEvent event) {}

	/**
	 * Used to activate abilities on regular bow shot.
	 * <p>
	 * This method is only called on player bow shot
	 *
	 * @param event the player shoot bow event
	 */
	default void activate(@Nonnull EntityShootBowEvent event) {}

	/**
	 * Used to activate abilities when an arrow lands.
	 * <p>
	 * This method is only called from arrows that are shot from the
	 * {@code EntityShootBowEvent} event.
	 *
	 * @param event the arrow hit event
	 */
	default void activate(@Nonnull ProjectileHitEvent event) {}

	/**
	 * Used to activate abilities when an arrow damages an entity.
	 * <p>
	 * This method is only called from arrows that are shot from the
	 * {@code EntityShootBowEvent} event.
	 *
	 * @param event the arrow damage event
	 */
	default void activate(@Nonnull EntityDamageByEntityEvent event) {}
}
