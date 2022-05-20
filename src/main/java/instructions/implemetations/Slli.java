package instructions.implemetations;

import instructions.InstructionI;
import memory.Registers.RegisterNames;
import visitors.InstructionVisitor;

public class Slli extends InstructionI {
	
	public Slli(RegisterNames rd, RegisterNames rs1, int imm) {
		super(rd, rs1, imm);
	}
	
	@Override
	public void accept(InstructionVisitor visitor) {
		visitor.visit(this);
	}
}
