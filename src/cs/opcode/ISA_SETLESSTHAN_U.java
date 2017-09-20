package cs.opcode;

public class ISA_SETLESSTHAN_U extends ISA_SETLESSTHAN
{
	public ISA_SETLESSTHAN_U(String line)
	{
		super(line);
		parseFull();
		parseReg();
		
		HEX_OPCODE = 0x00;
		HEX_FUNCT = 0x2B;
	}
}
