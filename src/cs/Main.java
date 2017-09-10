package cs;

import cs.architecture.Internal;
import cs.routine.Routine;

public class Main
{
	public static void main(String[] args)
	{	
		Internal internal = new Internal();
		Routine routine = new Routine(internal);
		
		Parser parser = new Parser();
		parser.parse("asm/Test.mips", routine);
		
		internal.setToMem(0x00, 0, 2);
		internal.setToMem(0x01, 0, 1024);
		internal.setTo("$s0", 0x00);
		internal.setTo("$s1", 0x01);
		
		routine.execute();
		
		printBinary(internal.getFrom("$t0"));
		System.out.println(" " + internal.getFrom("$t0"));
		
		printBinary(internal.getFrom("$t1"));
		System.out.println(" " + internal.getFrom("$t1"));
		
		printBinary(internal.getFrom("$t2"));
		System.out.println(" " + internal.getFrom("$t2"));
		
		printBinary(internal.getFrom("$t3"));
		System.out.println(" " + internal.getFrom("$t3"));
	}
	
	public static void printBinary(int val)
	{
		String t = String.format("%32s", Integer.toBinaryString(val)).replace(' ', '0');
		System.out.print(t);
	}
	
	public static void printlnBinary(int val)
	{
		String t = String.format("%32s", Integer.toBinaryString(val)).replace(' ', '0');
		System.out.println(t);
	}
}
