package cs.architecture;

public class Architecture
{
	private int 	ZERO = 0;
	private int		AT;
	private int[]	VALS = new int[2];
	private int[]	ARGS = new int[4];
	private int[]	TEMP = new int[10];
	private int[]	SEMP = new int[8];
	private int[]	ROSK = new int[2];
	private int		GLBP;
	private int		STKP;
	private int		FRMP;
	private int		RTRN;
	
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
	
	public int getVALS(int addr)
	{
		if(addr > VALS.length - 1)
			return -1;
		return VALS[addr];
	}
	
	public void setVALS(int addr, int val)
	{
		if(addr < VALS.length)
			VALS[addr] = val;
	}
	
	public int getARGS(int addr)
	{
		if(addr > ARGS.length - 1)
			return -1;
		return VALS[addr];
	}
	
	public void setARGS(int addr, int val)
	{
		if(addr < ARGS.length)
			ARGS[addr] = val;
	}
	
	public int getTEMP(int addr)
	{
		return 0;
	}
	
	public void setTEMP(int addr, int val)
	{
		if(addr < TEMP.length)
			TEMP[addr] = val;
	}
	
	public int getSEMP(int addr)
	{
		return 0;
	}
	
	public void setSEMP(int addr, int val)
	{
		
	}
	
	public int getROSK(int addr)
	{
		
	}
	
	public void setROSK(int addr, int val)
	{
		
	}
	
	public int getGLBP(int addr)
	{
		
	}
	
	public void setGLBP(int val)
	{
		
	}
	
	public int getSTKP(int addr)
	{
		
	}
	
	public void setSTKP(int val)
	{
		
	}
	
	public int getFRMP(int addr)
	{
		
	}
	
	public void setFRMP(int val)
	{
		
	}
	
	public int getRTRN(int addr)
	{
		
	}
	
	public void setRTRN(int val)
	{
		
	}
}
