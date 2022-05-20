package instructions;

import visitors.InstructionVisitor;

public interface Instruction {
	
	void accept(InstructionVisitor visitor);
	
	String toString();
}
