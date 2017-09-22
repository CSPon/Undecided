package cs.architecture.assembler;

import java.util.LinkedList;

import cs.architecture.Linker;
import cs.architecture.Loader;

public interface IAssembler
{
	public void assemble(Loader loader, Linker linker, LinkedList<String> expressions);
	
	public void linkSymbols(Loader loader, Linker linker);
}
