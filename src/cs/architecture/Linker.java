package cs.architecture;

import cs.instruction.ISA_INSTRUCTION;
import cs.opcode.ISA_ADD;
import cs.opcode.ISA_ADD_I;
import cs.opcode.ISA_ADD_IU;
import cs.opcode.ISA_ADD_U;
import cs.opcode.ISA_AND;
import cs.opcode.ISA_AND_I;
import cs.opcode.ISA_BRANCHGE;
import cs.opcode.ISA_BRANCHGT;
import cs.opcode.ISA_BRANCHLE;
import cs.opcode.ISA_BRANCHLT;
import cs.opcode.ISA_BRANCH_ON_EQUAL;
import cs.opcode.ISA_BRANCH_ON_NOT_EQUAL;
import cs.opcode.ISA_DIVIDE;
import cs.opcode.ISA_DIVIDE_U;
import cs.opcode.ISA_JUMP;
import cs.opcode.ISA_JUMP_AND_LINK;
import cs.opcode.ISA_JUMP_REG;
import cs.opcode.ISA_LOAD_BYTE_U;
import cs.opcode.ISA_LOAD_HALF_U;
import cs.opcode.ISA_LOAD_IMM;
import cs.opcode.ISA_LOAD_UPPER_I;
import cs.opcode.ISA_LOAD_WORD;
import cs.opcode.ISA_MOVE;
import cs.opcode.ISA_MOVE_FROM_HI;
import cs.opcode.ISA_MOVE_FROM_LO;
import cs.opcode.ISA_MULTIPLY;
import cs.opcode.ISA_MULTIPLY_U;
import cs.opcode.ISA_NOR;
import cs.opcode.ISA_OR;
import cs.opcode.ISA_OR_I;
import cs.opcode.ISA_SET_LESS_THAN;
import cs.opcode.ISA_SET_LESS_THAN_I;
import cs.opcode.ISA_SET_LESS_THAN_I_U;
import cs.opcode.ISA_SET_LESS_THAN_U;
import cs.opcode.ISA_SHIFT_LEFT_LOGICAL;
import cs.opcode.ISA_SHIFT_RIGHT_LOGICAL;
import cs.opcode.ISA_STORE_BYTE;
import cs.opcode.ISA_STORE_HALF;
import cs.opcode.ISA_STORE_WORD;
import cs.opcode.ISA_SUB;
import cs.opcode.ISA_SUB_U;

public class Linker
{
	public ISA_INSTRUCTION checkOpcode(String name, String line)
	{
		name = name.toLowerCase();
		if(name.matches("\\badd\\b"))
			return new ISA_ADD(line);
		else if(name.matches("\\baddi\\b"))
			return new ISA_ADD_I(line);
		else if(name.matches("\\baddiu\\b"))
			return new ISA_ADD_IU(line);
		else if(name.matches("\\baddu\\b"))
			return new ISA_ADD_U(line);
		else if(name.matches("\\band\\b"))
			return new ISA_AND(line);
		else if(name.matches("\\bandi\\b"))
			return new ISA_AND_I(line);
		else if(name.matches("\\bbeq\\b"))
			return new ISA_BRANCH_ON_EQUAL(line);
		else if(name.matches("\\bbne\\b"))
			return new ISA_BRANCH_ON_NOT_EQUAL(line);
		else if(name.matches("\\bblt\\b"))
			return new ISA_BRANCHLT(line);
		else if(name.matches("\\bbgt\\b"))
			return new ISA_BRANCHGT(line);
		else if(name.matches("\\bble\\b"))
			return new ISA_BRANCHLE(line);
		else if(name.matches("\\bbge\\b"))
			return new ISA_BRANCHGE(line);
		else if(name.matches("\\bj\\b"))
			return new ISA_JUMP(line);
		else if(name.matches("\\bjal\\b"))
			return new ISA_JUMP_AND_LINK(line);
		else if(name.matches("\\bjr\\b"))
			return new ISA_JUMP_REG(line);
		else if(name.matches("\\blbu\\b"))
			return new ISA_LOAD_BYTE_U(line);
		else if(name.matches("\\blhu\\b"))
			return new ISA_LOAD_HALF_U(line);
		else if(name.matches("\\blui\\b"))
			return new ISA_LOAD_UPPER_I(line);
		else if(name.matches("\\bli\\b"))
			return new ISA_LOAD_IMM(line);
		else if(name.matches("\\blw\\b"))
			return new ISA_LOAD_WORD(line);
		else if(name.matches("\\bmove\\b"))
			return new ISA_MOVE(line);
		else if(name.matches("\\bnor\\b"))
			return new ISA_NOR(line);
		else if(name.matches("\\bor\\b"))
			return new ISA_OR(line);
		else if(name.matches("\\bori\\b"))
			return new ISA_OR_I(line);
		else if(name.matches("\\bslt\\b"))
			return new ISA_SET_LESS_THAN(line);
		else if(name.matches("\\bslti\\b"))
			return new ISA_SET_LESS_THAN_I(line);
		else if(name.matches("\\bsltiu\\b"))
			return new ISA_SET_LESS_THAN_I_U(line);
		else if(name.matches("\\bsltu\\b"))
			return new ISA_SET_LESS_THAN_U(line);
		else if(name.matches("\\bsll\\b"))
			return new ISA_SHIFT_LEFT_LOGICAL(line);
		else if(name.matches("\\bslr\\b"))
			return new ISA_SHIFT_RIGHT_LOGICAL(line);
		else if(name.matches("\\bsb\\b"))
			return new ISA_STORE_BYTE(line);
		else if(name.matches("\\bsh\\b"))
			return new ISA_STORE_HALF(line);
		else if(name.matches("\\bsw\\b"))
			return new ISA_STORE_WORD(line);
		else if(name.matches("\\bsub\\b"))
			return new ISA_SUB(line);
		else if(name.matches("\\bsubu\\b"))
			return new ISA_SUB_U(line);
		else if(name.matches("\\band\\b"))
			return new ISA_AND(line);
		else if(name.matches("\\bdiv\\b"))
			return new ISA_DIVIDE(line);
		else if(name.matches("\\bdivu\\b"))
			return new ISA_DIVIDE_U(line);
		else if(name.matches("\\bmfhi\\b"))
			return new ISA_MOVE_FROM_HI(line);
		else if(name.matches("\\bmflo\\b"))
			return new ISA_MOVE_FROM_LO(line);
		else if(name.matches("\\bmult\\b"))
			return new ISA_MULTIPLY(line);
		else if(name.matches("\\bmultu\\b"))
			return new ISA_MULTIPLY_U(line);
		else return null;
	}
}
