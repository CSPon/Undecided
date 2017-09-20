package cs.opcode;

public class ISA_SET_LESS_THAN_I_U extends ISA_SET_LESS_THAN_I
{
	public ISA_SET_LESS_THAN_I_U(String line)
	{
		super(line);
		parseFull();
		parseReg();
		
		HEX_OPCODE = 0x0B;
		HEX_FUNCT = 0x00;
	}
}
