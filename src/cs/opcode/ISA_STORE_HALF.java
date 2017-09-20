package cs.opcode;

import cs.architecture.Internal;

public class ISA_STORE_HALF extends ISA_STORE_WORD
{
	public ISA_STORE_HALF(String line)
	{
		super(line);
		parseFull();
		parseReg();
		
		HEX_OPCODE = 0x29;
		HEX_FUNCT = 0x00;
	}
	
	@Override
	public void parseReg()
	{
		String[] parsed = REGS.split(",");
		
		RT = checkReg(parsed[0]);
		IMMEDIATE = checkShift(parsed[1]);
		RS = checkReg(parsed[1]);
	}

	@Override
	public void perform(Internal internal)
	{
		if(OPCODE.equalsIgnoreCase("sh"))
			internal.setMemoryVal(internal.getRegisterVal(RS), IMMEDIATE, internal.getRegisterVal(RT) & 0xFFFF);
			//internal.setToMem(internal.getFrom(RS), IMMEDIATE, internal.getFrom(RT) & 0xFFFF);
	}
}
