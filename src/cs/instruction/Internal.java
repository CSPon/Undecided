package cs.instruction;

import cs.architecture.Architecture;

public class Internal
{
	public Architecture arc;
	
	public Internal()
	{
		this.arc = new Architecture();
	}
	
	public int getFrom(String NAME)
	{
		NAME = NAME.toUpperCase();
		if(NAME.startsWith("$"))
		{
			if(NAME.contains("ZERO"))
				return arc.getZero();
			else if(NAME.contains("A") && NAME.charAt(1) == 'A')
			{
				return arc.getARGS((int)(NAME.charAt(2) - 48));
			}
			else if(NAME.contains("S") && NAME.charAt(1) == 'S')
			{
				return arc.getSEMP((int)(NAME.charAt(2) - 48));
			}
			else if(NAME.contains("T") && NAME.charAt(1) == 'T')
			{
				return arc.getTEMP((int)(NAME.charAt(2) - 48));
			}
			else if(NAME.contains("V") && NAME.charAt(1) == 'V')
			{
				return arc.getVALS((int)(NAME.charAt(2) - 48));
			}
		}
		return -1;
	}
	
	public void setTo(String NAME, int val)
	{
		NAME = NAME.toUpperCase();
		if(NAME.startsWith("$"))
		{
			if(NAME.contains("A") && NAME.charAt(1) == 'A')
			{
				int addr = (int)(NAME.charAt(2) - 48);
				arc.setARGS(addr, val);
			}
			else if(NAME.contains("S") && NAME.charAt(1) == 'S')
			{
				int addr = (int)(NAME.charAt(2) - 48);
				arc.setSEMP(addr, val);
			}
			else if(NAME.contains("T") && NAME.charAt(1) == 'T')
			{
				int addr = (int)(NAME.charAt(2) - 48);
				arc.setTEMP(addr, val);
			}
			else if(NAME.contains("V") && NAME.charAt(1) == 'V')
			{
				int addr = (int)(NAME.charAt(2) - 48);
				arc.setVALS(addr, val);
			}
		}
	}
}
