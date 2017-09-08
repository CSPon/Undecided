package cs.instruction;

import cs.architecture.Internal;

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
