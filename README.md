# Untitled

Untitled MIPS Simulator using JAVA

Available function(s) (Checked and working ones only)

(Italics indicates not fully implemented but partially working)

---

* add (add $rs, $rt, $rd)
* addi (addi $rs, $rt, imm)
* _addiu_
* _addu_
* and (and $rd, $rs, $rt)
* andi (andi $rt, $rs, imm)
* beq (beq $rs, $st, LABEL)
* bne (bne $rs, $st, LABEL)
* j (j LABEL)
* jal (jal LABEL)
* jr (jr $rs)
* lbu (lbu $rt, offset($rs))
* lhu (lhu $rt, offset($rs))
* lw (lw $rt, offset($rs))
* nor (nor $rd, $rs, $rt)
* or (or $rd, $rs, $rt)
* ori (ori $rs, $rt, imm)
* slt (slt $rd, $rs, $rt)
* slti (slti $rt, $rs, imm)
* _sltiu_
* _sltu_
* sll (sll $rd, $rt, shamt)
* srl (srl $rd, $rt, shamt)
* sb (sb $rt, offset($rs))
* sh (sh $rt, offset($rs))
* sw (sw $rt, offset($rs))
* sub (sub $rd, $rs, $rt)
* _subu_
* div (div $s, $t)
* _divu_
* mfhi (mfhi $d)
* mflo (mflo $d)
* mult (mult $s, $t)
* _multu_
* blt (blt $rs, $rt, LABEL)
* bgt (bgt $rs, $rt, LABEL)
* ble (ble $rs, $rt, LABEL)
* bge (bge $rs, $rt, LABEL)
* li (blt $rd, imm)
* move (move $rd, $rs)
---

### To use

1. Add file to asm folder with file extesion of .mips   
(Only Test.mips works at this point; will add function to allow read in all .mips files)

2. Run Main.java

---

### For Reference

Memory address from 0x00 to 0xFF

All possible registers are added.

__Does not fully simulate actual MIPS architecture; only simulates core instructions!__

__Does not simulate actual memory allocation!__

---

### To do

1. More Instructions!
2. Add Memory Modifier
3. Add program arguments
