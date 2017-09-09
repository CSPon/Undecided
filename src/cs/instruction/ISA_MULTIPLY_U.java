package cs.instruction;

public class ISA_MULTIPLY_U extends ISA_MULTIPLY
{
	public ISA_MULTIPLY_U(String line)
	{
		super(line);
		parseFull();
		parseReg();
	}
}
