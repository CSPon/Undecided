package cs.gui;

import java.util.Map;

import javax.swing.DefaultListModel;
import javax.swing.text.Position;

import cs.architecture.Internal;
import cs.instruction.types.ISA_OPCODE;
import cs.routine.Routine;

/**
 * 
 * @author Charlie Shin
 *
 */
public class PCAddressViewer extends javax.swing.JFrame
{
	private static final long serialVersionUID = -1485329096512117768L;
	
	private Internal internal;
	private Routine routine;
	
	public PCAddressViewer(Internal _internal, Routine _routine)
    {
		internal = _internal;
		routine = _routine;
        initComponents();
    }
    
	private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        jLabel1 = new javax.swing.JLabel();
        jSplitPane2 = new javax.swing.JSplitPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        listPC = new javax.swing.JList<>();
        jSplitPane3 = new javax.swing.JSplitPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        listOPCODE = new javax.swing.JList<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        listHEX = new javax.swing.JList<>();

        setTitle("MIPS Simulator - PC Address Viewer");

        jSplitPane1.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("PC Address Viewer");
        jSplitPane1.setTopComponent(jLabel1);

        jSplitPane2.setDividerLocation(150);

        listPC.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        listPC.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listPC.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listPCValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(listPC);

        jSplitPane2.setLeftComponent(jScrollPane1);

        jSplitPane3.setDividerLocation(300);

        listOPCODE.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        listOPCODE.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listOPCODE.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listOPCODEValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(listOPCODE);

        jSplitPane3.setLeftComponent(jScrollPane2);

        listHEX.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        listHEX.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listHEX.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listHEXValueChanged(evt);
            }
        });
        jScrollPane3.setViewportView(listHEX);

        jSplitPane3.setRightComponent(jScrollPane3);

        jSplitPane2.setRightComponent(jSplitPane3);

        jSplitPane1.setRightComponent(jSplitPane2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 720, Short.MAX_VALUE)
        );

        pack();
    }

    private void listPCValueChanged(javax.swing.event.ListSelectionEvent evt)
    {
    	int index = listPC.getSelectedIndex();
    	listPC.setSelectedIndex(index);
    	listPC.ensureIndexIsVisible(index);
    	listOPCODE.setSelectedIndex(index);
    	listOPCODE.ensureIndexIsVisible(index);
    	listHEX.setSelectedIndex(index);
    	listHEX.ensureIndexIsVisible(index);
    }

    private void listOPCODEValueChanged(javax.swing.event.ListSelectionEvent evt)
    {
    	int index = listOPCODE.getSelectedIndex();
    	listPC.setSelectedIndex(index);
    	listPC.ensureIndexIsVisible(index);
    	listOPCODE.setSelectedIndex(index);
    	listOPCODE.ensureIndexIsVisible(index);
    	listHEX.setSelectedIndex(index);
    	listHEX.ensureIndexIsVisible(index);
    }

    private void listHEXValueChanged(javax.swing.event.ListSelectionEvent evt)
    {
    	int index = listHEX.getSelectedIndex();
    	listPC.setSelectedIndex(index);
    	listPC.ensureIndexIsVisible(index);
    	listOPCODE.setSelectedIndex(index);
    	listOPCODE.ensureIndexIsVisible(index);
    	listHEX.setSelectedIndex(index);
    	listHEX.ensureIndexIsVisible(index);
    }
    
    public void updateViewers()
    {
    	DefaultListModel<String> addressList = new DefaultListModel<String>();
    	DefaultListModel<String> opcodeList = new DefaultListModel<String>();
    	DefaultListModel<String> parseList = new DefaultListModel<String>();
    	
    	for(Map.Entry<Integer, ISA_OPCODE> entry : routine.getInstructions().entrySet())
    	{
    		addressList.addElement(String.format("0x%08X", entry.getKey()));
    		opcodeList.addElement(entry.getValue().getOPCODE() + " " + entry.getValue().getREGS());
    		parseList.addElement(entry.getValue().toString(internal));
    	}
    	
    	listPC.setModel(addressList);
    	listOPCODE.setModel(opcodeList);
    	listHEX.setModel(parseList);
    }
    
    public void updatePositions()
    {
    	String address = String.format("0x%08X", internal.getPC());
    	int index = listPC.getNextMatch(address, 0, Position.Bias.Forward);
    	
    	if(index != -1)
    	{
    		listPC.setSelectedIndex(index);
        	listPC.ensureIndexIsVisible(index);
        	listOPCODE.setSelectedIndex(index);
        	listOPCODE.ensureIndexIsVisible(index);
        	listHEX.setSelectedIndex(index);
        	listHEX.ensureIndexIsVisible(index);
    	}
    }
    
    public void updatePositions(int index)
    {
    	listPC.setSelectedIndex(index);
    	listPC.ensureIndexIsVisible(index);
    	listOPCODE.setSelectedIndex(index);
    	listOPCODE.ensureIndexIsVisible(index);
    	listHEX.setSelectedIndex(index);
    	listHEX.ensureIndexIsVisible(index);
    }

    public void init()
    {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PCAddressViewer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PCAddressViewer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PCAddressViewer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PCAddressViewer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
    
    public void start()
    {
        this.setVisible(true);
    }

 // Variables declaration - do not modify                     
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JSplitPane jSplitPane2;
    private javax.swing.JSplitPane jSplitPane3;
    private javax.swing.JList<String> listHEX;
    private javax.swing.JList<String> listOPCODE;
    private javax.swing.JList<String> listPC;
    // End of variables declaration                   
}
