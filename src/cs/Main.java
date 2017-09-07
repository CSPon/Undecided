package cs;

import cs.instruction.ISA_ADD;
import cs.instruction.Internal;

public class Main
{
	public static void main(String[] args)
	{
		Internal internal = new Internal();
		
		ISA_ADD test = new ISA_ADD("$s0,$t0,$t1");
		
		test.parse();
		internal.setTo("$t0", 1);
		internal.setTo("$t1", 2);
		test.perform(internal);
		System.out.println(internal.getFrom("$s0"));
	}
}
