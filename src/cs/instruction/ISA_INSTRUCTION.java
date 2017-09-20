package cs.instruction;

import cs.architecture.AArchitecture;

public abstract class ISA_INSTRUCTION implements Instruction
{
	private String expression;
	private String opcode;
	private String register_rs;
	private String register_rt;
	private String register_rd;
	private int shamt;
	private int immediate;
	private int funct;
	
	private String label_self;
	private String label_target;
	
	private int address_self;
	private int address_target;
	
	private int hex_opcode;
	
	private int cycle_count;
	
	public ISA_INSTRUCTION(String _expression)
	{
		expression = _expression;
		
		opcode = "0x00";
		
		register_rs = "";
		register_rt = "";
		register_rd = "";
		
		shamt = 0;
		immediate = 0;
		funct = 0;
		
		hex_opcode = 0x00;
		
		cycle_count = 1;
	}
	
	public abstract void eval(AArchitecture arc);
	public abstract void assign();

	public String getExpression() {
		return expression;
	}
	public void setExpression(String expression) {
		this.expression = expression;
	}
	public String getOpcode() {
		return opcode;
	}
	public void setOpcode(String opcode) {
		this.opcode = opcode;
	}
	public String getRegister_rs() {
		return register_rs;
	}
	public void setRegister_rs(String register_rs) {
		this.register_rs = register_rs;
	}
	public String getRegister_rt() {
		return register_rt;
	}
	public void setRegister_rt(String register_rt) {
		this.register_rt = register_rt;
	}
	public String getRegister_rd() {
		return register_rd;
	}
	public void setRegister_rd(String register_rd) {
		this.register_rd = register_rd;
	}
	public int getShamt() {
		return shamt;
	}
	public void setShamt(int shamt) {
		this.shamt = shamt;
	}
	public int getImmediate() {
		return immediate;
	}
	public void setImmediate(int immediate) {
		this.immediate = immediate;
	}
	public int getFunct() {
		return funct;
	}
	public void setFunct(int funct) {
		this.funct = funct;
	}
	public String getLabel_self() {
		return label_self;
	}
	public void setLabel_self(String label_self) {
		this.label_self = label_self;
	}
	public String getLabel_target() {
		return label_target;
	}
	public void setLabel_target(String label_target) {
		this.label_target = label_target;
	}
	public int getAddress_self() {
		return address_self;
	}
	public void setAddress_self(int address_self) {
		this.address_self = address_self;
	}
	public int getAddress_target() {
		return address_target;
	}
	public void setAddress_target(int address_target) {
		this.address_target = address_target;
	}

	public int getHex_opcode() {
		return hex_opcode;
	}
	public void setHex_opcode(int hex_opcode) {
		this.hex_opcode = hex_opcode;
	}
	public int getCycle_count() {
		return cycle_count;
	}
	public void setCycle_count(int cycle_count) {
		this.cycle_count = cycle_count;
	}
	
	@Override
	public int checkShift(String reg)
	{
		if(!reg.startsWith("$"))
		{
			int shift = Integer.parseInt(reg.substring(0, reg.indexOf("(")));
			shift /= 4;
			return shift;
		}
		return 0;
	}

	@Override
	public String checkReg(String reg)
	{
		if(!reg.startsWith("$"))
		{
			reg = reg.substring(reg.indexOf("$"), reg.indexOf(")"));
			return reg;
		}
		return reg;
	}
}
