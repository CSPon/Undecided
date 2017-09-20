package cs.opcode;

import cs.architecture.AArchitecture;

public class ISA_LOAD_UPPER_I extends ISA_IType
{
	public ISA_LOAD_UPPER_I(String expression)
	{
		super(expression);
		assign();
		
		setHex_opcode(0x0F);
		setFunct(0x00);
	}
	
	@Override
	public void assign()
	{
		String regs = getExpression().split(" ")[1];
		
		setOpcode(getExpression().split(" ")[0]);
		
		setRegister_rt(regs.split(",")[0]);
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
		int imm = getImmediate() << 16;
		arc.registers().setTo(getRegister_rt(), imm);
	}
}
