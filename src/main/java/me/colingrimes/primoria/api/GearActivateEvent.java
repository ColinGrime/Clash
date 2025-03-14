package me.colingrimes.primoria.api;

import me.colingrimes.primoria.gear.Gear;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import javax.annotation.Nonnull;

/**
 * Called when a {@link Gear} has been activated.
 * <p>
 * Once a gear ability has reached this stage, it cannot be cancelled.
 */
public class GearActivateEvent extends Event  {

	private static final HandlerList handlers = new HandlerList();
	private final Gear gear;
	private final LivingEntity entity;

	public GearActivateEvent(@Nonnull Gear gear, @Nonnull LivingEntity entity) {
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
