import java.awt.event.*;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;



public class DoctorList extends JFrame implements ActionListener {
	private JPanel panel;
	private JTable table;
	private JScrollPane scrollPane;
	private DefaultTableModel tableModel;
	private JButton buttonBack,buttonAddDoc,buttonDelDoc,buttonUpDoc;
	
	public DoctorList()
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
		
		else if(buttonText.equals("Add Doctor"))
		{
			AddDoctor ad=new AddDoctor();
			ad.setVisible(true);
			this.setVisible(false);
		}
		
		else if(buttonText.equals("Update Doctor"))
		{
			UpdateDoctor ud=new UpdateDoctor();
			ud.setVisible(true);
			this.setVisible(false);
		}
		
		else if(buttonText.equals("Delete Doctor"))
		{
			DeleteDoctor dd=new DeleteDoctor();
			dd.setVisible(true);
			this.setVisible(false);
		}
		
		
		else if(buttonText.equals("Back"))
		{
			HomeFrame hf=new HomeFrame();
			hf.setVisible(true);
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
		
		this.buttonAddDoc = new JButton("Add Doctor");
		this.buttonAddDoc.setBounds(510, 130, 120, 20);
		this.buttonAddDoc.addActionListener(this);
		this.panel.add(this.buttonAddDoc);
		
		this.buttonUpDoc = new JButton("Update Doctor");
		this.buttonUpDoc.setBounds(510, 160, 120, 20);
		this.buttonUpDoc.addActionListener(this);
		this.panel.add(this.buttonUpDoc);
		
		this.buttonDelDoc = new JButton("Delete Doctor");
		this.buttonDelDoc.setBounds(510, 190, 120, 20);
		this.buttonDelDoc.addActionListener(this);
		this.panel.add(this.buttonDelDoc);
		
		
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
