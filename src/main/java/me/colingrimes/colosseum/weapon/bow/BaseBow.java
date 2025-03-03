package me.colingrimes.colosseum.weapon.bow;

import javax.annotation.Nonnull;

public abstract class BaseBow implements CustomBow {

	private final String id;
	private final String name;
	private final String[] lore;

	public BaseBow(@Nonnull String id, @Nonnull String name, @Nonnull String...lore) {
		this.id = id;
		this.name = name;
		this.lore = lore;
	}

	@Nonnull
	@Override
	public String getId() {
		return id;
	}

	@Nonnull
	@Override
	public String getName() {
		return name;
	}

	@Nonnull
	@Override
	public String[] getLore() {
		return lore;
	}
}
