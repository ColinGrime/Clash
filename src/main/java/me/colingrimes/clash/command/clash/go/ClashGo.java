package me.colingrimes.clash.command.clash.go;

import me.colingrimes.clash.Clash;
import me.colingrimes.midnight.command.Command;
import me.colingrimes.midnight.command.handler.util.ArgumentList;
import me.colingrimes.midnight.command.handler.util.CommandProperties;
import me.colingrimes.midnight.command.handler.util.Sender;
import me.colingrimes.midnight.display.implementation.Title;
import me.colingrimes.midnight.scheduler.Scheduler;
import me.colingrimes.midnight.util.bukkit.Items;
import me.colingrimes.midnight.util.bukkit.Locations;
import me.colingrimes.midnight.util.bukkit.Worlds;
import me.colingrimes.midnight.util.misc.Random;
import org.bukkit.*;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;

import javax.annotation.Nonnull;

public class ClashGo implements Command<Clash> {

	@Override
	public void execute(@Nonnull Clash plugin, @Nonnull Sender sender, @Nonnull ArgumentList args) {
		Player player = sender.player();
		Title title = new Title("&cTeleporting to &lClash &carena...");
		title.setFadeInTime(10);
		title.setStayTime(20);
		title.setFadeOutTime(10);
		title.show(player);

		World world = Worlds.get("clash").orElse(Worlds.create(new WorldCreator("clash")));
		Location location = Locations.random(new Location(world, 0, 0, 0), 1000000, true).orElse(null);
		if (location == null) {
			sender.message("&cNo valid location was found.");
			return;
		}

		world.getChunkAt(location);
		Scheduler.sync().runLater(() -> setupClashGame(plugin, player, location), 20L);
	}

	@Override
	public void configureProperties(@Nonnull CommandProperties properties) {
		properties.setPlayerRequired(true);
	}

	private void setupClashGame(@Nonnull Clash plugin, @Nonnull Player player, @Nonnull Location location) {
		// Set up the world.
		location.getWorld().setTime(0);
		location.getWorld().setClearWeatherDuration(100 * 60 * 20);

		// Set up the player state.
		player.setGameMode(GameMode.SURVIVAL);
		player.setFoodLevel(20);
		player.setSaturation(20);
		player.setHealth(player.getAttribute(Attribute.MAX_HEALTH).getValue());
		player.setLevel(0);
		player.setExp(0);

		// Set up the player inventory.
		player.getInventory().clear();
		player.getInventory().setItem(17, Items.of(Material.ARROW).build());
		Random.items(plugin.getBows(), 5).forEach(b -> player.getInventory().addItem(b.getGear()));
		player.getInventory().setHeldItemSlot(0);

		// Teleport player and setup world border.
		player.teleport(location);
		player.setWorldBorder(Worlds.border(location, 100));
	}
}
