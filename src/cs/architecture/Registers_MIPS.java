package cs.architecture;

public class Registers_MIPS extends Registers
{
	public Registers_MIPS()
	{
		super();
		resetAll();
	}

	@Override
	public void resetAll()
	{
		super.resetAll();
		setAddress("$zero", 0);
		
		setAddress("$at", 1);
		
		setAddress("$v0", 2);
		setAddress("$v1", 3);
		
		setAddress("$a0", 4);
		setAddress("$a1", 5);
		setAddress("$a2", 6);
		setAddress("$a3", 7);
		
		setAddress("$t0", 8);
		setAddress("$t1", 9);
		setAddress("$t2", 10);
		setAddress("$t3", 11);
		setAddress("$t4", 12);
		setAddress("$t5", 13);
		setAddress("$t6", 14);
		setAddress("$t7", 15);
		
		setAddress("$s0", 16);
		setAddress("$s1", 17);
		setAddress("$s2", 18);
		setAddress("$s3", 19);
		setAddress("$s4", 20);
		setAddress("$s5", 21);
		setAddress("$s6", 22);
		setAddress("$s7", 23);
		
		setAddress("$t8", 24);
		setAddress("$t9", 25);
		
		setAddress("$k0", 26);
		setAddress("$k1", 27);
		
		setAddress("$gp", 28);
		setAddress("$sp", 29);
		setAddress("$fp", 30);
		setAddress("$ra", 31);
		
		setAddress("$pc", 32);
		setAddress("$hi", 33);
		setAddress("$lo", 33);
	}
}
