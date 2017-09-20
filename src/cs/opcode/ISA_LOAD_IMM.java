package cs.opcode;

import cs.architecture.AArchitecture;
import cs.architecture.Architecture_MIPS;
import cs.architecture.Internal;
import cs.instruction.ISA_OPCODE;

public class ISA_LOAD_IMM extends ISA_IType
{
	public ISA_LOAD_IMM(String line)
	{
		super(line);
		assign();

		setHex_opcode(0xFF);
		setFunct(0xFF);
	}
	
	@Override
	public void assign()
	{
		String regs = getExpression().split(" ")[1];
		
		setOpcode(getExpression().split(" ")[0]);
		
		setRegister_rd(regs.split(",")[0]);
		if(regs.split(",")[1].startsWith("0x"))
		{
			String val = regs.split(",")[1].replaceAll("0x", "");
			setImmediate((int) Long.parseLong(val, 16));
		}
		else setImmediate(Integer.parseInt(regs.split(",")[1]));
	}

	@Override
	public void eval(AArchitecture arc)
	{
		int upper = (getImmediate() & Architecture_MIPS.$UPPER_16) >> 16;
		int lower = (getImmediate() & Architecture_MIPS.$LOWER_16);
		
		// TODO Generate lui $rd, upper and eval
		// TODO generate ori $rd, $rd, lower and eval
	}
}
