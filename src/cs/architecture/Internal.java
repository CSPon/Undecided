package cs.architecture;

public class Internal
{
	public Architecture arc;
	
	public Internal()
	{
		this.arc = new Architecture();
	}
	
	public int getFrom(String NAME, int offset)
	{
		NAME = NAME.toUpperCase();
		if(NAME.startsWith("$"))
		{
			if(NAME.contains("ZERO"))
				return arc.getZero();
			else if(NAME.contains("A") && NAME.charAt(1) == 'A')
			{
				return arc.getARGS((int)(NAME.charAt(2) - 48), offset);
			}
			else if(NAME.contains("S") && NAME.charAt(1) == 'S')
			{
				return arc.getSEMP((int)(NAME.charAt(2) - 48), offset);
			}
			else if(NAME.contains("T") && NAME.charAt(1) == 'T')
			{
				return arc.getTEMP((int)(NAME.charAt(2) - 48), offset);
			}
			else if(NAME.contains("V") && NAME.charAt(1) == 'V')
			{
				return arc.getVALS((int)(NAME.charAt(2) - 48), offset);
			}
		}
		return -1;
	}
	
	public void setTo(String NAME, int offset, int val)
	{
		NAME = NAME.toUpperCase();
		if(NAME.startsWith("$"))
		{
			if(NAME.contains("A") && NAME.charAt(1) == 'A')
			{
				int addr = (int)(NAME.charAt(2) - 48);
				arc.setARGS(addr, offset, val);
			}
			else if(NAME.contains("S") && NAME.charAt(1) == 'S')
			{
				int addr = (int)(NAME.charAt(2) - 48);
				arc.setSEMP(addr, offset, val);
			}
			else if(NAME.contains("T") && NAME.charAt(1) == 'T')
			{
				int addr = (int)(NAME.charAt(2) - 48);
				arc.setTEMP(addr, offset, val);
			}
			else if(NAME.contains("V") && NAME.charAt(1) == 'V')
			{
				int addr = (int)(NAME.charAt(2) - 48);
				arc.setVALS(addr, offset, val);
			}
		}
	}
}
