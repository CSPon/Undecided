package cs.instruction;

import cs.architecture.Internal;
import cs.instruction.types.ISA_RType;

public class ISA_AND extends ISA_RType
{
	public ISA_AND(String line)
	{
		super(line);
		parseFull();
		parseReg();
	}

	@Override
	public void perform(Internal internal)
	{
		if(OPCODE.equalsIgnoreCase("and"))
			internal.setTo(RD, internal.getFrom(RS) & internal.getFrom(RT));
	}
}
