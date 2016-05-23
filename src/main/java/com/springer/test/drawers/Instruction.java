package com.springer.test.drawers;

import com.springer.test.vo.Coordinates;

public class Instruction {

	private Commands command;
	private Coordinates[] coordinates;
	private char fillChar;

	private final String regex = "^[Cc](\\s[0-9]{1,2}){2}$|^[LlRr](\\s[0-9]{1,2}){4}$|^[Bb](\\s[0-9]{1,2}){2}\\s[a-zA-Z]$|^[Qq]$";

	/**
	 * This method is used to validate the instruction for below:
	 * 1. C x1 y1 (to draw a canvas)
	 * 2. L x1 y1 x2 y2 (to draw a line)
	 * 3. R x1 y1 x2 y2 (to draw a rectangle)
	 * 4. B x1 y1 char (to bucket fill the canvas from location with the passed char
	 * 5. Q
	 * The method uses the regex checker to validate
	 *
	 * @param input - The instruction to be validated
	 * @return - true if the instruction is valid, false otherwise
	 */
	private boolean validateInstruction(String input) {
		return input.matches(regex);
	}

	public void setInstruction(String input) {
		if (validateInstruction(input)) {
			// Parsing the instruction
			String[] data = input.split(" ");

			// First part of instruction is the command. Parsing the command
			command = Commands.valueOf(data[0].trim().toUpperCase());

			// Based on the command, second part of instruction is
			// 1. 2 coordinates in case of R and L
			// 2. 1 coordinate in case of C
			// 3. 1 coordinate and a char in case of B
			// 4. no further params in case of Q
			switch (command) {
				case C: coordinates = new Coordinates[1];
					coordinates[0] = new Coordinates(Integer.parseInt(data[1]), Integer.parseInt(data[2]));
					break;
				case L: coordinates = new Coordinates[2];
					coordinates[0] = new Coordinates(Integer.parseInt(data[1]), Integer.parseInt(data[2]));
					coordinates[1] = new Coordinates(Integer.parseInt(data[3]), Integer.parseInt(data[4]));
					break;
				case R: coordinates = new Coordinates[2];
					coordinates[0] = new Coordinates(Integer.parseInt(data[1]), Integer.parseInt(data[2]));
					coordinates[1] = new Coordinates(Integer.parseInt(data[3]), Integer.parseInt(data[4]));
					break;
				case B: coordinates = new Coordinates[1];
					coordinates[0] = new Coordinates(Integer.parseInt(data[1]), Integer.parseInt(data[2]));
					fillChar = data[3].charAt(0);
					break;
			}
		}
	}

	/* Getters and Setters */

	public Commands getCommand() {
		return command;
	}

	public void setCommand(Commands command) {
		this.command = command;
	}

	public Coordinates[] getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(Coordinates[] coordinates) {
		this.coordinates = coordinates;
	}

	public char getFillChar() {
		return fillChar;
	}

	public void setFillChar(char fillChar) {
		this.fillChar = fillChar;
	}

}
