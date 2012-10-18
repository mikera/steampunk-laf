package mikera.ui.steampunk;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.plaf.synth.*;

import net.miginfocom.swing.MigLayout;

public class TestApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		boolean use=true;
		if (use) {
			 SynthLookAndFeel laf = new SynthLookAndFeel();
			 try {
				UIManager.setLookAndFeel(laf);
			 } catch (UnsupportedLookAndFeelException e) {
				e.printStackTrace();
			 }
			 SynthLookAndFeel.setStyleFactory(new SteamPunkStyleFactory());
		}
		
		JFrame frame=new JFrame();
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		MigLayout layout=new MigLayout(
				"insets 5 5 5 5",
			    "[150!][200:2000:][250!]",
			    "[100!][100:1000:, top][250!]");
		
		// main panel over whole screen
		JPanel p1=new JPanel();
		p1.setLayout(layout);
		frame.add(p1);
		
		
		// left top
		JButton b1=new JButton("Test Button!!");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showInputDialog("Enter some text:");
			}		
		});
		p1.add(b1,"cell 0 0");
		
		// centre top split pane
		JSplitPane split1=new JSplitPane();
		
		p1.add(split1,"cell 1 0 1 1,grow");
		
		// panel for left centre
		JPanel p2=new JPanel();
		p2.setBorder(new SteamPunkBorder());
		p2.setLayout(new MigLayout("left, wrap 1","[]"));
		p1.add(p2,"cell 0 1 1 1,grow");
		
		p2.add(new JLabel("Bordered Panel"));
		
		JLabel l1=new JLabel("Test Red Label");
		l1.setForeground(Color.RED);
		l1.setMinimumSize(new Dimension(0,0));
		p2.add(l1);
		
		JButton b2=new JButton("Open...");
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser c=new JFileChooser();
				c.showOpenDialog(null);
			}
		});
		p2.add(b2);
		
		JTextArea ta1=new JTextArea("Text area yayayay ayyayyay ay aya yaya ay aya ya ya");
		ta1.setMinimumSize(new Dimension(0,0));
		p2.add(ta1);
		


		// top right
		final JCheckBox cb1=new JCheckBox("Test check");
		p1.add(cb1,"cell 2 0 1 1, growx");
		JCheckBox cb2=new JCheckBox("Enable/disable");
		cb2.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange()==ItemEvent.SELECTED)	{
					cb1.setEnabled(false);
				} else {
					cb1.setEnabled(true);					
				}
			}		
		});
		p1.add(cb2,"cell 2 0 1 1");
		

		// centre area
		JScrollPane sp1=new JScrollPane();
		p1.add(sp1,"cell 1 1 1 1,grow");
		JPanel sppanel1=new JPanel();
		sp1.getViewport().add(sppanel1);
		JTextArea ta3=new JTextArea("Text area yayayay ayyayyay ay aya yaya ay ayavfbgfdbgfb ya ya");
		sppanel1.add(ta3);
		sppanel1.add(new JButton("Button in ScrollPane"));
		sppanel1.add(new JButton("Another button in ScrollPane"));
		sppanel1.add(new JButton("Yet another button in ScrollPane"));
		
		// centre right (radio buttons split with JList)
		JSplitPane split2=new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		
		ButtonGroup radioGroup=new ButtonGroup();
		JRadioButton rb1=new JRadioButton("Radio 1");
		JRadioButton rb2=new JRadioButton("Radio 2");
		JRadioButton rb3=new JRadioButton("Radio 3");
		JRadioButton rb4=new JRadioButton("Radio 4");
		JPanel radioPanel=new JPanel();
		radioGroup.add(rb1);
		radioGroup.add(rb2);
		radioGroup.add(rb3);
		radioGroup.add(rb4);
		radioPanel.add(rb1);
		radioPanel.add(rb2);
		radioPanel.add(rb3);
		radioPanel.add(rb4);
		
		DefaultListModel<String> listModel=new DefaultListModel<String>();
		listModel.addElement("Alpha");
		listModel.addElement("Beta");
		listModel.addElement("Gamma");
		listModel.addElement("Delta");
		JList<String> jl1=new JList<String>(listModel);
		jl1.setCellRenderer(new SteamPunkCellRenderer());
		
		split2.add(JSplitPane.TOP,radioPanel);
		split2.add(JSplitPane.BOTTOM,jl1);
		p1.add(split2,"cell 2 1 1 1,grow");
		
		
		// Tabbed panel at bottom
		JTabbedPane tabbed=new JTabbedPane();
		JPanel tab1=new JPanel();
		tab1.add(new JButton("Alpha button"));

		JPanel tab2=new JPanel();
		tab2.add(new JButton("Beta button"));

		JPanel tab3=new JPanel();
		tab3.setBorder(SteamPunkBorder.FILLED_BORDER);
		tab3.add(new JButton("Gamma button"));

		
		tabbed.addTab("Alpha", tab1);
		tabbed.addTab("Beta", tab2);
		tabbed.addTab("Gamma", tab3);
		p1.add(tabbed,"cell 0 2 3 1,grow");
		
		
		// menu
		JMenuBar menuBar=new JMenuBar();
		JMenu m1=new JMenu("Test Menu");
		m1.add(new JMenuItem("Hello"));
		menuBar.add(m1);
		frame.setJMenuBar(menuBar);
		
		
		// final frame launch
		frame.setSize(800,600);
		frame.setVisible(true);
		frame.validate();
		
		 
	}

}
