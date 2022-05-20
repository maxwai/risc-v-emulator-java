package instructions.implemetations;

import instructions.InstructionB;
import memory.Registers.RegisterNames;
import visitors.InstructionVisitor;

public class Bne extends InstructionB {
	
	public Bne(RegisterNames rs1, RegisterNames rs2, int imm) {
		super(rs1, rs2, imm);
	}
	
	@Override
	public void accept(InstructionVisitor visitor) {
		visitor.visit(this);
	}
}
