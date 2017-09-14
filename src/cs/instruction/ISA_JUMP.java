package cs.instruction;

import cs.architecture.Internal;
import cs.instruction.types.ISA_JType;

public class ISA_JUMP extends ISA_JType
{
	public ISA_JUMP(String line)
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
		internal.setPC(ADDRESS_JUMP);
	}
}
