package com.springer.test.drawers;

import junit.framework.TestCase;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

public class InstructionTest extends TestCase {

	@Test
	public void testSetInstructionCreateCanvasValid() {
		Instruction instruction = new Instruction();
		instruction.setInstruction("C 1 1");
		assertThat("Command not properly parsed", instruction.getCommand(), is(Commands.C));
		assertThat("Coordinates not properly parsed", instruction.getCoordinates().length, is(1));
		assertThat("Coordinates not properly parsed", instruction.getCoordinates()[0].getX(), is(1));
		assertThat("Coordinates not properly parsed", instruction.getCoordinates()[0].getY(), is(1));
	}

	@Test
	public void testSetInstructionCreateCanvasInvalidLess() {
		Instruction instruction = new Instruction();
		instruction.setInstruction("C 1");
		assertThat("Command properly parsed", instruction.getCommand(), is(nullValue()));
	}

	@Test
	public void testSetInstructionCreateCanvasInvalidChars() {
		Instruction instruction = new Instruction();
		instruction.setInstruction("C D");
		assertThat("Command properly parsed", instruction.getCommand(), is(nullValue()));
	}

	@Test
	public void testSetInstructionCreateCanvasInvalidMore() {
		Instruction instruction = new Instruction();
		instruction.setInstruction("C 1 1 1");
		assertThat("Command properly parsed", instruction.getCommand(), is(nullValue()));
	}

	@Test
	public void testSetInstructionInvalidInstructions() {
		Instruction instruction = new Instruction();
		instruction.setInstruction("CAASDFIHasdfoh");
		assertThat("Command properly parsed", instruction.getCommand(), is(nullValue()));
	}

	@Test
	public void testSetInstructionInvalidCreateRectangleLess() {
		Instruction instruction = new Instruction();
		instruction.setInstruction("R 1 1");
		assertThat("Command properly parsed", instruction.getCommand(), is(nullValue()));
	}

	@Test
	public void testSetInstructionInvalidCreateRectangleMore() {
		Instruction instruction = new Instruction();
		instruction.setInstruction("R 1 1 1 1 1");
		assertThat("Command properly parsed", instruction.getCommand(), is(nullValue()));
	}

	@Test
	public void testSetInstructionInvalidOtherChars() {
		Instruction instruction = new Instruction();
		instruction.setInstruction("R 1 3 t s");
		assertThat("Command properly parsed", instruction.getCommand(), is(nullValue()));
	}

	@Test
	public void testSetInstructionValidCreateRectangle() {
		Instruction instruction = new Instruction();
		instruction.setInstruction("R 1 3 1 2");
		assertThat("Command not properly parsed", instruction.getCommand(), is(Commands.R));
		assertThat("Coordinates not properly parsed", instruction.getCoordinates().length, is(2));
		assertThat("Coordinates not properly parsed", instruction.getCoordinates()[0].getX(), is(1));
		assertThat("Coordinates not properly parsed", instruction.getCoordinates()[0].getY(), is(3));
		assertThat("Coordinates not properly parsed", instruction.getCoordinates()[1].getX(), is(1));
		assertThat("Coordinates not properly parsed", instruction.getCoordinates()[1].getY(), is(2));
	}

	@Test
	public void testSetInstructionValidCreateLine() {
		Instruction instruction = new Instruction();
		instruction.setInstruction("L 1 3 1 2");
		assertThat("Command not properly parsed", instruction.getCommand(), is(Commands.L));
		assertThat("Coordinates not properly parsed", instruction.getCoordinates().length, is(2));
		assertThat("Coordinates not properly parsed", instruction.getCoordinates()[0].getX(), is(1));
		assertThat("Coordinates not properly parsed", instruction.getCoordinates()[0].getY(), is(3));
		assertThat("Coordinates not properly parsed", instruction.getCoordinates()[1].getX(), is(1));
		assertThat("Coordinates not properly parsed", instruction.getCoordinates()[1].getY(), is(2));
	}

	@Test
	public void testSetInstructionValidBucketFill() {
		Instruction instruction = new Instruction();
		instruction.setInstruction("B 1 3 c");
		assertThat("Command not properly parsed", instruction.getCommand(), is(Commands.B));
		assertThat("Coordinates not properly parsed", instruction.getCoordinates().length, is(1));
		assertThat("Coordinates not properly parsed", instruction.getCoordinates()[0].getX(), is(1));
		assertThat("Coordinates not properly parsed", instruction.getCoordinates()[0].getY(), is(3));
		assertThat("Coordinates not properly parsed", instruction.getFillChar(), is('c'));
	}

	@Test
	public void testSetInstructionValidQuit() {
		Instruction instruction = new Instruction();
		instruction.setInstruction("Q");
		assertThat("Command not properly parsed", instruction.getCommand(), is(Commands.Q));
		assertThat("Coordinates not properly parsed", instruction.getCoordinates(), is(nullValue()));
	}
	@Test
	public void testSetInstructionInValidQuit() {
		Instruction instruction = new Instruction();
		instruction.setInstruction("Q 1 2");
		assertThat("Command properly parsed", instruction.getCommand(), is(nullValue()));
	}
}