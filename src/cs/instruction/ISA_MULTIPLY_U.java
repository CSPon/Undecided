package cs.instruction;

public class ISA_MULTIPLY_U extends ISA_MULTIPLY
{
	public ISA_MULTIPLY_U(String line)
	{
		super(line);
		parseFull();
		parseReg();
		
		HEX_OPCODE = 0x00;
		HEX_FUNCT = 0x19;
	}
}
