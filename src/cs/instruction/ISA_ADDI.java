package cs.instruction;

import cs.architecture.Internal;
import cs.instruction.types.ISA_IType;

public class ISA_ADDI extends ISA_IType
{
	public ISA_ADDI(String line)
	{
		super(line);
		parseFull();
		parseReg();
	}

	@Override
	public void parseReg()
	{
		// OPCODE has been parsed
		String[] parsed = REGS.split(",");
		RT = parsed[0];
		RS = parsed[1];
		IMMEDIATE = Integer.parseInt(parsed[2]);
		
		OFFSET_RT = checkShift(RT); RT = checkReg(RT);
		OFFSET_RS = checkShift(RS); RS = checkReg(RS);
	}

	@Override
	public void perform(Internal internal)
	{
		internal.setTo(RT, OFFSET_RT, (internal.getFrom(RT, OFFSET_RT) + IMMEDIATE));
	}

}
