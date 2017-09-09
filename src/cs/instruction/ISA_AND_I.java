package cs.instruction;

import cs.architecture.Internal;
import cs.instruction.types.ISA_IType;

public class ISA_AND_I extends ISA_IType
{
	public ISA_AND_I(String line)
	{
		super(line);
		parseFull();
		parseReg();
	}

	@Override
	public void perform(Internal internal)
	{
		if(OPCODE.equalsIgnoreCase("andi"))
			internal.setTo(RT, internal.getFrom(RS) & IMMEDIATE);
	}
}
