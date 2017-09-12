package cs;

import java.util.HashMap;

public class References
{
	private HashMap<String, String> references;
	
	public References()
	{
		references = new HashMap<String, String>();
		
		references.put("add", "add $d, $s, $t\n R-Type\n Adds $s and $t, then saves on $d");
		references.put("addi", "addi $t, $s, immediate\n I-Type\n Adds $s and immediate, then saves on $t");
		references.put("and", "and $d, $s, $t\n R-Type\n Compares bits on $s and $t, then saves on $d");
		references.put("and", "and $d, $s, $t\n R-Type\n Compares bits on $s and $t, then saves on $d");
		references.put("andi", "andi $t, $s, immediate\n I-Type\n Compares bits on $s and immediate,\n then saves on $t");
		
		references.put("beq", "beq $s, $t, LABEL\n I-Type\n If $s is equal to $t, jump to target LABEL");
		references.put("bne", "bne $s, $t, LABEL\n I-Type\n If $s is not equal to $t, jump to target LABEL");
		
		references.put("j", "j LABEL\n J-Type\n Jump to target LABEL");
		references.put("jal", "jal LABEL\n J-Type\n Jump to target LABEL.\n Current position + 1 is saved to $ra");
		references.put("jr", "jr $s\n R-Type\n Jump to $s value");
		
		references.put("lw", "lw $t, offset($s)\n I-Type\n Loads 32-bit word to $t, from memory address\n pointed by $s with offset");
		
		references.put("nor", "nor $d, $s, $t\n R-Type\n Performes $s | $t, then negates. Saves result to $d");
		references.put("or", "or $d, $s, $t\n R-Type\n Performes $s | $t. Saves result to $d");
		references.put("ori", "ori $t, $s, immediate\n I-Type\n Performes $s | immediate. Saves result to $t");
		
		references.put("slt", "slt $d, $s, $t\n R-Type\n Performs $s < $t. If true, $d becomes 1.\n If not, $d becomes 0");
		references.put("sli", "sli $t, $s, immediate\n I-Type\n Performs $s < immediate. If true, $d becomes 1.\n If not, $d becomes 0");
		
		references.put("sll", "sll $d, $t, shamt\n R-Type\n Performs bitwise $t << shamt. Saves result to $d");
		references.put("srl", "srl $d, $t, shamt\n R-Type\n Performs bitwise $t >> shamt. Saves result to $d");
		
		references.put("sw", "sw $t, offset($s)\n I-Type\n Saves $t to memory address pointed by $s, with offset");
		
		references.put("sub", "sub $d, $s, $t\n R-Type\n Performs $s - $t. Saves result to $d");
		
		references.put("div", "div $s, $t, $t\n R-Type\n Performs $s / $t. $LO register $s / $t,\n while $HI saves $s % $t");
		
		references.put("mfhi", "mfhi $d\n R-Type\n Moves value in $HI to $d");
		references.put("mflo", "mflo $d\n R-Type\n Moves value in $LO to $d");
		
		references.put("mult", "mult $s, $t\n R-Type\n Performs $s * $t.\n In case of 64-bit output, higher 32 bits are saved on $HI while lower 32 bits are saved\n on $LO");
		
		references.put("sra", "sra $d, $t, shamt\n R-Type\n Performes bitwise $t >> shamt. Any bit that got\n pushed out is moved to left side.\n Saves result to $d");
		
		references.put("blt", "blt $s, $t, LABEL\n Pseudoinstruction\n Performes $s < $t. If true, jumps to LABEL");
		references.put("bgt", "blt $s, $t, LABEL\n Pseudoinstruction\n Performes $s > $t. If true, jumps to LABEL");
		references.put("ble", "ble $s, $t, LABEL\n Pseudoinstruction\n Performes $s <= $t. If true, jumps to LABEL");
		references.put("bge", "bge $s, $t, LABEL\n Pseudoinstruction\n Performes $s >= $t. If true, jumps to LABEL");
		
		references.put("li", "li $d, immediate\n Pseudoinstruction\n Loads immediate to $d");
		references.put("move", "move $d, $s\n Pseudoinstruction\n Moves value in $s to $d");
	}
	
	public String getReference(String key)
	{
		return references.get(key);
	}
}
