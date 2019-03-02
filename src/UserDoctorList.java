import java.awt.event.*;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;



public class UserDoctorList extends JFrame implements ActionListener {
	private JPanel panel;
	private JTable table;
	private JScrollPane scrollPane;
	private DefaultTableModel tableModel;
	private JButton buttonBack,buttonAddDoc,buttonDelDoc,buttonUpDoc;
	
	public UserDoctorList()
	{
		this.initializeComponents();
	}
	
	public void actionPerformed(ActionEvent event)
	{
		String buttonText = event.getActionCommand();
		if(buttonText.equals("Exit"))
		{
			System.exit(0);
		}
		
		else if(buttonText.equals("Back"))
		{
			UserFrame uf=new UserFrame();
			uf.setVisible(true);
			this.setVisible(false);
		}
	}
	private void initializeComponents()
	{
		this.panel = new JPanel();
		this.panel.setLayout(null);
		
		Database context = new Database();
		Vector<String> columns = new Vector<String>();
		columns.add("Doctor Name");
		columns.add("Cabin No");
		columns.add("Phone");
		columns.add("Address");
		columns.add("Working Hour");
		columns.add("Salary");
		
		this.tableModel = new DefaultTableModel(context.getdoctorlist(), columns);
		
		this.table = new JTable(this.tableModel);
		this.table.getColumnModel().getColumn(0).setPreferredWidth(80);
		this.table.getColumnModel().getColumn(1).setPreferredWidth(150);
		this.table.getColumnModel().getColumn(2).setPreferredWidth(100);
		this.table.getColumnModel().getColumn(3).setPreferredWidth(150);
		this.table.getColumnModel().getColumn(4).setPreferredWidth(120);
		this.table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		
		this.scrollPane = new JScrollPane(this.table);
		this.scrollPane.setBounds(0, 0, 500, 250);
		this.panel.add(this.scrollPane);
		
		
		this.buttonBack = new JButton("Back");
		this.buttonBack.setBounds(530, 220, 90, 20);
		this.buttonBack.addActionListener(this);
		this.panel.add(this.buttonBack);
		
		this.add(this.panel);
		
		this.setTitle("Doctor List Window");
		this.setSize(650, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}
