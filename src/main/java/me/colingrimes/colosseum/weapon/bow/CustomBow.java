package me.colingrimes.colosseum.weapon.bow;

import me.colingrimes.colosseum.weapon.Weapon;
import me.colingrimes.midnight.util.bukkit.Items;
import org.bukkit.Material;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerPickupArrowEvent;
import org.bukkit.inventory.ItemFlag;
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
		meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
		item.setItemMeta(meta);
		return item;
	}

	/**
	 * Used to activate interaction abilities.
	 *
	 * @param event the player interact event
	 * @param info the bow event info
	 */
	default void activate(@Nonnull PlayerInteractEvent event, @Nonnull BowEventInfo info) {}

	/**
	 * Used to activate abilities on regular bow shot.
	 *
	 * @param event the player shoot bow event
	 * @param info the bow event info
	 */
	default void activate(@Nonnull EntityShootBowEvent event, @Nonnull BowEventInfo info) {}

	/**
	 * Used to activate abilities when an arrow lands.
	 * <p>
	 * This method is only called from arrows that are shot from the
	 * {@code EntityShootBowEvent} event.
	 *
	 * @param event the arrow hit event
	 * @param info the bow event info
	 */
	default void activate(@Nonnull ProjectileHitEvent event, @Nonnull BowEventInfo info) {}

	/**
	 * Used to activate abilities when an arrow damages an entity.
	 * <p>
	 * This method is only called from arrows that are shot from the
	 * {@code EntityShootBowEvent} event.
	 *
	 * @param event the arrow damage event
	 * @param info the bow event info
	 */
	default void activate(@Nonnull EntityDamageByEntityEvent event, @Nonnull BowEventInfo info) {}

	/**
	 * Used to handle custom arrow pickup events.
	 *
	 * @param event the arrow pickup event
	 * @param info the bow event info
	 */
	default void activate(@Nonnull PlayerPickupArrowEvent event, @Nonnull BowEventInfo info) {}
}
