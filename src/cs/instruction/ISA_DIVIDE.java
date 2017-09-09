package cs.instruction;

import cs.architecture.Internal;
import cs.instruction.types.ISA_RType;

public class ISA_DIVIDE extends ISA_RType
{
	public ISA_DIVIDE(String line)
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
		if(OPCODE.equalsIgnoreCase("div"))
		{
			internal.setTo("$LO", internal.getFrom(RS) / internal.getFrom(RT));
			internal.setTo("$HI", internal.getFrom(RS) % internal.getFrom(RT));
		}
		else if(OPCODE.equalsIgnoreCase("divu"))
		{
			internal.setTo("$LO", internal.getFrom(RS) / internal.getFrom(RT));
			internal.setTo("$HI", internal.getFrom(RS) % internal.getFrom(RT));
		}
	}
}
