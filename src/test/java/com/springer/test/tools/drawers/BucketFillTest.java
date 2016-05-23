package com.springer.test.tools.drawers;

import com.springer.test.drawers.Canvas;
import com.springer.test.tools.DrawTool;
import com.springer.test.vo.Coordinates;
import junit.framework.TestCase;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BucketFillTest extends TestCase {

	private Canvas canvas;
	DrawTool drawTool;

	@Test
	public void testBucketFillValid() throws Exception {
		// Initialize Canvas
		canvas = Canvas.getInstance();
		canvas.initializeCanvas(15, 20);

		// Initialise draw tool with Bucket Fill
		Coordinates coordinates = new Coordinates(5, 7);
		drawTool = new BucketFill(canvas, 'c', coordinates);

		// draw
		drawTool.draw();

		// assert to see at least one coordinate has been replaced by the character
		assertThat("A coordinate is plotted", canvas.getChar(coordinates.getX(), coordinates.getY()), is('c'));
	}


	@Test
	public void testBucketFillValidAfterRectangleDrawn() throws Exception {
		// Initialize Canvas
		canvas = Canvas.getInstance();
		canvas.initializeCanvas(15, 20);

		// Initialise draw tool with rectangle drawer
		Coordinates leftCoordinates = new Coordinates(5, 7);
		Coordinates rightCoordinates = new Coordinates(10, 13);
		DrawTool rectDrawTool = new RectDrawer(canvas, leftCoordinates, rightCoordinates);

		// draw rectangle
		rectDrawTool.draw();

		// Initialise draw tool with Bucket Fill
		Coordinates coordinates = new Coordinates(8, 8);
		drawTool = new BucketFill(canvas, 'c', coordinates);

		// fill using bucket tool
		drawTool.draw();

		// assert to see at least one coordinate has been plotted inside the rectangle
		assertThat("Coordinate was not filled", canvas.getChar(8, 8), is('c'));

		// assert to see at least coordinate on rectangle is not replaced
		assertThat("Coordinate was filled incorrectly on rectangle", canvas.getChar(7, 7), is('x'));

		// assert to see no changes are made outside rectangle
		assertThat("A coordinate is plotted outside rectangle", canvas.getChar(1, 3), is(' '));
	}

	@Test
	public void testBucketFillValidTheLinesOfRectangleDrawn() throws Exception {
		// Initialize Canvas
		canvas = Canvas.getInstance();
		canvas.initializeCanvas(15, 20);

		// Initialise draw tool with rectangle drawer
		Coordinates leftCoordinates = new Coordinates(5, 7);
		Coordinates rightCoordinates = new Coordinates(10, 13);
		DrawTool rectDrawTool = new RectDrawer(canvas, leftCoordinates, rightCoordinates);

		// draw rectangle
		rectDrawTool.draw();

		// Initialise draw tool with Bucket Fill
		Coordinates coordinates = new Coordinates(7, 7);
		drawTool = new BucketFill(canvas, 'c', coordinates);

		// fill using bucket tool
		drawTool.draw();

		// assert to see no fill should be done inside the rectangle
		assertThat("Changes have been made inside rectangle", canvas.getChar(8, 8), is(' '));

		// assert to see at least one coordinate on rectangle is replaced
		assertThat("Coordinate not filled on the lines of rectangle", canvas.getChar(7, 7), is('c'));

		// assert to see no changes are made outside rectangle
		assertThat("A coordinate is plotted outside rectangle", canvas.getChar(1, 3), is(' '));
	}

	@Test
	public void testBucketFillValidnOutsideRectangleDrawn() throws Exception {
		// Initialize Canvas
		canvas = Canvas.getInstance();
		canvas.initializeCanvas(15, 20);

		// Initialise draw tool with rectangle drawer
		Coordinates leftCoordinates = new Coordinates(5, 7);
		Coordinates rightCoordinates = new Coordinates(10, 13);
		DrawTool rectDrawTool = new RectDrawer(canvas, leftCoordinates, rightCoordinates);

		// draw rectangle
		rectDrawTool.draw();

		// Initialise draw tool with Bucket Fill
		Coordinates coordinates = new Coordinates(1, 3);
		drawTool = new BucketFill(canvas, 'c', coordinates);

		// fill using bucket tool
		drawTool.draw();

		// assert to see no fill should be done inside the rectangle
		assertThat("Changes have been made inside rectangle", canvas.getChar(8, 8), is(' '));

		// assert to see at no coordinate on rectangle is replaced
		assertThat("Coordinate filled on the lines of rectangle", canvas.getChar(7, 7), is('x'));

		// assert to see at least one coordinate is filled outside rectangle
		assertThat("No coordinate is plotted outside rectangle", canvas.getChar(1, 3), is('c'));
	}

	@Test
	public void testDrawInvalidNumberOfCoordinates() {
		// Initialize Canvas
		canvas = Canvas.getInstance();
		canvas.initializeCanvas(15, 20);
		// Initialise draw tool with Bucket Fill
		Coordinates leftCoordinates = new Coordinates(5, 7);
		drawTool = new BucketFill(canvas, 'c');

		// draw
		drawTool.draw();

		// assert to see no coordinated is plotted
		assertThat("A coordinate is plotted", canvas.getChar(leftCoordinates.getX(), leftCoordinates.getY()), is(' '));
	}

	@Test
	public void testDrawInvalidBeforeCanvas() {
		// Initialize Canvas
		canvas = Canvas.getInstance();
		canvas.initializeCanvas(15, 20);
		// Initialise draw tool with Bucket Fill
		Coordinates coordinates = new Coordinates(-3, 10);
		drawTool = new BucketFill(canvas, 'c', coordinates);

		// draw
		drawTool.draw();

		// assert to see no coordinated is plotted
		assertThat("A coordinate is plotted", canvas.getChar(2, coordinates.getY()), is(' '));
	}

	@Test
	public void testDrawInvalidBeyondCanvas() {
		// Initialize Canvas
		canvas = Canvas.getInstance();
		canvas.initializeCanvas(15, 20);
		// Initialise draw tool with BucketFill
		Coordinates coordinates = new Coordinates(5, 22);
		drawTool = new BucketFill(canvas, 'c', coordinates);

		// draw
		drawTool.draw();

		// assert to see no coordinated is plotted
		assertThat("A coordinate is plotted", canvas.getChar(coordinates.getX(), canvas.getWidth()-2), is(' '));
	}

	public void testNoCanvasDrawn() {
		// Initialize Canvas
		canvas = Canvas.getInstance();
		canvas.initializeCanvas(0, 0);
		// Initialize draw tool with BucketFill
		Coordinates coordinates = new Coordinates(0, 0);
		drawTool = new BucketFill(canvas, 'c', coordinates);

		// draw
		drawTool.draw();

		assertThat("A coordinate is plotted", canvas.isCanvasNull(), is(true));
	}
}
