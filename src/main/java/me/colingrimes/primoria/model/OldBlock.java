package me.colingrimes.primoria.model;

import org.bukkit.Material;
import org.bukkit.block.Block;

import javax.annotation.Nonnull;

public class OldBlock {

	private final Block block;
	private final Material material;

	public OldBlock(@Nonnull Block block) {
		this.block = block;
		this.material = block.getType();
	}

	public void revert() {
		block.setType(material);
	}
}