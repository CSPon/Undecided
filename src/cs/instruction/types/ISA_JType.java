package cs.instruction.types;

import cs.architecture.Internal;

public abstract class ISA_JType extends ISA_OPCODE
{
	protected String ADDR;
	
	public ISA_JType(String line)
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
	
	public int checkShift(String reg)
	{
		if(!reg.startsWith("$"))
		{
			int shift = Integer.parseInt(reg.substring(0, reg.indexOf("(")));
			shift /= 4;
			return shift;
		}
		return 0;
	}
	
	public String checkReg(String reg)
	{
		if(!reg.startsWith("$"))
		{
			reg = reg.substring(reg.indexOf("$"), reg.indexOf(")"));
			return reg;
		}
		return reg;
	}

	@Override
	public abstract void perform(Internal internal);
}
