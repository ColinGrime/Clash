package me.colingrimes.primoria.command.primoria.give;

import me.colingrimes.primoria.Primoria;
import me.colingrimes.primoria.weapon.bow.CustomBow;
import me.colingrimes.midnight.command.Command;
import me.colingrimes.midnight.command.handler.util.ArgumentList;
import me.colingrimes.midnight.command.handler.util.CommandProperties;
import me.colingrimes.midnight.command.handler.util.Sender;
import me.colingrimes.midnight.util.bukkit.Players;
import me.colingrimes.midnight.util.misc.Random;
import org.bukkit.entity.Player;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;
import java.util.Optional;

public class PrimoriaGive implements Command<Primoria> {

	@Override
	public void execute(@Nonnull Primoria plugin, @Nonnull Sender sender, @Nonnull ArgumentList args) {
		Optional<Player> optPlayer = args.getPlayer(0);
		if (optPlayer.isEmpty()) {
			if (!args.get(0).equalsIgnoreCase("me") && sender.isPlayer()) {
				return;
			}
			optPlayer = Optional.of(sender.player());
		}

		Player player = optPlayer.get();
		if (args.get(1).equalsIgnoreCase("random")) {
			int bowAmount = args.getIntOrDefault(2, 1);
			Random.items(plugin.getBows(), bowAmount).forEach(b -> player.getInventory().addItem(b.getWeapon()));
		} else {
			plugin.findBow(args.get(1)).ifPresent(b -> player.getInventory().addItem(b.getWeapon()));
		}
	}

	@Nullable
	@Override
	public List<String> tabComplete(@Nonnull Primoria plugin, @Nonnull Sender sender, @Nonnull ArgumentList args) {
		if (args.size() == 1) {
			return Players.mapList(Player::getName);
		} else if (args.size() == 2) {
			return plugin.getBows().stream().map(CustomBow::getId).toList();
		} else {
			return null;
		}
	}

	@Override
	public void configureProperties(@Nonnull CommandProperties properties) {
		properties.setArgumentsRequired(2);
	}
}
