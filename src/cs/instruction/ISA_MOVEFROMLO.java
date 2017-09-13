package cs.instruction;

import cs.architecture.Internal;
import cs.instruction.types.ISA_RType;

public class ISA_MOVEFROMLO extends ISA_RType
{
	public ISA_MOVEFROMLO(String line)
	{
		super(line);
		parseFull();
		parseReg();
	}
	
	@Override
	public void parseReg()
	{
		String[] parsed = REGS.split(",");
		SHAMT = 0;
		FUNCT = "0";
		
		RD = checkReg(parsed[0]);
	}

	@Override
	public void perform(Internal internal)
	{
		if(OPCODE.equalsIgnoreCase("mflo"))
			internal.setRegisterVal(RD, internal.getRegisterVal("$LO"));
	}
}
