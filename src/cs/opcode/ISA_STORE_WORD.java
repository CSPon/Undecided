package cs.opcode;

import cs.architecture.IArchitecture;

public class ISA_STORE_WORD extends ISA_IType
{
	public ISA_STORE_WORD(String line)
	{
		super(line);
		assign();
		
		setHex_opcode(0x2B);
		setFunct(0x00);
	}
	
	@Override
	public void assign()
	{
		String regs = getExpression().split(" ")[1];
		
		setOpcode(getExpression().split(" ")[0]);
		
		setRegister_rt(regs.split(",")[0]);
		setImmediate(checkShift(regs.split(",")[1]));
		setRegister_rs(checkReg(regs.split(",")[1]));
	}

	@Override
	public void eval(IArchitecture arc)
	{
		int val_rt = arc.registers().getFrom(getRegister_rt());
		int val_rs = arc.registers().getFrom(getRegister_rs());
		int offset = getImmediate();
		
		arc.memory().writeMemory(val_rs, offset, val_rt);
	}
}
