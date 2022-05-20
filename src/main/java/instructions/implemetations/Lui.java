package instructions.implemetations;

import instructions.InstructionU;
import memory.Registers.RegisterNames;
import visitors.InstructionVisitor;

public class Lui extends InstructionU {
	
	public Lui(RegisterNames rd, int imm) {
		super(rd, imm);
	}
	
	@Override
	public void accept(InstructionVisitor visitor) {
		visitor.visit(this);
	}
}
