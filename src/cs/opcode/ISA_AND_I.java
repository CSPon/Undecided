package cs.opcode;

import cs.architecture.IArchitecture;
import cs.instruction.ISA_IType;

public class ISA_AND_I extends ISA_IType
{
	public ISA_AND_I(String line)
	{
		super(line);
		assign();
		
		setHex_opcode(0x0C);
		setFunct(0);
	}

	@Override
	public void eval(IArchitecture arc)
	{
		int imm = getImmediate();
		int val_rs = arc.registers().getFrom(getRegister_rs());
		
		arc.registers().setTo(getRegister_rt(), val_rs & imm);
	}
}
