package cs;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineFactory;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

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
		gui.updateRegisterViewer();
		
		Main main = new Main();
	}
	
	int rs = 1;
	int rt = 2;
	int rd = 0;
	
	Something anObject;
	
	public int getFrom(String target)
	{
		if(target.equals("rs"))
			return rs;
		else if(target.equals("rt"))
			return rt;
		else return 0;
	}
	
	public void setTo(String target, int val)
	{
		if(target.equals("rd"))
			rd = val;
	}
	
	
	public void add(int a, int b)
	{
		System.out.println((a + b));
	}
	
	public Main()
	{
		anObject = new Something();
		
		try
		{
			ScriptEngineManager sem = new ScriptEngineManager();
			ScriptEngine engine = sem.getEngineByName("JavaScript");
			engine.put("main", this);
			engine.put("rs", rs);
			engine.put("anObject", anObject);
			
			ScriptEngineFactory sef = engine.getFactory();
			String command = sef.getMethodCallSyntax("anObject", "printSomething", new String[0]);
			System.out.println(command);
			engine.eval(command);
		}
		catch (ScriptException e)
		{
			e.printStackTrace();
		}
	}
	
	class Something
	{
		public void printSomething()
		{
			System.out.println("Hello!");
		}
	}
}
