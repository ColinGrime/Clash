package me.colingrimes.colosseum.command.colosseum.give;

import me.colingrimes.colosseum.Colosseum;
import me.colingrimes.colosseum.weapon.bow.CustomBow;
import me.colingrimes.midnight.command.Command;
import me.colingrimes.midnight.command.handler.util.ArgumentList;
import me.colingrimes.midnight.command.handler.util.CommandProperties;
import me.colingrimes.midnight.command.handler.util.Sender;
import org.bukkit.entity.Player;

import javax.annotation.Nonnull;
import java.util.Optional;

public class ColosseumGive implements Command<Colosseum> {

	@Override
	public void execute(@Nonnull Colosseum plugin, @Nonnull Sender sender, @Nonnull ArgumentList args) {
		Optional<Player> player = args.getPlayer(0);
		Optional<CustomBow> bow = plugin.findBow(args.get(1));
		if (player.isPresent() && bow.isPresent()) {
			player.get().getInventory().addItem(bow.get().getWeapon());
		}
	}

	@Override
	public void configureProperties(@Nonnull CommandProperties properties) {
		properties.setArgumentsRequired(2);
	}
}
