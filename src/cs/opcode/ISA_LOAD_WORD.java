package cs.opcode;

import cs.architecture.Internal;

public class ISA_LOAD_WORD extends ISA_IType
{
	public ISA_LOAD_WORD(String expression)
	{
		super(expression);
		parseFull();
		parseReg();
		
		HEX_OPCODE = 0x23;
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
		if(OPCODE.equalsIgnoreCase("lw"))
			internal.setRegisterVal(RT, internal.getMemoryVal(internal.getRegisterVal(RS), IMMEDIATE));
	}
}
