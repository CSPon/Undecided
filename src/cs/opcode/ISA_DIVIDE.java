package cs.opcode;

import cs.architecture.Internal;

public class ISA_DIVIDE extends ISA_RType
{
	public ISA_DIVIDE(String line)
	{
		super(line);
		parseFull();
		parseReg();
		
		HEX_OPCODE = 0x00;
		HEX_FUNCT = 0x1A;
	}
	
	@Override
	public void parseReg()
	{
		String[] parsed = REGS.split(",");
		
		RS = checkReg(parsed[0]);
		RT = checkReg(parsed[1]);
	}

	@Override
	public void perform(Internal internal)
	{
		if(OPCODE.equalsIgnoreCase("div"))
		{
			internal.setRegisterVal("$LO", internal.getRegisterVal(RS) / internal.getRegisterVal(RT));
			internal.setRegisterVal("$HI", internal.getRegisterVal(RS) % internal.getRegisterVal(RT));
		}
		else if(OPCODE.equalsIgnoreCase("divu"))
		{
			internal.setRegisterVal("$LO", internal.getRegisterVal(RS) / internal.getRegisterVal(RT));
			internal.setRegisterVal("$HI", internal.getRegisterVal(RS) % internal.getRegisterVal(RT));
		}
	}
}
