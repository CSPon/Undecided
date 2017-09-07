package cs.architecture;

public class Architecture
{
	private final int 	ZERO = 0;
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
	
	public Architecture()
	{
		AT = 0;
		VALS = new int[]{0, 0};
		ARGS = new int[]{0, 0, 0, 0};
		TEMP = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		SEMP = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		ROSK = new int[]{0, 0};
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
		if(addr > TEMP.length - 1)
			return -1;
		return TEMP[addr];
	}
	
	public void setTEMP(int addr, int val)
	{
		if(addr < TEMP.length)
			TEMP[addr] = val;
		
		System.out.println(TEMP[addr]);
	}
	
	public int getSEMP(int addr)
	{
		if(addr > SEMP.length - 1)
			return -1;
		return SEMP[addr];
	}
	
	public void setSEMP(int addr, int val)
	{
		if(addr < SEMP.length)
			SEMP[addr] = val;
	}
	
	public int getROSK(int addr)
	{
		if(addr > ROSK.length - 1)
			return -1;
		return ROSK[addr];
	}
	
	public void setROSK(int addr, int val)
	{
		if(addr < ROSK.length)
			ROSK[addr] = val;
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
