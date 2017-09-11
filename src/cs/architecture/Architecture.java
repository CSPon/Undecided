package cs.architecture;

public class Architecture
{
	/* Registers */
	private final int 	ZERO = 0;
	private int			AT;
	private int[] 		VALS, ARGS, TEMP, SEMP, ROSK;
	private int			GLBP;
	private int			STKP;
	private int			FRMP;
	private int			RTRN;
	
	/* Special Registers */
	private int			HI, LO;
	private int			PC;
	
	/* Memory */
	private int[]		MEM;
	
	public Architecture()
	{	
		VALS = new int[2];
		ARGS = new int[4];
		TEMP = new int[10];
		SEMP = new int[8];
		ROSK = new int[2];
		
		HI = 0;
		LO = 0;
		
		AT = 0;
		GLBP = 0;
		STKP = 0;
		FRMP = 0;
		RTRN = 0;
		
		MEM = new int[0xFF + 1];
		
		PC = 0;
	}
	
	public int getHI()
	{
		return HI;
	}
	
	public void setHI(int val)
	{
		HI = val;
	}
	
	public int getLO()
	{
		return LO;
	}
	
	public void setLO(int val)
	{
		LO = val;
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
		if(addr < ARGS.length)
			return VALS[addr];
		
		return -1;
	}
	
	public void setVALS(int addr, int val)
	{
		if(addr < VALS.length)
			VALS[addr] = val;
	}
	
	public int getARGS(int addr)
	{
		if(addr > ARGS.length)
			return ARGS[addr];
		
		return -1;
	}
	
	public void setARGS(int addr, int val)
	{
		if(addr < ARGS.length)
			ARGS[addr] = val;
	}
	
	public int getTEMP(int addr)
	{
		if(addr < TEMP.length)
			return TEMP[addr];
		
		return -1;
	}
	
	public void setTEMP(int addr, int val)
	{
		if(addr < TEMP.length)
			TEMP[addr] = val;
	}
	
	public int getSEMP(int addr)
	{
		if(addr < SEMP.length)
			return SEMP[addr];
		
		return -1;
	}
	
	public void setSEMP(int addr, int val)
	{
		if(addr < SEMP.length)
			SEMP[addr] = val;
	}
	
	public int getROSK(int addr)
	{
		if(addr < ROSK.length)
			return ROSK[addr];
		
		return -1;
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
	
	public int getMem(int addr, int offset)
	{
		if(addr < MEM.length)
			return MEM[addr + offset];
		
		return -1;
	}
	
	public void setMem(int addr, int offset, int val)
	{
		if(addr < MEM.length)
			MEM[addr + offset] = val;
	}
	
	public int getPC()
	{
		return PC;
	}
	
	public void setPC(int _PC)
	{
		this.PC = _PC;
	}
}
