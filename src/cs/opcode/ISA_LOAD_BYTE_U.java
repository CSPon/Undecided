package cs.opcode;

import cs.architecture.AArchitecture;
import cs.architecture.Architecture_MIPS;

public class ISA_LOAD_BYTE_U extends ISA_LOAD_HALF_U
{
	public ISA_LOAD_BYTE_U(String line)
	{
		super(line);
		assign();
		
		setHex_opcode(0x24);
		setFunct(0x00);
	}

	@Override
	public void eval(AArchitecture arc)
	{
		int val_rs = arc.registers().getFrom(getRegister_rs());
		int offset = getImmediate();
		
		arc.registers().setTo(getRegister_rt(), arc.memory().readMemory(val_rs, offset) & Architecture_MIPS.$LOWER_8);
	}
}
