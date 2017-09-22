package cs.opcode;

import cs.architecture.IArchitecture;
import cs.instruction.ISA_RType;

public class ISA_MOVE extends ISA_RType
{
	public ISA_MOVE(String line)
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
		
		setRegister_rs(regs.split(",")[0]);
		setRegister_rt(regs.split(",")[1]);
	}

	@Override
	public void eval(IArchitecture arc)
	{
		// TODO Generate add $rs, $rt, $zero and eval
	}
}
