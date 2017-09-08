package cs.instruction;

import cs.architecture.Internal;
import cs.instruction.types.ISA_RType;

public class ISA_ADD extends ISA_RType
{	
	public ISA_ADD(String line)
	{
		super(line);
		parseFull();
		parseReg();
	}
	
	@Override
	public void parseReg()
	{
		String[] parsed = REGS.split(",");
		RD = parsed[0];
		RS = parsed[1];
		RT = parsed[2];
		SHAMT = "0";
		FUNCT = "0";
		
		RD = checkReg(parsed[0]);
		RS = checkReg(parsed[1]);
		RT = checkReg(parsed[2]);
	}
	
	@Override
	public void perform(Internal internal)
	{
		internal.setTo(RD, internal.getFrom(RS) + internal.getFrom(RT));
	}
}
