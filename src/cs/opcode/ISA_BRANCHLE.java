package cs.opcode;

import cs.architecture.IArchitecture;
import cs.instruction.ISA_IType;

public class ISA_BRANCHLE extends ISA_IType
{
	public ISA_BRANCHLE(String expression)
	{
		super(expression);
		assign();
		
		setHex_opcode(0xFF);
		setFunct(0xFF);
		
		setCycle_count(3);
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
		// TODO Create beq $rs,$rt,target instruction, then perform
		// TODO Create bne $at,$zero,target instruction, then perform
	}
}
