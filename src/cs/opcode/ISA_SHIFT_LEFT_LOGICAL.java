package cs.opcode;

import cs.architecture.Internal;

public class ISA_SHIFT_LEFT_LOGICAL extends ISA_RType
{
	public ISA_SHIFT_LEFT_LOGICAL(String line)
	{
		super(line);
		parseFull();
		parseReg();
		
		HEX_OPCODE = 0x00;
		HEX_FUNCT = 0x00;
	}
	
	@Override
	public void parseReg()
	{
		String[] parsed = REGS.split(",");
		
		RD = checkReg(parsed[0]);
		RT = checkReg(parsed[1]);
		SHAMT = Integer.parseInt(parsed[2]);
	}

	@Override
	public void perform(Internal internal)
	{
		if(OPCODE.equalsIgnoreCase("sll"))
			internal.setRegisterVal(RD, internal.getRegisterVal(RT) << SHAMT);
	}

}
