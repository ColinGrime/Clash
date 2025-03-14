package me.colingrimes.primoria.gear.util;

import me.colingrimes.midnight.util.text.Text;

import javax.annotation.Nonnull;

/**
 * Represents the gear quality (how powerful the gear is).
 */
public enum GearGrade {

	S(5, "&9&l"),
	A(4, "&c&l"),
	B(3, "&6&l"),
	C(2, "&e&l"),
	D(1, "&7&l"),
	F(0, "&8&l");

	private final int grade;
	private final String color;

	GearGrade(int grade, @Nonnull String color) {
		this.grade = grade;
		this.color = color;
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
}
