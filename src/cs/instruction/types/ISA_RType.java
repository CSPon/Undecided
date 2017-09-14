package cs.instruction.types;

import cs.architecture.Internal;

public abstract class ISA_RType extends ISA_OPCODE
{
	public ISA_RType(String line)
	{
		super(line);
	}
	
	@Override
	public void parseFull()
	{
		OPCODE = INSTRUCTION.split(" ")[0];
		REGS = INSTRUCTION.substring(INSTRUCTION.indexOf(" ") + 1);
		REGS = REGS.replaceAll(" ", "");
	}
	
	@Override
	public void parseReg()
	{
		String[] parsed = REGS.split(",");
		SHAMT = 0;
		FUNCT = "0";
		
		RD = checkReg(parsed[0]);
		RS = checkReg(parsed[1]);
		RT = checkReg(parsed[2]);
	}
	
	@Override
	public String toString(Internal internal)
	{
		int HEX = 0x00;
		HEX |= HEX_OPCODE; HEX = HEX << 6;
		if(RS.isEmpty())
		{
			HEX |= 0x00; HEX = HEX << 5;
		}
		else
		{
			HEX |= internal.getRegisterAddr(RS); HEX = HEX << 5;
		}
		if(RT.isEmpty())
		{
			HEX |= 0x00; HEX = HEX << 5;
		}
		else
		{
			HEX |= internal.getRegisterAddr(RT); HEX = HEX << 5;
		}
		if(RD.isEmpty())
		{
			HEX |= 0x00; HEX = HEX << 5;			
		}
		else
		{
			HEX |= internal.getRegisterAddr(RD); HEX = HEX << 5;
		}
		HEX |= SHAMT; HEX = HEX << 5;
		HEX |= HEX_FUNCT;
		
		return String.format("0x%08X", HEX);
	}

	@Override
	public abstract void perform(Internal internal);
}
