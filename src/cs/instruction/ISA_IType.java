package cs.instruction;

import cs.architecture.IArchitecture;

public abstract class ISA_IType extends ISA_INSTRUCTION
{
	public ISA_IType(String expression)
	{
		super(expression);
		assign();
	}

	@Override
	public void assign()
	{
		// Parses common I-Type Instruction
		// opcode rt,rs,immediate
		// Override this method to change assign method
		String regs = getExpression().split(" ")[1];
		
		setOpcode(getExpression().split(" ")[0]);
		setLabel_self(getExpression().split(" ")[0]);
		
		setRegister_rt(regs.split(",")[0]);
		setRegister_rs(regs.split(",")[1]);
		setImmediate(Integer.parseInt(regs.split(",")[2]));
	}

	@Override
	public String toString(IArchitecture arc)
	{
		// Need to shift IMMEDIATE by 16 (Or mask out, whatever we want)
		int IMM = getImmediate();
		IMM &= 0x0000FFFF;
		
		int HEX = 0x00;
		HEX |= getHex_opcode();
		
		HEX = HEX << 5;
		HEX |= arc.registers().getFrom(getRegister_rs());
		
		HEX = HEX << 5;
		HEX |= arc.registers().getFrom(getRegister_rt());
		
		HEX = HEX << 16;
		HEX |= IMM;
		
		return String.format("0x%08X", HEX);
	}
}
