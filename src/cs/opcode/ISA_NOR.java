package cs.opcode;

import cs.architecture.Internal;

public class ISA_NOR extends ISA_RType
{
	public ISA_NOR(String line)
	{
		super(line);
		parseFull();
		parseReg();
		
		HEX_OPCODE = 0x00;
		HEX_FUNCT = 0x27;
	}

	@Override
	public void perform(Internal internal)
	{
		if(OPCODE.equalsIgnoreCase("nor"))
			internal.setRegisterVal(RD, ~(internal.getRegisterVal(RS) | internal.getRegisterVal(RT)));
	}

}
