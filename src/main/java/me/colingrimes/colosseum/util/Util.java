package me.colingrimes.colosseum.util;

import org.bukkit.Location;

import java.util.ArrayList;
import java.util.List;

public final class Util {

	/**
	 * Retrieves all locations between two locations.
	 *
	 * @param location1 the first location
	 * @param location2 the second location
	 * @return all blocks between the two locations
	 */
	public static List<Location> getLocationsBetween(Location location1, Location location2) {
		double lowX = Math.min(location1.getX(), location2.getX());
		double lowY = Math.min(location1.getY(), location2.getY());
		double lowZ = Math.min(location1.getZ(), location2.getZ());

		List<Location> locations = new ArrayList<>();
		for (int blockY = Math.abs(location1.getBlockY() - location2.getBlockY()); blockY >= 0; blockY--) {
			for (int blockX = 0; blockX < Math.abs(location1.getBlockX() - location2.getBlockX()); blockX++) {
				for (int blockZ = 0; blockZ < Math.abs(location1.getBlockZ() - location2.getBlockZ()); blockZ++)
					locations.add(new Location(location1.getWorld(), lowX + blockX, lowY + blockY, lowZ + blockZ));
			}
		}
		return locations;
	}

	private Util() {
		throw new UnsupportedOperationException("This class cannot be instantiated.");
	}
}
