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
	
	public void printAll()
	{
		System.out.print("$zero: "); System.out.println(0);
		System.out.println();
		
		System.out.print("$at: "); printlnHex(getAT());
		System.out.println();
		
		System.out.print("$v0: "); printlnHex(getVALS(0));
		System.out.print("$v1: "); printlnHex(getVALS(1));
		System.out.println();
		
		System.out.print("$a0: "); printlnHex(getARGS(0));
		System.out.print("$a1: "); printlnHex(getARGS(1));
		System.out.print("$a2: "); printlnHex(getARGS(2));
		System.out.print("$a3: "); printlnHex(getARGS(3));
		System.out.println();
		
		System.out.print("$t0: "); printlnHex(getTEMP(0));
		System.out.print("$t1: "); printlnHex(getTEMP(1));
		System.out.print("$t2: "); printlnHex(getTEMP(2));
		System.out.print("$t3: "); printlnHex(getTEMP(3));
		System.out.print("$t4: "); printlnHex(getTEMP(4));
		System.out.print("$t5: "); printlnHex(getTEMP(5));
		System.out.print("$t6: "); printlnHex(getTEMP(6));
		System.out.print("$t7: "); printlnHex(getTEMP(7));
		System.out.print("$t8: "); printlnHex(getTEMP(8));
		System.out.print("$t9: "); printlnHex(getTEMP(9));
		System.out.println();
		
		System.out.print("$s0: "); printlnHex(getSEMP(0));
		System.out.print("$s1: "); printlnHex(getSEMP(1));
		System.out.print("$s2: "); printlnHex(getSEMP(2));
		System.out.print("$s3: "); printlnHex(getSEMP(3));
		System.out.print("$s4: "); printlnHex(getSEMP(4));
		System.out.print("$s5: "); printlnHex(getSEMP(5));
		System.out.print("$s6: "); printlnHex(getSEMP(6));
		System.out.print("$s7: "); printlnHex(getSEMP(7));
		System.out.println();
		
		System.out.print("$k0: "); printlnHex(getROSK(0));
		System.out.print("$k1: "); printlnHex(getROSK(1));
		System.out.println();
		
		System.out.print("$gp: "); printlnHex(getGLBP());
		System.out.print("$sp: "); printlnHex(getSTKP());
		System.out.print("$fp: "); printlnHex(getFRMP());
		System.out.print("$ra: "); printlnHex(getRTRN());
		
		System.out.println();
		
		for(int i = 0; i < MEM.length; i++)
		{
			printHex(i); System.out.print(" ");
			printlnHex(MEM[i]);			
		}
	}
	
	public static void printHex(int val)
	{
		String t = String.format("0x%04x", val);
		System.out.print(t);
	}
	
	public static void printlnHex(int val)
	{
		String t = String.format("0x%04x", val);
		System.out.println(t);
	}
	
	public static void printBinary(int val)
	{
		String t = String.format("%32s", Integer.toBinaryString(val)).replace(' ', '0');
		System.out.print(t);
	}
	
	public static void printlnBinary(int val)
	{
		String t = String.format("%32s", Integer.toBinaryString(val)).replace(' ', '0');
		System.out.println(t);
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
	
	public void resetMEM()
	{
		for(int i = 0; i < MEM.length; i++)
		{
			MEM[i] = 0;
		}
	}
	
	public int getAddress(String reg)
	{
		if(reg.contains("$zero"))
			return 0;
		else if(reg.contains("$at"))
			return 1;
		else if(reg.contains("$v0"))
			return 2;
		else if(reg.contains("$v1"))
			return 3;
		else if(reg.contains("$a0"))
			return 4;
		else if(reg.contains("$a1"))
			return 5;
		else if(reg.contains("$a2"))
			return 6;
		else if(reg.contains("$a3"))
			return 7;
		else if(reg.contains("$t0"))
			return 8;
		else if(reg.contains("$t1"))
			return 9;
		else if(reg.contains("$t2"))
			return 10;
		else if(reg.contains("$t3"))
			return 11;
		else if(reg.contains("$t4"))
			return 12;
		else if(reg.contains("$t5"))
			return 13;
		else if(reg.contains("$t6"))
			return 14;
		else if(reg.contains("$t7"))
			return 15;
		else if(reg.contains("$s0"))
			return 16;
		else if(reg.contains("$s1"))
			return 17;
		else if(reg.contains("$s2"))
			return 18;
		else if(reg.contains("$s3"))
			return 19;
		else if(reg.contains("$s4"))
			return 20;
		else if(reg.contains("$s5"))
			return 21;
		else if(reg.contains("$s6"))
			return 22;
		else if(reg.contains("$s7"))
			return 23;
		else if(reg.contains("$t8"))
			return 24;
		else if(reg.contains("$t9"))
			return 25;
		else if(reg.contains("$k0"))
			return 26;
		else if(reg.contains("$k1"))
			return 27;
		else if(reg.contains("$gp"))
			return 28;
		else if(reg.contains("$sp"))
			return 29;
		else if(reg.contains("$fp"))
			return 30;
		else if(reg.contains("$ra"))
			return 31;
		else return 0xFF;
	}
}
