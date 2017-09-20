package cs.opcode;

import cs.architecture.Internal;

public class ISA_OR_I extends ISA_IType
{
	public ISA_OR_I(String line)
	{
		super(line);
		parseFull();
		parseReg();
		
		HEX_OPCODE = 0x0D;
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
		if(OPCODE.equalsIgnoreCase("ori"))
			internal.setRegisterVal(RD, internal.getRegisterVal(RS) | IMMEDIATE);
	}
}
