package cs.opcode;

import cs.architecture.IArchitecture;

public class ISA_SUB extends ISA_RType
{
	public ISA_SUB(String line)
	{
		super(line);
		assign();
		
		setHex_opcode(0x00);
		setFunct(0x22);
	}

	@Override
	public void eval(IArchitecture arc)
	{
		int val_rs = arc.registers().getFrom(getRegister_rs());
		int val_rt = arc.registers().getFrom(getRegister_rt());
		
		arc.registers().setTo(getRegister_rd(), val_rs - val_rt);
	}
}
