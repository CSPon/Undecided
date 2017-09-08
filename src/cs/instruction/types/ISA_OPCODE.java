package cs.instruction.types;

public abstract class ISA_OPCODE implements Instruction
{
	protected String REGS;
	protected String OPCODE;
	protected String INSTRUCTION;
	
	public ISA_OPCODE(String line)
	{
		INSTRUCTION = line;
	}
}
