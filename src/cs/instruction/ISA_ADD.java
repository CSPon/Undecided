package cs.instruction;

import cs.architecture.Internal;
import cs.instruction.types.ISA_RType;

public class ISA_ADD extends ISA_RType
{	
	public ISA_ADD(String line)
	{
		super(line);
		parseFull();
		parseReg();
	}
	
	@Override
	public void perform(Internal internal)
	{
		if(OPCODE.equalsIgnoreCase("add"))
			internal.setTo(RD, internal.getFrom(RS) + internal.getFrom(RT));
		else if(OPCODE.equalsIgnoreCase("addu"))
			internal.setTo(RD, internal.getFrom(RS) + internal.getFrom(RT));
	}
}
