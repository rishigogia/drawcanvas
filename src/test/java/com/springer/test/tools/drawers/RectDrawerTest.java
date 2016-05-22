package com.springer.test.tools.drawers;

import com.springer.test.drawers.Canvas;
import com.springer.test.tools.DrawTool;
import com.springer.test.vo.Coordinates;
import junit.framework.TestCase;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class RectDrawerTest extends TestCase {

	private Canvas canvas;
	DrawTool drawTool;

	@Test
	public void testDrawValid() {
		// Initialize Canvas
		canvas = Canvas.getInstance();
		canvas.initializeCanvas(15, 20);
		// Initialise draw tool with rectangle drawer
		Coordinates leftCoordinates = new Coordinates(5, 7);
		Coordinates rightCoordinates = new Coordinates(10, 15);
		drawTool = new RectDrawer(canvas, leftCoordinates, rightCoordinates);

		// draw
		drawTool.draw();

		// assert whether rectangle is drawn correctly
		for(int i=leftCoordinates.getY(); i<=rightCoordinates.getY(); i++) {
			// Asserting Horizontal lines of rectangle
			assertThat("Rectangle not drawn correctly", canvas.getChar(i, leftCoordinates.getX()), is('x'));
			assertThat("Rectangle not drawn correctly", canvas.getChar(i, rightCoordinates.getX()), is('x'));
		}
		for(int i=leftCoordinates.getX(); i<=rightCoordinates.getX(); i++) {
			// Asserting Vertical lines of rectangle
			assertThat("Rectangle not drawn correctly", canvas.getChar(leftCoordinates.getY(), i), is('x'));
			assertThat("Rectangle not drawn correctly", canvas.getChar(rightCoordinates.getY(), i), is('x'));
		}
	}

	@Test
	public void testDrawInvalidNumberOfCoordinates() {
		// Initialize Canvas
		canvas = Canvas.getInstance();
		canvas.initializeCanvas(15, 20);
		// Initialise draw tool with rectangle drawer
		Coordinates leftCoordinates = new Coordinates(5, 7);
		drawTool = new RectDrawer(canvas, leftCoordinates);

		// draw
		drawTool.draw();

		// assert to see no coordinated is plotted
		assertThat("A coordinate is plotted", canvas.getChar(leftCoordinates.getX(), leftCoordinates.getY()), is(' '));
	}

	@Test
	public void testDrawInvalidBeyondCanvas() {
		// Initialize Canvas
		canvas = Canvas.getInstance();
		canvas.initializeCanvas(15, 20);
		// Initialise draw tool with rectangle drawer
		Coordinates leftCoordinates = new Coordinates(5, 3);
		Coordinates rightCoordinates = new Coordinates(10, 22);
		drawTool = new RectDrawer(canvas, leftCoordinates, rightCoordinates);

		// draw
		drawTool.draw();

		// assert to see no rectangle should be drawn
		for (int i=leftCoordinates.getY(); i<canvas.getHeight()-1; i++) {
			assertThat("Rectangle is there", canvas.getChar(i, leftCoordinates.getY()), is(' '));
		}
	}

	@Test
	public void testDrawInvalidBeforeCanvas() {
		// Initialize Canvas
		canvas = Canvas.getInstance();
		canvas.initializeCanvas(15, 20);
		// Initialise draw tool with rectangle drawer
		Coordinates leftCoordinates = new Coordinates(-3, 5);
		Coordinates rightCoordinates = new Coordinates(10, 17);
		drawTool = new RectDrawer(canvas, leftCoordinates, rightCoordinates);

		// draw
		drawTool.draw();

		// assert to see no rectangle should be drawn
		for (int i=1; i<rightCoordinates.getX(); i++) {
			assertThat("Rectangle is there", canvas.getChar(leftCoordinates.getY(), i), is(' '));
		}
	}

	@Test
	public void testDrawInvalidReverseRectangle() {
		// Initialize Canvas
		canvas = Canvas.getInstance();
		canvas.initializeCanvas(15, 20);
		// Initialise draw tool with rectangle drawer
		Coordinates leftCoordinates = new Coordinates(15, 17);
		Coordinates rightCoordinates = new Coordinates(10, 13);
		drawTool = new RectDrawer(canvas, leftCoordinates, rightCoordinates);

		// draw
		drawTool.draw();

		// assert to see rectangle shouldn't be drawn
		for (int i=rightCoordinates.getY(); i<leftCoordinates.getY(); i++) {
			assertThat("Rectangle is created", canvas.getChar(i, leftCoordinates.getX()), is(' '));
		}
	}
}
