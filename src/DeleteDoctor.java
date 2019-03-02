import java.awt.event.*;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class DeleteDoctor extends JFrame implements ActionListener {

		private JPanel panel;
		private JButton buttonBack,buttonDelete,buttonDoctor_status;
		private JLabel labelName;
		private JTextField textName;
		private String stringtxtName="";
		private int inttxtCabin_no;
		private JTable table;
		private JScrollPane scrollPane;
		private DefaultTableModel tableModel;
		
		public DeleteDoctor()
		{
			this.initializeComponents();
		}
		
		public void actionPerformed(ActionEvent event)
		{
			String buttonText = event.getActionCommand();
			if (buttonText.equals("Delete")) 
				{
				//stringtxtCabin_no=textCabin_no.getText();
				//inttxtCabin_no=Integer.valueOf(stringtxtCabin_no);
				stringtxtName=textName.getText();
				//stringtxtType=textType.getText();
				//stringtxtPrice=textPrice.getText();
				
				Database db=new Database();
					db.deleteDoctor(stringtxtName);
					
				}
			else if (buttonText.equals("Doctor Status"))
			{
				Database context = new Database();
				Vector<String> columns = new Vector<String>();
				columns.add("Doctor_name");
				columns.add("Cabin_no");
				
				this.tableModel = new DefaultTableModel(context.getdoctorlist(), columns);
				
				this.table = new JTable(this.tableModel);
				this.table.getColumnModel().getColumn(0).setPreferredWidth(80);
				this.table.getColumnModel().getColumn(1).setPreferredWidth(100);
				//this.table.getColumnModel().getColumn(2).setPreferredWidth(100);
				this.table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				
				
				this.scrollPane = new JScrollPane(this.table);
				this.scrollPane.setBounds(400, 50, 200, 150);
				this.panel.add(this.scrollPane);
				
				
			}
			
			
			else if(buttonText.equals("Back"))
			{
				DoctorList dl=new DoctorList();
				dl.setVisible(true);
				this.setVisible(false);
			}
		}
		
		private void initializeComponents()
		{
			this.panel = new JPanel();
			this.panel.setLayout(null);
			
			
			this.labelName = new JLabel("Doctor Name");
			this.labelName.setBounds(20, 20, 80, 20);
			this.panel.add(this.labelName);
			
			
			this.textName = new JTextField();
			this.textName.setBounds(110, 20, 120, 20);
			this.panel.add(this.textName);
			
			
				
			this.buttonDoctor_status = new JButton("Doctor Status");
			this.buttonDoctor_status.setBounds(120, 350, 120, 30);
			this.buttonDoctor_status.addActionListener(this);
			this.panel.add(this.buttonDoctor_status);
			
			this.buttonDelete = new JButton("Delete");
			this.buttonDelete.setBounds(270, 350, 90, 30);
			this.buttonDelete.addActionListener(this);
			this.panel.add(this.buttonDelete);
			
			
			this.buttonBack = new JButton("Back");
			this.buttonBack.setBounds(400, 350, 90, 30);
			this.buttonBack.addActionListener(this);
			this.panel.add(this.buttonBack);
			
			this.add(this.panel);
			
			this.setTitle("Delete Doctor Window");
			this.setSize(700, 450);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}

}

