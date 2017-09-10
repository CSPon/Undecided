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
		IMMEDIATE = Integer.parseInt(parsed[1]);
	}

	@Override
	public void perform(Internal internal)
	{
		if(OPCODE.equalsIgnoreCase("li"))
			internal.setTo(RD, IMMEDIATE);
	}
}