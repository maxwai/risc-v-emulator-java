package instructions;

import memory.Registers.RegisterNames;

public abstract class InstructionB extends InstructionS {
	
	protected InstructionB(RegisterNames rs1, RegisterNames rs2, int imm) {
		super(rs1, rs2, imm);
	}
	
	static InstructionI parseInstruction(String bitMap) {
		RegisterNames rs1 = RegisterNames.getRegisterName(
				Integer.parseInt("000" + new StringBuilder(bitMap.substring(15, 20)).reverse(),
						2));
		RegisterNames rs2 = RegisterNames.getRegisterName(
				Integer.parseInt("000" + new StringBuilder(bitMap.substring(20, 25)).reverse(),
						2));
		int imm = Integer.parseInt(bitMap.substring(31, 32).repeat(20) + bitMap.charAt(7) +
								   new StringBuilder(bitMap.substring(25, 31)).reverse() +
								   new StringBuilder(bitMap.substring(8, 12)).reverse() + "0", 2);
		
		return null;
	}
}
