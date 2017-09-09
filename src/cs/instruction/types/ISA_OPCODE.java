package cs.instruction.types;

import cs.architecture.Internal;

public abstract class ISA_OPCODE implements Instruction
{
	protected String RS, RT, RD, FUNCT, ADDR;
	protected int IMMEDIATE, SHAMT;
	
	protected String REGS;
	protected String OPCODE;
	protected String INSTRUCTION;
	
	protected ISA_OPCODE(String line)
	{
		INSTRUCTION = line;
	}
	
	public abstract void perform(Internal internal);
	
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
}
