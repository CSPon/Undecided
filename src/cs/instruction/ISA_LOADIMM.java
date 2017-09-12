package cs.instruction;

import cs.architecture.Internal;
import cs.instruction.types.ISA_OPCODE;

public class ISA_LOADIMM extends ISA_OPCODE
{
	public ISA_LOADIMM(String line)
	{
		super(line);
		parseFull();
		parseReg();
		
		CYCLE_COUNT = 2;
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
			internal.setTo(RD, IMMEDIATE);
	}
}
