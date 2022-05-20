package instructions;

import exceptions.UnknownInstruction;
import instructions.implemetations.Addi;
import instructions.implemetations.Andi;
import instructions.implemetations.Jalr;
import instructions.implemetations.Lb;
import instructions.implemetations.Lbu;
import instructions.implemetations.Lh;
import instructions.implemetations.Lhu;
import instructions.implemetations.Lw;
import instructions.implemetations.Ori;
import instructions.implemetations.Slli;
import instructions.implemetations.Slti;
import instructions.implemetations.Sltiu;
import instructions.implemetations.Srai;
import instructions.implemetations.Srli;
import instructions.implemetations.Xori;
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
		int immSpezial = Byte.parseByte("0".repeat(3) +
										new StringBuilder(bitMap.substring(20, 25)).reverse(), 2);
		
		return switch (new StringBuilder(bitMap.substring(0, 7)).reverse().toString()) {
			case "1100111" -> new Jalr(rd, rs1, imm);
			case "0000011" ->
					switch (new StringBuilder(bitMap.substring(12, 15)).reverse().toString()) {
						case "000" -> new Lb(rd, rs1, imm);
						case "001" -> new Lh(rd, rs1, imm);
						case "010" -> new Lw(rd, rs1, imm);
						case "100" -> new Lbu(rd, rs1, imm);
						case "101" -> new Lhu(rd, rs1, imm);
						default -> throw new UnknownInstruction(
								new StringBuilder(bitMap).reverse().toString());
					};
			case "0010011" ->
					switch (new StringBuilder(bitMap.substring(12, 15)).reverse().toString()) {
						case "000" -> new Addi(rd, rs1, imm);
						case "010" -> new Slti(rd, rs1, imm);
						case "011" -> new Sltiu(rd, rs1, imm);
						case "100" -> new Xori(rd, rs1, imm);
						case "110" -> new Ori(rd, rs1, imm);
						case "111" -> new Andi(rd, rs1, imm);
						case "001" -> new Slli(rd, rs1, immSpezial);
						case "101" -> switch (bitMap.charAt(30)) {
							case '0' -> new Srli(rd, rs1, immSpezial);
							case '1' -> new Srai(rd, rs1, immSpezial);
							default -> throw new UnknownInstruction(
									new StringBuilder(bitMap).reverse().toString());
						};
						default -> throw new UnknownInstruction(
								new StringBuilder(bitMap).reverse().toString());
					};
			case "0001111" -> throw new RuntimeException("FENCE not yet implemented");
			case "1110011" -> {
				switch (bitMap.charAt(20)) {
					case '0' -> throw new RuntimeException("ECALL not yet implemented");
					case '1' -> throw new RuntimeException("EBREAK not yet implemented");
					default -> throw new UnknownInstruction(
							new StringBuilder(bitMap).reverse().toString());
				}
			}
			default -> throw new UnknownInstruction(new StringBuilder(bitMap).reverse().toString());
		};
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
