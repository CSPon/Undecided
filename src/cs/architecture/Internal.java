package cs.architecture;

import cs.instruction.*;
import cs.instruction.types.ISA_OPCODE;

public class Internal
{
	private Architecture arc;
	
	public Internal()
	{
		this.arc = new Architecture();
	}
	
	public int getPC()
	{
		return arc.getPC();
	}
	
	public void setPC(int addr)
	{
		arc.setPC(addr);
	}
	
	public int getFrom(String NAME)
	{
		NAME = NAME.toUpperCase();
		if(NAME.startsWith("$"))
		{
			if(NAME.contains("ZERO"))
				return arc.getZero();
			else if(NAME.contains("HI"))
				return arc.getHI();
			else if(NAME.contains("LO"))
				return arc.getLO();
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
			else if(NAME.contains("RA"))
			{
				return arc.getRTRN();
			}
		}
		return -1;
	}
	
	public void setTo(String NAME, int val)
	{
		NAME = NAME.toUpperCase();
		if(NAME.startsWith("$"))
		{
			if(NAME.contains("HI"))
				arc.setHI(val);
			else if(NAME.contains("LO"))
				arc.setLO(val);
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
			else if(NAME.contains("RA"))
			{
				arc.setRTRN(val);
			}
		}
	}
	
	public int getFromMem(int addr, int offset)
	{
		return arc.getMem(addr, offset);
	}
	
	public void setToMem(int addr, int offset, int val)
	{
		arc.setMem(addr, offset, val);
	}
	
	public ISA_OPCODE getType(String line)
	{
		line = line.trim();
		line = line.replaceAll("\\s{1,}", " ");
		line = line.trim();
		line = line.replace(", ", ":");
		line = line.replace(" ", ":");
		String[] parsed = line.split("\\:");
		
		String INSTRUCTION = parsed[0] + " ";
		for(int i = 1; i < parsed.length - 1; i++)
		{
			INSTRUCTION += parsed[i];
			INSTRUCTION += ",";
		}
		INSTRUCTION += parsed[parsed.length - 1];
		
		return checkOpcode(parsed[0], INSTRUCTION);
	}
	
	private ISA_OPCODE checkOpcode(String name, String line)
	{
		name = name.toLowerCase();
		if(name.matches("\\badd\\b"))
			return new ISA_ADD(line);
		else if(name.matches("\\baddi\\b"))
			return new ISA_ADD_I(line);
		else if(name.matches("\\baddiu\\b"))
			return new ISA_ADD_IU(line);
		else if(name.matches("\\baddu\\b"))
			return new ISA_ADD_U(line);
		else if(name.matches("\\band\\b"))
			return new ISA_AND(line);
		else if(name.matches("\\bandi\\b"))
			return new ISA_AND_I(line);
		else if(name.matches("\\bbeq\\b"))
			return new ISA_BRANCHEQ(line);
		else if(name.matches("\\bbne\\b"))
			return new ISA_BRANCHNE(line);
		else if(name.matches("\\bblt\\b"))
			return new ISA_BRANCHLT(line);
		else if(name.matches("\\bbgt\\b"))
			return new ISA_BRANCHGT(line);
		else if(name.matches("\\bble\\b"))
			return new ISA_BRANCHLE(line);
		else if(name.matches("\\bbge\\b"))
			return new ISA_BRANCHGE(line);
		else if(name.matches("\\bj\\b"))
			return new ISA_JUMP(line);
		else if(name.matches("\\bjal\\b"))
			return new ISA_JUMPANDLINK(line);
		else if(name.matches("\\bjr\\b"))
			return new ISA_JUMPREG(line);
		else if(name.matches("\\blbu\\b"))
			return new ISA_LOADBYTE_U(line);
		else if(name.matches("\\blhu\\b"))
			return new ISA_LOADHALF_U(line);
		else if(name.matches("\\bli\\b"))
			return new ISA_LOADIMM(line);
		else if(name.matches("\\blw\\b"))
			return new ISA_LOADWORD(line);
		else if(name.matches("\\bmove\\b"))
			return new ISA_MOVE(line);
		else if(name.matches("\\bnor\\b"))
			return new ISA_NOR(line);
		else if(name.matches("\\bor\\b"))
			return new ISA_OR(line);
		else if(name.matches("\\bori\\b"))
			return new ISA_OR_I(line);
		else if(name.matches("\\bslt\\b"))
			return new ISA_SETLESSTHAN(line);
		else if(name.matches("\\bslti\\b"))
			return new ISA_SETLESSTHAN_I(line);
		else if(name.matches("\\bsltiu\\b"))
			return new ISA_SETLESSTHAN_IU(line);
		else if(name.matches("\\bsltu\\b"))
			return new ISA_SETLESSTHAN_U(line);
		else if(name.matches("\\bsll\\b"))
			return new ISA_SHIFTLEFT_L(line);
		else if(name.matches("\\bslr\\b"))
			return new ISA_SHIFTRIGHT_L(line);
		else if(name.matches("\\bsb\\b"))
			return new ISA_STOREBYTE(line);
		else if(name.matches("\\bsh\\b"))
			return new ISA_STOREHALF(line);
		else if(name.matches("\\bsw\\b"))
			return new ISA_STOREWORD(line);
		else if(name.matches("\\bsub\\b"))
			return new ISA_SUB(line);
		else if(name.matches("\\bsubu\\b"))
			return new ISA_SUB_U(line);
		else if(name.matches("\\band\\b"))
			return new ISA_AND(line);
		else if(name.matches("\\bdiv\\b"))
			return new ISA_DIVIDE(line);
		else if(name.matches("\\bdivu\\b"))
			return new ISA_DIVIDE_U(line);
		else if(name.matches("\\bmfhi\\b"))
			return new ISA_MOVEFROMHI(line);
		else if(name.matches("\\bmflo\\b"))
			return new ISA_MOVEFROMLO(line);
		else if(name.matches("\\bmult\\b"))
			return new ISA_MULTIPLY(line);
		else if(name.matches("\\bmultu\\b"))
			return new ISA_MULTIPLY_U(line);
		else return null;
	}
}
