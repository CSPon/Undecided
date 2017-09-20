package cs.opcode;

import cs.architecture.Internal;

public class ISA_SHIFT_RIGHT_LOGICAL extends ISA_RType
{
	public ISA_SHIFT_RIGHT_LOGICAL(String line)
	{
		super(line);
		parseFull();
		parseReg();
		
		HEX_OPCODE = 0x00;
		HEX_FUNCT = 0x02;
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
		if(OPCODE.equalsIgnoreCase("srl"))
			internal.setRegisterVal(RD, internal.getRegisterVal(RT) >> SHAMT);
			//internal.setTo(RD, internal.getFrom(RT) >> SHAMT);
	}

}
