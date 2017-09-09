package cs.instruction;

import cs.architecture.Internal;
import cs.instruction.types.ISA_RType;

public class ISA_SETLESSTHAN extends ISA_RType
{
	public ISA_SETLESSTHAN(String line)
	{
		super(line);
		parseFull();
		parseReg();
	}

	@Override
	public void perform(Internal internal)
	{
		if(OPCODE.equalsIgnoreCase("slt"))
			internal.setTo(RD, (internal.getFrom(RS) < internal.getFrom(RT)) ? 1 : 0);
		else if(OPCODE.equalsIgnoreCase("sltu"))
			internal.setTo(RD, (internal.getFrom(RS) < internal.getFrom(RT)) ? 1 : 0);
	}
}
