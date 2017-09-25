package cs.gui;

import java.io.File;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Map;

import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.text.Position;

import cs.Parser;
import cs.architecture.Architecture;
import cs.architecture.Internal;
import cs.architecture.routine.Routine;
import cs.instruction.ISA_OPCODE;

/**
 * 
 * @author Charlie Shin
 *
 */
public class MIPSFrame extends javax.swing.JFrame {

	private static final long serialVersionUID = 1L;
	
	private PCAddressViewer pcav;
	private FullDebugger fd;
	
	private Routine routine;
	
    public MIPSFrame()
    {
        initComponents();
        
        routine = new Routine();
        
        pcav = new PCAddressViewer(routine);
        fd = new FullDebugger(this, routine);
    }
                        
    private void initComponents() {

        instChooser = new javax.swing.JFileChooser();
        saveChooser = new javax.swing.JFileChooser();
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
        jSplitPane3 = new javax.swing.JSplitPane();
        jLabel14 = new javax.swing.JLabel();
        jSplitPane7 = new javax.swing.JSplitPane();
        jScrollPane5 = new javax.swing.JScrollPane();
        listPCAddress = new javax.swing.JList<>();
        jScrollPane8 = new javax.swing.JScrollPane();
        listOPCODE = new javax.swing.JList<>();
        jSplitPane5 = new javax.swing.JSplitPane();
        jSplitPane10 = new javax.swing.JSplitPane();
        jSplitPane2 = new javax.swing.JSplitPane();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        listMemory = new javax.swing.JList<>();
        jSplitPane4 = new javax.swing.JSplitPane();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        listRegister = new javax.swing.JList<>();
        jSplitPane1 = new javax.swing.JSplitPane();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        textAreaInstruction = new javax.swing.JTextArea();
        jSplitPane8 = new javax.swing.JSplitPane();
        jPanel2 = new javax.swing.JPanel();
        buttonCompileOnly = new javax.swing.JButton();
        buttonStep = new javax.swing.JButton();
        buttonStop = new javax.swing.JButton();
        buttonRun = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jSplitPane9 = new javax.swing.JSplitPane();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textAreaPrompt = new javax.swing.JTextArea();
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
        jMenu2 = new javax.swing.JMenu();
        menuOpenFullDebugger = new javax.swing.JMenuItem();
        menuPCAParser = new javax.swing.JMenuItem();

        instChooser.setCurrentDirectory(new java.io.File("C:\\Program Files\\NetBeans 8.2"));
        instChooser.setDialogTitle("Open File...");

        saveChooser.setDialogType(javax.swing.JFileChooser.SAVE_DIALOG);
        saveChooser.setCurrentDirectory(new java.io.File("C:\\Program Files\\NetBeans 8.2"));
        saveChooser.setDialogTitle("Save .mips File...");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MIPS Simulator (WIP)");
        setMinimumSize(new java.awt.Dimension(1024, 700));
        setResizable(false);

        jSplitPane6.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        jLabel5.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Debugger");
        jSplitPane6.setTopComponent(jLabel5);

        jLabel6.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("PC POS");

        fieldPC.setEditable(false);
        fieldPC.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N

        fieldHI.setEditable(false);
        fieldHI.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("$HI");

        jLabel8.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Registers");

        fieldLO.setEditable(false);
        fieldLO.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("$LO");

        jSplitPane3.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        jLabel14.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("PC Address Viewer");
        jSplitPane3.setTopComponent(jLabel14);

        jSplitPane7.setDividerLocation(100);

        listPCAddress.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        listPCAddress.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listPCAddress.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listPCAddressValueChanged(evt);
            }
        });
        jScrollPane5.setViewportView(listPCAddress);

        jSplitPane7.setLeftComponent(jScrollPane5);

        listOPCODE.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
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
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fieldPC, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)
                            .addComponent(fieldHI, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(fieldLO)))
                    .addComponent(jSplitPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel8)
                .addGap(5, 5, 5)
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
                .addComponent(jSplitPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE))
        );

        jSplitPane6.setRightComponent(jPanel1);

        jSplitPane10.setDividerLocation(300);

        jSplitPane2.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        jLabel3.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Memory Viewer");
        jSplitPane2.setTopComponent(jLabel3);

        listMemory.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        listMemory.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane6.setViewportView(listMemory);

        jSplitPane2.setRightComponent(jScrollPane6);

        jSplitPane10.setLeftComponent(jSplitPane2);

        jSplitPane4.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        jLabel4.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Register Viewer");
        jSplitPane4.setTopComponent(jLabel4);

        listRegister.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        listRegister.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane4.setViewportView(listRegister);

        jSplitPane4.setRightComponent(jScrollPane4);

        jSplitPane10.setRightComponent(jSplitPane4);

        jSplitPane5.setRightComponent(jSplitPane10);

        jSplitPane1.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        jLabel2.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Instruction Editor");
        jSplitPane1.setTopComponent(jLabel2);

        textAreaInstruction.setColumns(20);
        textAreaInstruction.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        textAreaInstruction.setRows(5);
        jScrollPane2.setViewportView(textAreaInstruction);

        jSplitPane1.setRightComponent(jScrollPane2);

        jSplitPane5.setLeftComponent(jSplitPane1);

        jSplitPane8.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        buttonCompileOnly.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        buttonCompileOnly.setText("Assemble Only");
        buttonCompileOnly.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCompileOnlyActionPerformed(evt);
            }
        });

        buttonStep.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        buttonStep.setText("Step");
        buttonStep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonStepActionPerformed(evt);
            }
        });

        buttonStop.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        buttonStop.setText("Stop");
        buttonStop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonStopActionPerformed(evt);
            }
        });

        buttonRun.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        buttonRun.setText("Assemble & Run");
        buttonRun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRunActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(buttonCompileOnly, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonStep)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonStop))
                    .addComponent(buttonRun, javax.swing.GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonCompileOnly)
                    .addComponent(buttonStep)
                    .addComponent(buttonStop))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonRun)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jSplitPane8.setBottomComponent(jPanel2);

        jLabel10.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Assembler / Debugger");
        jSplitPane8.setLeftComponent(jLabel10);

        jSplitPane9.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        jLabel1.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Prompt");
        jSplitPane9.setTopComponent(jLabel1);

        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        textAreaPrompt.setEditable(false);
        textAreaPrompt.setColumns(20);
        textAreaPrompt.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        textAreaPrompt.setLineWrap(true);
        textAreaPrompt.setRows(5);
        jScrollPane1.setViewportView(textAreaPrompt);

        jSplitPane9.setRightComponent(jScrollPane1);

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

        jMenu2.setText("View");

        menuOpenFullDebugger.setText("Full Debugger");
        menuOpenFullDebugger.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuOpenFullDebuggerActionPerformed(evt);
            }
        });
        jMenu2.add(menuOpenFullDebugger);

        menuPCAParser.setText("PC Address Parser");
        menuPCAParser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuPCAParserActionPerformed(evt);
            }
        });
        jMenu2.add(menuPCAParser);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSplitPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 687, Short.MAX_VALUE)
                    .addComponent(jSplitPane9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jSplitPane6)
                    .addComponent(jSplitPane8)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jSplitPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jSplitPane8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSplitPane6)
                    .addComponent(jSplitPane5)))
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
                textAreaInstruction.setText("");
                for(String line : lines)
                {
                	line += "\n";
                	textAreaInstruction.append(line);
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
            	internal.resetMemory();
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
            parser.saveInstructionToFile(file, textAreaInstruction.getText());
        }
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
            	
            	internal.resetMemory();
                parser.loadMemoryFromFile(file, internal);
                
                updateMemoryList();
            }
            else
            {
            	JOptionPane.showMessageDialog(null, "Not a valid .mipsq file!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    private void menuOpenFullDebuggerActionPerformed(java.awt.event.ActionEvent evt)
    {
    }
    
    private void menuPCAParserActionPerformed(java.awt.event.ActionEvent evt)
    {
    }
    
    private void loadQuestion(int number)
    {
    	String prompt = parser.parsePrompt("asm/questions/question_" + String.format("%02d", number) + ".mipsq");
    	textAreaPrompt.setText(prompt);
    	textAreaInstruction.setText("");
    	
    	File file = new File("asm/questions/question_" + String.format("%02d", number) + ".mipsq");
    	internal.resetMemory();
        parser.loadMemoryFromFile(file, internal);
        
        updateMemoryList();
    }
    
    private void buttonCompileOnlyActionPerformed(java.awt.event.ActionEvent evt)
    {
    	assemble();
    	
    	internal.resetMemory();
    	internal.resetRegisters();
    	
    	updateDebugger();
    	updateMemoryList();
    	updatePCAddressList();
    	updateRegisterViewer();
    	updatePCAddressPosition();
    }

    private void buttonRunActionPerformed(java.awt.event.ActionEvent evt)
    {
    	assemble();
    	
    	updateDebugger();
    	updateMemoryList();
    	updatePCAddressList();
    	updateRegisterViewer();
    	updatePCAddressPosition();
    	
    	updateDebugger();
    	updateMemoryList();
    	updatePCAddressList();
    	updateRegisterViewer();
    	updatePCAddressPosition();
    }

    private void buttonStepActionPerformed(java.awt.event.ActionEvent evt)
    {
//    	// Check if previous execution was done
//    	if(internal.getPC() > routine.getInstructionEnd())
//    	{
//    		routine.clearInstruction(); // To ensure clean state
//    		assemble();
//    		routine.compile();
//    		internal.setPC(Architecture.$PC);
//    		
//    		updateDebugger();
//        	updateMemoryList();
//        	updatePCAddressList();
//        	updateRegisterViewer();
//        	updatePCAddressPosition();
//    	}
//    	else
//    	{
//    		routine.execute(internal.getPC());
//        	internal.setPC(internal.getPC() + 0x04);
//        	
//        	updateDebugger();
//        	updateMemoryList();
//        	updatePCAddressList();
//        	updateRegisterViewer();
//        	updatePCAddressPosition();
//    	}
    	
//    	if(internal.getPC() > routine.getInstructionEnd())
//    	{
//    		internal.setPC(Architecture.$PC);
//    		listPCAddress.setSelectedIndex(-1);
//    		listOPCODE.setSelectedIndex(-1);
//    		
//    		// Moved to Full Debugger Window
//    		textAreaCompilerWindow.setText("");
////        	if(internal.getPC() >= routine.getInstructionsCount())
////        		textAreaCompilerWindow.append("\n Execution completed with total cycle of: " + routine.getCYCLE());
//    		
//    		routine.resetCYCLE();
//    		
//    		updateDebugger();
//        	updateMemoryList();
//        	updateRegisterViewer();
//        	updatePCAddressPosition();
//    	}
    }

    private void buttonStopActionPerformed(java.awt.event.ActionEvent evt)
    {
    	internal.setPC(Architecture.$PC);
    	
    	listPCAddress.setSelectedIndex(internal.getPC());
    	listPCAddress.ensureIndexIsVisible(internal.getPC());
    	listOPCODE.setSelectedIndex(internal.getPC());
    	listOPCODE.ensureIndexIsVisible(internal.getPC());
    	
    	internal.resetMemory();
    	internal.resetRegisters();
    	
    	updateDebugger();
    	updateMemoryList();
    	updatePCAddressList();
    	updateRegisterViewer();
    	updatePCAddressPosition();
    	
    	// Moved to Full Debugger Window
//    	textAreaCompilerWindow.setText("");
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
    
    private void assemble()
    {
    	String[] instructions = textAreaInstruction.getText().split("\n");
    	for(String instruction : instructions)
    	{
    	}
    }
    
    public void updatePCAddressPosition()
    {
    	if(listPCAddress.getModel().getSize() > 0)
    	{
    		String address = String.format("0x%08X", internal.getPC());
        	int index = listPCAddress.getNextMatch(address, 0, Position.Bias.Forward);
        	
        	listPCAddress.setSelectedIndex(index);
        	listPCAddress.ensureIndexIsVisible(index);
        	listOPCODE.setSelectedIndex(index);
        	listOPCODE.ensureIndexIsVisible(index);
    	}
    }
    
    public void updateMemoryList()
    {
        DefaultListModel<String> memoryList = new DefaultListModel<String>();
        
        for(Map.Entry<Integer, Integer> entry : internal.getMemory().entrySet())
        {
        	memoryList.addElement(String.format("0x%08X: 0x%08X", entry.getKey(), entry.getValue()));
        }
        listMemory.setModel(memoryList);
        
        if(listMemory.getModel().getSize() > 0)
        {
        	String address = String.format("0x%08X", internal.getFrom("$sp"));
        	int index = listMemory.getNextMatch(address, 0, Position.Bias.Forward);
        	
        	listMemory.setSelectedIndex(index);
        	listMemory.ensureIndexIsVisible(index);
        }
    }
    
    public void updatePCAddressList()
    {
    	boolean finished = false;
    	DefaultListModel<String> pcList = new DefaultListModel<String>();
    	DefaultListModel<String> regList = new DefaultListModel<String>();
    }
    
    private void updateDebugger()
    {
    	fieldPC.setText(String.format("0x%08X", internal.getPC()));
    	
    	fieldHI.setText(String.format("0x%08X", internal.getFrom("$hi")));
    	
    	fieldLO.setText(String.format("0x%08X", internal.getFrom("$lo")));
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
    private javax.swing.JTextField fieldHI;
    private javax.swing.JTextField fieldLO;
    private javax.swing.JTextField fieldPC;
    private javax.swing.JFileChooser instChooser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
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
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JSplitPane jSplitPane10;
    private javax.swing.JSplitPane jSplitPane2;
    private javax.swing.JSplitPane jSplitPane3;
    private javax.swing.JSplitPane jSplitPane4;
    private javax.swing.JSplitPane jSplitPane5;
    private javax.swing.JSplitPane jSplitPane6;
    private javax.swing.JSplitPane jSplitPane7;
    private javax.swing.JSplitPane jSplitPane8;
    private javax.swing.JSplitPane jSplitPane9;
    private javax.swing.JList<String> listMemory;
    private javax.swing.JList<String> listOPCODE;
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
    private javax.swing.JMenuItem menuOpenFullDebugger;
    private javax.swing.JMenuItem menuPCAParser;
    private javax.swing.JMenuItem menuSave;
    private javax.swing.JFileChooser saveChooser;
    private javax.swing.JTextArea textAreaInstruction;
    private javax.swing.JTextArea textAreaPrompt;
    // End of variables declaration                                     
}
