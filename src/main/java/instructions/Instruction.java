package instructions;

import exceptions.UnknownInstruction;
import visitors.InstructionVisitor;

public interface Instruction {
	
	private static String byteArrayToBitString(int instruction) {
		StringBuilder output = new StringBuilder();
		
		for (int i = 0; i < 32; i++) {
			output.append((instruction & 1) == 1 ? "1" : "0");
			instruction = instruction >>> 1;
		}
		
		return output.toString();
	}
	
	static Instruction parseInstruction(int instruction) {
		String bitMap = byteArrayToBitString(instruction);
		return switch (new StringBuilder(bitMap.substring(0, 7)).reverse().toString()) {
			case "0110111", "0010111" -> InstructionU.parseInstruction(bitMap);
			case "1101111" -> InstructionJ.parseInstruction(bitMap);
			case "1100111", "0000011", "0010011", "0001111", "1110011" ->
					InstructionI.parseInstruction(bitMap);
			case "1100011" -> InstructionB.parseInstruction(bitMap);
			case "0100011" -> InstructionS.parseInstruction(bitMap);
			case "0110011" -> InstructionR.parseInstruction(bitMap);
			default -> throw new UnknownInstruction(new StringBuilder(bitMap).reverse().toString());
		};
	}
	
	void accept(InstructionVisitor visitor);
	
	String toString();
}
