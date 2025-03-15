package me.colingrimes.clash.command.gear.list;

import me.colingrimes.clash.Clash;
import me.colingrimes.clash.gear.bow.BowGear;
import me.colingrimes.midnight.command.Command;
import me.colingrimes.midnight.command.handler.util.ArgumentList;
import me.colingrimes.midnight.command.handler.util.Sender;
import me.colingrimes.midnight.util.text.Text;

import javax.annotation.Nonnull;

public class GearList implements Command<Clash> {

	@Override
	public void execute(@Nonnull Clash plugin, @Nonnull Sender sender, @Nonnull ArgumentList args) {
		for (BowGear bow : plugin.getBows()) {
			sender.message(Text.color("&a" + Text.format(bow.getId())));
		}
	}
}
