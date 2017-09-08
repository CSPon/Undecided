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
		
		RT = checkReg(parsed[0]);
		RS = checkReg(parsed[1]);
		IMMEDIATE = Integer.parseInt(parsed[2]);
	}

	@Override
	public void perform(Internal internal)
	{
		internal.setTo(RT, internal.getFrom(RS) + IMMEDIATE);
	}

}
