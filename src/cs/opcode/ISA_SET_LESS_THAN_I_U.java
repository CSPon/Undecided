package cs.opcode;

public class ISA_SET_LESS_THAN_I_U extends ISA_SET_LESS_THAN_I
{
	public ISA_SET_LESS_THAN_I_U(String line)
	{
		super(line);
		assign();
		
		setHex_opcode(0x0B);
		setFunct(0x00);
	}
}
