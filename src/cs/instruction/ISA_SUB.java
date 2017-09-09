package cs.instruction;

import cs.architecture.Internal;
import cs.instruction.types.ISA_RType;

public class ISA_SUB extends ISA_RType
{
	public ISA_SUB(String line)
	{
		super(line);
		parseFull();
		parseReg();
	}

	@Override
	public void perform(Internal internal)
	{
		if(OPCODE.equalsIgnoreCase("sub"))
			internal.setTo(RD, internal.getFrom(RS) - internal.getFrom(RT));
		else if(OPCODE.equalsIgnoreCase("subu"))
			internal.setTo(RD, internal.getFrom(RS) - internal.getFrom(RT));
	}

}
