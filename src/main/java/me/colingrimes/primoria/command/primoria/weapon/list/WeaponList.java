package me.colingrimes.primoria.command.primoria.weapon.list;

import me.colingrimes.primoria.Primoria;
import me.colingrimes.primoria.gear.bow.BowGear;
import me.colingrimes.midnight.command.Command;
import me.colingrimes.midnight.command.handler.util.ArgumentList;
import me.colingrimes.midnight.command.handler.util.Sender;
import me.colingrimes.midnight.util.text.Text;

import javax.annotation.Nonnull;

public class WeaponList implements Command<Primoria> {

	@Override
	public void execute(@Nonnull Primoria plugin, @Nonnull Sender sender, @Nonnull ArgumentList args) {
		for (BowGear bow : plugin.getBows()) {
			sender.message(Text.color("&a" + Text.format(bow.getId())));
		}
	}
}
