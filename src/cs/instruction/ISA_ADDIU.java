package cs.instruction;

import cs.architecture.Internal;
import cs.instruction.types.ISA_IType;

public class ISA_ADDIU extends ISA_IType
{
	public ISA_ADDIU(String line)
	{
		super(line);
		parseFull();
		parseReg();
	}

	@Override
	public void parseReg()
	{
		// TODO Convert to unsigned val
	}

	@Override
	public void perform(Internal internal)
	{
		internal.setTo(RT, internal.getFrom(RS));
	}

}
