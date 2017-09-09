package cs.instruction;

public class ISA_SETLESSTHAN_IU extends ISA_SETLESSTHAN_I
{
	public ISA_SETLESSTHAN_IU(String line)
	{
		super(line);
		parseFull();
		parseReg();
	}
}
