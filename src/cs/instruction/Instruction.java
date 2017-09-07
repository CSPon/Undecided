package cs.instruction;

public interface Instruction
{
	/**
	 * Parses given line
	 */
	public void parse();
	
	/**
	 * Performs instruction
	 */
	public void perform(Internal internal);
}
