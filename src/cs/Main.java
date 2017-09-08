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
		
		System.out.println(internal.getFrom("$t0"));
		System.out.println(internal.getFrom("$t1"));
		System.out.println(internal.getFrom("$t2"));
		
		internal.setToMem(0x00, 4, 999);
		internal.setTo("$s0", 0x00);
		
		ISA_LOADWORD lw = new ISA_LOADWORD("LW $t0, 16($s0)"); lw.perform(internal);
		lw = new ISA_LOADWORD("LW $t1, 16($s0)"); lw.perform(internal);
		ISA_STOREWORD sw = new ISA_STOREWORD("SW $t0, $s0"); sw.perform(internal);
		ISA_ADD add = new ISA_ADD("ADD $t2, $t1, $t0"); add.perform(internal);
		ISA_ADDI addi = new ISA_ADDI("ADDI $t2, $t2, -10"); addi.perform(internal);
		
		System.out.println(internal.getFrom("$t0"));
		System.out.println(internal.getFrom("$t1"));
		System.out.println(internal.getFrom("$t2"));
	}
}
