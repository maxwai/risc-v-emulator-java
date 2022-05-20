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
		RegisterNames rd = RegisterNames.getRegisterName(
				Integer.parseInt("000" + new StringBuilder(bitMap.substring(7, 12)).reverse(),
						2));
		RegisterNames rs1 = RegisterNames.getRegisterName(
				Integer.parseInt("000" + new StringBuilder(bitMap.substring(15, 20)).reverse(),
						2));
		int imm = Integer.parseInt(bitMap.substring(31, 32).repeat(21) +
								   new StringBuilder(bitMap.substring(20, 31)).reverse(), 2);
		
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
