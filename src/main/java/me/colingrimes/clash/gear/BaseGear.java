package me.colingrimes.clash.gear;

import me.colingrimes.midnight.cache.Cooldown;
import me.colingrimes.midnight.display.Display;
import me.colingrimes.midnight.display.implementation.BossBar;
import me.colingrimes.clash.Clash;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import javax.annotation.Nonnull;
import java.time.Duration;

public abstract class BaseGear implements Gear, Listener {

	protected final Cooldown<LivingEntity> cooldown = Cooldown.create(Duration.ofMillis((long) (getCooldown() * 1000)));
	protected final Clash plugin;
	protected final String id;

	public BaseGear(@Nonnull Clash plugin, @Nonnull String id) {
		this.plugin = plugin;
		this.id = id;
	}

	@Nonnull
	@Override
	public String getId() {
		return id;
	}

	@Override
	public boolean onCooldown(@Nonnull LivingEntity entity) {
		return cooldown.onCooldown(entity);
	}

	@Nonnull
	@Override
	public Duration getTimeLeft(@Nonnull LivingEntity entity) {
		return cooldown.getTimeLeft(entity);
	}

	/**
	 * Starts the cooldown of the gear if applicable.
	 *
	 * @param entity the entity to cooldown
	 */
	protected void startCooldown(@Nonnull LivingEntity entity) {
		if (getCooldown() <= 0) {
			return;
		}

		cooldown.add(entity);

		// Show cooldown bar to players.
		if (entity instanceof Player player) {
			BossBar bossBar = Display.bossBar(getGrade().getColor() + getName().toText() + " Cooldown");
			bossBar.setId("gear");
			bossBar.setColor(getGrade().getBarColor());
			bossBar.animateProgress((int) (getCooldown() * 20));
			bossBar.show(player);
		}
	}
}
