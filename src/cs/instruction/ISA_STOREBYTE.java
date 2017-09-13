package cs.instruction;

import cs.architecture.Internal;
import cs.instruction.types.ISA_IType;

public class ISA_STOREBYTE extends ISA_IType
{
	public ISA_STOREBYTE(String line)
	{
		super(line);
		parseFull();
		parseReg();
	}
	
	@Override
	public void parseReg()
	{
		String[] parsed = REGS.split(",");
		
		RT = checkReg(parsed[0]);
		IMMEDIATE = checkShift(parsed[1]);
		RS = checkReg(parsed[1]);
	}

	@Override
	public void perform(Internal internal)
	{
		if(OPCODE.equalsIgnoreCase("sb"))
			internal.setMemoryVal(internal.getRegisterVal(RS), IMMEDIATE, internal.getRegisterVal(RT) & 0xFF);
			//internal.setToMem(internal.getFrom(RS), IMMEDIATE, internal.getFrom(RT) & 0xFF);
	}
}
