package cs.instruction;

import cs.architecture.Internal;
import cs.instruction.types.ISA_RType;

public class ISA_SUB extends ISA_RType
{
	public ISA_SUB(String line)
	{
		super(line);
		parseFull();
		parseReg();
		HEX_OPCODE = 0x00;
		HEX_FUNCT = 0x22;
	}

	@Override
	public void perform(Internal internal)
	{
		if(OPCODE.equalsIgnoreCase("sub"))
			internal.setRegisterVal(RD, internal.getRegisterVal(RS) - internal.getRegisterVal(RT));
		else if(OPCODE.equalsIgnoreCase("subu"))
			internal.setRegisterVal(RD, internal.getRegisterVal(RS) - internal.getRegisterVal(RT));
	}
	
	public String toString(Internal internal)
	{
		int HEX = 0x00;
		HEX |= HEX_OPCODE; HEX = HEX << 6;
		HEX |= internal.getRegisterAddr(RS); HEX = HEX << 5;
		HEX |= internal.getRegisterAddr(RT); HEX = HEX << 5;
		HEX |= internal.getRegisterAddr(RD); HEX = HEX << 5;
		HEX |= SHAMT; HEX = HEX << 5;
		HEX |= HEX_FUNCT;
		
		return String.format("0x%08X", HEX);
	}
}
