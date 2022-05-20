package instructions;

import memory.Registers.RegisterNames;

public abstract class InstructionB extends InstructionS {
	
	protected InstructionB(RegisterNames rs1, RegisterNames rs2, int imm) {
		super(rs1, rs2, imm);
	}
	
	static InstructionI parseInstruction(String bitMap) {
		return null;
	}
}
