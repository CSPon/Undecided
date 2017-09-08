package cs.instruction;

import cs.architecture.Internal;
import cs.instruction.types.ISA_RType;

public class ISA_ADD extends ISA_RType
{	
	public ISA_ADD(String line)
	{
		this.line = line;
	}
	
	@Override
	public void parse()
	{
		// OPCODE has been parsed
		line = line.replace(" ", "");
		String[] parsed = line.split(",");
		rd = parsed[0];
		rs = parsed[1];
		rt = parsed[2];
		if(parsed.length > 3)
		{
			shamt = parsed[3];
			funct = parsed[4];
		}
	}
	
	@Override
	public void perform(Internal internal)
	{
		int _rs = internal.getFrom(rs);
		int _rt = internal.getFrom(rt);
		internal.setTo(rd, (_rs + _rt));
	}
}
