package cs.instruction;

import cs.architecture.Architecture;
import cs.architecture.Internal;
import cs.instruction.types.ISA_JType;

public class ISA_JUMP extends ISA_JType
{
	public ISA_JUMP(String line)
	{
		super(line);
		parseFull();
		
		HEX_OPCODE = 0x02;
		HEX_FUNCT = 0x00;
	}

	@Override
	public void parseFull()
	{
		String[] parsed = INSTRUCTION.split(" ");
		OPCODE = parsed[0];
		ADDR_JUMP = parsed[1];
		REGS = parsed[1];
	}

	@Override
	public void perform(Internal internal)
	{
		int JUMP_ADDRESS = (internal.getPC() & Architecture.$UPPER_4) | (IMMEDIATE << 2);
		// Shouldn't be stopping on actual LABEL but to show step execution
		JUMP_ADDRESS -= 0x04;
		internal.setPC(JUMP_ADDRESS);
	}
}
