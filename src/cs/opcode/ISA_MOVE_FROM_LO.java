package cs.opcode;

import cs.architecture.AArchitecture;

public class ISA_MOVE_FROM_LO extends ISA_RType
{
	public ISA_MOVE_FROM_LO(String line)
	{
		super(line);
		assign();
		
		setHex_opcode(0x00);
		setFunct(0x12);
	}
	
	@Override
	public void assign()
	{
		String regs = getExpression().split(" ")[1];
		
		setOpcode(getExpression().split(" ")[0]);
		
		setRegister_rd(regs);
	}

	@Override
	public void eval(AArchitecture arc)
	{
		int val_lo = arc.registers().getFrom("$lo");
		arc.registers().setTo(getRegister_rd(), val_lo);
	}
}
