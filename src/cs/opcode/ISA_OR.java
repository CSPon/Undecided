package cs.opcode;

import cs.architecture.Internal;

public class ISA_OR extends ISA_RType
{
	public ISA_OR(String line)
	{
		super(line);
		parseFull();
		parseReg();
		
		HEX_OPCODE = 0x00;
		HEX_FUNCT = 0x25;
	}

	@Override
	public void perform(Internal internal)
	{
		if(OPCODE.equalsIgnoreCase("or"))
			internal.setRegisterVal(RD, internal.getRegisterVal(RS) | internal.getRegisterVal(RT));
	}
}
