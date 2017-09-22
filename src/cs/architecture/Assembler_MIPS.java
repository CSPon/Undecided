package cs.architecture;

import java.util.LinkedList;

// Timestamp testing
public class Assembler_MIPS implements IAssembler
{
	@Override
	public void assemble(Loader loader, Linker linker, LinkedList<String> expressions)
	{
		for(String expression : expressions)
		{
			
		}
		// TODO assembling
	}
	
	private String clean(String expression)
	{
		String cleaned = "";
		// Trim string
		cleaned = expression.trim();
		// Replace all whitespaces into single whitespace
		cleaned = cleaned.replaceAll("\\s{1,}", " ");
		// Clean all comma separated values
		cleaned = cleaned.replaceAll(", ", ",");
		return cleaned;
	}
}
