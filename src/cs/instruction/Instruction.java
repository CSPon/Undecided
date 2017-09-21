package cs.instruction;

import cs.architecture.IArchitecture;

public interface Instruction
{
	public void eval(IArchitecture arc);
	
	public void assign();

	public int checkShift(String reg);
	
	public String checkReg(String reg);
	
	public String toString(IArchitecture arc);
}
