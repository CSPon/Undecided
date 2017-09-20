package cs.opcode;

public class ISA_SETLESSTHAN_IU extends ISA_SETLESSTHAN_I
{
	public ISA_SETLESSTHAN_IU(String line)
	{
		super(line);
		parseFull();
		parseReg();
		
		HEX_OPCODE = 0x0B;
		HEX_FUNCT = 0x00;
	}
}
