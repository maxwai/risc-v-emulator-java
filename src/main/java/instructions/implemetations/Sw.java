package instructions.implemetations;

import instructions.InstructionS;
import memory.Registers.RegisterNames;
import visitors.InstructionVisitor;

public class Sw extends InstructionS {
	
	public Sw(RegisterNames rs1, RegisterNames rs2, int imm) {
		super(rs1, rs2, imm);
	}
	
	@Override
	public void accept(InstructionVisitor visitor) {
		visitor.visit(this);
	}
}
