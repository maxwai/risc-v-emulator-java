package instructions.implemetations;

import instructions.InstructionI;
import memory.Registers.RegisterNames;
import visitors.InstructionVisitor;

public class Lw extends InstructionI {
	
	public Lw(RegisterNames rd, RegisterNames rs1, int imm) {
		super(rd, rs1, imm);
	}
	
	@Override
	public void accept(InstructionVisitor visitor) {
		visitor.visit(this);
	}
}
