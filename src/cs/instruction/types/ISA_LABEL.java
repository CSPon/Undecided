package cs.instruction.types;

import cs.architecture.Internal;

public class ISA_LABEL extends ISA_JType
{	
	public ISA_LABEL(String line)
	{
		super(line);
		parseFull();
	}
	
	@Override
	public void parseFull()
	{
		ADDR = INSTRUCTION.split(":")[0];
	}
	
	@Override
	public void parseReg()
	{
	}

	@Override
	public void perform(Internal internal)
	{
		// Do nothing. Its just label
	}
}
