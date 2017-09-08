package cs.instruction.types;

import cs.architecture.Internal;
import cs.instruction.Instruction;

public abstract class ISA_JType implements Instruction
{
	protected String line;
	protected String address;
	
	@Override
	public abstract void parse();

	@Override
	public abstract void perform(Internal internal);
}
