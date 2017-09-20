package cs.opcode;

public class ISA_ADD_U extends ISA_ADD
{
	public ISA_ADD_U(String line)
	{
		super(line);
		setHex_opcode(0x00);
		setFunct(0x21);
	}
}
