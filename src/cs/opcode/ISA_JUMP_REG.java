package cs.opcode;

import cs.architecture.AArchitecture;
import cs.architecture.Architecture_MIPS;

public class ISA_JUMP_REG extends ISA_RType
{
	public ISA_JUMP_REG(String expression)
	{
		super(expression);
		assign();
		
		setHex_opcode(0x00);
		setFunct(0x08);
	}
	
	@Override
	public void assign()
	{
		String regs = getExpression().split(" ")[1];
		
		setOpcode(getExpression().split(" ")[0]);
		
		setRegister_rs(regs);
	}

	@Override
	public void eval(AArchitecture arc)
	{
		int JUMP_ADDR = (arc.registers().getFrom("$pc") & Architecture_MIPS.$UPPER_4) | (arc.registers().getFrom(getRegister_rs()) << 2);
		// TODO Shouldn't be stopping on label but to show step execution
		JUMP_ADDR -= 0x04;
		arc.registers().setTo("$pc", JUMP_ADDR);
	}
}
