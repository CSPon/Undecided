package cs.opcode;

import cs.architecture.Architecture;
import cs.architecture.Internal;

public class ISA_JUMPREG extends ISA_RType
{
	public ISA_JUMPREG(String line)
	{
		super(line);
		parseFull();
		parseReg();
		
		HEX_OPCODE = 0x00;
		HEX_FUNCT = 0x08;
	}
	
	@Override
	public void parseReg()
	{
		String[] parsed = REGS.split(",");
		
		RS = checkReg(parsed[0]);
	}

	@Override
	public void perform(Internal internal)
	{
		// Preserve UPPER 4 bits from PC, mask with RS (After shifting RS by 2 bits left)
		int JUMP_ADDRESS = (internal.getPC() & Architecture.$UPPER_4) | (internal.getRegisterVal(RS) << 2);
		// Shouldn't be stopping on actual LABEL but to show step execution
//		JUMP_ADDRESS -= 0x04;
		internal.setPC(JUMP_ADDRESS);
	}
}
