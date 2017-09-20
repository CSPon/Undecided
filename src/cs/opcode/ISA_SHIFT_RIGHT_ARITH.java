package cs.opcode;

import cs.architecture.AArchitecture;

public class ISA_SHIFT_RIGHT_ARITH extends ISA_RType
{
	public ISA_SHIFT_RIGHT_ARITH(String line)
	{
		super(line);
		assign();
		
		setHex_opcode(0x00);
		setFunct(0x03);
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
		// Copy bottom (32 - SHAMT) bits to separate variable
		// Shift RT to right by SHAMT
		// Mask saved bits to RT
		// Save to RD
		
		// 1001 0101 1010 1100
		// 1100 1001 0101 1010
		
		int val_rt = arc.registers().getFrom(getRegister_rt());
		int shamt = getShamt();
		
		int temp = val_rt << (32 - shamt);
		int _rt = val_rt >> shamt;
		
		arc.registers().setTo(getRegister_rd(), temp | _rt);
	}
}
