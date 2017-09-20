package cs.architecture;

import java.util.LinkedHashMap;

public abstract class Registers implements IRegisters
{
	private LinkedHashMap<String, Integer> reg_adr;
	private LinkedHashMap<Integer, Integer> reg_val;
	
	public Registers()
	{
		reg_adr = new LinkedHashMap<String, Integer>();
		reg_val = new LinkedHashMap<Integer, Integer>();
	}

	@Override
	public void resetAll()
	{
		reg_adr.clear();
		reg_val.clear();
	}

	@Override
	public int getFrom(String register_name)
	{
		if(reg_adr.containsKey(register_name))
			return reg_val.get(reg_adr.get(register_name));
		
		return -1;
	}

	@Override
	public int setTo(String register_name, int data)
	{
		if(!reg_adr.containsKey(register_name))
			reg_adr.put(register_name, data);
		else
			reg_val.put(reg_adr.get(register_name), data);
		
		return reg_val.get(reg_adr.get(register_name));
	}

	@Override
	public int getAddress(String register_name)
	{
		return reg_adr.get(register_name);
	}

	@Override
	public int setAddress(String register_name, int new_address)
	{
		reg_adr.put(register_name, new_address);
		return reg_adr.get(register_name);
	}
}
