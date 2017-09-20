package cs.opcode;

public class ISA_SUB_U extends ISA_SUB
{
	public ISA_SUB_U(String line)
	{
		super(line);
		assign();
		
		setHex_opcode(0x00);
		setFunct(0x23);
	}
}
