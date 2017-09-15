package cs.instruction;

import cs.architecture.Internal;
import cs.instruction.types.ISA_OPCODE;

@Deprecated
public class ISA_BRANCHGT extends ISA_OPCODE
{
	public ISA_BRANCHGT(String line)
	{
		super(line);
		parseFull();
		parseReg();
		
		CYCLE_COUNT = 2;
		
		// TODO Modify BGT
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
		if(internal.getRegisterVal(RS) > internal.getRegisterVal(RT))
		{
			int UPPER = internal.getPC() >> 28;
			int JUMP_ADDRESS = (UPPER << 28) | (ADDRESS_JUMP << 2);
			// Shouldn't be stopping on actual LABEL but to show step execution
			JUMP_ADDRESS -= 0x04;
			internal.setPC(JUMP_ADDRESS);
		}
	}

	@Override
	public String toString(Internal internal)
	{
		return "PSEUDOINST";
	}
}
