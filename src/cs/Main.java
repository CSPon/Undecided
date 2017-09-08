package cs;

import cs.architecture.Internal;
import cs.instruction.ISA_ADD;
import cs.instruction.ISA_ADDI;

public class Main
{
	public static void main(String[] args)
	{
		Internal internal = new Internal();
		
		ISA_ADDI test = new ISA_ADDI("$s0, $t0, 15");
		
		test.parse();
		test.perform(internal);
		System.out.println(internal.getFrom("$s0"));
	}
}
