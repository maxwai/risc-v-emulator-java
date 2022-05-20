package instructions;

import memory.Registers.RegisterNames;

public abstract class InstructionU implements Instruction {
	
	private final RegisterNames rd;
	private final int imm;
	
	protected InstructionU(RegisterNames rd, int imm) {
		this.rd = rd;
		this.imm = imm;
	}
	
	static InstructionI parseInstruction(String bitMap) {
		return null;
	}
	
	public RegisterNames rd() {
		return rd;
	}
	
	public int imm() {
		return imm;
	}
}
