package com.springer.test.drawers;
/**
 * This class defines the canvas where the other draw operations, i.e. line,
 * rectangle etc. will be drawn
 *
 * This is a singleton class and only one instance will be declared for this
 * class
 */
public final class Canvas {
	// The canvas object which is a 2-dimensional array of characters
	private char canvas[][];

	// Dimensions of the canvas
	private int width;
	private int height;

	// Offset value to assign to the border
	private static final int BORDER_OFFSET = 2;
	private static final char BORDER_HORIZ = '-';
	private static final char BORDER_VERT = '|';
	private static final char EMPTY_CHAR = ' ';

	// The canvas instance (since this is a singleton class, thus there
	// would be only a single instance of the Canvas
	private static Canvas canvasInstance;

	/**
	 * Constructor. Private so that only one instance can be created and assigned
	 */
	private Canvas() {}

	/**
	 * Method to initialize canvas, set borders, empty canvas drawable area
	 */
	public void initializeCanvas(int width, int height) {

		// Resetting canvas in case of a new canvas being built
		canvas = null;
		if(validate(width, height)) {
			// Add border offset to the width and height of the canvas to facilitate the border.
			this.width = width + BORDER_OFFSET;
			this.height = height + BORDER_OFFSET;

			// Initialize canvas
			canvas = new char[this.width][this.height];

			// Set vertical Borders
			setVerticalBorders();

			// Set Horizontal borders
			setHorizontalBorders();

			// Empty canvas
			emptyCanvas();
		}
	}

	/**
	 * Setting the horizontal borders
	 */
	private void setHorizontalBorders() {
		for (int i=0; i<height; i++) {
			// Top border
			putChar(i, 0, BORDER_HORIZ);
			// Bottom border
			putChar(i, width-1, BORDER_HORIZ);
		}
	}

	/**
	 * Setting the vertical borders
	 */
	private void setVerticalBorders() {
		for (int i=0; i<width; i++) {
			// Left border
			putChar(0, i, BORDER_VERT);
			// Right border
			putChar(height-1, i, BORDER_VERT);
		}
	}

	/**
	 * Empty the canvas, put space char to all the locations in the canvas
	 */
	private void emptyCanvas() {
		for (int i=1; i<this.width-1; i++) {
			for (int j =1; j<this.height-1; j++) {
				putChar(j, i, EMPTY_CHAR);
			}
		}
	}

	/**
	 * Place the character on canvas on a certain location
	 *
	 * @param x - x-position (horizontal)
	 * @param y - y-position (vertical)
	 * @param fillChar - Fill character
	 */
	public void putChar(int x, int y, char fillChar) {
		canvas[y][x] = fillChar;
	}

	/**
	 * Get the character on canvas on a certain location
	 *
	 * @param x - x-position (horizontal)
	 * @param y - y-position (vertical)
	 * @return - character on the position x and y
	 */
	public char getChar(int x, int y) {
		return canvas[y][x];
	}

	/**
	 * Returns the instance of the singleton class Canvas
	 *
	 * @return - the singleton instance of the Canvas class
	 */
	public static final Canvas getInstance() {
		// Create the instance of the Canvas class if it doesn't exist
		if (canvasInstance == null) {
			canvasInstance = new Canvas();
		}
		return canvasInstance;
	}

	/**
	 * Returns the width of the canvas
	 *
	 * @return width of canvas
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * Returns the height of the canvas
	 *
	 * @return height of canvas
	 */
	public int getHeight() {
		return height;
	}

	public void displayCanvas() {
		for (int i=0; i<width; i++) {
			for (int j =0; j<height; j++) {
				System.out.print(getChar(j, i));
			}
			System.out.println();
		}
	}

	/**
	 * Validates the input to Canvas object (i.e. the width and height of the canvas)
	 *
	 * @param width - Width of canvas
	 * @param height - Height of canvas
	 * @return if the width and height of the canvas are +ve numbers, return true, else return false
	 */
	private boolean validate(int width, int height) {
		if (width > 0 && height > 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Checks if the canvas is null
	 *
	 * @return true if the canvas is null, false otherwise
	 */
	public boolean isCanvasNull() {
		return (canvas == null);
	}
}
