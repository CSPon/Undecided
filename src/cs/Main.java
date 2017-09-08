package cs;

import cs.architecture.Internal;
import cs.instruction.ISA_ADD;
import cs.instruction.ISA_ADDI;
import cs.instruction.ISA_LOADWORD;
import cs.instruction.ISA_STOREWORD;

public class Main
{
	public static void main(String[] args)
	{
		Internal internal = new Internal();
		
		internal.setTo("$s0", 4, 10);
		internal.setTo("$s1", 4, 15);
		
		ISA_LOADWORD lw = new ISA_LOADWORD("LW $t0, 16($s0)"); lw.perform(internal);
		lw = new ISA_LOADWORD("LW $t1, 16($s1)"); lw.perform(internal);
		ISA_ADD add = new ISA_ADD("ADD $t2, $t0, $t1"); add.perform(internal);
		ISA_ADDI addi = new ISA_ADDI("ADDI $t2, $t2, 15"); addi.perform(internal);
		ISA_STOREWORD sw = new ISA_STOREWORD("SW $t3, $t2"); sw.perform(internal);
		
		System.out.println(internal.getFrom("$t3", 0));
	}
}
