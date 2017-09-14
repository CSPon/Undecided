package cs.instruction;

public class ISA_ADD_U extends ISA_ADD
{
	public ISA_ADD_U(String line)
	{
		super(line);
		parseFull();
		parseReg();
		
		HEX_OPCODE = 0x00;
		HEX_FUNCT = 0x21;
	}
}
