package cs.opcode;

import cs.architecture.IArchitecture;
import cs.architecture.Architecture_MIPS;

public class ISA_JUMP_AND_LINK extends ISA_JType
{
	public ISA_JUMP_AND_LINK(String expression)
	{
		super(expression);
		assign();
		
		setHex_opcode(0x03);
		setFunct(0x00);
	}
	
	@Override
	public void assign()
	{
		String regs = getExpression().split(" ")[1];
		
		setOpcode(getExpression().split(" ")[0]);
		
		setLabel_target(regs);
	}

	@Override
	public void eval(IArchitecture arc)
	{
		int SELF_ADDR = (getAddress_self() & Architecture_MIPS.$LOWER_26) >> 2;
		int JUMP_ADDR = (arc.registers().getFrom("$pc") & Architecture_MIPS.$UPPER_4) | (getAddress_target() << 2);
		// TODO Shouldn't be stopping on label but to show step execution
		JUMP_ADDR -= 0x04;
		
		arc.registers().setTo("$ra", SELF_ADDR);
		arc.registers().setTo("$pc", JUMP_ADDR);
	}
}
