package cs.instruction;

import cs.architecture.Internal;
import cs.instruction.types.ISA_OPCODE;

public class ISA_BRANCHGT extends ISA_OPCODE
{
	public ISA_BRANCHGT(String line)
	{
		super(line);
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
		
		RS = parsed[0];
		RT = parsed[1];
		ADDR = parsed[2];
	}

	@Override
	public void perform(Internal internal)
	{
		if(internal.getFrom(RS) > internal.getFrom(RT))
			internal.setPC(TARGET_ADDR);
	}
}