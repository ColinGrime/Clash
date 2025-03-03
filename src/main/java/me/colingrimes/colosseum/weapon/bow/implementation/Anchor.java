package me.colingrimes.colosseum.weapon.bow.implementation;

import me.colingrimes.colosseum.weapon.bow.BaseBow;
import org.bukkit.event.player.PlayerInteractEvent;

import javax.annotation.Nonnull;

public class Anchor extends BaseBow {

	public Anchor() {
		super("anchor", "Anchor", "Arrows pin enemies to the ground, preventing movement.");
	}

	@Override
	public void activate(@Nonnull PlayerInteractEvent event) {
		event.getPlayer().sendMessage("Test!");
	}
}
