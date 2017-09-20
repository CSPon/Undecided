package cs.opcode;

import cs.architecture.AArchitecture;
import cs.instruction.ISA_INSTRUCTION;

public abstract class ISA_JType extends ISA_INSTRUCTION
{	
	public ISA_JType(String line)
	{
		super(line);
	}

	@Override
	public void assign()
	{
		// Parses common J-Type
		// opcode address
		// Override assign method to create class-spesific method
		setOpcode(getExpression().split(" ")[0]);
		setLabel_target(getExpression().split(" ")[1]);
	}

	@Override
	public String toString(AArchitecture arc)
	{
		int HEX = 0x00;
		HEX |= getHex_opcode(); HEX = HEX << 26;
		HEX |= getAddress_target();
		
		return String.format("0x%08X", HEX);
	}
}
