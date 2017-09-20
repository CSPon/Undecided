package cs.opcode;

import cs.architecture.AArchitecture;
import cs.instruction.ISA_INSTRUCTION;

public abstract class ISA_RType extends ISA_INSTRUCTION
{
	public ISA_RType(String expression)
	{
		super(expression);
	}

	@Override
	public void assign()
	{
		// Parses common R-Type Instruction
		// opcode rd,rs,rt
		// Override this method to change assign method
		String regs = getExpression().split(" ")[1];
		
		setOpcode(getExpression().split(" ")[0]);
		
		setRegister_rd(regs.split(",")[0]);
		setRegister_rs(regs.split(",")[1]);
		setRegister_rt(regs.split(",")[2]);
	}

	@Override
	public String toString(AArchitecture arc)
	{
		int HEX = 0x00;
		
		HEX |= getHex_opcode();
		
		HEX = HEX << 6;
		HEX |= arc.registers().getFrom(getRegister_rs());
		
		HEX = HEX << 5;
		HEX |= arc.registers().getFrom(getRegister_rt());
		
		HEX = HEX << 5;
		HEX |= arc.registers().getFrom(getRegister_rd());
		
		HEX = HEX << 5;
		HEX |= getShamt();
		
		HEX = HEX << 6;
		HEX |= getFunct();
		
		return String.format("0x%08X", HEX);
	}
}
