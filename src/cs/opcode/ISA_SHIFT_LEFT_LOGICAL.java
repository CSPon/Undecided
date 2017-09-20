package cs.opcode;

import cs.architecture.AArchitecture;

public class ISA_SHIFT_LEFT_LOGICAL extends ISA_RType
{
	public ISA_SHIFT_LEFT_LOGICAL(String line)
	{
		super(line);
		assign();
		
		setHex_opcode(0x00);
		setFunct(0x00);
	}
	
	@Override
	public void assign()
	{
		String regs = getExpression().split(" ")[1];
		
		setOpcode(getExpression().split(" ")[0]);
		
		setRegister_rd(regs.split(",")[0]);
		setRegister_rt(regs.split(",")[1]);
		setShamt(Integer.parseInt(regs.split(",")[2]));
	}

	@Override
	public void eval(AArchitecture arc)
	{
		int val_rt = arc.registers().getFrom(getRegister_rt());
		int shamt = getShamt();
		
		arc.registers().setTo(getRegister_rd(), val_rt << shamt);
	}
}
