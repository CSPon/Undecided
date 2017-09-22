package cs.opcode;

import cs.architecture.IArchitecture;
import cs.instruction.ISA_JType;
import cs.architecture.Architecture_MIPS;

public class ISA_JUMP extends ISA_JType
{
	public ISA_JUMP(String expression)
	{
		super(expression);
		assign();
		
		setHex_opcode(0x02);
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
		int JUMP_ADDR = (arc.registers().getFrom("$pc") & Architecture_MIPS.$UPPER_4) | (getAddress_target() << 2);
		// TODO Shouldn't be stopping on label but to show step execution
		JUMP_ADDR -= 0x04;
		arc.registers().setTo("$pc", JUMP_ADDR);
	}
}
