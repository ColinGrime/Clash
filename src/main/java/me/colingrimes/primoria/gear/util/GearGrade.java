package me.colingrimes.primoria.gear.util;

import me.colingrimes.midnight.util.text.Text;
import org.bukkit.boss.BarColor;

import javax.annotation.Nonnull;

/**
 * Represents the gear quality (how powerful the gear is).
 */
public enum GearGrade {

	S(5, "&9&l", BarColor.PURPLE),
	A(4, "&c&l", BarColor.RED),
	B(3, "&6&l", BarColor.YELLOW),
	C(2, "&e&l", BarColor.YELLOW),
	D(1, "&7&l", BarColor.WHITE),
	F(0, "&8&l", BarColor.WHITE);

	private final int grade;
	private final String color;
	private final BarColor barColor;

	GearGrade(int grade, @Nonnull String color, @Nonnull BarColor barColor) {
		this.grade = grade;
		this.color = color;
		this.barColor = barColor;
	}

	/**
	 * Gets the numerical value for the grade.
	 *
	 * @return the grade value
	 */
	public int getGrade() {
		return grade;
	}

	/**
	 * Gets the color-coded name of the grade.
	 *
	 * @return the color-coded grade name
	 */
	@Nonnull
	public String getName() {
		return Text.color(color + name().toUpperCase());
	}

	/**
	 * Gets the color code for the grade.
	 *
	 * @return the grade color
	 */
	@Nonnull
	public String getColor() {
		return Text.color(color);
	}

	/**
	 * Gets the boss bar color associated with this grade.
	 *
	 * @return the boss bar color
	 */
	@Nonnull
	public BarColor getBarColor() {
		return barColor;
	}
}
