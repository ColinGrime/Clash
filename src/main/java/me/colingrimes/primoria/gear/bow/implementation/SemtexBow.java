package me.colingrimes.primoria.gear.bow.implementation;

import me.colingrimes.midnight.message.Message;
import me.colingrimes.primoria.Primoria;
import me.colingrimes.primoria.config.GearSettings;
import me.colingrimes.primoria.gear.util.GearGrade;
import me.colingrimes.primoria.gear.bow.BowGear;

import javax.annotation.Nonnull;

public class SemtexBow extends BowGear {

	public SemtexBow(@Nonnull Primoria plugin) {
		super(plugin, "semtex");
	}

	@Nonnull
	@Override
	public Message<?> getName() {
		return GearSettings.BOW_SEMTEX_NAME;
	}

	@Nonnull
	@Override
	public Message<?> getDescription() {
		return GearSettings.BOW_SEMTEX_DESC;
	}

	@Nonnull
	@Override
	public GearGrade getGrade() {
		return GearGrade.B;
	}

	@Override
	public boolean isEnabled() {
		return false;
	}
}
