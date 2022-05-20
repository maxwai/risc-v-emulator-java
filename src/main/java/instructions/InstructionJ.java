package instructions;

import memory.Registers.RegisterNames;

public abstract class InstructionJ extends InstructionU {
	
	protected InstructionJ(RegisterNames rd, int imm) {
		super(rd, imm);
	}
	
	static InstructionI parseInstruction(String bitMap) {
		return null;
	}
}
