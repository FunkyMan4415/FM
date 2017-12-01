package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;

public class FMFrame extends JFrame{
	private JLabel lblHeader;
	private JTable table;
	private JScrollPane scrollTable;
	private JProgressBar progBar;
	private JButton btnInfo;
	private JButton btnAdd;
	private JLabel lblHersteller, lblLeistung, lblPreis, lblTyp;
	private JTextField fldHersteller;
	private JSpinner spinLeistung, spinPreis;
	private JComboBox boxTyp; 
	private JPanel pnlAdd;
	private JPanel pnlLeft;
	
	public FMFrame() {
		this.setTitle("Fahrzeug Manager");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		createWidgets();
		setupInteractions();
		addWidgets();
		
		this.pack();
		this.setLocationRelativeTo(null);
	}

	
	
	private void setupInteractions() {
		btnAdd.addActionListener(new AddFahrzeugAction());
	}
	private void createWidgets() {
		lblHeader = new JLabel("Fahrzeug-Manager");
		lblHeader.setFont(lblHeader.getFont().deriveFont(Font.BOLD + Font.ITALIC, 30));
		lblHeader.setForeground(Color.WHITE);
		lblHeader.setBackground(Color.BLACK);
		lblHeader.setOpaque(true);
		lblHeader.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		progBar = new JProgressBar(0, 100);
		progBar.setPreferredSize(new Dimension(0, 30));
		
		table = new JTable(100, 4);
		scrollTable = new JScrollPane(table);
		
		
		btnInfo = new JButton("Information...");
		btnInfo.setAlignmentX(Box.LEFT_ALIGNMENT);
		
		pnlAdd = new JPanel();
		pnlAdd.setLayout(new GridLayout(0, 2, 5, 5));
		
		lblHersteller = new JLabel("Hersteller");
		lblLeistung = new JLabel("Leistung");
		lblPreis = new JLabel("Preis");
		lblTyp = new JLabel("Typ");
		
		
		fldHersteller = new JTextField();
		spinLeistung = new JSpinner(new SpinnerNumberModel(100, 5, 1000, 10));
		spinPreis = new JSpinner(new SpinnerNumberModel(5000, 500, 100000, 100));
		boxTyp = new JComboBox<String>(new String[] {"PKW", "LKW","Motorrad"});
		
		
		btnAdd = new JButton("Hinzufügen");
		
		pnlLeft = new JPanel();
		pnlLeft.setLayout(new BoxLayout(pnlLeft, BoxLayout.PAGE_AXIS));
		pnlLeft.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
	}
	
	private void addWidgets() {
		getContentPane().setLayout(new BorderLayout(5, 5));
		getContentPane().add(BorderLayout.NORTH, lblHeader);
		getContentPane().add(BorderLayout.SOUTH, progBar);
		getContentPane().add(BorderLayout.CENTER, scrollTable);
		getContentPane().add(BorderLayout.LINE_START, pnlLeft);
		
		pnlAdd.add(lblHersteller);
		pnlAdd.add(fldHersteller);
		
		pnlAdd.add(lblLeistung);
		pnlAdd.add(spinLeistung);
		
		pnlAdd.add(lblPreis);
		pnlAdd.add(spinPreis);
		
		pnlAdd.add(lblTyp);
		pnlAdd.add(boxTyp);
		
		pnlAdd.add(Box.createHorizontalGlue());
		pnlAdd.add(btnAdd);
		
		pnlAdd.setMaximumSize(pnlAdd.getPreferredSize());
		pnlAdd.setAlignmentX(Box.LEFT_ALIGNMENT);
		
		pnlLeft.add(pnlAdd);
		pnlLeft.add(Box.createVerticalGlue());
		pnlLeft.add(btnInfo);
		
	}
}
