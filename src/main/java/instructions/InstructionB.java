package instructions;

import exceptions.UnknownInstruction;
import instructions.implemetations.Beq;
import instructions.implemetations.Bge;
import instructions.implemetations.Bgeu;
import instructions.implemetations.Blt;
import instructions.implemetations.Bltu;
import instructions.implemetations.Bne;
import memory.Registers.RegisterNames;

public abstract class InstructionB extends InstructionS {
	
	protected InstructionB(RegisterNames rs1, RegisterNames rs2, int imm) {
		super(rs1, rs2, imm);
	}
	
	static InstructionB parseInstruction(String bitMap) {
		RegisterNames rs1 = RegisterNames.getRegisterName(
				Integer.parseInt("000" + new StringBuilder(bitMap.substring(15, 20)).reverse(),
						2));
		RegisterNames rs2 = RegisterNames.getRegisterName(
				Integer.parseInt("000" + new StringBuilder(bitMap.substring(20, 25)).reverse(),
						2));
		int imm = Integer.parseInt(bitMap.substring(31, 32).repeat(20) + bitMap.charAt(7) +
								   new StringBuilder(bitMap.substring(25, 31)).reverse() +
								   new StringBuilder(bitMap.substring(8, 12)).reverse() + "0", 2);
		
		return switch (new StringBuilder(bitMap.substring(12, 15)).reverse().toString()) {
			case "000" -> new Beq(rs1, rs2, imm);
			case "001" -> new Bne(rs1, rs2, imm);
			case "100" -> new Blt(rs1, rs2, imm);
			case "101" -> new Bge(rs1, rs2, imm);
			case "110" -> new Bltu(rs1, rs2, imm);
			case "111" -> new Bgeu(rs1, rs2, imm);
			default -> throw new UnknownInstruction(new StringBuilder(bitMap).reverse().toString());
		};
	}
}
