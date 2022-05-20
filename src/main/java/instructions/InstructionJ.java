package instructions;

import instructions.implemetations.Jal;
import memory.Registers.RegisterNames;

public abstract class InstructionJ extends InstructionU {
	
	protected InstructionJ(RegisterNames rd, int imm) {
		super(rd, imm);
	}
	
	static InstructionJ parseInstruction(String bitMap) {
		RegisterNames rd = RegisterNames.getRegisterName(
				Integer.parseInt("000" + new StringBuilder(bitMap.substring(7, 12)).reverse(),
						2));
		int imm = Integer.parseInt(bitMap.substring(31, 32).repeat(12) +
								   new StringBuilder(bitMap.substring(12, 20)).reverse() +
								   bitMap.charAt(20) +
								   new StringBuilder(bitMap.substring(21, 31)).reverse() + "0", 2);
		
		return new Jal(rd, imm);
	}
}
