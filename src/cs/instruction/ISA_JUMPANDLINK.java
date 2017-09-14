package cs.instruction;

import cs.architecture.Internal;
import cs.instruction.types.ISA_JType;

public class ISA_JUMPANDLINK extends ISA_JType
{
	public ISA_JUMPANDLINK(String line)
	{
		super(line);
		parseFull();
	}
	
	@Override
	public void parseFull()
	{
		String[] parsed = INSTRUCTION.split(" ");
		OPCODE = parsed[0];
		ADDR_JUMP = parsed[1];
		REGS = parsed[1];
	}

	@Override
	public void perform(Internal internal)
	{
		internal.setRegisterVal("$ra", ADDRESS_SELF);
		internal.setPC(ADDRESS_JUMP);
	}
}
