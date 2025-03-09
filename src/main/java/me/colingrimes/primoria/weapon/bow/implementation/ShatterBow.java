package me.colingrimes.primoria.weapon.bow.implementation;

import me.colingrimes.primoria.Primoria;
import me.colingrimes.primoria.weapon.bow.BaseBow;
import me.colingrimes.primoria.weapon.bow.BowEventInfo;
import org.bukkit.event.entity.ProjectileHitEvent;

import javax.annotation.Nonnull;

public class ShatterBow extends BaseBow {

	public ShatterBow(@Nonnull Primoria plugin) {
		super("shatter", "&c&lShatter", "&7Arrows explode on impact!");
	}

	@Override
	public void activate(@Nonnull ProjectileHitEvent event, @Nonnull BowEventInfo info) {
		info.arrow().remove();
		info.world().createExplosion(info.location(), 6F, false, false);
	}
}
