package cs.architecture;

import java.util.LinkedHashMap;

import cs.architecture.registers.Registers;
import cs.instruction.ISA_INSTRUCTION;

public interface IArchitecture
{
	public Registers registers();
	public Memory memory();
	
	public LinkedHashMap<Integer, ISA_INSTRUCTION> symbolTable();
	public LinkedHashMap<Integer, ISA_INSTRUCTION> textTable();
}
