package cs.architecture;

import java.util.LinkedList;

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
