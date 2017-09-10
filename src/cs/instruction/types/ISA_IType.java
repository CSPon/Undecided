package cs.instruction.types;

import cs.architecture.Internal;

public abstract class ISA_IType extends ISA_OPCODE
{
	public ISA_IType(String line)
	{
		super(line);
		IMMEDIATE = 0;
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
		
		RT = checkReg(parsed[0]);
		RS = checkReg(parsed[1]);
		IMMEDIATE = Integer.parseInt(parsed[2]);
	}

	@Override
	public abstract void perform(Internal internal);
}
