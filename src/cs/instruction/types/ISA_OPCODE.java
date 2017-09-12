package cs.instruction.types;

import cs.architecture.Internal;
import cs.routine.Routine;

public abstract class ISA_OPCODE implements Instruction
{
	protected String RS, RT, RD, FUNCT, ADDR;
	protected int IMMEDIATE, SHAMT, ADDRESS, TARGET_ADDR;
	protected int SELF_ADDR;
	
	protected int HEX_OPCODE;
	protected int HEX_FUNCT;
	
	protected int CYCLE_COUNT;
	
	protected String REGS;
	protected String OPCODE;
	protected String INSTRUCTION;
	
	public ISA_OPCODE(String line)
	{
		INSTRUCTION = line;
		RS = "";
		RT = "";
		RD = "";
		FUNCT = "";
		ADDR = "";
		
		CYCLE_COUNT = 1;
	}
	
	public abstract void perform(Internal internal);
	
	public int getCYCLE()
	{
		return CYCLE_COUNT;
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
	
	public String getADDR()
	{
		return ADDR;
	}
	
	public void parseJump(Routine routine, int currentPos)
	{
		TARGET_ADDR = routine.getLabelAddr(ADDR, currentPos);
		SELF_ADDR = currentPos;
	}

	public String getOPCODE()
	{
		return OPCODE;
	}
	
	public String getREGS()
	{
		return REGS;
	}
}
