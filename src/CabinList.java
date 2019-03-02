import java.awt.event.*;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;



public class CabinList extends JFrame implements ActionListener {
	private JPanel panel;
	private JTable table;
	private JScrollPane scrollPane;
	private DefaultTableModel tableModel;
	private JButton buttonBack,buttonAddCabin,buttonDelCabin,buttonUpCabin;
	
	public CabinList()
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
		
		else if(buttonText.equals("Add Cabin"))
		{
			AddCabin ac=new AddCabin();
			ac.setVisible(true);
			this.setVisible(false);
		}
		
		else if(buttonText.equals("Update Cabin"))
		{
			UpdateCabin uc=new UpdateCabin();
			uc.setVisible(true);
			this.setVisible(false);
		}
		
		else if(buttonText.equals("Delete Cabin"))
		{
			DeleteCabin dc=new DeleteCabin();
			dc.setVisible(true);
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
		columns.add("Cabin No");
		columns.add("Doctor Name");
		columns.add("Type");
		columns.add("Price");
		
		this.tableModel = new DefaultTableModel(context.getcabinlist(), columns);
		
		this.table = new JTable(this.tableModel);
		this.table.getColumnModel().getColumn(0).setPreferredWidth(80);
		this.table.getColumnModel().getColumn(1).setPreferredWidth(150);
		this.table.getColumnModel().getColumn(2).setPreferredWidth(100);
		this.table.getColumnModel().getColumn(3).setPreferredWidth(150);
		this.table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		
		this.scrollPane = new JScrollPane(this.table);
		this.scrollPane.setBounds(0, 0, 500, 250);
		this.panel.add(this.scrollPane);
		
		this.buttonAddCabin = new JButton("Add Cabin");
		this.buttonAddCabin.setBounds(510, 130, 120, 20);
		this.buttonAddCabin.addActionListener(this);
		this.panel.add(this.buttonAddCabin);
		
		this.buttonUpCabin = new JButton("Update Cabin");
		this.buttonUpCabin.setBounds(510, 160, 120, 20);
		this.buttonUpCabin.addActionListener(this);
		this.panel.add(this.buttonUpCabin);
		
		this.buttonDelCabin = new JButton("Delete Cabin");
		this.buttonDelCabin.setBounds(510, 190, 120, 20);
		this.buttonDelCabin.addActionListener(this);
		this.panel.add(this.buttonDelCabin);
		
		this.buttonBack = new JButton("Back");
		this.buttonBack.setBounds(530, 220, 90, 20);
		this.buttonBack.addActionListener(this);
		this.panel.add(this.buttonBack);
		
		this.add(this.panel);
		
		this.setTitle("Cabin List Window");
		this.setSize(650, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}