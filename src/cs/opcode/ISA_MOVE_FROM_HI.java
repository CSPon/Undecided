package cs.opcode;

import cs.architecture.IArchitecture;

public class ISA_MOVE_FROM_HI extends ISA_RType
{
	public ISA_MOVE_FROM_HI(String line)
	{
		super(line);
		assign();
		
		setHex_opcode(0x00);
		setFunct(0x10);
	}
	
	@Override
	public void assign()
	{
		String regs = getExpression().split(" ")[1];
		
		setOpcode(getExpression().split(" ")[0]);
		
		setRegister_rd(regs);
	}

	@Override
	public void eval(IArchitecture arc)
	{
		int val_hi = arc.registers().getFrom("$hi");
		arc.registers().setTo(getRegister_rd(), val_hi);
	}
}
