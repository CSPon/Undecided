package cs.architecture;

import java.util.LinkedHashMap;
import java.util.Map;

public class Architecture
{
	/* Constants */
	public static final int $PC			= 0x00400000;
	public static final int $LOWER_26	= 0x03FFFFFF;
	public static final int $LOWER_16	= 0x0000FFFF;
	public static final int $UPPER_4	= 0xF0000000;
	public static final int $UPPER_16	= 0xFFFF0000;
	
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
	
	/* New Version */
	private LinkedHashMap<String, Integer>	REGISTERS_ADDR;
	private LinkedHashMap<Integer, Integer>	REGISTERS_VALS;
	private LinkedHashMap<Integer, Integer>	MEMORY;
	private LinkedHashMap<String, Integer>	SYMBOL_TABLE;
	
	public Architecture()
	{
		assignVal();
		
		HI = 0;
		LO = 0;
		
		AT = 0;
		GLBP = 0;
		STKP = 0;
		FRMP = 0;
		RTRN = 0;
		
		PC = $PC;
	}
	
	public boolean hasSymbol(String LABEL)
	{
		return SYMBOL_TABLE.get(LABEL) != null ? true : false;
	}
	
	public int getSymbolAddress(String LABEL)
	{
		return SYMBOL_TABLE.get(LABEL);
	}
	
	public LinkedHashMap<String, Integer> getSymbolTable()
	{
		return SYMBOL_TABLE;
	}
	
	public void addSymbol(String LABEL, int ADDRESS)
	{
		SYMBOL_TABLE.put(LABEL, ADDRESS);
	}
	
	public LinkedHashMap<Integer, Integer> getRegisterVals()
	{
		return REGISTERS_VALS;
	}
	
	public LinkedHashMap<String, Integer> getRegisterAddrs()
	{
		return REGISTERS_ADDR;
	}
	
	public LinkedHashMap<Integer, Integer> getMemory()
	{
		return MEMORY;
	}
	
	public void resetMemory()
	{
		MEMORY.clear();
	}
	
	public int getRegisterAddress(String reg)
	{
		return REGISTERS_ADDR.get(reg);
	}
	
	public int getRegisterVal(String reg)
	{
		return REGISTERS_VALS.get(REGISTERS_ADDR.get(reg));
	}
	
	public void setRegisterVal(String reg, int val)
	{
		REGISTERS_VALS.put(REGISTERS_ADDR.get(reg), val);
	}
	
	public int getMemoryVal(int addr, int offset)
	{
		return MEMORY.get(addr + offset);
	}
	
	public void setMemoryVal(int addr, int offset, int val)
	{
		MEMORY.put(addr + offset, val);
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
	
	private void assignVal()
	{
		int i = 0;
		REGISTERS_ADDR = new LinkedHashMap<>();
		REGISTERS_ADDR.put("$zero", i);
		
		REGISTERS_ADDR.put("$at", ++i);
		
		REGISTERS_ADDR.put("$v0", ++i);
		REGISTERS_ADDR.put("$v1", ++i);
		
		REGISTERS_ADDR.put("$a0", ++i);
		REGISTERS_ADDR.put("$a1", ++i);
		REGISTERS_ADDR.put("$a2", ++i);
		REGISTERS_ADDR.put("$a3", ++i);
		
		REGISTERS_ADDR.put("$t0", ++i);
		REGISTERS_ADDR.put("$t1", ++i);
		REGISTERS_ADDR.put("$t2", ++i);
		REGISTERS_ADDR.put("$t3", ++i);
		REGISTERS_ADDR.put("$t4", ++i);
		REGISTERS_ADDR.put("$t5", ++i);
		REGISTERS_ADDR.put("$t6", ++i);
		REGISTERS_ADDR.put("$t7", ++i);
		
		REGISTERS_ADDR.put("$s0", ++i);
		REGISTERS_ADDR.put("$s1", ++i);
		REGISTERS_ADDR.put("$s2", ++i);
		REGISTERS_ADDR.put("$s3", ++i);
		REGISTERS_ADDR.put("$s4", ++i);
		REGISTERS_ADDR.put("$s5", ++i);
		REGISTERS_ADDR.put("$s6", ++i);
		REGISTERS_ADDR.put("$s7", ++i);
		
		REGISTERS_ADDR.put("$t8", ++i);
		REGISTERS_ADDR.put("$t9", ++i);
		
		REGISTERS_ADDR.put("$k0", ++i);
		REGISTERS_ADDR.put("$k1", ++i);
		
		REGISTERS_ADDR.put("$gp", ++i);
		REGISTERS_ADDR.put("$sp", ++i);
		REGISTERS_ADDR.put("$fp", ++i);
		REGISTERS_ADDR.put("$ra", ++i);
		
		REGISTERS_VALS = new LinkedHashMap<>();
		for(Map.Entry<String, Integer> entry : REGISTERS_ADDR.entrySet())
		{
			REGISTERS_VALS.put(entry.getValue(), 0);
		}
		
		MEMORY = new LinkedHashMap<>();
		
		SYMBOL_TABLE = new LinkedHashMap<>();
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
	
	public static String toHex(int val)
	{
		String t = String.format("0x%08x", val);
		return t;
	}
	
	public static String toBinary(int val)
	{
		String t = String.format("%32s", Integer.toBinaryString(val));
		t = t.replace(" ", "0");
		return t;
	} 
}
