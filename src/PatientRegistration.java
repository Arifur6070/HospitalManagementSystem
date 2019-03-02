import java.awt.event.*;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class PatientRegistration extends JFrame implements ActionListener {

		private JPanel panel;
		private JButton buttonBack,buttonReg,buttonCabin_status;
		private JLabel labelName,labelCabin_no,labelPhone,labelDate,labelType,labelPrice;
		private JTextField textName,textCabin_no,textPhone,textDate,textType,textPrice;
		private String stringtxtName="",stringtxtCabin_no="",stringtxtPhone="",stringtxtDate="",stringtxtType="",stringtxtPrice="";
		private int inttxtCabin_no,inttxtPrice;
		private JTable table;
		private JScrollPane scrollPane;
		private DefaultTableModel tableModel;
		
		public PatientRegistration()
		{
			this.initializeComponents();
		}
		
		public void actionPerformed(ActionEvent event)
		{
			String buttonText = event.getActionCommand();
			if(buttonText.equals("Register"))
			{
				stringtxtCabin_no=textCabin_no.getText();
				inttxtCabin_no=Integer.valueOf(stringtxtCabin_no);
				stringtxtName=textName.getText();
				stringtxtPhone=textPhone.getText();
				
				DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
				Date date = new Date();
				stringtxtDate = dateFormat.format(date);
				
				
				//stringtxtDate=textDate.getText();
				stringtxtType=textType.getText();
				stringtxtPrice=textPrice.getText();
				inttxtPrice=Integer.valueOf(stringtxtPrice);
				
				Database db=new Database();
				db.insertToPatient(stringtxtName,inttxtCabin_no,stringtxtPhone,stringtxtDate,stringtxtType,inttxtPrice);
				try{
				if (inttxtCabin_no==0 || stringtxtName.equals("") || stringtxtPhone.equals("") || stringtxtType.equals("") || inttxtPrice==0)
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
				UserFrame uf=new UserFrame();
				uf.setVisible(true);
				this.setVisible(false);
			}
		}
		
		private void initializeComponents()
		{
			this.panel = new JPanel();
			this.panel.setLayout(null);
			
			
			this.labelName = new JLabel("Patient Name");
			this.labelName.setBounds(20, 20, 80, 20);
			this.panel.add(this.labelName);
			
			
			this.textName = new JTextField();
			this.textName.setBounds(110, 20, 120, 20);
			this.panel.add(this.textName);
			
			this.labelCabin_no = new JLabel("Cabin No.");
			this.labelCabin_no.setBounds(20, 50, 80, 20);
			this.panel.add(this.labelCabin_no);
			
			
			this.textCabin_no = new JTextField();
			this.textCabin_no.setBounds(110, 50, 120, 20);
			this.panel.add(this.textCabin_no);
			
			this.labelPhone = new JLabel("Phone No.");
			this.labelPhone.setBounds(20, 80, 80, 20);
			this.panel.add(this.labelPhone);
			
			
			this.textPhone = new JTextField();
			this.textPhone.setBounds(110, 80, 120, 20);
			this.panel.add(this.textPhone);
			
			this.labelType = new JLabel("Type");
			this.labelType.setBounds(20, 110, 80, 20);
			this.panel.add(this.labelType);
			
			
			this.textType = new JTextField();
			this.textType.setBounds(110, 110, 120, 20);
			this.panel.add(this.textType);
			
			this.labelPrice = new JLabel("Price");
			this.labelPrice.setBounds(20, 140, 80, 20);
			this.panel.add(this.labelPrice);
			
			
			this.textPrice = new JTextField();
			this.textPrice.setBounds(110, 140, 120, 20);
			this.panel.add(this.textPrice);
			
			this.buttonCabin_status = new JButton("Cabin Status");
			this.buttonCabin_status.setBounds(100, 250, 120, 30);
			this.buttonCabin_status.addActionListener(this);
			this.panel.add(this.buttonCabin_status);
			
			this.buttonReg = new JButton("Register");
			this.buttonReg.setBounds(250, 250, 120, 30);
			this.buttonReg.addActionListener(this);
			this.panel.add(this.buttonReg);
			
			
			
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
			Date date = new Date();
			String time = dateFormat.format(date);
			System.out.println(time);
			
			
			
			this.buttonBack = new JButton("Back");
			this.buttonBack.setBounds(400, 250, 70, 30);
			this.buttonBack.addActionListener(this);
			this.panel.add(this.buttonBack);
			
			this.add(this.panel);
			
			this.setTitle("Booking Window");
			this.setSize(650, 350);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}

}

