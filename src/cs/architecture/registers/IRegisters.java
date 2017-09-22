package cs.architecture.registers;

public interface IRegisters
{
	public void resetAll();
	public int getFrom(String register_name);
	public int setTo(String register_name, int data);
	public int getAddress(String register_name);
	public int setAddress(String register_name, int new_address);
}
