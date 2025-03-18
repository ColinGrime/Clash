package me.colingrimes.clash.gear;

import me.colingrimes.clash.gear.util.GearGrade;
import me.colingrimes.midnight.cache.Cooldown;
import me.colingrimes.midnight.display.Display;
import me.colingrimes.midnight.display.implementation.BossBar;
import me.colingrimes.clash.Clash;
import me.colingrimes.midnight.message.Message;
import me.colingrimes.midnight.util.text.Text;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import javax.annotation.Nonnull;
import java.time.Duration;

public abstract class BaseGear implements Gear, Listener {

	protected final Cooldown<LivingEntity> cooldown = Cooldown.create(Duration.ofMillis((long) (getCooldown() * 1000)));
	protected final Clash plugin;
	protected final String id;
	private final Message<?> name;
	private final Message<?> description;
	protected final GearGrade grade;

	public BaseGear(@Nonnull Clash plugin, @Nonnull String id, @Nonnull Message<?> name, @Nonnull Message<?> description, @Nonnull GearGrade grade) {
		this.plugin = plugin;
		this.id = id;
		this.name = name;
		this.description = description;
		this.grade = grade;
	}

	@Nonnull
	@Override
	public String getId() {
		return id;
	}

	@Nonnull
	@Override
	public String getName() {
		return Text.color(getGrade().getColor() + name.toText());
	}

	@Nonnull
	@Override
	public String getDescription() {
		return Text.color("&7" + description.toText());
	}

	@Nonnull
	@Override
	public GearGrade getGrade() {
		return grade;
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
			BossBar bossBar = Display.bossBar(getName() + " Cooldown");
			bossBar.setId("gear");
			bossBar.setColor(grade.getBarColor());
			bossBar.animateProgress((int) (getCooldown() * 20));
			bossBar.show(player);
		}
	}
}
