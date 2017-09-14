package cs.instruction;

import cs.architecture.Internal;
import cs.instruction.types.ISA_IType;

public class ISA_BRANCHEQ extends ISA_IType
{
	public ISA_BRANCHEQ(String line)
	{
		super(line);
		parseFull();
		parseReg();
		
		HEX_OPCODE = 0x04;
		HEX_FUNCT = 0x00;
	}
	
	@Override
	public void parseReg()
	{
		String[] parsed = REGS.split(",");
		
		RS = checkReg(parsed[0]);
		RT = checkReg(parsed[1]);
		ADDR_JUMP = parsed[2];
	}

	@Override
	public void perform(Internal internal)
	{
		if(internal.getRegisterVal(RS) == internal.getRegisterVal(RT))
			internal.setPC(ADDRESS_JUMP);
	}
}
