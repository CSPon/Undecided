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
		
		OFFSET_RD = checkShift(RD); RD = checkReg(RD);
		OFFSET_RS = checkShift(RS); RS = checkReg(RS);
		OFFSET_RT = checkShift(RT); RT = checkReg(RT);
	}
	
	@Override
	public void perform(Internal internal)
	{
		internal.setTo(RD, OFFSET_RD, (int) (internal.getFrom(RS, OFFSET_RS) + internal.getFrom(RT, OFFSET_RT)));
	}
}
