package cs.opcode;

import cs.architecture.IArchitecture;

public class ISA_SET_LESS_THAN_I extends ISA_IType
{
	public ISA_SET_LESS_THAN_I(String line)
	{
		super(line);
		assign();
		
		setHex_opcode(0x0A);
		setFunct(0x00);
	}

	@Override
	public void eval(IArchitecture arc)
	{
		int val_rs = arc.registers().getFrom(getRegister_rs());
		int imm = getImmediate();
		
		arc.registers().setTo(getRegister_rt(), val_rs < imm ? 1 : 0);
	}
}
