/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs.gui;

import java.io.File;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;

import cs.Parser;
import cs.architecture.Internal;
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
	
    public MIPSFrame(Internal _internal, Routine _routine, Parser _parser)
    {
    	internal = _internal;
    	routine = _routine;
    	parser = _parser;
        initComponents();
    }
                        
    private void initComponents()
    {
    	instChooser = new javax.swing.JFileChooser();
        saveChooser = new javax.swing.JFileChooser();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
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
        jSplitPane5 = new javax.swing.JSplitPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        listRegister = new javax.swing.JList<>();
        jScrollPane6 = new javax.swing.JScrollPane();
        textAreaRegisterViewer = new javax.swing.JTextArea();
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
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuSave = new javax.swing.JMenuItem();
        menuLoadInstFile = new javax.swing.JMenuItem();
        menuLoadMemory = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();

        instChooser.setCurrentDirectory(new java.io.File("C:\\Program Files\\NetBeans 8.2"));

        saveChooser.setDialogType(javax.swing.JFileChooser.SAVE_DIALOG);
        saveChooser.setCurrentDirectory(new java.io.File("C:\\Program Files\\NetBeans 8.2"));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MIPS Simulator (WIP)");
        setMinimumSize(new java.awt.Dimension(1024, 768));
        setResizable(false);

        jLabel1.setText("Prompt");

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

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

        jScrollPane4.setViewportView(listMemory);

        jSplitPane1.setRightComponent(jScrollPane4);

        jSplitPane4.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Register Viewer");
        jSplitPane4.setTopComponent(jLabel3);

        jSplitPane5.setDividerLocation(100);

        listRegister.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "$zero", "$at", "$v0", "$v1", "$a0", "$a1", "$a2", "$a3", "$t0", "$t1", "$t2", "$t3", "$t4", "$t5", "$t6", "$t7", "$s0", "$s1", "$s2", "$s3", "$s4", "$s5", "$s6", "$s7", "$t8", "$t9", "$k0", "$k1", "$gp", "$sp", "$fp", "$ra" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        listRegister.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listRegister.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listRegisterValueChanged(evt);
            }
        });
        jScrollPane3.setViewportView(listRegister);

        jSplitPane5.setLeftComponent(jScrollPane3);

        textAreaRegisterViewer.setEditable(false);
        textAreaRegisterViewer.setColumns(20);
        textAreaRegisterViewer.setRows(5);
        jScrollPane6.setViewportView(textAreaRegisterViewer);

        jSplitPane5.setRightComponent(jScrollPane6);

        jSplitPane4.setRightComponent(jSplitPane5);

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
                    .addComponent(buttonCompileOnly, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonRun, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonStep, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonStop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE)
                    .addComponent(jSplitPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonCompileOnly)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonRun)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonStep)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonStop)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSplitPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                .addContainerGap())
        );

        jSplitPane6.setRightComponent(jPanel1);

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

        menuLoadMemory.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        menuLoadMemory.setText("Load Memory From File...");
        menuLoadMemory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuLoadMemoryActionPerformed(evt);
            }
        });
        jMenu1.add(menuLoadMemory);

        jMenu3.setText("Load Question...");

        jMenuItem1.setText("Question 00: Self Test");
        jMenu3.add(jMenuItem1);

        jMenuItem3.setText("Question 01: Amplifier");
        jMenu3.add(jMenuItem3);

        jMenu1.add(jMenu3);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jSplitPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSplitPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSplitPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSplitPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSplitPane2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSplitPane4)
                            .addComponent(jSplitPane1)
                            .addComponent(jSplitPane6))))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>

    private void menuLoadInstFileActionPerformed(java.awt.event.ActionEvent evt)
    {                                                 
    	textAreaInsturction.setText("");
        int returnVal = instChooser.showOpenDialog(this);
        if(returnVal == JFileChooser.APPROVE_OPTION)
        {
            File file = instChooser.getSelectedFile();
            ArrayList<String> lines = parser.parseOnly(file);
            for(String line : lines)
            {
            	line += "\n";
            	textAreaInsturction.append(line);
            }
        }
    }
    
    private void menuLoadMemoryActionPerformed(java.awt.event.ActionEvent evt)
    {
    	int returnVal = saveChooser.showOpenDialog(this);
        if(returnVal == JFileChooser.APPROVE_OPTION)
        {
            File file = instChooser.getSelectedFile();
            parser.writeToFile(file, textAreaInsturction.getText());
        }
    }
    
    private void menuSaveActionPerformed(java.awt.event.ActionEvent evt)
    {                                         
    	int returnVal = saveChooser.showSaveDialog(this);
        if(returnVal == JFileChooser.APPROVE_OPTION)
        {
            File file = saveChooser.getSelectedFile();
            parser.writeToFile(file, textAreaInsturction.getText());
        }
    }
    
    private void listRegisterValueChanged(javax.swing.event.ListSelectionEvent evt)
    {                                            
    	String register = listRegister.getSelectedValue();
    	int value = internal.getFrom(register);
    	
    	String out = register + "\n";
    	out += "Value(Dec): " + value + "\n";
    	out += "Value(Hex): " + String.format("0x%04x", value).toUpperCase() + "\n";
    	out += "Value(Bin): \n" + String.format("%32s", Integer.toBinaryString(value)).replace(' ', '0');;
    	
    	textAreaRegisterViewer.setText(out);
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
    	
    	updateMemoryList();
    	updatePCAddressList();
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
    	
    	updateMemoryList();
    	updatePCAddressList();
    	
    	routine.execute();
    }

    private void buttonStepActionPerformed(java.awt.event.ActionEvent evt)
    {
    	routine.execute(internal.getPC());
    	
    	listPCAddress.setSelectedIndex(internal.getPC());
    	listPCAddress.ensureIndexIsVisible(internal.getPC());
    	listOPCODE.setSelectedIndex(internal.getPC());
    	listOPCODE.ensureIndexIsVisible(internal.getPC());
    	
    	String format = "0x";
    	format += String.format("%04x", internal.getPC()).toUpperCase();
    	fieldPC.setText(format);
    	
    	format = "0x";
    	format += String.format("%04x", internal.getFrom("$HI"));
    	fieldHI.setText(format);
    	
    	format = "0x";
    	format += String.format("%04x", internal.getFrom("$LO"));
    	fieldLO.setText(format);
    	
    	format = "0x";
    	format += String.format("%04x", internal.getFrom("$AT"));
    	fieldAT.setText(format);
    	
    	format = "0x";
    	format += String.format("%04x", internal.getFrom("$RA"));
    	fieldRA.setText(format);
    	
    	updateRegisterViewer();
    }

    private void buttonStopActionPerformed(java.awt.event.ActionEvent evt)
    {
    	internal.setPC(0);
    	
    	listPCAddress.setSelectedIndex(internal.getPC());
    	listPCAddress.ensureIndexIsVisible(internal.getPC());
    	listOPCODE.setSelectedIndex(internal.getPC());
    	listOPCODE.ensureIndexIsVisible(internal.getPC());
    	
    	updateRegisterViewer();
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
    
    public void updateMemoryList()
    {
        DefaultListModel<String> memoryList = new DefaultListModel<String>();
        for(int i = 0; i <= 0xFF; i++)
        {
        	String format = "0x";
        	format += String.format("%02x", i).toUpperCase();
        	
        	int value = internal.getFromMem(i, 0);
        	String valFormat = "0x";
        	valFormat += String.format("%04x", value).toUpperCase();
        	format += ": (" + value + ") " + valFormat;
        	memoryList.addElement(format);
        }
        listMemory.setModel(memoryList);
    }
    
    public void updatePCAddressList()
    {
    	DefaultListModel<String> pcList = new DefaultListModel<String>();
    	DefaultListModel<String> regList = new DefaultListModel<String>();
    	
    	for(int i = 0; i < routine.getInstructionsCount(); i++)
    	{
    		String format = "0x";
        	format += String.format("%02x", i).toUpperCase();
    		pcList.addElement(format);
    		regList.addElement(routine.getOPCODE(i) + " " + routine.getREGS(i));
    	}
    	
    	listPCAddress.setModel(pcList);
    	listOPCODE.setModel(regList);
    }
    
    private void updateRegisterViewer()
    {
    	String register = listRegister.getSelectedValue();
    	if(register != null)
    	{
    		int value = internal.getFrom(register);
        	
        	String out = register + "\n";
        	out += "Value(Dec): " + value + "\n";
        	out += "Value(Hex): " + String.format("0x%04x", value).toUpperCase() + "\n";
        	out += "Value(Bin): \n" + String.format("%32s", Integer.toBinaryString(value)).replace(' ', '0');;
        	
        	textAreaRegisterViewer.setText(out);
    	}
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
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JSplitPane jSplitPane2;
    private javax.swing.JSplitPane jSplitPane3;
    private javax.swing.JSplitPane jSplitPane4;
    private javax.swing.JSplitPane jSplitPane5;
    private javax.swing.JSplitPane jSplitPane6;
    private javax.swing.JSplitPane jSplitPane7;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JList<String> listMemory;
    private javax.swing.JList<String> listOPCODE;
    private javax.swing.JList<String> listPCAddress;
    private javax.swing.JList<String> listRegister;
    private javax.swing.JMenuItem menuLoadInstFile;
    private javax.swing.JMenuItem menuLoadMemory;
    private javax.swing.JMenuItem menuSave;
    private javax.swing.JFileChooser saveChooser;
    private javax.swing.JTextArea textAreaCompilerWindow;
    private javax.swing.JTextArea textAreaInsturction;
    private javax.swing.JTextArea textAreaRegisterViewer;
    // End of variables declaration                  
}
