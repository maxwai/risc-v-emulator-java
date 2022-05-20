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
	
	static InstructionS parseInstruction(String bitMap) {
		RegisterNames rs1 = RegisterNames.getRegisterName(
				Integer.parseInt("000" + new StringBuilder(bitMap.substring(15, 20)).reverse(),
						2));
		RegisterNames rs2 = RegisterNames.getRegisterName(
				Integer.parseInt("000" + new StringBuilder(bitMap.substring(20, 25)).reverse(),
						2));
		int imm = Integer.parseInt(bitMap.substring(31, 32).repeat(21) +
								   new StringBuilder(bitMap.substring(25, 31)).reverse() +
								   new StringBuilder(bitMap.substring(7, 12)).reverse(), 2);
		
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
