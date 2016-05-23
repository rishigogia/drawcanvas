package com.springer.test.tools.drawers;

import com.springer.test.drawers.Canvas;
import com.springer.test.tools.DrawTool;
import com.springer.test.vo.Coordinates;

/**
 * This class implements the bucket fill. This purpose is similar as the pain bucket
 * tool to fill everything within the bounds
 */
public class BucketFill extends DrawTool {

	/**
	 * The constructor. This sets the coordinates parameter
	 *
	 * @param coordinates - The coordinates parameter is a vararg array of coordinates
	 *                    The vararg serves the purpose of variable number of arguments
	 *                    to be included for various implementations of the DrawTool
	 */
	public BucketFill(Canvas canvas, char fillChar, Coordinates... coordinates) {
		super(canvas, fillChar, coordinates);
	}

	/**
	 * The method to draw the Rectangle
	 */
	@Override
	public void draw() {
		if(validate()) {
			// bucket fill using recursive function
			fill(fillChar, canvas.getChar(coordinates[0].getX(), coordinates[0].getY()),
					coordinates[0].getX(), coordinates[0].getY());
		}
	}

	/**
	 * validates the various validations including below:
	 * 1. At least 2 coordinates (x-y pairs)
	 * 2. Either x1 = x2 (vertical line) or y1 = y2 (horizontal line)
	 * 3. Validations from super method.
	 * @return
	 */
	@Override
	protected boolean validate() {
		boolean validate = true;
		if (coordinates.length < 1) {
			// There should be 1 coordinate (i.e. x-y pair)
			validate = false;
		}
		return validate && super.validate();
	}

	private void fill(char fillChar, char charToReplace, int x, int y) {
		if(canvas.getChar(x, y) == charToReplace) {
			canvas.putChar(x, y, fillChar);
			fill(fillChar, charToReplace, x+1, y);
			fill(fillChar, charToReplace, x-1, y);
			fill(fillChar, charToReplace, x, y+1);
			fill(fillChar, charToReplace, x, y-1);
		}
	}
}
