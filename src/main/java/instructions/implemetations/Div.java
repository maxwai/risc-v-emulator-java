package instructions.implemetations;

import instructions.InstructionR;
import memory.Registers.RegisterNames;
import visitors.InstructionVisitor;

public class Div extends InstructionR {
	
	public Div(RegisterNames rd, RegisterNames rs1, RegisterNames rs2) {
		super(rd, rs1, rs2);
	}
	
	@Override
	public void accept(InstructionVisitor visitor) {
		visitor.visit(this);
	}
}
