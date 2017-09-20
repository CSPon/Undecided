package cs.architecture;

import java.util.HashMap;

public class Memory
{
	private HashMap<Integer, Integer> memory;
	
	public Memory()
	{
		memory = new HashMap<Integer, Integer>();
	}
	
	public int readMemory(int address, int offset)
	{
		return memory.get(address + offset);
	}
	
	public int writeMemory(int address, int offset, int value)
	{
		memory.put(address + offset, value);
		return memory.get(address + offset);
	}
	
	public void resetAll()
	{
		memory.clear();
	}
}
