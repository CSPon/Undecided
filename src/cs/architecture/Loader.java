package cs.architecture;

public class Loader
{
	private IArchitecture arc;
	
	public Loader()
	{
		arc = new Architecture_MIPS();
	}
	
	public IArchitecture architecture()
	{
		return arc;
	}
}
