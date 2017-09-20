package cs.opcode;

import cs.architecture.Internal;

public class ISA_ADD extends ISA_RType
{	
	public ISA_ADD(String line)
	{
		super(line);
		parseFull();
		parseReg();
		
		HEX_OPCODE = 0x00;
		HEX_FUNCT = 0x20;
	}
	
	@Override
	public void perform(Internal internal)
	{
		if(OPCODE.equalsIgnoreCase("add"))
			internal.setRegisterVal(RD, internal.getRegisterVal(RS) + internal.getRegisterVal(RT));
		else if(OPCODE.equalsIgnoreCase("addu"))
			internal.setRegisterVal(RD, internal.getRegisterVal(RS) + internal.getRegisterVal(RT));
	}
}
