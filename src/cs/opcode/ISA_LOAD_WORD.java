package cs.opcode;

import cs.architecture.IArchitecture;

public class ISA_LOAD_WORD extends ISA_IType
{
	public ISA_LOAD_WORD(String expression)
	{
		super(expression);
		assign();
		
		setHex_opcode(0x23);
		setFunct(0x00);
	}
	
	@Override
	public void assign()
	{
		String regs = getExpression().split(" ")[1];
		
		setOpcode(getExpression().split(" " )[0]);
		
		setRegister_rt(regs.split(",")[0]);
		
		setImmediate(checkShift(regs.split(",")[1]));
		setRegister_rs(checkReg(regs.split(",")[1]));
	}

	@Override
	public void eval(IArchitecture arc)
	{
		int val_rs = arc.registers().getFrom(getRegister_rs());
		int offset = getImmediate();
		
		arc.registers().setTo(getRegister_rt(), arc.memory().readMemory(val_rs, offset));
	}
}
