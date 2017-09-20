package cs.architecture;

public class Loader
{
	private AArchitecture arc;
	
	public Loader()
	{
		arc = new Architecture_MIPS();
	}
	
	public AArchitecture architecture()
	{
		return arc;
	}
}
