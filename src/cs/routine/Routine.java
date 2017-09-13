package cs.routine;

import java.util.ArrayList;

import cs.architecture.Architecture;
import cs.architecture.Internal;
import cs.instruction.*;
import cs.instruction.types.ISA_LABEL;
import cs.instruction.types.ISA_OPCODE;

public class Routine
{
	private Internal internal;
	private ArrayList<ISA_OPCODE> INSTRUCTIONS;
	
	private int CYCLE_COUNTS;
	
	public Routine(Internal _internal)
	{
		this.internal = _internal;
		INSTRUCTIONS = new ArrayList<ISA_OPCODE>();
		
		CYCLE_COUNTS = 0;
	}
	
	public int getCYCLE()
	{
		return CYCLE_COUNTS;
	}
	
	public String getOPCODE(int i)
	{
		return INSTRUCTIONS.get(i).getOPCODE();
	}
	
	public String getREGS(int i)
	{
		return INSTRUCTIONS.get(i).getREGS();
	}
	
	public int getInstructionsCount()
	{
		return INSTRUCTIONS.size();
	}
	
	public int getInstructionPC(int i)
	{
		return INSTRUCTIONS.get(i).getPC();
	}
	
	public void clearInstruction()
	{
		INSTRUCTIONS.clear();
		INSTRUCTIONS.trimToSize();
	}
	
	public void addInstruction(String line)
	{
		INSTRUCTIONS.add(internal.getType(line));
		int PC = Architecture.$PC + ((INSTRUCTIONS.size() - 1) * 4);
		INSTRUCTIONS.get(INSTRUCTIONS.size() - 1).setPC(PC);
	}
	
	public void addLabel(String line)
	{
		INSTRUCTIONS.add(new ISA_LABEL(line));
		int PC = Architecture.$PC + ((INSTRUCTIONS.size() - 1) * 4);
		INSTRUCTIONS.get(INSTRUCTIONS.size() - 1).setPC(PC);
	}
	
	public void execute()
	{
		CYCLE_COUNTS = 0;
		internal.setPC(0);
		while(internal.getPC() < INSTRUCTIONS.size())
		{
			execute(internal.getPC());
			internal.setPC(internal.getPC() + 1);
		}
	}
	
	/**
	 * Step Execution
	 */
	public void execute(int pc)
	{
		if(internal.getPC() >= INSTRUCTIONS.size())
		{
			CYCLE_COUNTS = 0;
			internal.setPC(0);
		}
		else
		{
			INSTRUCTIONS.get(pc).perform(internal);
			if(!(INSTRUCTIONS.get(pc) instanceof ISA_LABEL))
					CYCLE_COUNTS += INSTRUCTIONS.get(pc).getCYCLE();
		}
	}
	
	public void compile()
	{
		for(int i = 0; i < INSTRUCTIONS.size(); i++)
		{
			if(INSTRUCTIONS.get(i) instanceof ISA_JUMP)
				INSTRUCTIONS.get(i).parseJump(this, i);
			else if(INSTRUCTIONS.get(i) instanceof ISA_JUMPANDLINK)
				INSTRUCTIONS.get(i).parseJump(this, i);
			else if(INSTRUCTIONS.get(i) instanceof ISA_BRANCHEQ)
				INSTRUCTIONS.get(i).parseJump(this, i);
			else if(INSTRUCTIONS.get(i) instanceof ISA_BRANCHNE)
				INSTRUCTIONS.get(i).parseJump(this, i);
			else if(INSTRUCTIONS.get(i) instanceof ISA_BRANCHLT)
				INSTRUCTIONS.get(i).parseJump(this, i);
			else if(INSTRUCTIONS.get(i) instanceof ISA_BRANCHGT)
				INSTRUCTIONS.get(i).parseJump(this, i);
			else if(INSTRUCTIONS.get(i) instanceof ISA_BRANCHLE)
				INSTRUCTIONS.get(i).parseJump(this, i);
			else if(INSTRUCTIONS.get(i) instanceof ISA_BRANCHGE)
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
