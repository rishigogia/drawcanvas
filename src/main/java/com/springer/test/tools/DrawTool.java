package com.springer.test.tools;

import com.springer.test.drawers.Canvas;
import com.springer.test.vo.Coordinates;

/**
 * This class is the abstract class that provides a skeleton to draw on the canvas
 */
public abstract class DrawTool {

	protected Coordinates[] coordinates;
	protected Canvas canvas;
	protected char fillChar;

	/**
	 * The constructor. This sets the coordinates parameter
	 * @param canvas
	 * @param coordinates - The coordinates parameter is a vararg array of coordinates
	 *                    The vararg serves the purpose of variable number of arguments
	 */
	public DrawTool(Canvas canvas, char fillChar, Coordinates... coordinates) {
		this.canvas = canvas;
		this.coordinates = coordinates;
		this.fillChar = fillChar;
	}

	/**
	 * Abstract method to provide a skeleton to draw using the draw tool. Implementation varies
	 */
	public abstract void draw();

	/**
	 * Method validates the coordinates for
	 * 1. The coordinates should be within the boundaries of the canvas and
	 *          shouldn't touch the borders.
	 * The method will be further overridden in implementing classes to provide#
	 * more validation
	 *
	 * @return true if valid, false otherwise
	 */
	protected boolean validate() {
		boolean validate = true;
		for(Coordinates coordinate:coordinates) {
			if(coordinate.getX() <= 0 || coordinate.getY() <= 0 ||
					coordinate.getX() >= canvas.getWidth() || coordinate.getY() >= canvas.getHeight()) {
				// Coordinates should be within the bounds of the canvas (excluding borders)
				validate = false;
			}
		}
		return validate;
	}
}
