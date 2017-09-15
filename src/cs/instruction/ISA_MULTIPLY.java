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
		
		HEX_OPCODE = 0x00;
		HEX_FUNCT = 0x18;
	}
	
	@Override
	public void parseReg()
	{
		String[] parsed = REGS.split(",");
		
		RS = checkReg(parsed[0]);
		RT = checkReg(parsed[1]);
	}

	@Override
	public void perform(Internal internal)
	{
		if(OPCODE.equalsIgnoreCase("mult"))
		{
			internal.setTo("$hi", (internal.getRegisterVal(RS) * internal.getRegisterVal(RT)) >> 16);
			internal.setTo("$lo", (internal.getRegisterVal(RS) * internal.getRegisterVal(RT)) & 0xFFFF);
		}
		else if(OPCODE.equalsIgnoreCase("multu"))
		{
			internal.setTo("$hi", (internal.getRegisterVal(RS) * internal.getRegisterVal(RT)) >> 16);
			internal.setTo("$lo", (internal.getRegisterVal(RS) * internal.getRegisterVal(RT)) & 0xFFFF);
		}
	}
}
