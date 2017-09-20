package cs.opcode;

public class ISA_DIVIDE_U extends ISA_DIVIDE
{
	public ISA_DIVIDE_U(String line)
	{
		super(line);
		assign();
		
		setHex_opcode(0x00);
		setFunct(0x1B);
	}
}
