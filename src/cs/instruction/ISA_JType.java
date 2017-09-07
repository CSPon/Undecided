package cs.instruction;

public abstract class ISA_JType implements Instruction
{
	protected String line;
	protected String address;
	
	@Override
	public abstract void parse();

	@Override
	public abstract void perform(Internal internal);
}
