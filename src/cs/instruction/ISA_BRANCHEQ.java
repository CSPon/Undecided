package cs.instruction;

import cs.architecture.Internal;
import cs.instruction.types.ISA_IType;

public class ISA_BRANCHEQ extends ISA_IType
{
	public ISA_BRANCHEQ(String line)
	{
		super(line);
		parseFull();
		parseReg();
	}
	
	@Override
	public void parseReg()
	{
		String[] parsed = REGS.split(",");
		
		RS = checkReg(parsed[0]);
		RT = checkReg(parsed[1]);
		ADDR = parsed[2];
	}

	@Override
	public void perform(Internal internal)
	{
		if(internal.getFrom(RS) == internal.getFrom(RT))
			internal.setPC(TARGET_ADDR);
	}
}