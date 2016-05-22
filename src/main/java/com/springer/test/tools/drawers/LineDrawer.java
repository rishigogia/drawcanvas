package com.springer.test.tools.drawers;

import com.springer.test.drawers.Canvas;
import com.springer.test.tools.DrawTool;
import com.springer.test.vo.Coordinates;

public class LineDrawer extends DrawTool {

	// Fill character. Default for Line drawer is 'x'
	private static final char FILL_CHAR = 'x';

	/**
	 * The constructor. This sets the coordinates parameter
	 *
	 * @param coordinates - The coordinates parameter is a vararg array of coordinates
	 *                    The vararg serves the purpose of variable number of arguments
	 *                    to be included for various implementations of the DrawTool
	 */
	public LineDrawer(Canvas canvas, Coordinates... coordinates) {
		super(canvas, FILL_CHAR, coordinates);
	}

	/**
	 * The method to draw the line. The current version supports only horizontal
	 * or vertical line.
	 */
	@Override
	public void draw() {
		if(validate()) {
			if(coordinates[0].getX() == coordinates[1].getX()) {
				// Vertical Line
				for (int i=coordinates[0].getY(); i<=coordinates[1].getY(); i++) {
					canvas.putChar(coordinates[0].getX(), i, fillChar);
				}
			} else if(coordinates[0].getY() == coordinates[1].getY()) {
				// Horizontal Line
				for (int i=coordinates[0].getX(); i<=coordinates[1].getX(); i++) {
					canvas.putChar(i, coordinates[0].getY(), fillChar);
				}
			}
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
		if (coordinates.length < 2) {
			// There should be 2 coordinates (i.e. x-y pair)
			validate = false;
		} else if (coordinates[0].getX() > coordinates [1].getX() || coordinates[0].getY() > coordinates[0].getY()) {
			// x1-y1 should be before x2-y2
			validate = false;
		} else if (coordinates[0].getX() != coordinates[1].getX() && coordinates[0].getY() != coordinates[1].getY()) {
			// either x1 = x2 (horizontal line) or y1 = y2 (vertical line) (diagonal lines not supported)
			validate = false;
		}
		return validate && super.validate();
	}
}
