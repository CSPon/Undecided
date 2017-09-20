package cs.opcode;

public class ISA_SET_LESS_THAN_U extends ISA_SET_LESS_THAN
{
	public ISA_SET_LESS_THAN_U(String line)
	{
		super(line);
		assign();
		
		setHex_opcode(0x00);
		setFunct(0x2B);
	}
}
