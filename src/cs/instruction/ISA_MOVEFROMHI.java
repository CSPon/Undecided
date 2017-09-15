package cs.instruction;

import cs.architecture.Internal;
import cs.instruction.types.ISA_RType;

public class ISA_MOVEFROMHI extends ISA_RType
{
	public ISA_MOVEFROMHI(String line)
	{
		super(line);
		parseFull();
		parseReg();
		
		HEX_OPCODE = 0x00;
		HEX_FUNCT = 0x10;
	}
	
	@Override
	public void parseReg()
	{
		String[] parsed = REGS.split(",");
		
		RD = checkReg(parsed[0]);
	}

	@Override
	public void perform(Internal internal)
	{
		internal.setTo(RD, internal.getFrom("$hi"));
	}
}
