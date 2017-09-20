package cs.architecture;

import java.util.LinkedHashMap;

import cs.instruction.*;
import cs.instruction.types.ISA_OPCODE;
import cs.opcode.ISA_ADD;
import cs.opcode.ISA_ADD_I;
import cs.opcode.ISA_ADD_IU;
import cs.opcode.ISA_ADD_U;
import cs.opcode.ISA_AND;
import cs.opcode.ISA_AND_I;
import cs.opcode.ISA_BRANCHEQ;
import cs.opcode.ISA_BRANCHGE;
import cs.opcode.ISA_BRANCHGT;
import cs.opcode.ISA_BRANCHLE;
import cs.opcode.ISA_BRANCHLT;
import cs.opcode.ISA_BRANCHNE;
import cs.opcode.ISA_DIVIDE;
import cs.opcode.ISA_DIVIDE_U;
import cs.opcode.ISA_JUMP;
import cs.opcode.ISA_JUMPANDLINK;
import cs.opcode.ISA_JUMPREG;
import cs.opcode.ISA_LOADBYTE_U;
import cs.opcode.ISA_LOADHALF_U;
import cs.opcode.ISA_LOADIMM;
import cs.opcode.ISA_LOADUPPER_I;
import cs.opcode.ISA_LOADWORD;
import cs.opcode.ISA_MOVE;
import cs.opcode.ISA_MOVEFROMHI;
import cs.opcode.ISA_MOVEFROMLO;
import cs.opcode.ISA_MULTIPLY;
import cs.opcode.ISA_MULTIPLY_U;
import cs.opcode.ISA_NOR;
import cs.opcode.ISA_OR;
import cs.opcode.ISA_OR_I;
import cs.opcode.ISA_SETLESSTHAN;
import cs.opcode.ISA_SETLESSTHAN_I;
import cs.opcode.ISA_SETLESSTHAN_IU;
import cs.opcode.ISA_SETLESSTHAN_U;
import cs.opcode.ISA_SHIFTLEFT_L;
import cs.opcode.ISA_SHIFTRIGHT_L;
import cs.opcode.ISA_STOREBYTE;
import cs.opcode.ISA_STOREHALF;
import cs.opcode.ISA_STOREWORD;
import cs.opcode.ISA_SUB;
import cs.opcode.ISA_SUB_U;

public class Internal
{
	private Architecture arc;
	
	public Internal()
	{
		this.arc = new Architecture();
	}
	
	public boolean hasSymbol(String LABEL)
	{
		return arc.hasSymbol(LABEL);
	}
	
	public int getSymbolAddress(String LABEL)
	{
		return arc.getSymbolAddress(LABEL);
	}
	
	public LinkedHashMap<String, Integer> getSymbolTable()
	{
		return arc.getSymbolTable();
	}
	
	public void addSymbol(String LABEL, int ADDRESS)
	{
		arc.addSymbol(LABEL, ADDRESS);
	}
	
	public LinkedHashMap<Integer, Integer> getRegisterVals()
	{
		return arc.getRegisterVals();
	}
	
	public LinkedHashMap<String, Integer> getRegisterAddrs()
	{
		return arc.getRegisterAddrs();
	}
	
	public LinkedHashMap<Integer, Integer> getMemory()
	{
		return arc.getMemory();
	}
	
	public void resetMemory()
	{
		arc.resetMemory();
	}
	
	public void resetRegisters()
	{
		arc.resetRegisters();
	}
	
	public int getAddress(String reg)
	{
		return arc.getAddress(reg);
	}
	
	/**
	 * Returns current Program Counter
	 * @return
	 */
	public int getPC()
	{
		return arc.getPC();
	}
	
	public void setPC(int addr)
	{
		arc.setPC(addr);
	}
	
	public int getRegisterVal(String reg)
	{
		return arc.getRegisterVal(reg);
	}
	
	public String getRegisterValHex(String reg)
	{
		return Integer.toHexString(arc.getRegisterVal(reg));
	}
	
	public int getRegisterAddr(String reg)
	{
		return arc.getRegisterAddress(reg);
	}
	
	public String getRegisterAddrHex(String reg)
	{
		return Integer.toHexString(arc.getRegisterAddress(reg));
	}
	
	public void setRegisterVal(String reg, int val)
	{
		arc.setRegisterVal(reg, val);
	}
	
	public int getMemoryVal(int addr, int offset)
	{
		return arc.getMemoryVal(addr, offset);
	}
	
	public void setMemoryVal(int addr, int offset, int val)
	{
		arc.setMemoryVal(addr, offset, val);
	}
	
	public int getFrom(String NAME)
	{
		if(NAME.startsWith("$"))
		{
			if(NAME.contains("ZERO"))
				return arc.getZero();
			else if(NAME.contains("hi"))
				return arc.getHI();
			else if(NAME.contains("lo"))
				return arc.getLO();
			else
				return arc.getRegisterVal(NAME);
		}
		return -1;
	}
	
	public void setTo(String NAME, int val)
	{
		if(NAME.startsWith("$"))
		{
			if(NAME.contains("hi"))
				arc.setHI(val);
			else if(NAME.contains("lo"))
				arc.setLO(val);
			else
				arc.setRegisterVal(NAME, val);
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
		String[] parsed = line.split(":");
		
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
		else if(name.matches("\\blui\\b"))
			return new ISA_LOADUPPER_I(line);
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
