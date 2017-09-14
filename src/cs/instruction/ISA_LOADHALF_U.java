package cs.instruction;

import cs.architecture.Internal;
import cs.instruction.types.ISA_IType;

public class ISA_LOADHALF_U extends ISA_IType
{
	public ISA_LOADHALF_U(String line)
	{
		super(line);
		parseFull();
		parseReg();
		
		HEX_OPCODE = 0x25;
		HEX_FUNCT = 0x00;
	}
	
	@Override
	public void parseReg()
	{
		String[] parsed = REGS.split(",");
		
		RT = checkReg(parsed[0]);
		IMMEDIATE = checkShift(parsed[1]);
		RS = checkReg(parsed[1]);
	}

	@Override
	public void perform(Internal internal)
	{
		if(OPCODE.equalsIgnoreCase("lhu"))
			internal.setRegisterVal(RT, internal.getMemoryVal(internal.getRegisterVal(RS), IMMEDIATE) & 0xFFFF);
	}
}
