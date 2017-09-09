package cs.instruction.types;

import cs.architecture.Internal;

public abstract class ISA_JType extends ISA_OPCODE
{	
	public ISA_JType(String line)
	{
		super(line);
	}
	
	@Override
	public void parseFull()
	{
		OPCODE = INSTRUCTION.split(" ")[0];
		REGS = INSTRUCTION.substring(INSTRUCTION.indexOf(" ") + 1);
		REGS = REGS.replaceAll(" ", "");
	}
	
	@Override
	public void parseReg()
	{
	}

	@Override
	public abstract void perform(Internal internal);
}
