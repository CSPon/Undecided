package cs.opcode;

import cs.architecture.IArchitecture;

public class ISA_DIVIDE extends ISA_RType
{
	public ISA_DIVIDE(String line)
	{
		super(line);
		assign();
		
		setHex_opcode(0x00);
		setFunct(0x1A);
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
		
		arc.registers().setTo("$lo", val_rs / val_rt);
		arc.registers().setTo("$hi", val_rs % val_rt);
	}
}
