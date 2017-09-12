package cs;

import cs.architecture.Internal;
import cs.gui.MIPSFrame;
import cs.routine.Routine;

public class Main
{
	public static void main(String[] args)
	{
		Internal internal = new Internal();
		Routine routine = new Routine(internal);
		Parser parser = new Parser();
		
		MIPSFrame gui = new MIPSFrame(internal, routine, parser);
		gui.init(); gui.start();
		
		gui.updateMemoryList();
	}
}
