package cs.opcode;

import cs.architecture.IArchitecture;
import cs.instruction.ISA_RType;
import cs.architecture.Architecture_MIPS;

public class ISA_MULTIPLY extends ISA_RType
{
	public ISA_MULTIPLY(String expression)
	{
		super(expression);
		assign();
		
		setHex_opcode(0x00);
		setFunct(0x18);
	}
	
	@Override
	public void assign()
	{
		String regs = getExpression().split(" ")[1];
		
		setOpcode(getExpression().split(" ")[0]);
		
		setRegister_rs(regs.split(",")[0]);
		setRegister_rt(regs.split(",")[1]);
	}

	@Override
	public void eval(IArchitecture arc)
	{
		int val_rs = arc.registers().getFrom(getRegister_rs());
		int val_rt = arc.registers().getFrom(getRegister_rt());
		
		arc.registers().setTo("$hi", (val_rs * val_rt) >> 16);
		arc.registers().setTo("$lo", (val_rs * val_rt) & Architecture_MIPS.$LOWER_16);
	}
}
