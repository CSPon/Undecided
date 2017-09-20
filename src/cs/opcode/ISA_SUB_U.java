package cs.opcode;

public class ISA_SUB_U extends ISA_SUB
{
	public ISA_SUB_U(String line)
	{
		super(line);
		parseFull();
		parseReg();
		HEX_OPCODE = 0x00;
		HEX_FUNCT = 0x23;
	}
}
