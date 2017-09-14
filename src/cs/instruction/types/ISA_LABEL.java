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
		OPCODE = "LABEL";
		REGS = INSTRUCTION;
		ADDR_SELF = INSTRUCTION;
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

	@Override
	public String toString(Internal internal)
	{
		return String.format("0x%08X", PC);
	}
}
