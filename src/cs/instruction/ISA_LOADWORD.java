package cs.instruction;

import cs.architecture.Internal;
import cs.instruction.types.ISA_IType;

public class ISA_LOADWORD extends ISA_IType
{

	@Override
	public void parse()
	{
	}

	@Override
	public void perform(Internal internal)
	{
		internal.setTo(rt, val);
	}
}
