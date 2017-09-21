package cs.architecture;

import java.util.LinkedList;

public interface IAssembler
{
	public void assemble(Loader loader, Linker linker, LinkedList<String> expressions);
}
