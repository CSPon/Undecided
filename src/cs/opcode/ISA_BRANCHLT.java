package cs.opcode;

import cs.architecture.AArchitecture;

public class ISA_BRANCHLT extends ISA_IType
{
	public ISA_BRANCHLT(String expression)
	{
		super(expression);
		assign();
		
		setHex_opcode(0xFF);
		setFunct(0xFF);
		
		setCycle_count(2);
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
	public void eval(AArchitecture arc)
	{
		int val_rs = arc.registers().getFrom(getRegister_rs());
		int val_rt = arc.registers().getFrom(getRegister_rt());
		int tgt_adr = getAddress_target();
		
		// TODO Create slt $at,$rs,$rt instruction, then perform
		// TODO Create bnq $at,$zero,target instruction, then perform
	}
}
