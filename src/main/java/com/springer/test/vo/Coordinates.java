package com.springer.test.vo;

/**
 * This class is a value object to contain the x and y coordinates
 * and can help any drawing tool class
 */
public class Coordinates {
	private int x;
	private int y;

	public Coordinates() {}

	/**
	 * Constructor
	 *
	 * @param x - Set the x coordinate
	 * @param y - Set the y coordinate
	 */
	public Coordinates(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * Return the x coordinate
	 * @return the x coordinate
	 */
	public int getX() {
		return x;
	}

	/**
	 * sets the x coordinate
	 *
	 * @param x - the x coordinate
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * Return the y coordinate
	 * @return the y coordinate
	 */
	public int getY() {
		return y;
	}

	 /**
	 * sets the y coordinate
	 *
	 * @param y - the y coordinate
	 */
	public void setY(int y) {
		this.y = y;
	}
}
