/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs.gui;

import java.io.File;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Map;

import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import cs.Parser;
import cs.References;
import cs.architecture.Internal;
import cs.instruction.types.ISA_OPCODE;
import cs.routine.Routine;

/**
 *
 * @author Charlie S.
 */
public class MIPSFrame extends javax.swing.JFrame {

	private static final long serialVersionUID = 1L;
	
	private Internal internal;
	private Routine routine;
	private Parser parser;
	private References refs;
	
    public MIPSFrame(Internal _internal, Routine _routine, Parser _parser)
    {
    	internal = _internal;
    	routine = _routine;
    	parser = _parser;
    	refs = new References();
        initComponents();
    }
                        
    private void initComponents()
    {

        instChooser = new javax.swing.JFileChooser();
        saveChooser = new javax.swing.JFileChooser();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textAreaPrompt = new javax.swing.JTextArea();
        jSplitPane2 = new javax.swing.JSplitPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        textAreaInsturction = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jSplitPane1 = new javax.swing.JSplitPane();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        listMemory = new javax.swing.JList<>();
        jSplitPane4 = new javax.swing.JSplitPane();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        listRegister = new javax.swing.JList<>();
        jSplitPane6 = new javax.swing.JSplitPane();
        jLabel5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        fieldPC = new javax.swing.JTextField();
        fieldHI = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        fieldLO = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        fieldAT = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        fieldRA = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        buttonCompileOnly = new javax.swing.JButton();
        buttonRun = new javax.swing.JButton();
        buttonStep = new javax.swing.JButton();
        buttonStop = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        textAreaCompilerWindow = new javax.swing.JTextArea();
        jSplitPane3 = new javax.swing.JSplitPane();
        jLabel14 = new javax.swing.JLabel();
        jSplitPane7 = new javax.swing.JSplitPane();
        jScrollPane5 = new javax.swing.JScrollPane();
        listPCAddress = new javax.swing.JList<>();
        jScrollPane8 = new javax.swing.JScrollPane();
        listOPCODE = new javax.swing.JList<>();
        jSplitPane8 = new javax.swing.JSplitPane();
        jLabel15 = new javax.swing.JLabel();
        jSplitPane9 = new javax.swing.JSplitPane();
        jScrollPane9 = new javax.swing.JScrollPane();
        listOPCODEs = new javax.swing.JList<>();
        jScrollPane10 = new javax.swing.JScrollPane();
        textAreaReference = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuSave = new javax.swing.JMenuItem();
        menuLoadInstFile = new javax.swing.JMenuItem();
        menuLoadMemory = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        menuLoadCustomQuestion = new javax.swing.JMenuItem();
        menuLoadQ0 = new javax.swing.JMenuItem();
        menuLoadQ1 = new javax.swing.JMenuItem();
        menuLoadQ2 = new javax.swing.JMenuItem();
        menuLoadQ3 = new javax.swing.JMenuItem();
        menuLoadQ4 = new javax.swing.JMenuItem();
        menuLoadQ5 = new javax.swing.JMenuItem();
        menuLoadQ6 = new javax.swing.JMenuItem();
        menuLoadQ7 = new javax.swing.JMenuItem();
        menuLoadQ8 = new javax.swing.JMenuItem();
        menuLoadQ9 = new javax.swing.JMenuItem();
        menuLoadQ10 = new javax.swing.JMenuItem();

        instChooser.setCurrentDirectory(new java.io.File("C:\\Program Files\\NetBeans 8.2"));

        saveChooser.setDialogType(javax.swing.JFileChooser.SAVE_DIALOG);
        saveChooser.setCurrentDirectory(new java.io.File("C:\\Program Files\\NetBeans 8.2"));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MIPS Simulator (WIP)");
        setMinimumSize(new java.awt.Dimension(1024, 768));
        setResizable(false);

        jLabel1.setText("Prompt");

        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        textAreaPrompt.setEditable(false);
        textAreaPrompt.setColumns(20);
        textAreaPrompt.setLineWrap(true);
        textAreaPrompt.setRows(5);
        jScrollPane1.setViewportView(textAreaPrompt);

        jSplitPane2.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        textAreaInsturction.setColumns(20);
        textAreaInsturction.setRows(5);
        jScrollPane2.setViewportView(textAreaInsturction);

        jSplitPane2.setBottomComponent(jScrollPane2);

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Instruction Editor");
        jSplitPane2.setLeftComponent(jLabel4);

        jSplitPane1.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Memory Viewer");
        jSplitPane1.setTopComponent(jLabel2);

        listMemory.setFont(new java.awt.Font("Monospaced", 0, 11)); // NOI18N
        jScrollPane4.setViewportView(listMemory);

        jSplitPane1.setRightComponent(jScrollPane4);

        jSplitPane4.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Register Viewer");
        jSplitPane4.setTopComponent(jLabel3);

        listRegister.setFont(new java.awt.Font("Monospaced", 0, 11)); // NOI18N
        listRegister.setModel(new javax.swing.AbstractListModel<String>() {
			private static final long serialVersionUID = 1L;
			String[] strings = { "$zero", "$at", "$v0", "$v1", "$a0", "$a1", "$a2", "$a3", "$t0", "$t1", "$t2", "$t3", "$t4", "$t5", "$t6", "$t7", "$s0", "$s1", "$s2", "$s3", "$s4", "$s5", "$s6", "$s7", "$t8", "$t9", "$k0", "$k1", "$gp", "$sp", "$fp", "$ra" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        listRegister.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane3.setViewportView(listRegister);

        jSplitPane4.setRightComponent(jScrollPane3);

        jSplitPane6.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Debugger");
        jSplitPane6.setTopComponent(jLabel5);

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("PC");

        fieldPC.setEditable(false);

        fieldHI.setEditable(false);

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("HI");

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Registers");

        fieldLO.setEditable(false);

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("LO");

        fieldAT.setEditable(false);

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("$at");

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("$ra");

        fieldRA.setEditable(false);

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Compiler/Debugger");

        buttonCompileOnly.setText("Compile Only");
        buttonCompileOnly.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCompileOnlyActionPerformed(evt);
            }
        });

        buttonRun.setText("Compile & Run");
        buttonRun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRunActionPerformed(evt);
            }
        });

        buttonStep.setText("Step");
        buttonStep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonStepActionPerformed(evt);
            }
        });

        buttonStop.setText("Stop");
        buttonStop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonStopActionPerformed(evt);
            }
        });

        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Compiler Window");

        textAreaCompilerWindow.setEditable(false);
        textAreaCompilerWindow.setColumns(20);
        textAreaCompilerWindow.setRows(5);
        jScrollPane7.setViewportView(textAreaCompilerWindow);

        jSplitPane3.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Address Viewer");
        jSplitPane3.setTopComponent(jLabel14);

        jSplitPane7.setDividerLocation(100);

        listPCAddress.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listPCAddress.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listPCAddressValueChanged(evt);
            }
        });
        jScrollPane5.setViewportView(listPCAddress);

        jSplitPane7.setLeftComponent(jScrollPane5);

        listOPCODE.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listOPCODE.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listOPCODEValueChanged(evt);
            }
        });
        jScrollPane8.setViewportView(listOPCODE);

        jSplitPane7.setRightComponent(jScrollPane8);

        jSplitPane3.setRightComponent(jSplitPane7);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fieldPC, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(fieldHI, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(fieldLO)
                            .addComponent(fieldAT, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(fieldRA)))
                    .addComponent(buttonRun, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane7)
                    .addComponent(jSplitPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(buttonCompileOnly, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonStep)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonStop)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(fieldPC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(fieldHI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(fieldLO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(fieldAT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(fieldRA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonCompileOnly)
                    .addComponent(buttonStep)
                    .addComponent(buttonStop))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonRun)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSplitPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE)
                .addContainerGap())
        );

        jSplitPane6.setRightComponent(jPanel1);

        jSplitPane8.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("MIPS ISA Reference");
        jSplitPane8.setTopComponent(jLabel15);

        jSplitPane9.setDividerLocation(100);

        listOPCODEs.setModel(new javax.swing.AbstractListModel<String>() {
			private static final long serialVersionUID = 1L;
			String[] strings = { "add", "addi", "and", "andi", "beq", "bne", "blt", "bgt", "ble", "bge", "div", "j", "jal", "jr", "li", "lw", "mfhi", "mflo", "move", "mult", "nor", "or", "ori", "slt", "sli", "sll", "srl", "sw", "sub", "sra" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        listOPCODEs.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listOPCODEs.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listOPCODEsValueChanged(evt);
            }
        });
        jScrollPane9.setViewportView(listOPCODEs);

        jSplitPane9.setLeftComponent(jScrollPane9);

        textAreaReference.setEditable(false);
        textAreaReference.setColumns(20);
        textAreaReference.setLineWrap(true);
        textAreaReference.setRows(5);
        jScrollPane10.setViewportView(textAreaReference);

        jSplitPane9.setRightComponent(jScrollPane10);

        jSplitPane8.setRightComponent(jSplitPane9);

        jMenu1.setText("File");

        menuSave.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        menuSave.setText("Save to .MIPS File...");
        menuSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSaveActionPerformed(evt);
            }
        });
        jMenu1.add(menuSave);

        menuLoadInstFile.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        menuLoadInstFile.setText("Load .MIPS File...");
        menuLoadInstFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuLoadInstFileActionPerformed(evt);
            }
        });
        jMenu1.add(menuLoadInstFile);

        menuLoadMemory.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        menuLoadMemory.setText("Load Memory From File...");
        menuLoadMemory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuLoadMemoryActionPerformed(evt);
            }
        });
        jMenu1.add(menuLoadMemory);

        jMenu3.setText("Load Question...");

        menuLoadCustomQuestion.setText("Custom Question...");
        menuLoadCustomQuestion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuLoadCustomQuestionActionPerformed(evt);
            }
        });
        jMenu3.add(menuLoadCustomQuestion);

        menuLoadQ0.setText("Question 00: Self Test");
        menuLoadQ0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuLoadQ0ActionPerformed(evt);
            }
        });
        jMenu3.add(menuLoadQ0);

        menuLoadQ1.setText("Question 01: Amplifier");
        menuLoadQ1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuLoadQ1ActionPerformed(evt);
            }
        });
        jMenu3.add(menuLoadQ1);

        menuLoadQ2.setText("Question 02: Compare 01");
        menuLoadQ2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuLoadQ2ActionPerformed(evt);
            }
        });
        jMenu3.add(menuLoadQ2);

        menuLoadQ3.setText("Question 03: Compare 02");
        menuLoadQ3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuLoadQ3ActionPerformed(evt);
            }
        });
        jMenu3.add(menuLoadQ3);

        menuLoadQ4.setText("Question 04: Compare 03");
        menuLoadQ4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuLoadQ4ActionPerformed(evt);
            }
        });
        jMenu3.add(menuLoadQ4);

        menuLoadQ5.setText("Question 05: Mixer");
        menuLoadQ5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuLoadQ5ActionPerformed(evt);
            }
        });
        jMenu3.add(menuLoadQ5);

        menuLoadQ6.setText("Question 06: For loop");
        menuLoadQ6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuLoadQ6ActionPerformed(evt);
            }
        });
        jMenu3.add(menuLoadQ6);

        menuLoadQ7.setText("Question 07: Nested for loop");
        menuLoadQ7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuLoadQ7ActionPerformed(evt);
            }
        });
        jMenu3.add(menuLoadQ7);

        menuLoadQ8.setText("Question 08: Bitwise Operation 01");
        menuLoadQ8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuLoadQ8ActionPerformed(evt);
            }
        });
        jMenu3.add(menuLoadQ8);

        menuLoadQ9.setText("Question 09: Bitwise Operation 02");
        menuLoadQ9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuLoadQ9ActionPerformed(evt);
            }
        });
        jMenu3.add(menuLoadQ9);

        menuLoadQ10.setText("Question 10: Interrupt Handler");
        menuLoadQ10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuLoadQ10ActionPerformed(evt);
            }
        });
        jMenu3.add(menuLoadQ10);

        jMenu1.add(jMenu3);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 586, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSplitPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 372, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jSplitPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSplitPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSplitPane4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSplitPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addComponent(jSplitPane8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jSplitPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
                            .addComponent(jSplitPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSplitPane2, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addComponent(jSplitPane6))
                .addContainerGap())
        );

        pack();
    }

    private void menuLoadInstFileActionPerformed(java.awt.event.ActionEvent evt)
    {                                                 
        int returnVal = instChooser.showOpenDialog(this);
        if(returnVal == JFileChooser.APPROVE_OPTION)
        {
            File file = instChooser.getSelectedFile();
            if(file.exists() && file.toString().contains(".mips"))
            {
            	ArrayList<String> lines = parser.readInstructionFromFile(file);
                
                textAreaPrompt.setText("");
                textAreaInsturction.setText("");
                for(String line : lines)
                {
                	line += "\n";
                	textAreaInsturction.append(line);
                }
            }
            else
            {
            	JOptionPane.showMessageDialog(null, "Not a valid .mips file!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    private void menuLoadMemoryActionPerformed(java.awt.event.ActionEvent evt)
    {
    	int returnVal = instChooser.showOpenDialog(this);
        if(returnVal == JFileChooser.APPROVE_OPTION)
        {
            File file = instChooser.getSelectedFile();
            
            if(file.toString().contains(".mem"))
            {
            	internal.resetMEM();
                parser.loadMemoryFromFile(file, internal);
                
                updateMemoryList();
            }
            else
            {
            	JOptionPane.showMessageDialog(null, "Not a valid .mem file!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    private void menuSaveActionPerformed(java.awt.event.ActionEvent evt)
    {                                         
    	int returnVal = saveChooser.showSaveDialog(this);
        if(returnVal == JFileChooser.APPROVE_OPTION)
        {
        	File file = saveChooser.getSelectedFile();
        	if(!file.exists())
        		file = new File(file.toString() + ".mips");
            parser.saveInstructionToFile(file, textAreaInsturction.getText());
        }
    }
    
    private void menuLoadQ0ActionPerformed(java.awt.event.ActionEvent evt)
    {
    	loadQuestion(0);
    	
    }
    
    private void menuLoadQ1ActionPerformed(java.awt.event.ActionEvent evt)
    {
    	loadQuestion(1);
    }

    private void menuLoadQ2ActionPerformed(java.awt.event.ActionEvent evt)
    {
    	loadQuestion(2);
    }

    private void menuLoadQ3ActionPerformed(java.awt.event.ActionEvent evt)
    {
    	loadQuestion(3);
    }

    private void menuLoadQ4ActionPerformed(java.awt.event.ActionEvent evt) 
    {
    	loadQuestion(4);
    }

    private void menuLoadQ5ActionPerformed(java.awt.event.ActionEvent evt)
    {
    	loadQuestion(5);
    }

    private void menuLoadQ6ActionPerformed(java.awt.event.ActionEvent evt)
    {
    	loadQuestion(6);
    }

    private void menuLoadQ7ActionPerformed(java.awt.event.ActionEvent evt)
    {
    	loadQuestion(7);
    }

    private void menuLoadQ8ActionPerformed(java.awt.event.ActionEvent evt)
    {
    	loadQuestion(8);
    }

    private void menuLoadQ9ActionPerformed(java.awt.event.ActionEvent evt)
    {
    	loadQuestion(9);
    }

    private void menuLoadQ10ActionPerformed(java.awt.event.ActionEvent evt)
    {
    	loadQuestion(10);
    }
    
    private void menuLoadCustomQuestionActionPerformed(java.awt.event.ActionEvent evt)
    {                                                       
    	int returnVal = instChooser.showOpenDialog(this);
        if(returnVal == JFileChooser.APPROVE_OPTION)
        {
            File file = instChooser.getSelectedFile();
            
            if(file.toString().contains(".mipsq"))
            {
            	String prompt = parser.parsePrompt(file.toString());
            	textAreaPrompt.setText(prompt);
            	
            	internal.resetMEM();
                parser.loadMemoryFromFile(file, internal);
                
                updateMemoryList();
            }
            else
            {
            	JOptionPane.showMessageDialog(null, "Not a valid .mipsq file!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    private void loadQuestion(int number)
    {
    	String prompt = parser.parsePrompt("asm/questions/question_" + String.format("%02d", number) + ".mipsq");
    	textAreaPrompt.setText(prompt);
    	textAreaInsturction.setText("");
    	
    	File file = new File("asm/questions/question_" + String.format("%02d", number) + ".mipsq");
    	internal.resetMEM();
        parser.loadMemoryFromFile(file, internal);
        
        updateMemoryList();
    }
    
    private void buttonCompileOnlyActionPerformed(java.awt.event.ActionEvent evt)
    {
    	routine.clearInstruction();
    	String[] instructions = textAreaInsturction.getText().split("\n");
    	for(String instruction : instructions)
    	{
    		parser.parseSingle(instruction, routine);
    	}
    	routine.compile();
    	textAreaCompilerWindow.setText("Compile completed with " + routine.getInstructionsCount() + " instructions.\n(Includes Labels)");
    	
    	updateDebugger();
    	updateMemoryList();
    	updatePCAddressList();
    	updateRegisterViewer();
    	
    	listPCAddress.setSelectedIndex(internal.getPC());
    	listPCAddress.ensureIndexIsVisible(internal.getPC());
    	listOPCODE.setSelectedIndex(internal.getPC());
    	listOPCODE.ensureIndexIsVisible(internal.getPC());
    }

    private void buttonRunActionPerformed(java.awt.event.ActionEvent evt)
    {
    	routine.clearInstruction();
    	String[] instructions = textAreaInsturction.getText().split("\n");
    	for(String instruction : instructions)
    	{
    		parser.parseSingle(instruction, routine);
    	}
    	
    	routine.compile();
    	textAreaCompilerWindow.setText("Compile completed with " + routine.getInstructionsCount() + " instructions.\n(Includes Labels)");
    	
    	updateDebugger();
    	updateMemoryList();
    	updatePCAddressList();
    	updateRegisterViewer();
    	
    	routine.execute();
    	
    	textAreaCompilerWindow.append("\n Execution completed with total cycle of: " + routine.getCYCLE());
    	
    	updateDebugger();
    	updateMemoryList();
    	updatePCAddressList();
    	updateRegisterViewer();
    }

    private void buttonStepActionPerformed(java.awt.event.ActionEvent evt)
    {
    	routine.compile();
    	
    	routine.execute(internal.getPC());
    	internal.setPC(internal.getPC() + 1);
    	
    	textAreaCompilerWindow.setText("");
    	if(internal.getPC() >= routine.getInstructionsCount())
    		textAreaCompilerWindow.append("\n Execution completed with total cycle of: " + routine.getCYCLE());
    	
    	updateDebugger();
    	updateMemoryList();
    	updatePCAddressList();
    	updateRegisterViewer();
    	
    	listPCAddress.setSelectedIndex(internal.getPC());
    	listPCAddress.ensureIndexIsVisible(internal.getPC());
    	listOPCODE.setSelectedIndex(internal.getPC());
    	listOPCODE.ensureIndexIsVisible(internal.getPC());
    }

    private void buttonStopActionPerformed(java.awt.event.ActionEvent evt)
    {
    	internal.setPC(0);
    	
    	listPCAddress.setSelectedIndex(internal.getPC());
    	listPCAddress.ensureIndexIsVisible(internal.getPC());
    	listOPCODE.setSelectedIndex(internal.getPC());
    	listOPCODE.ensureIndexIsVisible(internal.getPC());
    	
    	updateDebugger();
    	updateMemoryList();
    	updatePCAddressList();
    	updateRegisterViewer();
    	
    	textAreaCompilerWindow.setText("");
    }
    
    private void listPCAddressValueChanged(javax.swing.event.ListSelectionEvent evt)
    {
    	int index = listPCAddress.getSelectedIndex();
    	listPCAddress.setSelectedIndex(index);
    	listPCAddress.ensureIndexIsVisible(index);
    	listOPCODE.setSelectedIndex(index);
    	listOPCODE.ensureIndexIsVisible(index);
    }

    private void listOPCODEValueChanged(javax.swing.event.ListSelectionEvent evt)
    {
    	int index = listOPCODE.getSelectedIndex();
    	listPCAddress.setSelectedIndex(index);
    	listPCAddress.ensureIndexIsVisible(index);
    	listOPCODE.setSelectedIndex(index);
    	listOPCODE.ensureIndexIsVisible(index);
    }
    
    private void listOPCODEsValueChanged(javax.swing.event.ListSelectionEvent evt)
    {                                         
        String key = listOPCODEs.getSelectedValue();
        String value = refs.getReference(key);
        textAreaReference.setText(value);
    }
    
    public void updateMemoryList()
    {
        DefaultListModel<String> memoryList = new DefaultListModel<String>();
        
        for(Map.Entry<Integer, Integer> entry : internal.getMemory().entrySet())
        {
        	memoryList.addElement(String.format("0x%08X: 0x%08X", entry.getKey(), entry.getValue()));
        }
        listMemory.setModel(memoryList);
    }
    
    public void updatePCAddressList()
    {
    	DefaultListModel<String> pcList = new DefaultListModel<String>();
    	DefaultListModel<String> regList = new DefaultListModel<String>();
    	
    	for(Map.Entry<Integer, ISA_OPCODE> entry : routine.getInstructions().entrySet())
    	{
    		pcList.addElement(String.format("0x%08X", entry.getKey()));
    		regList.addElement(entry.getValue().getOPCODE() + " " + entry.getValue().getREGS());
    	}
    	
//    	for(int i = 0; i < routine.getInstructionsCount(); i++)
//    	{
//    		pcList.addElement(String.format("0x%08X", routine.getInstructionPC(i)));
//    		regList.addElement(routine.getOPCODE(i) + " " + routine.getREGS(i));
//    	}
    	
    	listPCAddress.setModel(pcList);
    	listOPCODE.setModel(regList);
    }
    
    private void updateDebugger()
    {
    	String format = "0x";
    	format += String.format("%04X", internal.getPC()).toUpperCase();
    	fieldPC.setText(format);
    	
    	format = "0x";
    	format += String.format("%04X", internal.getFrom("$HI"));
    	fieldHI.setText(format);
    	
    	format = "0x";
    	format += String.format("%04X", internal.getFrom("$LO"));
    	fieldLO.setText(format);
    	
    	format = "0x";
    	format += String.format("%04X", internal.getFrom("$AT"));
    	fieldAT.setText(format);
    	
    	format = "0x";
    	format += String.format("%04X", internal.getFrom("$RA"));
    	fieldRA.setText(format);
    }
    
    public void updateRegisterViewer()
    {
    	DefaultListModel<String> regList = new DefaultListModel<String>();
    	
    	for(Map.Entry<String, Integer> entry : internal.getRegisterAddrs().entrySet())
    	{
    		regList.addElement(toFormatString(entry.getKey()));
    	}
    	
    	listRegister.setModel(regList);
    }
    
    private String toFormatString(String reg)
    {
    	String format = "";
    	int value = internal.getRegisterVal(reg);
    	format = String.format("%-5s: 0x%08X ", reg, value);
    	format += String.format("0b%032d", new BigInteger(Integer.toBinaryString(value)));
    	format += String.format(" (%-10d)", value);
    	
    	return format;
    }

    public void init() {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MIPSFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MIPSFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MIPSFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MIPSFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
    
    public void start()
    {
        this.setVisible(true);
    }

 // Variables declaration - do not modify                     
    private javax.swing.JButton buttonCompileOnly;
    private javax.swing.JButton buttonRun;
    private javax.swing.JButton buttonStep;
    private javax.swing.JButton buttonStop;
    private javax.swing.JTextField fieldAT;
    private javax.swing.JTextField fieldHI;
    private javax.swing.JTextField fieldLO;
    private javax.swing.JTextField fieldPC;
    private javax.swing.JTextField fieldRA;
    private javax.swing.JFileChooser instChooser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JSplitPane jSplitPane2;
    private javax.swing.JSplitPane jSplitPane3;
    private javax.swing.JSplitPane jSplitPane4;
    private javax.swing.JSplitPane jSplitPane6;
    private javax.swing.JSplitPane jSplitPane7;
    private javax.swing.JSplitPane jSplitPane8;
    private javax.swing.JSplitPane jSplitPane9;
    private javax.swing.JList<String> listMemory;
    private javax.swing.JList<String> listOPCODE;
    private javax.swing.JList<String> listOPCODEs;
    private javax.swing.JList<String> listPCAddress;
    private javax.swing.JList<String> listRegister;
    private javax.swing.JMenuItem menuLoadCustomQuestion;
    private javax.swing.JMenuItem menuLoadInstFile;
    private javax.swing.JMenuItem menuLoadMemory;
    private javax.swing.JMenuItem menuLoadQ0;
    private javax.swing.JMenuItem menuLoadQ1;
    private javax.swing.JMenuItem menuLoadQ10;
    private javax.swing.JMenuItem menuLoadQ2;
    private javax.swing.JMenuItem menuLoadQ3;
    private javax.swing.JMenuItem menuLoadQ4;
    private javax.swing.JMenuItem menuLoadQ5;
    private javax.swing.JMenuItem menuLoadQ6;
    private javax.swing.JMenuItem menuLoadQ7;
    private javax.swing.JMenuItem menuLoadQ8;
    private javax.swing.JMenuItem menuLoadQ9;
    private javax.swing.JMenuItem menuSave;
    private javax.swing.JFileChooser saveChooser;
    private javax.swing.JTextArea textAreaCompilerWindow;
    private javax.swing.JTextArea textAreaInsturction;
    private javax.swing.JTextArea textAreaPrompt;
    private javax.swing.JTextArea textAreaReference;
    // End of variables declaration                                     
}
