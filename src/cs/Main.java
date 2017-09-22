package cs;

import cs.gui.MIPSFrame;

public class Main
{
	public static void main(String[] args)
	{
		new Main();
	}
	
	MIPSFrame mainFrame;
	
	public Main()
	{
		mainFrame = new MIPSFrame();
		
		mainFrame.start();
	}
}
