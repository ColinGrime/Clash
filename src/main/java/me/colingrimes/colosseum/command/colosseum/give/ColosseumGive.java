package me.colingrimes.colosseum.command.colosseum.give;

import me.colingrimes.colosseum.Colosseum;
import me.colingrimes.colosseum.weapon.bow.CustomBow;
import me.colingrimes.midnight.command.Command;
import me.colingrimes.midnight.command.handler.util.ArgumentList;
import me.colingrimes.midnight.command.handler.util.CommandProperties;
import me.colingrimes.midnight.command.handler.util.Sender;
import me.colingrimes.midnight.util.bukkit.Players;
import org.bukkit.entity.Player;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class ColosseumGive implements Command<Colosseum> {

	@Override
	public void execute(@Nonnull Colosseum plugin, @Nonnull Sender sender, @Nonnull ArgumentList args) {
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
			List<CustomBow> bows = plugin.getBows();
			Collections.shuffle(bows);
			bows.subList(0, bowAmount).forEach(b -> player.getInventory().addItem(b.getWeapon()));
		} else {
			Optional<CustomBow> bow = plugin.findBow(args.get(1));
			bow.ifPresent(b -> player.getInventory().addItem(b.getWeapon()));
		}
	}

	@Nullable
	@Override
	public List<String> tabComplete(@Nonnull Colosseum plugin, @Nonnull Sender sender, @Nonnull ArgumentList args) {
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
