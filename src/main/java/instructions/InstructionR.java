package instructions;

import exceptions.UnknownInstruction;
import instructions.implemetations.Add;
import instructions.implemetations.And;
import instructions.implemetations.Or;
import instructions.implemetations.Sll;
import instructions.implemetations.Slt;
import instructions.implemetations.Sltu;
import instructions.implemetations.Sra;
import instructions.implemetations.Srl;
import instructions.implemetations.Sub;
import instructions.implemetations.Xor;
import memory.Registers.RegisterNames;

public abstract class InstructionR implements Instruction {
	
	private final RegisterNames rd, rs1, rs2;
	
	protected InstructionR(RegisterNames rd, RegisterNames rs1, RegisterNames rs2) {
		this.rd = rd;
		this.rs1 = rs1;
		this.rs2 = rs2;
	}
	
	static InstructionR parseInstruction(String bitMap) {
		RegisterNames rd = RegisterNames.getRegisterName(
				Integer.parseInt("000" + new StringBuilder(bitMap.substring(7, 12)).reverse(),
						2));
		RegisterNames rs1 = RegisterNames.getRegisterName(
				Integer.parseInt("000" + new StringBuilder(bitMap.substring(15, 20)).reverse(),
						2));
		RegisterNames rs2 = RegisterNames.getRegisterName(
				Integer.parseInt("000" + new StringBuilder(bitMap.substring(20, 25)).reverse(),
						2));
		
		return switch (new StringBuilder(bitMap.substring(12, 15)).reverse().toString()) {
			case "000" -> switch (bitMap.charAt(30)) {
				case '0' -> new Add(rd, rs1, rs2);
				case '1' -> new Sub(rd, rs1, rs2);
				default -> throw new UnknownInstruction(
						new StringBuilder(bitMap).reverse().toString());
			};
			case "001" -> new Sll(rd, rs1, rs2);
			case "010" -> new Slt(rd, rs1, rs2);
			case "011" -> new Sltu(rd, rs1, rs2);
			case "100" -> new Xor(rd, rs1, rs2);
			case "101" -> switch (bitMap.charAt(30)) {
				case '0' -> new Srl(rd, rs1, rs2);
				case '1' -> new Sra(rd, rs1, rs2);
				default -> throw new UnknownInstruction(
						new StringBuilder(bitMap).reverse().toString());
			};
			case "110" -> new Or(rd, rs1, rs2);
			case "111" -> new And(rd, rs1, rs2);
			default -> throw new UnknownInstruction(new StringBuilder(bitMap).reverse().toString());
		};
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
