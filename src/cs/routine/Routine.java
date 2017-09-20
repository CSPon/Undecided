package cs.routine;

import java.util.LinkedHashMap;
import java.util.Map;

import cs.architecture.Architecture;
import cs.architecture.Internal;
import cs.instruction.*;
import cs.opcode.ISA_BRANCHEQ;
import cs.opcode.ISA_BRANCHGE;
import cs.opcode.ISA_BRANCHGT;
import cs.opcode.ISA_BRANCHLE;
import cs.opcode.ISA_BRANCHLT;
import cs.opcode.ISA_BRANCHNE;
import cs.opcode.ISA_JUMP;
import cs.opcode.ISA_JUMPANDLINK;
import cs.opcode.ISA_LABEL;

public class Routine
{
	private Internal internal;
	
	private LinkedHashMap<Integer, ISA_OPCODE> INSTRUCTIONS;
	
	private int CYCLE_COUNTS;
	
	private int LAST_PC;
	
	public Routine(Internal _internal)
	{
		this.internal = _internal;
		INSTRUCTIONS = new LinkedHashMap<>();
		
		CYCLE_COUNTS = 0;
	}
	
	public int getInstructionEnd()
	{
		return LAST_PC;
	}
	
	public int getCYCLE()
	{
		return CYCLE_COUNTS;
	}
	
	public void resetCYCLE()
	{
		CYCLE_COUNTS = 0;
	}
	
	public String getOPCODE(int i)
	{
		return INSTRUCTIONS.get(i).getOPCODE();
	}
	
	public String getREGS(int i)
	{
		return INSTRUCTIONS.get(i).getREGS();
	}
	
	public LinkedHashMap<Integer, ISA_OPCODE> getInstructions()
	{
		return INSTRUCTIONS;
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
		while(!INSTRUCTIONS.isEmpty())
			INSTRUCTIONS.clear();
		
		LAST_PC = Architecture.$PC;
	}
	
	public void addInstruction(String line)
	{
		int PC = Architecture.$PC + (INSTRUCTIONS.size() * 0x04);
		INSTRUCTIONS.put(PC, internal.getType(line));
		LAST_PC = PC;
	}
	
	public void addLabel(String line)
	{
		int PC = Architecture.$PC + (INSTRUCTIONS.size() * 0x04);
		INSTRUCTIONS.put(PC, new ISA_LABEL(line));
		internal.addSymbol(line, PC);
		LAST_PC = PC;
	}
	
	public void execute()
	{
		CYCLE_COUNTS = 0;
		internal.setPC(Architecture.$PC);
		
		while(INSTRUCTIONS.get(internal.getPC()) != null)
		{
			execute(internal.getPC());
			internal.setPC(internal.getPC() + 0x04);
		}
		
		internal.setPC(Architecture.$PC);
	}
	
	/**
	 * Step Execution
	 */
	public void execute(int pc)
	{
		INSTRUCTIONS.get(pc).perform(internal);
		if(!(INSTRUCTIONS.get(pc) instanceof ISA_LABEL))
				CYCLE_COUNTS += INSTRUCTIONS.get(pc).getCYCLE();
	}
	
	public void compile()
	{
		// Add all LABELs to Symbol Table first
		for(Map.Entry<Integer, ISA_OPCODE> entry : INSTRUCTIONS.entrySet())
			if(entry.getValue() instanceof ISA_LABEL)
				entry.getValue().setPC(internal);
		
		// Then link all J-Type and Branches to target LABEL
		for(Map.Entry<Integer, ISA_OPCODE> entry : INSTRUCTIONS.entrySet())
		{
			if(entry.getValue() instanceof ISA_JUMP)
				entry.getValue().parseJump(internal, entry.getKey());
			else if(entry.getValue() instanceof ISA_JUMPANDLINK)
				entry.getValue().parseJump(internal, entry.getKey());
			else if(entry.getValue() instanceof ISA_BRANCHEQ)
				entry.getValue().parseJump(internal, entry.getKey());
			else if(entry.getValue() instanceof ISA_BRANCHNE)
				entry.getValue().parseJump(internal, entry.getKey());
			else if(entry.getValue() instanceof ISA_BRANCHLT)
				entry.getValue().parseJump(internal, entry.getKey());
			else if(entry.getValue() instanceof ISA_BRANCHGT)
				entry.getValue().parseJump(internal, entry.getKey());
			else if(entry.getValue() instanceof ISA_BRANCHLE)
				entry.getValue().parseJump(internal, entry.getKey());
			else if(entry.getValue() instanceof ISA_BRANCHGE)
				entry.getValue().parseJump(internal, entry.getKey());
		}
	}
	
	public int getLabelAddr(String ADDR, int currentPos)
	{
		for(Map.Entry<Integer, ISA_OPCODE> entry : INSTRUCTIONS.entrySet())
		{
			if(entry.getValue() instanceof ISA_LABEL)
				if(entry.getValue().getADDR_SELF().compareTo(ADDR) == 0)
					return entry.getKey();
		}
		
		return currentPos;
	}
}
