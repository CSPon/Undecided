package cs.instruction;

import cs.architecture.Internal;
import cs.instruction.types.ISA_RType;

public class ISA_SUB extends ISA_RType
{
	public ISA_SUB(String line)
	{
		super(line);
		parseFull();
		parseReg();
		HEX_OPCODE = 0x00;
		HEX_FUNCT = 0x22;
	}

	@Override
	public void perform(Internal internal)
	{
		if(OPCODE.equalsIgnoreCase("sub"))
			internal.setRegisterVal(RD, internal.getRegisterVal(RS) - internal.getRegisterVal(RT));
		else if(OPCODE.equalsIgnoreCase("subu"))
			internal.setRegisterVal(RD, internal.getRegisterVal(RS) - internal.getRegisterVal(RT));
	}
}
