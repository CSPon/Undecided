package cs.opcode;

import cs.architecture.Internal;

public class ISA_ADD_I extends ISA_IType
{
	public ISA_ADD_I(String line)
	{
		super(line);
		parseFull();
		parseReg();
		
		HEX_OPCODE = 0x08;
		HEX_FUNCT = 0x00;
	}

	@Override
	public void perform(Internal internal)
	{
		if(OPCODE.equalsIgnoreCase("addi"))
			internal.setRegisterVal(RT, internal.getRegisterVal(RS) + IMMEDIATE);
		else if(OPCODE.equalsIgnoreCase("addiu"))
			internal.setRegisterVal(RT, internal.getRegisterVal(RS) + IMMEDIATE);
	}

}
