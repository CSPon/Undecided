package cs.routine;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import cs.architecture.Architecture;
import cs.architecture.Internal;
import cs.instruction.*;
import cs.instruction.types.ISA_LABEL;
import cs.instruction.types.ISA_OPCODE;

public class Routine
{
	private Internal internal;
	private ArrayList<ISA_OPCODE> INSTRUCTIONS;
	
	private LinkedHashMap<Integer, ISA_OPCODE> _INSTRUCTIONS;
	
	private int CYCLE_COUNTS;
	
	private int LAST_PC;
	
	public Routine(Internal _internal)
	{
		this.internal = _internal;
		INSTRUCTIONS = new ArrayList<ISA_OPCODE>();
		_INSTRUCTIONS = new LinkedHashMap<>();
		
		CYCLE_COUNTS = 0;
	}
	
	public int getCYCLE()
	{
		return CYCLE_COUNTS;
	}
	
	public String getOPCODE(int i)
	{
		return _INSTRUCTIONS.get(i).getOPCODE();
//		return INSTRUCTIONS.get(i).getOPCODE();
	}
	
	public String getREGS(int i)
	{
		return _INSTRUCTIONS.get(i).getREGS();
//		return INSTRUCTIONS.get(i).getREGS();
	}
	
	public LinkedHashMap<Integer, ISA_OPCODE> getInstructions()
	{
		return _INSTRUCTIONS;
	}
	
	public int getInstructionsCount()
	{
		return _INSTRUCTIONS.size();
//		return INSTRUCTIONS.size();
	}
	
	public int getInstructionPC(int i)
	{
		return _INSTRUCTIONS.get(i).getPC();
//		return INSTRUCTIONS.get(i).getPC();
	}
	
	public void clearInstruction()
	{
		_INSTRUCTIONS.clear();
//		INSTRUCTIONS.clear();
//		INSTRUCTIONS.trimToSize();
	}
	
	public void addInstruction(String line)
	{
		int PC = Architecture.$PC + (_INSTRUCTIONS.size() * 0x04);
		_INSTRUCTIONS.put(PC, internal.getType(line));
		LAST_PC = PC;
		
//		INSTRUCTIONS.add(internal.getType(line));
//		PC = Architecture.$PC + ((INSTRUCTIONS.size() - 1) * 0x04);
//		INSTRUCTIONS.get(INSTRUCTIONS.size() - 1).setPC(PC);
	}
	
	public void addLabel(String line)
	{
		int PC = Architecture.$PC + (_INSTRUCTIONS.size() * 0x04);
		_INSTRUCTIONS.put(PC, new ISA_LABEL(line));
		LAST_PC = PC;
		
//		INSTRUCTIONS.add(new ISA_LABEL(line));
//		PC = Architecture.$PC + ((INSTRUCTIONS.size() - 1) * 0x04);
//		INSTRUCTIONS.get(INSTRUCTIONS.size() - 1).setPC(PC);
	}
	
	public void execute()
	{
		CYCLE_COUNTS = 0;
		internal.setPC(Architecture.$PC);
		
		while(_INSTRUCTIONS.get(internal.getPC()) != null)
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
		if(internal.getPC() >= LAST_PC)
		{
			CYCLE_COUNTS = 0;
			internal.setPC(Architecture.$PC);
		}
		else
		{
			_INSTRUCTIONS.get(pc).perform(internal);
			if(!(_INSTRUCTIONS.get(pc) instanceof ISA_LABEL))
					CYCLE_COUNTS += _INSTRUCTIONS.get(pc).getCYCLE();
		}
	}
	
	public void compile()
	{
		for(Map.Entry<Integer, ISA_OPCODE> entry : _INSTRUCTIONS.entrySet())
		{
			if(entry.getValue() instanceof ISA_JUMP)
				entry.getValue().parseJump(this, entry.getValue().getPC());
			else if(entry.getValue() instanceof ISA_JUMPANDLINK)
				entry.getValue().parseJump(this, entry.getValue().getPC());
			else if(entry.getValue() instanceof ISA_BRANCHEQ)
				entry.getValue().parseJump(this, entry.getValue().getPC());
			else if(entry.getValue() instanceof ISA_BRANCHNE)
				entry.getValue().parseJump(this, entry.getValue().getPC());
			else if(entry.getValue() instanceof ISA_BRANCHLT)
				entry.getValue().parseJump(this, entry.getValue().getPC());
			else if(entry.getValue() instanceof ISA_BRANCHGT)
				entry.getValue().parseJump(this, entry.getValue().getPC());
			else if(entry.getValue() instanceof ISA_BRANCHLE)
				entry.getValue().parseJump(this, entry.getValue().getPC());
			else if(entry.getValue() instanceof ISA_BRANCHGE)
				entry.getValue().parseJump(this, entry.getValue().getPC());
		}
		
//		for(int i = 0; i < INSTRUCTIONS.size(); i++)
//		{
//			if(INSTRUCTIONS.get(i) instanceof ISA_JUMP)
//				INSTRUCTIONS.get(i).parseJump(this, i);
//			else if(INSTRUCTIONS.get(i) instanceof ISA_JUMPANDLINK)
//				INSTRUCTIONS.get(i).parseJump(this, i);
//			else if(INSTRUCTIONS.get(i) instanceof ISA_BRANCHEQ)
//				INSTRUCTIONS.get(i).parseJump(this, i);
//			else if(INSTRUCTIONS.get(i) instanceof ISA_BRANCHNE)
//				INSTRUCTIONS.get(i).parseJump(this, i);
//			else if(INSTRUCTIONS.get(i) instanceof ISA_BRANCHLT)
//				INSTRUCTIONS.get(i).parseJump(this, i);
//			else if(INSTRUCTIONS.get(i) instanceof ISA_BRANCHGT)
//				INSTRUCTIONS.get(i).parseJump(this, i);
//			else if(INSTRUCTIONS.get(i) instanceof ISA_BRANCHLE)
//				INSTRUCTIONS.get(i).parseJump(this, i);
//			else if(INSTRUCTIONS.get(i) instanceof ISA_BRANCHGE)
//				INSTRUCTIONS.get(i).parseJump(this, i);
//		}
	}
	
	public int getLabelAddr(String ADDR, int currentPos)
	{
		for(Map.Entry<Integer, ISA_OPCODE> entry : _INSTRUCTIONS.entrySet())
		{
			if(entry.getValue() instanceof ISA_LABEL)
				if(entry.getValue().getADDR().compareTo(ADDR) == 0)
					return entry.getValue().getPC();
		}
		
		return currentPos;
	}
}
