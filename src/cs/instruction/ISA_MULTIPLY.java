package cs.instruction;

import cs.architecture.Internal;
import cs.instruction.types.ISA_RType;

public class ISA_MULTIPLY extends ISA_RType
{
	public ISA_MULTIPLY(String line)
	{
		super(line);
		parseFull();
		parseReg();
	}
	
	@Override
	public void parseReg()
	{
		String[] parsed = REGS.split(",");
		SHAMT = 0;
		FUNCT = "0";
		
		RS = checkReg(parsed[0]);
		RT = checkReg(parsed[1]);
	}

	@Override
	public void perform(Internal internal)
	{
		if(OPCODE.equalsIgnoreCase("mult"))
		{
			internal.setTo("$HI", (internal.getFrom(RS) * internal.getFrom(RT)) >> 8);
			internal.setTo("$LO", (internal.getFrom(RS) * internal.getFrom(RT)) & 0xFF);
		}
		else if(OPCODE.equalsIgnoreCase("multu"))
		{
			internal.setTo("$HI", (internal.getFrom(RS) * internal.getFrom(RT)) >> 8);
			internal.setTo("$LO", (internal.getFrom(RS) * internal.getFrom(RT)) & 0xFF);
		}
	}
}
