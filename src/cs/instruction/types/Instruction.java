package cs.instruction.types;

import cs.architecture.Internal;

public interface Instruction
{
	/**
	 * Parses given line
	 */
	public void parseFull();
	
	public void parseReg();
	
	public int checkShift(String reg);
	
	public String checkReg(String reg);
	
	/**
	 * Performs instruction
	 */
	public void perform(Internal internal);
}
