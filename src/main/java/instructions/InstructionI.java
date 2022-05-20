package instructions;

import memory.Registers.RegisterNames;

public abstract class InstructionI implements Instruction {
	
	private final RegisterNames rd, rs1;
	private final int imm;
	
	protected InstructionI(RegisterNames rd, RegisterNames rs1, int imm) {
		this.rd = rd;
		this.rs1 = rs1;
		this.imm = imm;
	}
	
	static InstructionI parseInstruction(String bitMap) {
		return null;
	}
	
	public RegisterNames rd() {
		return rd;
	}
	
	public RegisterNames rs1() {
		return rs1;
	}
	
	public int imm() {
		return imm;
	}
}
