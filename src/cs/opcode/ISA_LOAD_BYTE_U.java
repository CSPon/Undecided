package cs.opcode;

import cs.architecture.Internal;

public class ISA_LOAD_BYTE_U extends ISA_LOAD_HALF_U
{
	public ISA_LOAD_BYTE_U(String line)
	{
		super(line);
		parseFull();
		parseReg();
		
		HEX_OPCODE = 0x24;
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
		if(OPCODE.equalsIgnoreCase("lbu"))
			internal.setRegisterVal(RT, internal.getMemoryVal(internal.getRegisterVal(RS), IMMEDIATE) & 0xFF);
	}
}
