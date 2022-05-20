package instructions;

import exceptions.UnknownInstruction;
import instructions.implemetations.Auipc;
import instructions.implemetations.Lui;
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
		return switch (new StringBuilder(bitMap.substring(0, 7)).reverse().toString()) {
			case "0110111" -> new Lui(rd, imm);
			case "0010111" -> new Auipc(rd, imm);
			default -> throw new UnknownInstruction(new StringBuilder(bitMap).reverse().toString());
		};
	}
	
	public RegisterNames rd() {
		return rd;
	}
	
	public int imm() {
		return imm;
	}
}
