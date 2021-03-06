package cs.opcode;

import cs.architecture.IArchitecture;
import cs.instruction.ISA_IType;

public class ISA_ADD_I extends ISA_IType
{
	public ISA_ADD_I(String expression)
	{
		super(expression);
		assign();
		
		setHex_opcode(0x08);
		setFunct(0x00);
	}

	@Override
	public void eval(IArchitecture arc)
	{
		int val_rs = arc.registers().getFrom(getRegister_rs());
		int imm = getImmediate();
		
		arc.registers().setTo(getRegister_rt(), val_rs + imm);
	}
}
