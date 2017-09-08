package cs.instruction;

import cs.architecture.Internal;
import cs.instruction.types.ISA_IType;

public class ISA_ADDI extends ISA_IType
{
	public ISA_ADDI(String line)
	{
		this.line = line;
	}

	@Override
	public void parse()
	{
		// OPCODE has been parsed
		line = line.replace(" ", "");
		String[] parsed = line.split(",");
		rt = parsed[0];
		rs = parsed[1];
		immediate = parsed[2];
	}

	@Override
	public void perform(Internal internal)
	{
		internal.setTo(rt, internal.getFrom(rt) + Integer.parseInt(immediate));
	}

}
