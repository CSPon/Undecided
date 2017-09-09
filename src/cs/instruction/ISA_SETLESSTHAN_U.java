package cs.instruction;

public class ISA_SETLESSTHAN_U extends ISA_SETLESSTHAN
{
	public ISA_SETLESSTHAN_U(String line)
	{
		super(line);
		parseFull();
		parseReg();
	}
}
