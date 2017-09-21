package cs.opcode;

import cs.architecture.IArchitecture;
import cs.instruction.ISA_INSTRUCTION;

public class ISA_LABEL extends ISA_INSTRUCTION
{
	public ISA_LABEL(String expression)
	{
		super(expression);
	}

	@Override
	public String toString(IArchitecture arc)
	{
		return String.format("0x%08X", getAddress_self());
	}

	@Override
	public void eval(IArchitecture arc)
	{
		// Label has nothing to do
	}

	@Override
	public void assign()
	{
		// Parses label
		// Note that ISA_LABEL takes label name and saves to OPCODE
		setOpcode(getExpression().split(":")[0]);
	}
}
