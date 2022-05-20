package instructions.implemetations;

import instructions.InstructionR;
import memory.Registers.RegisterNames;
import visitors.InstructionVisitor;

public class Slt extends InstructionR {
	
	public Slt(RegisterNames rd, RegisterNames rs1, RegisterNames rs2) {
		super(rd, rs1, rs2);
	}
	
	@Override
	public void accept(InstructionVisitor visitor) {
		visitor.visit(this);
	}
}