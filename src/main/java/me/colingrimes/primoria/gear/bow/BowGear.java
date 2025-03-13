package me.colingrimes.primoria.gear.bow;

import me.colingrimes.midnight.util.Common;
import me.colingrimes.primoria.Primoria;
import me.colingrimes.primoria.api.GearUseEvent;
import me.colingrimes.primoria.gear.Gear;
import me.colingrimes.midnight.util.bukkit.Items;
import org.bukkit.Material;
import org.bukkit.event.Event;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerPickupArrowEvent;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;

public abstract class BowGear implements Gear {

	protected Primoria plugin;
	protected String id;

	public BowGear(@Nonnull Primoria plugin, @Nonnull String id) {
		this.plugin = plugin;
		this.id = id;
	}

	@Nonnull
	@Override
	public String getId() {
		return id;
	}

	@Nonnull
	public ItemStack getGear() {
		return Items.of(Material.BOW)
				.name(getGrade().getColor() + getName().toText())
				.lore(new String[]{ "&7" + getDescription().toText(), "", "&7Grade: " + getGrade().getName() })
				.hide()
				.glow()
				.unbreakable()
				.nbt("gear_bow", getId())
				.build();
	}

	@Override
	public boolean activate(@Nonnull Event event) {
		BowInfo bow = BowInfo.of(event);
		if (bow == null) {
			return false;
		}

		GearUseEvent gearUseEvent = Common.call(new GearUseEvent(this, bow.shooter()));
		if (gearUseEvent.isCancelled()) {
			return false;
		}

		return switch (event) {
			case PlayerInteractEvent e -> activate(e, bow);
			case EntityShootBowEvent e -> activate(e, bow);
			case ProjectileHitEvent e -> activate(e, bow);
			case EntityDamageByEntityEvent e -> activate(e, bow);
			case PlayerPickupArrowEvent e -> activate(e, bow);
			default -> false;
		};
	}

	/**
	 * Used to activate interaction abilities.
	 *
	 * @param event the player interact event
	 * @param bow the bow info
	 * @return true if the gear was succesfully activated
	 */
	public boolean activate(@Nonnull PlayerInteractEvent event, @Nonnull BowInfo bow) {
		return false;
	}

	/**
	 * Used to activate abilities on regular bow shot.
	 *
	 * @param event the player shoot bow event
	 * @param bow the bow info
	 * @return true if the gear was succesfully activated
	 */
	public boolean activate(@Nonnull EntityShootBowEvent event, @Nonnull BowInfo bow) {
		return false;
	}

	/**
	 * Used to activate abilities when an arrow lands.
	 * <p>
	 * This method is only called from arrows that are shot from the
	 * {@code EntityShootBowEvent} event.
	 *
	 * @param event the arrow hit event
	 * @param bow the bow info
	 * @return true if the gear was succesfully activated
	 */
	public boolean activate(@Nonnull ProjectileHitEvent event, @Nonnull BowInfo bow) {
		return false;
	}

	/**
	 * Used to activate abilities when an arrow damages an entity.
	 * <p>
	 * This method is only called from arrows that are shot from the
	 * {@code EntityShootBowEvent} event.
	 *
	 * @param event the arrow damage event
	 * @param bow the bow info
	 * @return true if the gear was succesfully activated
	 */
	public boolean activate(@Nonnull EntityDamageByEntityEvent event, @Nonnull BowInfo bow) {
		return false;
	}

	/**
	 * Used to handle custom arrow pickup events.
	 *
	 * @param event the arrow pickup event
	 * @param bow the bow info
	 * @return true if the gear was succesfully activated
	 */
	public boolean activate(@Nonnull PlayerPickupArrowEvent event, @Nonnull BowInfo bow) {
		return false;
	}
}
