package visitors;

import instructions.implemetations.Add;
import instructions.implemetations.Addi;
import instructions.implemetations.And;
import instructions.implemetations.Andi;
import instructions.implemetations.Auipc;
import instructions.implemetations.Beq;
import instructions.implemetations.Bge;
import instructions.implemetations.Bgeu;
import instructions.implemetations.Blt;
import instructions.implemetations.Bltu;
import instructions.implemetations.Bne;
import instructions.implemetations.Ebreak;
import instructions.implemetations.Ecall;
import instructions.implemetations.Fence;
import instructions.implemetations.Jal;
import instructions.implemetations.Jalr;
import instructions.implemetations.Lb;
import instructions.implemetations.Lbu;
import instructions.implemetations.Lh;
import instructions.implemetations.Lhu;
import instructions.implemetations.Lui;
import instructions.implemetations.Lw;
import instructions.implemetations.Or;
import instructions.implemetations.Ori;
import instructions.implemetations.Sb;
import instructions.implemetations.Sh;
import instructions.implemetations.Sll;
import instructions.implemetations.Slli;
import instructions.implemetations.Slt;
import instructions.implemetations.Slti;
import instructions.implemetations.Sltiu;
import instructions.implemetations.Sltu;
import instructions.implemetations.Sra;
import instructions.implemetations.Srai;
import instructions.implemetations.Srl;
import instructions.implemetations.Srli;
import instructions.implemetations.Sub;
import instructions.implemetations.Sw;
import instructions.implemetations.Xor;
import instructions.implemetations.Xori;

public interface InstructionVisitor {
	
	void visit(Add add);
	
	void visit(Addi addi);
	
	void visit(And and);
	
	void visit(Andi andi);
	
	void visit(Auipc auipc);
	
	void visit(Beq beq);
	
	void visit(Bge bge);
	
	void visit(Bgeu bgeu);
	
	void visit(Blt blt);
	
	void visit(Bltu bltu);
	
	void visit(Bne bne);
	
	void visit(Ebreak ebreak);
	
	void visit(Ecall ecall);
	
	void visit(Fence fence);
	
	void visit(Jal jal);
	
	void visit(Jalr jalr);
	
	void visit(Lb lb);
	
	void visit(Lbu lbu);
	
	void visit(Lh lh);
	
	void visit(Lhu lhu);
	
	void visit(Lui lui);
	
	void visit(Lw lw);
	
	void visit(Or or);
	
	void visit(Ori ori);
	
	void visit(Sb sb);
	
	void visit(Sh sh);
	
	void visit(Sll sll);
	
	void visit(Slli slli);
	
	void visit(Slt slt);
	
	void visit(Slti slti);
	
	void visit(Sltiu sltiu);
	
	void visit(Sltu sltu);
	
	void visit(Sra sra);
	
	void visit(Srai srai);
	
	void visit(Srl srl);
	
	void visit(Srli srli);
	
	void visit(Sub sub);
	
	void visit(Sw sw);
	
	void visit(Xor xor);
	
	void visit(Xori xori);
}
