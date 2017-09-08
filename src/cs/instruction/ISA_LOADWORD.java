package cs.instruction;

import cs.architecture.Internal;
import cs.instruction.types.ISA_IType;

public class ISA_LOADWORD extends ISA_IType
{
	public ISA_LOADWORD(String line)
	{
		super(line);
		parseFull();
		parseReg();
	}

	@Override
	public void parseReg()
	{
		String[] parsed = REGS.split(",");
		RT = parsed[0];
		RS = parsed[1];
		
		OFFSET_RT = checkShift(RT); RT = checkReg(RT);
		OFFSET_RS = checkShift(RS); RS = checkReg(RS);
	}

	@Override
	public void perform(Internal internal)
	{
		internal.setTo(RT, OFFSET_RT, internal.getFrom(RS, OFFSET_RS));
	}
}
