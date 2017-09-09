package cs.instruction;

public class ISA_SUB_U extends ISA_SUB
{
	public ISA_SUB_U(String line)
	{
		super(line);
		parseFull();
		parseReg();
	}
}
