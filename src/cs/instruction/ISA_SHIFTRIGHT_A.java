package cs.instruction;

import cs.architecture.Internal;
import cs.instruction.types.ISA_RType;

public class ISA_SHIFTRIGHT_A extends ISA_RType
{
	public ISA_SHIFTRIGHT_A(String line)
	{
		super(line);
		parseFull();
		parseReg();
		
		HEX_OPCODE = 0x00;
		HEX_FUNCT = 0x03;
	}
	
	@Override
	public void parseReg()
	{
		String[] parsed = REGS.split(",");
		SHAMT = 0;
		FUNCT = "0";
		
		RD = checkReg(parsed[0]);
		RT = checkReg(parsed[1]);
		SHAMT = Integer.parseInt(parsed[2]);
	}

	@Override
	public void perform(Internal internal)
	{
		// Copy bottom (32 - SHAMT) bits to separate variable
		// Shift RT to right by SHAMT
		// Mask saved bits to RT
		// Save to RD
		
		// 1001 0101 1010 1100
		// 1100 1001 0101 1010
		
		int temp = internal.getRegisterVal(RT) << (32 - SHAMT);
		int _RT = internal.getRegisterVal(RT) >> SHAMT;
		internal.setRegisterVal(RD, temp | _RT);
	}
}
