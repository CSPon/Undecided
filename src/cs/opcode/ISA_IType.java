package cs.opcode;

import cs.architecture.Internal;
import cs.instruction.types.ISA_OPCODE;

public abstract class ISA_IType extends ISA_OPCODE
{
	public ISA_IType(String line)
	{
		super(line);
	}
	
	@Override
	public void parseFull()
	{
		OPCODE = INSTRUCTION.split(" ")[0];
		REGS = INSTRUCTION.split(" ")[1];
		REGS = REGS.replaceAll(" ", "");
	}
	
	@Override
	public void parseReg()
	{
		String[] parsed = REGS.split(",");
		
		RT = checkReg(parsed[0]);
		RS = checkReg(parsed[1]);
		
		if(parsed[2].startsWith("0x"))
		{
			parsed[2] = parsed[2].replaceAll("0x", "");
			IMMEDIATE = (int) Long.parseLong(parsed[2], 16);
		}
		else
			IMMEDIATE = Integer.parseInt(parsed[2]);
	}
	
	@Override
	public String toString(Internal internal)
	{
		// Need to shift IMMEDIATE by 16 (Or mask out, whatever we want)
		int IMM = IMMEDIATE; IMM &= 0x0000FFFF;
		
		int HEX = 0x00;
		HEX |= HEX_OPCODE;
		
		HEX = HEX << 5;
		HEX |= internal.getRegisterAddr(RS);
		
		HEX = HEX << 5;
		HEX |= internal.getRegisterAddr(RT);
		
		HEX = HEX << 16;
		HEX |= IMM;
		
		return String.format("0x%08X", HEX);
	}

	@Override
	public abstract void perform(Internal internal);
}
