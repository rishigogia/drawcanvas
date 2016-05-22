package com.springer.test.drawers;

import junit.framework.TestCase;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class CanvasTest extends TestCase {

	@Test
	public void testInitializeCanvasValid() {
		// get canvas instance
		Canvas canvas = Canvas.getInstance();

		// initialize canvas
		canvas.initializeCanvas(12, 10);

		// check vertical borders (should be filled with '|' char)
		for (int i=1; i<canvas.getWidth()-1; i++) {
			// assert left border
			assertThat("Border character is not properly set", Character.valueOf(canvas.getChar(0, i)), is('|'));
			// assert right border
			assertThat("Border character is not properly set", Character.valueOf(canvas.getChar(canvas.getHeight()-1, i)),
					is('|'));
		}

		// check horizontal borders (should be filled with '-' char)
		for (int i=0; i<canvas.getHeight(); i++) {
			// assert top border
			assertThat("Border character is not properly set", Character.valueOf(canvas.getChar(i, 0)), is('-'));
			// assert bottom border
			assertThat("Border character is not properly set", Character.valueOf(canvas.getChar(i, canvas.getWidth()-1)),
					is('-'));
		}

		// check internal cells (should be empty)
		for (int i=1; i<canvas.getHeight()-1; i++) {
			for (int j=1; j<canvas.getWidth()-1; j++) {
				assertThat("The canvas is not emptied properly", Character.valueOf(canvas.getChar(i, j)), is(' '));
			}
		}
	}

	@Test
	public void testInitializeCanvasInvalidWidthZero() {
		// get canvas instance
		Canvas canvas = Canvas.getInstance();

		// initialize canvas
		canvas.initializeCanvas(0, 10);

		// canvas is not initialized if incorrect values are passed
		assertThat("Canvas initialized properly", canvas.isCanvasNull(), is(true));
	}


	@Test
	public void testInitializeCanvasInvalidWidthNegative() {
		// get canvas instance
		Canvas canvas = Canvas.getInstance();

		// initialize canvas
		canvas.initializeCanvas(-10, 10);

		// canvas is not initialized if incorrect values are passed
		assertThat("Canvas initialized properly", canvas.isCanvasNull(), is(true));
	}

	@Test
	public void testInitializeCanvasInvalidHeightZero() {
		// get canvas instance
		Canvas canvas = Canvas.getInstance();

		// initialize canvas
		canvas.initializeCanvas(10, 0);

		// canvas is not initialized if incorrect values are passed
		assertThat("Canvas initialized properly", canvas.isCanvasNull(), is(true));
	}


	@Test
	public void testInitializeCanvasInvalidHeightNegative() {
		// get canvas instance
		Canvas canvas = Canvas.getInstance();

		// initialize canvas
		canvas.initializeCanvas(10, -10);

		// canvas is not initialized if incorrect values are passed
		assertThat("Canvas initialized properly", canvas.isCanvasNull(), is(true));
	}

	@Test
	public void testReInitializeCanvas() {
		// get canvas instance
		Canvas canvas = Canvas.getInstance();

		final int BORDER_OFFSET = 2;

		// initialize canvas
		canvas.initializeCanvas(10, 10);
		assertThat("Canvas not initialized properly", canvas.getWidth(), is(10 + BORDER_OFFSET));
		assertThat("Canvas not initialized properly", canvas.getHeight(), is(10 + BORDER_OFFSET));

		// re-initialize canvas with new width and height. The new width and height should be re-initialized
		canvas.initializeCanvas(20, 15);
		assertThat("Canvas not initialized properly", canvas.getWidth(), is(20 + BORDER_OFFSET));
		assertThat("Canvas not initialized properly", canvas.getHeight(), is(15 + BORDER_OFFSET));
	}

	@Test
	public void testGetInstance() throws Exception {
		Canvas canvas = Canvas.getInstance();
		assertThat("Canvas object not properly initialized", canvas, instanceOf(Canvas.class));
	}
}
