package cs.opcode;

public class ISA_ADD_IU extends ISA_ADD_I
{
	public ISA_ADD_IU(String line)
	{
		super(line);
		
		setHex_opcode(0x09);
		setFunct(0x00);
	}
}
