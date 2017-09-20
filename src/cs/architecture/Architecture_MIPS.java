package cs.architecture;

public class Architecture_MIPS extends AArchitecture
{
	public static final int $sp = 0x7FFFFFFC;
	public static final int $gp = 0x10008000;
	public static final int $pc = 0x00400000;
	public static final int $fp = 0x7FFFFFFC;
	
	public Architecture_MIPS()
	{
		memory = new Memory();
		registers = new Registers_MIPS();
	}
	
	@Override
	public Registers registers()
	{
		return registers;
	}

	@Override
	public Memory memory()
	{
		return memory;
	}
}
