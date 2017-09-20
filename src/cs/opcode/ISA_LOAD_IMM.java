package cs.opcode;

import cs.architecture.Internal;
import cs.instruction.ISA_OPCODE;

@Deprecated
public class ISA_LOAD_IMM extends ISA_IType
{
	public ISA_LOAD_IMM(String line)
	{
		super(line);
		parseFull();
		parseReg();
		
		CYCLE_COUNT = 1;
		
		HEX_OPCODE = 0xFF;
		HEX_FUNCT = 0xFF;
	}
	
	@Override
	public void parseFull()
	{
		OPCODE = INSTRUCTION.split(" ")[0];
		REGS = INSTRUCTION.substring(INSTRUCTION.indexOf(" ") + 1);
		REGS = REGS.replaceAll(" ", "");
	}
	
	@Override
	public void parseReg()
	{
		String[] parsed = REGS.split(",");
		
		RD = checkReg(parsed[0]);
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
		if(OPCODE.equalsIgnoreCase("li"))
			internal.setRegisterVal(RD, IMMEDIATE);
	}

	@Override
	public String toString(Internal internal)
	{
		return "PSEUDOINST";
	}
}
