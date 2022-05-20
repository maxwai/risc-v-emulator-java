package instructions;

import memory.Registers.RegisterNames;

public abstract class InstructionU implements Instruction {
	
	private final RegisterNames rd;
	private final int imm;
	
	protected InstructionU(RegisterNames rd, int imm) {
		this.rd = rd;
		this.imm = imm;
	}
	
	static InstructionU parseInstruction(String bitMap) {
		RegisterNames rd = RegisterNames.getRegisterName(
				Integer.parseInt("000" + new StringBuilder(bitMap.substring(7, 12)).reverse(),
						2));
		int imm = Integer.parseInt(new StringBuilder(bitMap.substring(12, 32)).reverse() +
								   "0".repeat(12), 2);
		
		return null;
	}
	
	public RegisterNames rd() {
		return rd;
	}
	
	public int imm() {
		return imm;
	}
}
