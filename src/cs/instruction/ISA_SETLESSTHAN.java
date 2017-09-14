package cs.instruction;

import cs.architecture.Internal;
import cs.instruction.types.ISA_RType;

public class ISA_SETLESSTHAN extends ISA_RType
{
	public ISA_SETLESSTHAN(String line)
	{
		super(line);
		parseFull();
		parseReg();
		
		HEX_OPCODE = 0x00;
		HEX_FUNCT = 0x2A;
	}

	@Override
	public void perform(Internal internal)
	{
		if(OPCODE.equalsIgnoreCase("slt"))
			internal.setRegisterVal(RD, (internal.getRegisterVal(RS) < internal.getRegisterVal(RT)) ? 1 : 0);
			//internal.setTo(RD, (internal.getFrom(RS) < internal.getFrom(RT)) ? 1 : 0);
		else if(OPCODE.equalsIgnoreCase("sltu"))
			internal.setRegisterVal(RD, (internal.getRegisterVal(RS) < internal.getRegisterVal(RT)) ? 1 : 0);
			//internal.setTo(RD, (internal.getFrom(RS) < internal.getFrom(RT)) ? 1 : 0);
	}
}
