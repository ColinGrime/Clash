package me.colingrimes.primoria;

import me.colingrimes.primoria.gear.bow.listener.BowListeners;
import me.colingrimes.primoria.gear.bow.BowGear;
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

public class Primoria extends Midnight {

	private final List<BowGear> bows = new ArrayList<>();

	@Override
	protected void enable() {
		registerBows();
	}

	@Override
	protected void registerListeners(@Nonnull List<Listener> listeners) {
		listeners.add(new BowListeners(this));
	}

	@Nonnull
	public List<BowGear> getBows() {
		return bows;
	}

	@Nonnull
	public Optional<BowGear> findBow(@Nullable ItemStack item) {
		Optional<String> tag = NBT.getTag(item, "gear_bow");
		return tag.flatMap(id -> bows.stream().filter(bow -> bow.getId().equals(id)).findFirst());
	}

	@Nonnull
	public Optional<BowGear> findBow(@Nonnull String id) {
		return bows.stream().filter(bow -> bow.getId().equalsIgnoreCase(id)).findFirst();
	}

	/**
	 * Registers all the custom bows.
	 */
	private void registerBows() {
		List<Class<?>> classes = Introspector.getClasses(getClassLoader(), getRootPackage() + ".gear.bow.implementation");
		List<BowGear> bows = Introspector.instantiateClasses(classes, BowGear.class, this);
		this.bows.addAll(bows.stream().filter(BowGear::isEnabled).toList());
		Logger.log("Registered " + bows.size() + " bows.");
	}
}
