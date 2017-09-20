package cs.instruction;

import cs.architecture.AArchitecture;

public interface Instruction
{
	public void eval(AArchitecture arc);
	
	public void assign();

	public int checkShift(String reg);
	
	public String checkReg(String reg);
	
	public String toString(AArchitecture arc);
}
