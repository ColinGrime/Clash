package me.colingrimes.colosseum.command.colosseum.list;

import me.colingrimes.colosseum.Colosseum;
import me.colingrimes.colosseum.weapon.bow.CustomBow;
import me.colingrimes.midnight.command.Command;
import me.colingrimes.midnight.command.handler.util.ArgumentList;
import me.colingrimes.midnight.command.handler.util.Sender;
import me.colingrimes.midnight.util.text.Text;

import javax.annotation.Nonnull;

public class ColosseumList implements Command<Colosseum> {

	@Override
	public void execute(@Nonnull Colosseum plugin, @Nonnull Sender sender, @Nonnull ArgumentList args) {
		for (CustomBow bow : plugin.getBows()) {
			sender.message(Text.color("&a" + Text.format(bow.getId())));
		}
	}
}
