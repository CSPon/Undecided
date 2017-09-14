package cs.instruction;

import cs.architecture.Internal;
import cs.instruction.types.ISA_IType;

public class ISA_LOADUPPER_I extends ISA_IType
{
	public ISA_LOADUPPER_I(String line)
	{
		super(line);
		parseFull();
		parseReg();
		
		HEX_OPCODE = 0x0F;
		HEX_FUNCT = 0x00;
	}
	
	@Override
	public void parseReg()
	{
		String[] parsed = REGS.split(",");
		
		RT = checkReg(parsed[0]);
		if(parsed[1].startsWith("0x"))
		{
			parsed[1] = parsed[1].replaceAll("0x", "");
			IMMEDIATE = (int) Long.parseLong(parsed[1], 16);
		}
		else
			IMMEDIATE = Integer.parseInt(parsed[1]);
	}

	@Override
	public void perform(Internal internal)
	{
		internal.setRegisterVal(RT, IMMEDIATE << 16);
	}
}
