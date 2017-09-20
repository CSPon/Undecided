package cs.opcode;

import cs.architecture.Internal;
import cs.instruction.types.ISA_OPCODE;

public abstract class ISA_JType extends ISA_OPCODE
{	
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
	
	@Override
	public void parseReg()
	{
	}
	
	public String toString(Internal internal)
	{
		int HEX = 0x00;
		HEX |= HEX_OPCODE; HEX = HEX << 26;
		HEX |= ADDRESS_JUMP;
		
		return String.format("0x%08X", HEX);
	}

	@Override
	public abstract void perform(Internal internal);
}
