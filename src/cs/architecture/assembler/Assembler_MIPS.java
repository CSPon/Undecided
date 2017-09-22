package cs.architecture.assembler;

import java.util.LinkedList;
import java.util.Map;

import cs.architecture.Architecture_MIPS;
import cs.architecture.Linker;
import cs.architecture.Loader;
import cs.instruction.ISA_INSTRUCTION;
import cs.opcode.ISA_LABEL;

public class Assembler_MIPS implements IAssembler
{
	@Override
	public void assemble(Loader loader, Linker linker, LinkedList<String> expressions)
	{
		int pc_pos = Architecture_MIPS.$pc;
		
		for(String expression : expressions)
		{
			String cleaned_expression = clean(expression);
			
			String[] parsed = cleaned_expression.split(":");
			
			// Check if label identifier is present
			if(parsed.length >= 2)
			{
				ISA_INSTRUCTION label = new ISA_LABEL(parsed[0]);
				label.setAddress_self(pc_pos);
				
				loader.architecture().symbolTable().put(pc_pos, label);
				loader.architecture().textTable().put(pc_pos, label);
				
				pc_pos += 0x04;
				
				String opcode = parsed[1].split(" ")[0];
				ISA_INSTRUCTION instruction = linker.getInstruction(opcode, cleaned_expression);
				instruction.setAddress_self(pc_pos);
				
				loader.architecture().textTable().put(pc_pos, instruction);
			}
			else
			{
				String opcode = parsed[0].split(" ")[0];
				ISA_INSTRUCTION instruction = linker.getInstruction(opcode, cleaned_expression);
				instruction.setAddress_self(pc_pos);
				
				loader.architecture().textTable().put(pc_pos, instruction);
			}
			
			pc_pos += 0x04;
		}
		
		linkSymbols(loader, linker);
		// TODO Assembling
	}
	
	@Override
	public void linkSymbols(Loader loader, Linker linker)
	{
		for(Map.Entry<Integer, ISA_INSTRUCTION> entry : loader.architecture().textTable().entrySet())
			entry.getValue().searchSymbol(loader.architecture(), entry.getValue().getLabel_target());
		// TODO Linking
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
