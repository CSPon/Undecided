package cs.instruction;

import cs.architecture.Internal;
import cs.instruction.types.ISA_IType;

public class ISA_ADD_I extends ISA_IType
{
	public ISA_ADD_I(String line)
	{
		super(line);
		parseFull();
		parseReg();
	}
	
	@Override
	public void parseReg()
	{
		String[] parsed = REGS.split(",");
		
		RT = checkReg(parsed[0]);
		RS = checkReg(parsed[1]);
		IMMEDIATE = Integer.parseInt(parsed[2]);
	}

	@Override
	public void perform(Internal internal)
	{
		if(OPCODE.equalsIgnoreCase("addi"))
			internal.setTo(RT, internal.getFrom(RS) + IMMEDIATE);
		else if(OPCODE.equalsIgnoreCase("addiu"))
			internal.setTo(RT, internal.getFrom(RS) + IMMEDIATE); 
	}

}
