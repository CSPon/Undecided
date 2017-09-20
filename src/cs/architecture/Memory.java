package cs.architecture;

import java.util.HashMap;

public class Memory
{
	private HashMap<Integer, Integer> memory;
	
	public Memory()
	{
		memory = new HashMap<Integer, Integer>();
	}
	
	public int readMemory(int address)
	{
		return memory.get(address);
	}
	
	public int writeMemory(int address, int value)
	{
		memory.put(address, value);
		return memory.get(address);
	}
	
	public void resetAll()
	{
		memory.clear();
	}
}
