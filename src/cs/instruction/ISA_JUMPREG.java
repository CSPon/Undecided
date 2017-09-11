package cs.instruction;

import cs.architecture.Internal;
import cs.instruction.types.ISA_RType;

public class ISA_JUMPREG extends ISA_RType
{
	public ISA_JUMPREG(String line)
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
		
		RS = checkReg(parsed[0]);
	}

	@Override
	public void perform(Internal internal)
	{
		internal.setPC(internal.getFrom(RS));
	}
}
