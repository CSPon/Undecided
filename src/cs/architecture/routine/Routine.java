package cs.architecture.routine;

import java.util.LinkedList;

import cs.architecture.Linker;
import cs.architecture.Loader;
import cs.architecture.assembler.Assembler_MIPS;
import cs.architecture.assembler.IAssembler;

public class Routine
{
	private Linker linker;
	private Loader loader;
	private IAssembler asm;
	
	private LinkedList<String> expressions;
	
	public Routine()
	{
		linker = new Linker();
		loader = new Loader();
		asm = new Assembler_MIPS();
	}
	
	public void addExpression(String expression)
	{
		expressions.addLast(expression);
	}
	
	public Linker getLinker()
	{
		return linker;
	}
	
	public Loader getLoader()
	{
		return loader;
	}
	
	public IAssembler asm()
	{
		return asm;
	}
	
	public void assemble()
	{
		asm.assemble(loader, linker, expressions);
	}
}
