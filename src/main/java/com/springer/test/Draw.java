package com.springer.test;

import com.springer.test.drawers.Canvas;
import com.springer.test.drawers.Commands;
import com.springer.test.drawers.Instruction;
import com.springer.test.tools.DrawTool;
import com.springer.test.tools.drawers.BucketFill;
import com.springer.test.tools.drawers.LineDrawer;
import com.springer.test.tools.drawers.RectDrawer;

import java.util.Scanner;

/**
 * This is the main class and the entry point of the application
 */
public class Draw {

	public static void main(String...ar) {
		Scanner scanner = new Scanner(System.in);
		Instruction instruction;
		DrawTool drawTool;
		Canvas canvas = Canvas.getInstance();;
		String input;

		do {
			// initializing the instruction class
			instruction = new Instruction();

			// Asking for user input
			System.out.print("Enter Command: ");
			input = scanner.nextLine();

			// parsing user input
			instruction.setInstruction(input);
			if (instruction.getCommand() == null) {
				System.out.println("Invalid instruction given. Please try again");
			} else {
				// Creating
				switch (instruction.getCommand()) {
					case C: // Create a canvas
						canvas.initializeCanvas(instruction.getCoordinates()[0].getX(),
								instruction.getCoordinates()[0].getY());
						break;
					case L: // Create a Line
						drawTool = new LineDrawer(canvas, instruction.getCoordinates());
						drawTool.draw();
						break;
					case R: /// Create a Rectangle
						drawTool = new RectDrawer(canvas, instruction.getCoordinates());
						drawTool.draw();
						break;
					case B: // Bucket fill
						drawTool = new BucketFill(canvas, instruction.getFillChar(), instruction.getCoordinates());
						drawTool.draw();
						break;
				}
				canvas.displayCanvas();
			}
		} while(!Commands.Q.equals(instruction.getCommand()));
	}
}
