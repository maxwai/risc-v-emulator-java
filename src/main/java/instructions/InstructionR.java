package instructions;

import memory.Registers.RegisterNames;

public abstract class InstructionR implements Instruction {
	
	private final RegisterNames rd, rs1, rs2;
	
	protected InstructionR(RegisterNames rd, RegisterNames rs1, RegisterNames rs2) {
		this.rd = rd;
		this.rs1 = rs1;
		this.rs2 = rs2;
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
	
	public RegisterNames rs2() {
		return rs2;
	}
}
