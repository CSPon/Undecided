package cs.instruction.types;

import cs.architecture.Internal;
import cs.instruction.Instruction;

public abstract class ISA_RType implements Instruction
{
	protected String line;
	protected String rs, rt, rd, shamt, funct;
	
	@Override
	public abstract void parse();

	@Override
	public abstract void perform(Internal internal);
}
