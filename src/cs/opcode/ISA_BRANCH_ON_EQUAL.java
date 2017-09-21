package cs.opcode;

import cs.architecture.IArchitecture;

public class ISA_BRANCH_ON_EQUAL extends ISA_IType
{
	public ISA_BRANCH_ON_EQUAL(String expression)
	{
		super(expression);
		assign();
		
		setHex_opcode(0x04);
		setFunct(0);
	}
	
	@Override
	public void assign()
	{
		String regs = getExpression().split(" ")[1];
		
		setOpcode(getExpression().split(" ")[0]);
		
		setRegister_rs(regs.split(",")[0]);
		setRegister_rt(regs.split(",")[1]);
		setLabel_target(regs.split(",")[2]);
	}

	@Override
	public void eval(IArchitecture arc)
	{
		int val_rs = arc.registers().getFrom(getRegister_rs());
		int val_rt = arc.registers().getFrom(getRegister_rt());
		int tgt_adr = getAddress_target();
		
		if(val_rs == val_rt)
		{
			int upper = arc.registers().getFrom("$pc") & 0xFFFF0000;
			int jump = upper | (tgt_adr << 2);
			jump -= 0x04;
			arc.registers().setTo("$pc", jump);
		}
	}
}
