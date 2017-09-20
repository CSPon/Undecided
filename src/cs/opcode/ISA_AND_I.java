package cs.opcode;

import cs.architecture.Internal;

public class ISA_AND_I extends ISA_IType
{
	public ISA_AND_I(String line)
	{
		super(line);
		parseFull();
		parseReg();
		
		HEX_OPCODE = 0x0C;
		HEX_FUNCT = 0x00;
	}

	@Override
	public void perform(Internal internal)
	{
		if(OPCODE.equalsIgnoreCase("andi"))
			internal.setRegisterVal(RT, internal.getRegisterVal(RS) & IMMEDIATE);
	}
}
