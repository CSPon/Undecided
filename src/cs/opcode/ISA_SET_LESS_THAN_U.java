package cs.opcode;

public class ISA_SET_LESS_THAN_U extends ISA_SET_LESS_THAN
{
	public ISA_SET_LESS_THAN_U(String line)
	{
		super(line);
		parseFull();
		parseReg();
		
		HEX_OPCODE = 0x00;
		HEX_FUNCT = 0x2B;
	}
}
