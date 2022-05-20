package instructions;

import exceptions.UnknownInstruction;
import instructions.implemetations.Lb;
import instructions.implemetations.Lbu;
import instructions.implemetations.Lh;
import instructions.implemetations.Lhu;
import instructions.implemetations.Lw;
import instructions.implemetations.Sb;
import instructions.implemetations.Sh;
import instructions.implemetations.Sw;
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
		
		return switch (new StringBuilder(bitMap.substring(12, 15)).reverse().toString()) {
			case "000" -> new Sb(rs1, rs2, imm);
			case "001" -> new Sh(rs1, rs2, imm);
			case "010" -> new Sw(rs1, rs2, imm);
			default -> throw new UnknownInstruction(
					new StringBuilder(bitMap).reverse().toString());
		};
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
