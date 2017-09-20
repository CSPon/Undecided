package cs.architecture;

public class Architecture_MIPS extends AArchitecture
{
	public static final int $LOWER_26	= 0x03FFFFFF;
	public static final int $LOWER_16	= 0x0000FFFF;
	public static final int $LOWER_8	= 0x000000FF;
	public static final int $LOWER_4	= 0x0000000F;
	public static final int $UPPER_4	= 0xF0000000;
	public static final int $UPPER_8	= 0xFF000000;
	public static final int $UPPER_16	= 0xFFFF0000;
	
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
