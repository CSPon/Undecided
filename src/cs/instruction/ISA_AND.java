package cs.instruction;

import cs.architecture.Internal;
import cs.instruction.types.ISA_RType;

public class ISA_AND extends ISA_RType
{
	public ISA_AND(String line)
	{
		super(line);
		parseFull();
		parseReg();
		
		HEX_OPCODE = 0x00;
		HEX_FUNCT = 0x24;
	}

	@Override
	public void perform(Internal internal)
	{
		if(OPCODE.equalsIgnoreCase("and"))
			internal.setRegisterVal(RD, internal.getRegisterVal(RS) & internal.getRegisterVal(RT));
	}
}
