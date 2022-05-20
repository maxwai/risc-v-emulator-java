package instructions;

import memory.Registers.RegisterNames;

public abstract class InstructionS implements Instruction {
	
	private final RegisterNames rs1, rs2;
	private final int imm;
	
	protected InstructionS(RegisterNames rs1, RegisterNames rs2, int imm) {
		this.rs1 = rs1;
		this.rs2 = rs2;
		this.imm = imm;
	}
	
	static InstructionI parseInstruction(String bitMap) {
		return null;
	}
	
	public RegisterNames rs1() {
		return rs1;
	}
	
	public RegisterNames rs2() {
		return rs2;
	}
	
	public int imm() {
		return imm;
	}
}
