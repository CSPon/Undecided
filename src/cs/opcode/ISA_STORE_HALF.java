package cs.opcode;

import cs.architecture.AArchitecture;
import cs.architecture.Architecture_MIPS;

public class ISA_STORE_HALF extends ISA_STORE_WORD
{
	public ISA_STORE_HALF(String line)
	{
		super(line);
		assign();
		
		setHex_opcode(0x29);
		setFunct(0x00);
	}
	
	@Override
	public void eval(AArchitecture arc)
	{
		int val_rt = arc.registers().getFrom(getRegister_rt());
		int val_rs = arc.registers().getFrom(getRegister_rs());
		int offset = getImmediate();
		
		arc.memory().writeMemory(val_rs, offset, val_rt & Architecture_MIPS.$LOWER_16);
	}
}
