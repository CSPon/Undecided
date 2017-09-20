package cs.opcode;

import cs.architecture.Architecture;
import cs.architecture.Internal;

public class ISA_JUMPANDLINK extends ISA_JType
{
	public ISA_JUMPANDLINK(String line)
	{
		super(line);
		parseFull();
		
		HEX_OPCODE = 0x03;
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
		// $ra will have 26-bit address so be sure to shift before jumping from jr!
		int SELF_ADDRESS = (ADDRESS_SELF & Architecture.$LOWER_26) >> 2;
		internal.setRegisterVal("$ra", SELF_ADDRESS);
		
		int JUMP_ADDRESS = (internal.getPC() & Architecture.$UPPER_4) | (IMMEDIATE << 2);
		// Shouldn't be stopping on actual LABEL but to show step execution
		JUMP_ADDRESS -= 0x04;
		internal.setPC(JUMP_ADDRESS);
	}
}
