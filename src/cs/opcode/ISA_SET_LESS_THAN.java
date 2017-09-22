package cs.opcode;

import cs.architecture.IArchitecture;
import cs.instruction.ISA_RType;

public class ISA_SET_LESS_THAN extends ISA_RType
{
	public ISA_SET_LESS_THAN(String line)
	{
		super(line);
		assign();
		
		setHex_opcode(0x00);
		setFunct(0x2A);
	}

	@Override
	public void eval(IArchitecture arc)
	{
		int val_rs = arc.registers().getFrom(getRegister_rs());
		int val_rt = arc.registers().getFrom(getRegister_rt());
		
		arc.registers().setTo(getRegister_rd(), val_rs < val_rt ? 1 : 0);
	}
}
