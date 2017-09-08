package cs.instruction.types;

import cs.architecture.Internal;
import cs.instruction.Instruction;

public abstract class ISA_IType implements Instruction
{
	protected String line;
	protected String rs, rt, immediate;
	
	@Override
	public abstract void parse();

	@Override
	public abstract void perform(Internal internal);
}
