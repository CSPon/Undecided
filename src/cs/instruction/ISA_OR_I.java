package cs.instruction;

import cs.architecture.Internal;
import cs.instruction.types.ISA_IType;

public class ISA_OR_I extends ISA_IType
{
	public ISA_OR_I(String line)
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
		RS = checkReg(parsed[1]);
		IMMEDIATE = Integer.parseInt(parsed[2]);
	}

	@Override
	public void perform(Internal internal)
	{
		if(OPCODE.equalsIgnoreCase("ori"))
			internal.setTo(RD, internal.getFrom(RS) | internal.getFrom(RT));
	}
}
