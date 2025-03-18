package me.colingrimes.clash.gear.listener;

import me.colingrimes.clash.Clash;
import me.colingrimes.clash.gear.Gear;
import me.colingrimes.midnight.display.Display;
import me.colingrimes.midnight.display.implementation.BossBar;
import me.colingrimes.midnight.event.DisplayHideEvent;
import me.colingrimes.midnight.event.DisplayShowEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemHeldEvent;

import javax.annotation.Nonnull;
import java.util.HashMap;
import java.util.Map;

public class GearListeners implements Listener {

	private final Clash plugin;
	private final Map<Player, Display> displays = new HashMap<>();

	public GearListeners(@Nonnull Clash plugin) {
		this.plugin = plugin;
	}

	@EventHandler
	public void onDisplayShow(@Nonnull DisplayShowEvent event) {
		String id = event.getDisplay().getId();
		if (id != null && id.equals("gear")) {
			displays.put(event.getPlayer(), event.getDisplay());
		}
	}

	@EventHandler
	public void onDisplayHide(@Nonnull DisplayHideEvent event) {
		String id = event.getDisplay().getId();
		if (id != null && id.equals("gear")) {
			displays.remove(event.getPlayer());
		}
	}

	@EventHandler
	public void onInventory(@Nonnull PlayerItemHeldEvent event) {
		// Remove old boss bar.
		Player player = event.getPlayer();
		if (displays.containsKey(player)) {
			displays.get(player).hide(player);
		}

		Gear gear = plugin.findBow(player.getInventory().getItem(event.getNewSlot())).orElse(null);
		if (gear == null || !gear.onCooldown(player)) {
			return;
		}

		int timeLeftTicks = (int) (gear.getTimeLeft(player).toMillis() / 50.0);
		int cooldownTicks = (int) (gear.getCooldown() * 20);

		BossBar bossBar = Display.bossBar(gear.getGrade().getColor() + gear.getName().toText() + " Cooldown");
		bossBar.setId("gear");
		bossBar.setColor(gear.getGrade().getBarColor());
		bossBar.animateProgress(timeLeftTicks, (double) (cooldownTicks - timeLeftTicks) / cooldownTicks);
		bossBar.show(player);
	}
}
