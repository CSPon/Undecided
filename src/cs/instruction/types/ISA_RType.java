package cs.instruction.types;

import cs.architecture.Internal;

public abstract class ISA_RType extends ISA_OPCODE
{
	public ISA_RType(String line)
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
		SHAMT = 0;
		FUNCT = "0";
		
		RD = checkReg(parsed[0]);
		RS = checkReg(parsed[1]);
		RT = checkReg(parsed[2]);
	}

	@Override
	public abstract void perform(Internal internal);
}
