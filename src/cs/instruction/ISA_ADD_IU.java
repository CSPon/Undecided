package cs.instruction;

public class ISA_ADD_IU extends ISA_ADD_I
{
	public ISA_ADD_IU(String line)
	{
		super(line);
		parseFull();
		parseReg();
	}
}
