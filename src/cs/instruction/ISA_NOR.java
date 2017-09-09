package cs.instruction;

import cs.architecture.Internal;
import cs.instruction.types.ISA_RType;

public class ISA_NOR extends ISA_RType
{
	public ISA_NOR(String line)
	{
		super(line);
		parseFull();
		parseReg();
	}

	@Override
	public void perform(Internal internal)
	{
		if(OPCODE.equalsIgnoreCase("nor"))
			internal.setTo(RD, ~(internal.getFrom(RS) | internal.getFrom(RT)));
	}

}
