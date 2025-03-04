package me.colingrimes.colosseum.weapon.bow.implementation;

import me.colingrimes.colosseum.weapon.bow.BaseBow;
import org.bukkit.entity.EntityType;
import org.bukkit.event.entity.ProjectileHitEvent;

import javax.annotation.Nonnull;

public class CannoneerBow extends BaseBow {

	public CannoneerBow() {
		super("cannoneer", "&c&lCannoneer", "&7T-N-T");
	}

	@Override
	public void activate(@Nonnull ProjectileHitEvent event) {
		for (int i=0; i<3; i++) {
			event.getEntity().getWorld().spawnEntity(event.getEntity().getLocation(), EntityType.TNT);
		}
	}
}
