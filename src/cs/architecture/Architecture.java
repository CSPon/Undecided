package cs.architecture;

import java.util.ArrayList;

public class Architecture
{
	private final int 	ZERO = 0;
	private int		AT;
	private ArrayList<ArrayList<Integer>> VALS, ARGS, TEMP, SEMP, ROSK;
	private int		GLBP;
	private int		STKP;
	private int		FRMP;
	private int		RTRN;
	
	public Architecture()
	{
		int i, j;
		
		VALS = new ArrayList<ArrayList<Integer>>(2);
		ARGS = new ArrayList<ArrayList<Integer>>(4);
		TEMP = new ArrayList<ArrayList<Integer>>(10);
		SEMP = new ArrayList<ArrayList<Integer>>(8);
		ROSK = new ArrayList<ArrayList<Integer>>(2);
		
		for(i = 0; i < 2; i++)
		{
			VALS.add(i, new ArrayList<Integer>(4096));
			for(j = 0; j < 4096; j++)
				VALS.get(i).add(j, 0);
		}
		for(i = 0; i < 4; i++)
		{
			ARGS.add(i, new ArrayList<Integer>(4096));
			for(j = 0; j < 4096; j++)
				ARGS.get(i).add(j, 0);
		}
		for(i = 0; i < 10; i++)
		{
			TEMP.add(i, new ArrayList<Integer>(4096));
			for(j = 0; j < 4096; j++)
				TEMP.get(i).add(j, 0);
		}
		for(i = 0; i < 8; i++)
		{
			SEMP.add(i, new ArrayList<Integer>(4096));
			for(j = 0; j < 4096; j++)
				SEMP.get(i).add(j, 0);
		}
		for(i = 0; i < 2; i++)
		{
			ROSK.add(i, new ArrayList<Integer>(4096));
			for(j = 0; j < 4096; j++)
				ROSK.get(i).add(j, 0);
		}
		
		AT = 0;
		GLBP = 0;
		STKP = 0;
		FRMP = 0;
		RTRN = 0;
	}
	
	public int getZero()
	{
		return ZERO;
	}
	
	public int getAT()
	{
		return AT;
	}
	
	public void setAT(int _AT)
	{
		this.AT = _AT;
	}
	
	public int getVALS(int addr, int offset)
	{
		if(addr > VALS.size() - 1)
			return -1;
		return VALS.get(addr).get(offset);
	}
	
	public void setVALS(int addr, int offset, int val)
	{
		if(addr < VALS.size())
			VALS.get(addr).set(offset, val);
	}
	
	public int getARGS(int addr, int offset)
	{
		if(addr > ARGS.size() - 1)
			return -1;
		return ARGS.get(addr).get(offset);
	}
	
	public void setARGS(int addr, int offset, int val)
	{
		if(addr < ARGS.size())
			ARGS.get(addr).set(offset, val);
	}
	
	public int getTEMP(int addr, int offset)
	{
		if(addr > TEMP.size() - 1)
			return -1;
		return TEMP.get(addr).get(offset);
	}
	
	public void setTEMP(int addr, int offset, int val)
	{
		if(addr < TEMP.size())
			TEMP.get(addr).set(offset, val);
	}
	
	public int getSEMP(int addr, int offset)
	{
		if(addr > SEMP.size() - 1)
			return -1;
		return SEMP.get(addr).get(offset);
	}
	
	public void setSEMP(int addr, int offset, int val)
	{
		if(addr < SEMP.size())
			SEMP.get(addr).set(offset, val);
	}
	
	public int getROSK(int addr, int offset)
	{
		if(addr > ROSK.size() - 1)
			return -1;
		return ROSK.get(addr).get(offset);
	}
	
	public void setROSK(int addr, int offset, int val)
	{
		if(addr < ROSK.size())
			ROSK.get(addr).set(offset, val);
	}
	
	public int getGLBP()
	{
		return GLBP;
	}
	
	public void setGLBP(int val)
	{
		GLBP = val;
	}
	
	public int getSTKP()
	{
		return STKP;
	}
	
	public void setSTKP(int val)
	{
		STKP = val;
	}
	
	public int getFRMP()
	{
		return FRMP;
	}
	
	public void setFRMP(int val)
	{
		FRMP = val;
	}
	
	public int getRTRN()
	{
		return RTRN;
	}
	
	public void setRTRN(int val)
	{
		RTRN = val;
	}
}
