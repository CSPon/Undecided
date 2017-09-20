package cs.opcode;

import cs.architecture.Internal;

public class ISA_SET_LESS_THAN_I extends ISA_IType
{
	public ISA_SET_LESS_THAN_I(String line)
	{
		super(line);
		parseFull();
		parseReg();
		
		HEX_OPCODE = 0x0A;
		HEX_FUNCT = 0x00;
	}
	
	@Override
	public void parseReg()
	{
		String[] parsed = REGS.split(",");
		
		RT = checkReg(parsed[0]);
		RS = checkReg(parsed[1]);
		IMMEDIATE = Integer.parseInt(parsed[2]);
	}

	@Override
	public void perform(Internal internal)
	{
		if(OPCODE.equalsIgnoreCase("slti"))
			internal.setRegisterVal(RT, (internal.getRegisterVal(RS) < IMMEDIATE) ? 1 : 0);
		else if(OPCODE.equalsIgnoreCase("sltiu"))
			internal.setRegisterVal(RT, (internal.getRegisterVal(RS) < IMMEDIATE) ? 1 : 0);
	}
}
