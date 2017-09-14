package cs.instruction.types;

import cs.architecture.Internal;
import cs.routine.Routine;

public abstract class ISA_OPCODE implements Instruction
{
	/* Common */
	protected String RS, RT, RD;
	
	/* OPCODE specific */
	protected String FUNCT;
	protected int IMMEDIATE, SHAMT;
	
	/* PC Searching */
	protected String ADDR_SELF, ADDR_JUMP;
	protected int ADDRESS_SELF, ADDRESS_JUMP;
	
	/* For debugging */
	protected int HEX_OPCODE;
	protected int HEX_FUNCT;
	
	protected int CYCLE_COUNT;
	
	protected String REGS;
	protected String OPCODE;
	protected String INSTRUCTION;
	
	protected int PC;
	
	public ISA_OPCODE(String line)
	{
		INSTRUCTION = line;
		RS = "";
		RT = "";
		RD = "";
		FUNCT = "";
		ADDR_SELF = "";
		
		CYCLE_COUNT = 1;
		
		IMMEDIATE = 0;
		SHAMT = 0;
	}
	
	public void setPC(int _PC)
	{
		PC = _PC;
	}
	
	public int getPC()
	{
		return PC;
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
	
	public void parseJump(Routine routine, int currentPos)
	{
		ADDRESS_JUMP = routine.getLabelAddr(ADDR_JUMP, currentPos);
		ADDRESS_SELF = currentPos;
		
		IMMEDIATE = ADDRESS_JUMP;
	}
	
	public String getADDR_SELF()
	{
		return ADDR_SELF;
	}
	
	public String getADDR_JUMP()
	{
		return ADDR_JUMP;
	}
	
	public int getADDRESS_SELF()
	{
		return ADDRESS_SELF;
	}
	
	public int getADDRESS_JUMP()
	{
		return ADDRESS_JUMP;
	}

	public String getOPCODE()
	{
		return OPCODE;
	}
	
	public String getREGS()
	{
		return REGS;
	}
	
	public abstract String toString(Internal internal);
}
