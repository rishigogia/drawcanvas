package com.springer.test.tools.drawers;

import com.springer.test.drawers.Canvas;
import com.springer.test.tools.DrawTool;
import com.springer.test.vo.Coordinates;
import junit.framework.TestCase;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class LineDrawerTest extends TestCase {

	private Canvas canvas;
	DrawTool drawTool;

	@Test
	public void testDrawValidVertical() {
		// Initialize Canvas
		canvas = Canvas.getInstance();
		canvas.initializeCanvas(15, 20);
		// Initialise draw tool with line drawer
		Coordinates leftCoordinates = new Coordinates(5, 7);
		Coordinates rightCoordinates = new Coordinates(5, 10);
		drawTool = new LineDrawer(canvas, leftCoordinates, rightCoordinates);

		// draw
		drawTool.draw();

		// assert whether it's drawn the line correctly
		for (int i=leftCoordinates.getY(); i<=rightCoordinates.getY(); i++) {
			assertThat("vertical line not put properly", canvas.getChar(leftCoordinates.getX(), i), is('x'));
		}
	}

	@Test
	public void testDrawValidHorizontal() {
		// Initialize Canvas
		canvas = Canvas.getInstance();
		canvas.initializeCanvas(15, 20);
		// Initialise draw tool with line drawer
		Coordinates leftCoordinates = new Coordinates(5, 7);
		Coordinates rightCoordinates = new Coordinates(10, 7);
		drawTool = new LineDrawer(canvas, leftCoordinates, rightCoordinates);

		// draw
		drawTool.draw();

		// assert whether it's drawn the line correctly
		for (int i=leftCoordinates.getX(); i<=rightCoordinates.getX(); i++) {
			assertThat("horizontal line not put properly", canvas.getChar(i, leftCoordinates.getY()), is('x'));
		}
	}

	@Test
	public void testDrawInvalidDiagonalLine() {
		// Initialize Canvas
		canvas = Canvas.getInstance();
		canvas.initializeCanvas(15, 20);
		// Initialise draw tool with line drawer
		Coordinates leftCoordinates = new Coordinates(5, 7);
		Coordinates rightCoordinates = new Coordinates(10, 15);
		drawTool = new LineDrawer(canvas, leftCoordinates, rightCoordinates);

		// draw
		drawTool.draw();

		// assert to see line Vertical shouldn't be drawn
		for (int i=leftCoordinates.getX(); i<=rightCoordinates.getX(); i++) {
			assertThat("Vertical line is there", canvas.getChar(i, leftCoordinates.getY()), is(' '));
		}

		// assert to see line Horizontal shouldn't be drawn
		for (int i=leftCoordinates.getX(); i<=rightCoordinates.getX(); i++) {
			assertThat("Horizontal line is there", canvas.getChar(i, leftCoordinates.getY()), is(' '));
		}
	}

	@Test
	public void testDrawInvalidNumberOfCoordinates() {
		// Initialize Canvas
		canvas = Canvas.getInstance();
		canvas.initializeCanvas(15, 20);
		// Initialise draw tool with line drawer
		Coordinates leftCoordinates = new Coordinates(5, 7);
		drawTool = new LineDrawer(canvas, leftCoordinates);

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
		// Initialise draw tool with line drawer
		Coordinates leftCoordinates = new Coordinates(5, 3);
		Coordinates rightCoordinates = new Coordinates(5, 22);
		drawTool = new LineDrawer(canvas, leftCoordinates, rightCoordinates);

		// draw
		drawTool.draw();

		// assert to see line Vertical shouldn't be drawn
		for (int i=leftCoordinates.getY(); i<canvas.getHeight()-1; i++) {
			assertThat("Vertical line is there", canvas.getChar(i, leftCoordinates.getY()), is(' '));
		}
	}

	@Test
	public void testDrawInvalidBeforeCanvas() {
		// Initialize Canvas
		canvas = Canvas.getInstance();
		canvas.initializeCanvas(15, 20);
		// Initialise draw tool with line drawer
		Coordinates leftCoordinates = new Coordinates(-3, 17);
		Coordinates rightCoordinates = new Coordinates(10, 17);
		drawTool = new LineDrawer(canvas, leftCoordinates, rightCoordinates);

		// draw
		drawTool.draw();

		// assert to see line Horizontal shouldn't be drawn
		for (int i=1; i<rightCoordinates.getX(); i++) {
			assertThat("Horizontal line is there", canvas.getChar(leftCoordinates.getY(), i), is(' '));
		}
	}

	@Test
	public void testDrawInvalidReverseLineVertical() {
		// Initialize Canvas
		canvas = Canvas.getInstance();
		canvas.initializeCanvas(15, 20);
		// Initialise draw tool with line drawer
		Coordinates leftCoordinates = new Coordinates(10, 17);
		Coordinates rightCoordinates = new Coordinates(10, 13);
		drawTool = new LineDrawer(canvas, leftCoordinates, rightCoordinates);

		// draw
		drawTool.draw();

		// assert to see line Vertical shouldn't be drawn
		for (int i=rightCoordinates.getY(); i<leftCoordinates.getY(); i++) {
			assertThat("Vertical line is there", canvas.getChar(i, leftCoordinates.getX()), is(' '));
		}
	}

	@Test
	public void testDrawInvalidReverseLineHorizontal() {
		// Initialize Canvas
		canvas = Canvas.getInstance();
		canvas.initializeCanvas(15, 20);
		// Initialise draw tool with line drawer
		Coordinates leftCoordinates = new Coordinates(15, 10);
		Coordinates rightCoordinates = new Coordinates(3, 10);
		drawTool = new LineDrawer(canvas, leftCoordinates, rightCoordinates);

		// draw
		drawTool.draw();

		// assert to see line Horizontal shouldn't be drawn
		for (int i=rightCoordinates.getX(); i<leftCoordinates.getX(); i++) {
			assertThat("Horizontal line is there", canvas.getChar(leftCoordinates.getY(), i), is(' '));
		}
	}
}
