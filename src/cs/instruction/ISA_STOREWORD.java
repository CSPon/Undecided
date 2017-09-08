package cs.instruction;

import cs.architecture.Internal;
import cs.instruction.types.ISA_IType;

public class ISA_STOREWORD extends ISA_IType
{
	public ISA_STOREWORD(String line)
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
		internal.setToMem(internal.getFrom(RS), IMMEDIATE, internal.getFrom(RT));
	}
}
