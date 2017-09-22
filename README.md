![image](https://raw.githubusercontent.com/CSPon/Undecided/master/imgs/Sample_000.png)

# Untitled (Overhaul in progress)

Untitled MIPS Simulator using JAVA

Planning on removing assemble & run so you can see step-by-step execution only.

Available function(s) (Checked and working ones only)

(Italics indicates not fully implemented but partially working)

__Currently going through overhaul__

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
* sra (sra $rd, $rt, shamt)
* blt (blt $rs, $rt, LABEL) __Deprecated__
* bgt (bgt $rs, $rt, LABEL) __Deprecated__
* ble (ble $rs, $rt, LABEL) __Deprecated__
* bge (bge $rs, $rt, LABEL) __Deprecated__
* li (blt $rd, imm) __Deprecated__
* move (move $rd, $rs) __Deprecated__
---

### To use

If you are using Eclipse IDE to run...

1. Use open menu to open a file with .mips extension

If you are running from executable (tested with Windows 10, Lubuntu 17.04)

1. Run Run_Jar.bat

I have no clue with Mac, so you have to run through Eclipse IDE

(Just import the whole repository as project)

Memory value can be changed via Memory.mem, under asm folder.

.mips is file extension for assembly code file

.mipsq is file extension for prompt file

.mem is file extension for memory preset file

---

### For Reference

Memory address must be assigned before using.

All possible registers are added.

__Does not fully simulate actual MIPS architecture; only simulates core instructions!__

__Does not simulate actual memory allocation!__

---

### To do

1. Implement $gp, $sp, $fp

2. Organize Routine and Architecture

3. Pseudocode parser

---

### For Future

1. Cycle counter (To see how many cycles it took to execute)

2. Pipeline Simulation (5 stages?)

3. ARM ISA

---

### Otherwise...

The heck am I doing in the middle of night.
