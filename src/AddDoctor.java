import java.awt.event.*;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class AddDoctor extends JFrame implements ActionListener {

		private JPanel panel;
		private JButton buttonBack,buttonAdd,buttonCabin_status;
		private JLabel labelName,labelCabin_no,label_phone,label_address,label_hour,label_salary;
		private JTextField textName,textCabin_no,textPhone,textAddress,textHour,textSalary;
		private String stringtxtName="",stringtxtCabin_no="",stringtxtPhone="",stringtxtAddress="",stringtxtHour="",stringtxtSalary="";
		private int inttxtCabin_no;
		private float flttxtSalary,flttxtHour;
		private JTable table;
		private JScrollPane scrollPane;
		private DefaultTableModel tableModel;
		
		public AddDoctor()
		{
			this.initializeComponents();
		}
		
		public void actionPerformed(ActionEvent event)
		{
			String buttonText = event.getActionCommand();
			if(buttonText.equals("Add"))
			{
				stringtxtCabin_no=textCabin_no.getText();
				inttxtCabin_no=Integer.valueOf(stringtxtCabin_no);
				stringtxtName=textName.getText();
				stringtxtPhone=textPhone.getText();
				stringtxtAddress=textAddress.getText();
				stringtxtHour=textHour.getText();
				flttxtHour=Float.valueOf(stringtxtHour);
				stringtxtSalary=textSalary.getText();
				flttxtSalary=Float.valueOf(stringtxtSalary);
				
				Database db=new Database();
				db.insertToDoctor(stringtxtName,inttxtCabin_no,stringtxtPhone,stringtxtAddress,flttxtHour,flttxtSalary);
				try{
				if ( stringtxtName.equals("") || inttxtCabin_no==0 || stringtxtPhone.equals("") || stringtxtAddress.equals("") || flttxtHour==0 || flttxtSalary==0)
				{
					JOptionPane.showMessageDialog(this, "Invalid text field");
				}
				else
				{
				JOptionPane.showMessageDialog(this, "1 rows updated");
				}
				}
				catch(Exception ex)
				{
					
				}
				
			}
			
			else if (buttonText.equals("Cabin Status"))
			{
				Database context = new Database();
				Vector<String> columns = new Vector<String>();
				columns.add("Cabin_no");
				columns.add("Doctor_name");
				columns.add("Type");
				
				this.tableModel = new DefaultTableModel(context.getcabinlist(), columns);
				
				this.table = new JTable(this.tableModel);
				this.table.getColumnModel().getColumn(0).setPreferredWidth(80);
				this.table.getColumnModel().getColumn(1).setPreferredWidth(100);
				this.table.getColumnModel().getColumn(2).setPreferredWidth(100);
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
			
			
			this.labelName = new JLabel("Name");
			this.labelName.setBounds(20, 20, 80, 20);
			this.panel.add(this.labelName);
			
			
			this.textName = new JTextField();
			this.textName.setBounds(110, 20, 120, 20);
			this.panel.add(this.textName);
			
			this.labelCabin_no = new JLabel("Cabin No");
			this.labelCabin_no.setBounds(20, 50, 80, 20);
			this.panel.add(this.labelCabin_no);
			
			
			this.textCabin_no = new JTextField();
			this.textCabin_no.setBounds(110, 50, 120, 20);
			this.panel.add(this.textCabin_no);
			
			
			this.label_phone = new JLabel("Phone");
			this.label_phone.setBounds(20, 80, 80, 20);
			this.panel.add(this.label_phone);
			
			
			this.textPhone = new JTextField();
			this.textPhone.setBounds(110, 80, 120, 20);
			this.panel.add(this.textPhone);
			
			this.label_address = new JLabel("Address");
			this.label_address.setBounds(20, 110, 80, 20);
			this.panel.add(this.label_address);
			
			
			this.textAddress = new JTextField();
			this.textAddress.setBounds(110, 110, 120, 20);
			this.panel.add(this.textAddress);
			
			this.label_hour = new JLabel("Working Hour");
			this.label_hour.setBounds(20, 140, 80, 20);
			this.panel.add(this.label_hour);
			
			
			this.textHour = new JTextField();
			this.textHour.setBounds(110, 140, 120, 20);
			this.panel.add(this.textHour);
			
			this.label_salary = new JLabel("Salary");
			this.label_salary.setBounds(20, 170, 80, 20);
			this.panel.add(this.label_salary);
			
			
			this.textSalary = new JTextField();
			this.textSalary.setBounds(110, 170, 120, 20);
			this.panel.add(this.textSalary);
			
			this.buttonAdd = new JButton("Add");
			this.buttonAdd.setBounds(100, 250, 70, 30);
			this.buttonAdd.addActionListener(this);
			this.panel.add(this.buttonAdd);
			
			
			this.buttonCabin_status = new JButton("Cabin Status");
			this.buttonCabin_status.setBounds(300, 250, 120, 30);
			this.buttonCabin_status.addActionListener(this);
			this.panel.add(this.buttonCabin_status);
			
			
			this.buttonBack = new JButton("Back");
			this.buttonBack.setBounds(200, 250, 70, 30);
			this.buttonBack.addActionListener(this);
			this.panel.add(this.buttonBack);
			
			this.add(this.panel);
			
			this.setTitle("Add Doctor Window");
			this.setSize(650, 350);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}

}

