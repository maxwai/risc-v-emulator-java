package visitors;

import instructions.Instruction;

public interface InstructionVisitor {
	
	void visit(Instruction instruction); // TODO change to one per type
}
