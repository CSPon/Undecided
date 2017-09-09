package cs.instruction;

public class ISA_DIVIDE_U extends ISA_DIVIDE
{
	public ISA_DIVIDE_U(String line)
	{
		super(line);
		parseFull();
		parseReg();
	}
}
