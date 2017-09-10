package cs.routine;

import java.util.ArrayList;

import cs.architecture.Internal;
import cs.instruction.ISA_BRANCHEQ;
import cs.instruction.ISA_BRANCHNE;
import cs.instruction.ISA_JUMP;
import cs.instruction.types.ISA_LABEL;
import cs.instruction.types.ISA_OPCODE;

public class Routine
{
	private Internal internal;
	private ArrayList<ISA_OPCODE> INSTRUCTIONS;
	
	public Routine(Internal _internal)
	{
		this.internal = _internal;
		INSTRUCTIONS = new ArrayList<ISA_OPCODE>();
	}
	
	public void addInstruction(String line)
	{
		INSTRUCTIONS.add(internal.getType(line));
	}
	
	public void addLabel(String line)
	{
		INSTRUCTIONS.add(new ISA_LABEL(line));
	}
	
	public void execute()
	{
		compile();
		
		while(internal.getPC() < INSTRUCTIONS.size())
		{
			INSTRUCTIONS.get(internal.getPC()).perform(internal);
			internal.setPC(internal.getPC() + 1);
		}
	}
	
	private void compile()
	{
		for(int i = 0; i < INSTRUCTIONS.size(); i++)
		{
			if(INSTRUCTIONS.get(i) instanceof ISA_JUMP)
				INSTRUCTIONS.get(i).parseJump(this, i);
			else if(INSTRUCTIONS.get(i) instanceof ISA_BRANCHEQ)
				INSTRUCTIONS.get(i).parseJump(this, i);
			else if(INSTRUCTIONS.get(i) instanceof ISA_BRANCHNE)
				INSTRUCTIONS.get(i).parseJump(this, i);
		}
	}
	
	public int getLabelAddr(String ADDR, int currentPos)
	{
		for(int i = 0; i < INSTRUCTIONS.size(); i++)
		{
			if(INSTRUCTIONS.get(i) instanceof ISA_LABEL)
				if(INSTRUCTIONS.get(i).getADDR().compareTo(ADDR) == 0)
					return i;
		}
		
		return currentPos;
	}
}
