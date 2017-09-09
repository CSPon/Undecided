package cs.routine;

import java.util.ArrayList;

import cs.architecture.Internal;
import cs.instruction.types.ISA_OPCODE;

public class SubRoutine implements Routine
{
	private String LABEL;
	private int ADDR;
	
	private ArrayList<ISA_OPCODE> INSTRUCTIONS;
	
	public SubRoutine(String LABEL, int ADDR)
	{
		setLabel(LABEL);
		setAddr(ADDR);
		
		INSTRUCTIONS = new ArrayList<ISA_OPCODE>(0);
	}
	
	public void execute(Internal internal)
	{
		for(ISA_OPCODE INSTRUCTION : INSTRUCTIONS)
			INSTRUCTION.perform(internal);
	}
	
	public void addInstruction(ISA_OPCODE INSTRUCTION)
	{
		INSTRUCTIONS.add(INSTRUCTION);
	}
	
	public void addInstruction(Internal internal, String line)
	{
		INSTRUCTIONS.add(internal.getType(line));
	}
	
	// TODO Might not need?
	public void removeInstruction(int interal_location)
	{
		INSTRUCTIONS.remove(interal_location);
	}
	
	public void setAddr(int addr)
	{
		ADDR = addr;
	}
	public int getAddr()
	{
		return ADDR;
	}
	
	public void setLabel(String label)
	{
		LABEL = label;
	}
	public String getLabel()
	{
		return LABEL;
	}
}
