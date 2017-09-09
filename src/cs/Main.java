package cs;

import cs.architecture.Internal;
import cs.routine.SubRoutine;

public class Main
{
	public static void main(String[] args)
	{
		Internal internal = new Internal();
		
		internal.setToMem(0x00, 0, 2);
		internal.setToMem(0x01, 0, 1024);
		internal.setTo("$s0", 0x00);
		internal.setTo("$s1", 0x01);
		
		SubRoutine routine = new SubRoutine("Main", 0);
		
		routine.addInstruction(internal, "	lw		$t0, $s0");
		routine.addInstruction(internal, "	lw		$t1, $s1");
		routine.addInstruction(internal, "	slti	$t2, $t1, 4096");
		
		routine.execute(internal);
		
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
