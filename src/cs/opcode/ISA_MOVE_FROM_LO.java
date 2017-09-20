package cs.opcode;

import cs.architecture.Internal;

public class ISA_MOVE_FROM_LO extends ISA_RType
{
	public ISA_MOVE_FROM_LO(String line)
	{
		super(line);
		parseFull();
		parseReg();
		
		HEX_OPCODE = 0x00;
		HEX_FUNCT = 0x12;
	}
	
	@Override
	public void parseReg()
	{
		String[] parsed = REGS.split(",");
		
		RD = checkReg(parsed[0]);
	}

	@Override
	public void perform(Internal internal)
	{
		internal.setTo(RD, internal.getFrom("$lo"));
	}
}
