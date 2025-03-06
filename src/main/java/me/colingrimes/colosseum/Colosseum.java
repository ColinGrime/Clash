package me.colingrimes.colosseum;

import me.colingrimes.colosseum.weapon.bow.listener.BowListeners;
import me.colingrimes.colosseum.weapon.bow.CustomBow;
import me.colingrimes.midnight.Midnight;
import me.colingrimes.midnight.util.bukkit.NBT;
import me.colingrimes.midnight.util.io.Introspector;
import me.colingrimes.midnight.util.io.Logger;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Colosseum extends Midnight {

	private final List<CustomBow> bows = new ArrayList<>();

	@Override
	protected void enable() {
		registerBows();
	}

	@Override
	protected void registerListeners(@Nonnull List<Listener> listeners) {
		listeners.add(new BowListeners(this));
	}

	@Nonnull
	public List<CustomBow> getBows() {
		return bows;
	}

	@Nonnull
	public Optional<CustomBow> findBow(@Nullable ItemStack item) {
		Optional<String> tag = NBT.getTag(item, "custom_bow");
		return tag.flatMap(id -> bows.stream().filter(bow -> bow.getId().equals(id)).findFirst());
	}

	@Nonnull
	public Optional<CustomBow> findBow(@Nonnull String id) {
		return bows.stream().filter(bow -> bow.getId().equalsIgnoreCase(id)).findFirst();
	}

	/**
	 * Registers all the custom bows.
	 */
	private void registerBows() {
		List<Class<?>> classes = Introspector.getClasses(getClassLoader(), getRootPackage() + ".weapon.bow.implementation");
		List<CustomBow> bows = Introspector.instantiateClasses(classes, CustomBow.class);
		this.bows.addAll(bows.stream().filter(CustomBow::isEnabled).toList());
		Logger.log("Registered " + bows.size() + " bows.");
	}
}
