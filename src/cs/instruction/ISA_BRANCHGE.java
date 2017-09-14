package cs.instruction;

import cs.architecture.Internal;
import cs.instruction.types.ISA_OPCODE;

public class ISA_BRANCHGE extends ISA_OPCODE
{
	public ISA_BRANCHGE(String line)
	{
		super(line);
		parseFull();
		parseReg();
		
		// TODO Modify BGE
		CYCLE_COUNT = 2;
		
		HEX_OPCODE = 0x00;
		HEX_FUNCT = 0x22;
	}
	
	@Override
	public void parseFull()
	{
		OPCODE = INSTRUCTION.split(" ")[0];
		REGS = INSTRUCTION.substring(INSTRUCTION.indexOf(" ") + 1);
		REGS = REGS.replaceAll(" ", "");
	}

	@Override
	public void parseReg()
	{
		String[] parsed = REGS.split(",");
		
		RS = parsed[0];
		RT = parsed[1];
		ADDR_JUMP = parsed[2];
	}

	@Override
	public void perform(Internal internal)
	{
		if(internal.getRegisterVal(RS) <= internal.getRegisterVal(RT))
			internal.setPC(ADDRESS_JUMP);
	}

	@Override
	public String toString(Internal internal)
	{
		return "PSEUDOINST";
	}
}
