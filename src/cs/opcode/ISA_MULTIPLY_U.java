package cs.opcode;

public class ISA_MULTIPLY_U extends ISA_MULTIPLY
{
	public ISA_MULTIPLY_U(String line)
	{
		super(line);
		assign();
		
		setHex_opcode(0x00);
		setFunct(0x19);
	}
}
