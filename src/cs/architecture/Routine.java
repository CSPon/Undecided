package cs.architecture;

public class Routine
{
	private Linker linker;
	private Loader loader;
	private IAssembler asm;
	
	public Routine()
	{
		linker = new Linker();
		loader = new Loader();
		asm = new Assembler_MIPS();
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
}
