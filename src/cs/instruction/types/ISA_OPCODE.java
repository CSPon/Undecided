package cs.instruction.types;

import cs.architecture.Architecture;
import cs.architecture.Internal;

public abstract class ISA_OPCODE implements Instruction
{
	/* Common */
	protected String RS, RT, RD;
	
	/* OPCODE specific */
	protected int IMMEDIATE, SHAMT;
	
	/* PC Searching */
	protected String ADDR_SELF, ADDR_JUMP;
	protected int ADDRESS_SELF, ADDRESS_JUMP;
	
	/* For debugging */
	protected int HEX_OPCODE;
	protected int HEX_FUNCT;
	
	protected int CYCLE_COUNT;
	
	/* For parsing */
	protected String REGS;
	protected String OPCODE;
	protected String INSTRUCTION;
	
	/* Program Counter */
	protected int PC;
	
	public ISA_OPCODE(String line)
	{
		INSTRUCTION = line;
		
		RS = "$zero";
		RT = "$zero";
		RD = "$zero";
		
		IMMEDIATE = 0;
		SHAMT = 0;
		
		ADDR_SELF = "$zero";
		ADDR_JUMP = "$zero";
		
		ADDRESS_SELF = Architecture.$PC;
		ADDRESS_JUMP = Architecture.$PC;
		
		HEX_OPCODE = 0x00;
		HEX_FUNCT = 0x00;
		
		CYCLE_COUNT = 1;
		
		REGS = "REGS";
		OPCODE = "OPCODE";
		
		PC = Architecture.$PC;
	}
	
	public void setPC(Internal internal)
	{
		PC = internal.getSymbolAddress(ADDR_SELF);
	}
	
	public void parseJump(Internal internal, int PC)
	{
		if(internal.hasSymbol(ADDR_JUMP))
			ADDRESS_JUMP = internal.getSymbolAddress(ADDR_JUMP);
		else ADDRESS_JUMP = internal.getSymbolAddress(ADDR_SELF);
		
		ADDRESS_SELF = PC;
		
		if(HEX_OPCODE != 0x02 && HEX_OPCODE != 0x03)
		{
			// For branch instructions
			ADDRESS_JUMP = ADDRESS_JUMP & Architecture.$LOWER_16; // Keep LOWER 16 bits
			ADDRESS_JUMP = ADDRESS_JUMP >> 2;
			IMMEDIATE = ADDRESS_JUMP;
		}
		else if(HEX_OPCODE == 0x02 || HEX_OPCODE == 0x03)
		{
			// For regular jump instructions
			ADDRESS_JUMP = ADDRESS_JUMP & Architecture.$LOWER_26; // Keep LOWER 26 bits
			ADDRESS_JUMP = ADDRESS_JUMP >> 2;
			IMMEDIATE = ADDRESS_JUMP;
		}
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
