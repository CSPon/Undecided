package cs.opcode;

import cs.architecture.AArchitecture;

public class ISA_ADD extends ISA_RType
{	
	public ISA_ADD(String expression)
	{
		super(expression);
		assign();
		
		setHex_opcode(0x00);
		setFunct(0x20);
	}
	
	@Override
	public void eval(AArchitecture arc)
	{
		int val_rs = arc.registers().getFrom(getRegister_rs());
		int val_rt = arc.registers().getFrom(getRegister_rt());
		arc.registers().setTo(getRegister_rd(), val_rs + val_rt);
	}
}
