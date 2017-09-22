package cs.opcode;

import cs.architecture.IArchitecture;
import cs.instruction.ISA_IType;

public class ISA_OR_I extends ISA_IType
{
	public ISA_OR_I(String line)
	{
		super(line);
		assign();
		
		setHex_opcode(0x0D);
		setFunct(0x00);
	}
	
	@Override
	public void assign()
	{
		String regs = getExpression().split(" ")[1];
		
		setOpcode(getExpression().split(" ")[0]);
		
		setRegister_rt(regs.split(",")[0]);
		setRegister_rs(regs.split(",")[1]);
		setImmediate(Integer.parseInt(regs.split(",")[2]));
	}

	@Override
	public void eval(IArchitecture arc)
	{
		int val_rs = arc.registers().getFrom(getRegister_rs());
		
		arc.registers().setTo(getRegister_rt(), val_rs | getImmediate());
	}
}
