package cs.instruction;

import cs.architecture.Internal;
import cs.instruction.types.ISA_OPCODE;

public class ISA_MOVE extends ISA_OPCODE
{
	public ISA_MOVE(String line)
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
		RS = checkReg(parsed[1]);
	}

	@Override
	public void perform(Internal internal)
	{
		if(OPCODE.equalsIgnoreCase("move"))
			internal.setTo(RD, internal.getFrom(RS));
	}
}
