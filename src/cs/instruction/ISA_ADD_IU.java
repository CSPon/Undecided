package cs.instruction;

public class ISA_ADD_IU extends ISA_ADD_I
{
	public ISA_ADD_IU(String line)
	{
		super(line);
		parseFull();
		parseReg();
		
		HEX_OPCODE = 0x09;
		HEX_FUNCT = 0x00;
	}
}
