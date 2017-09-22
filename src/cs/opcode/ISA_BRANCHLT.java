package cs.opcode;

import cs.architecture.IArchitecture;
import cs.instruction.ISA_IType;

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
	public void eval(IArchitecture arc)
	{
		int val_rs = arc.registers().getFrom(getRegister_rs());
		int val_rt = arc.registers().getFrom(getRegister_rt());
		int tgt_adr = getAddress_target();
		
		// TODO Create slt $at,$rs,$rt instruction, then perform
		String slt_is = "slt $at," + getRegister_rs() + "," + getRegister_rt();
		new ISA_SET_LESS_THAN(slt_is).eval(arc);
		
		// TODO Create bnq $at,$zero,target instruction, then perform
		String bnq_is = "bnq $at,$zero," + getLabel_target();
		new ISA_BRANCH_ON_NOT_EQUAL(bnq_is);
	}
}
