package me.colingrimes.primoria.gear.bow;

import me.colingrimes.midnight.util.Common;
import me.colingrimes.midnight.util.text.Text;
import me.colingrimes.primoria.Primoria;
import me.colingrimes.primoria.api.GearActivateEvent;
import me.colingrimes.primoria.api.GearUseEvent;
import me.colingrimes.midnight.util.bukkit.Items;
import me.colingrimes.primoria.gear.BaseGear;
import org.bukkit.Material;
import org.bukkit.event.Event;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerPickupArrowEvent;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;
import java.util.List;

public abstract class BowGear extends BaseGear {

	public BowGear(@Nonnull Primoria plugin, @Nonnull String id) {
		super(plugin, id);
	}

	/**
	 * @return true if arrows shot from this gear should be removed after successful activation
	 */
	public boolean removeArrow() {
		return true;
	}

	@Nonnull
	public ItemStack getGear() {
		String name = getGrade().getColor() + getName().toText() + " &7(" + getGrade().getName() + "&7)";

		// Add cooldown to name if applicable.
		if (getCooldown() > 0) {
			String cooldown = getCooldown() % 1 == 0 ? String.valueOf((int) getCooldown()) : String.valueOf(getCooldown());
			name += " (&e" + cooldown + " second" + (!cooldown.equals("1") ? "s" : "") + "&7)";
		}

		return Items.of(Material.BOW)
				.name(name)
				.lore(List.of("&7" + getDescription().toText()))
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

		// Bow gear is on cooldown.
		if (cooldown.onCooldown(bow.shooter())) {
			if (!(event instanceof PlayerInteractEvent)) {
				bow.shooter().sendMessage(Text.color("&7Your " + getGrade().getColor() + getName().toText() + " &7gear is currently on cooldown!"));
			}
			bow.removeArrow();
			return false;
		}

		GearUseEvent gearUseEvent = Common.call(new GearUseEvent(this, bow.shooter()));
		if (gearUseEvent.isCancelled()) {
			return false;
		}

		boolean success = switch (event) {
			case PlayerInteractEvent e -> activate(e, bow);
			case EntityShootBowEvent e -> activate(e, bow);
			case ProjectileHitEvent e -> activate(e, bow);
			case EntityDamageByEntityEvent e -> activate(e, bow);
			case PlayerPickupArrowEvent e -> activate(e, bow);
			default -> false;
		};

		if (!success) {
			return false;
		}

		// Remove the arrow on successful activation if applicable.
		if (removeArrow()) {
			bow.removeArrow();
		}

		startCooldown(bow.shooter());
		Common.call(new GearActivateEvent(this, bow.shooter()));
		return true;
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
