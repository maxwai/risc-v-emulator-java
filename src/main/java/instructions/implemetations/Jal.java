package instructions.implemetations;

import instructions.InstructionJ;
import memory.Registers.RegisterNames;
import visitors.InstructionVisitor;

public class Jal extends InstructionJ {
	
	public Jal(RegisterNames rd, int imm) {
		super(rd, imm);
	}
	
	@Override
	public void accept(InstructionVisitor visitor) {
		visitor.visit(this);
	}
}
