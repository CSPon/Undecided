package cs.architecture;

public class Loader
{
	private Architecture arc;
	
	public Loader()
	{
		arc = new Architecture_MIPS();
	}
	
	public Architecture architecture()
	{
		return arc;
	}
}
