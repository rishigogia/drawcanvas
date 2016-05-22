package com.springer.test.tools;

import com.springer.test.vo.Coordinates;

/**
 * This class is the abstract class that provides a skeleton to draw on the canvas
 */
public abstract class DrawTool {

	protected Coordinates[] coordinates;

	public DrawTool(Coordinates...coordinates) {
		this.coordinates = coordinates;
	}

	public abstract void draw();

	public abstract boolean validateCoordinates();
}
