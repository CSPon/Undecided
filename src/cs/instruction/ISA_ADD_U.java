package cs.instruction;

public class ISA_ADD_U extends ISA_ADD
{
	public ISA_ADD_U(String line)
	{
		super(line);
		parseFull();
		parseReg();
	}
}
