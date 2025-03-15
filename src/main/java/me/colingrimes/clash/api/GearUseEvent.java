package me.colingrimes.clash.api;

import me.colingrimes.clash.gear.Gear;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import javax.annotation.Nonnull;

/**
 * Called when a {@link me.colingrimes.clash.gear.Gear} is attempting to be used.
 * <p>
 * This does not guarantee the gear has been activated.
 * Refer to {@link GearActivateEvent} to listen to activated gears.
 */
public class GearUseEvent extends Event implements Cancellable {

	private static final HandlerList handlers = new HandlerList();
	private final Gear gear;
	private final LivingEntity entity;
	private boolean cancelled = false;

	public GearUseEvent(@Nonnull Gear gear, @Nonnull LivingEntity entity) {
		this.gear = gear;
		this.entity = entity;
	}

	@Nonnull
	public Gear getGear() {
		return gear;
	}

	@Nonnull
	public LivingEntity getEntity() {
		return entity;
	}

	@Override
	public boolean isCancelled() {
		return cancelled;
	}

	@Override
	public void setCancelled(boolean cancel) {
		this.cancelled = cancel;
	}

	@Nonnull
	@Override
	public HandlerList getHandlers() {
		return handlers;
	}

	@Nonnull
	public static HandlerList getHandlerList() {
		return handlers;
	}
}
