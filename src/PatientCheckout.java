import java.awt.event.*;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class PatientCheckout extends JFrame implements ActionListener {

		private JPanel panel;
		private JButton buttonBack,buttonCout,buttonPatient_status;
		private JLabel labelName,labelCabin_no;
		private JTextField textName,textCabin_no;
		private String stringtxtName="",stringtxtCabin_no="";
		private int inttxtCabin_no;
		private JTable table;
		private JScrollPane scrollPane;
		private DefaultTableModel tableModel;
		
		public PatientCheckout()
		{
			this.initializeComponents();
		}
		
		public void actionPerformed(ActionEvent event)
		{
			String buttonText = event.getActionCommand();
			if (buttonText.equals("CheckOut")) 
				{
				stringtxtCabin_no=textCabin_no.getText();
				inttxtCabin_no=Integer.valueOf(stringtxtCabin_no);
				stringtxtName=textName.getText();
				//stringtxtType=textType.getText();
				//stringtxtPrice=textPrice.getText();
				
				Database db=new Database();
					db.deletePatient(stringtxtName,inttxtCabin_no);
					
					JOptionPane.showMessageDialog(this, "1 Patient Checked Out");
					
				}
			else if (buttonText.equals("Patient Status"))
			{
				Database context = new Database();
				Vector<String> columns = new Vector<String>();
				columns.add("Patient_name");
				columns.add("Cabin No.");
				columns.add("Price");
				
				this.tableModel = new DefaultTableModel(context.getpatientlist(), columns);
				
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
			
			this.labelCabin_no = new JLabel("Cabin No");
			this.labelCabin_no.setBounds(20, 50, 80, 20);
			this.panel.add(this.labelCabin_no);
			
			
			this.textCabin_no = new JTextField();
			this.textCabin_no.setBounds(110, 50, 120, 20);
			this.panel.add(this.textCabin_no);
			
			
				
			this.buttonPatient_status = new JButton("Patient Status");
			this.buttonPatient_status.setBounds(120, 350, 120, 30);
			this.buttonPatient_status.addActionListener(this);
			this.panel.add(this.buttonPatient_status);
			
			this.buttonCout = new JButton("CheckOut");
			this.buttonCout.setBounds(270, 350, 90, 30);
			this.buttonCout.addActionListener(this);
			this.panel.add(this.buttonCout);
			
			
			this.buttonBack = new JButton("Back");
			this.buttonBack.setBounds(400, 350, 90, 30);
			this.buttonBack.addActionListener(this);
			this.panel.add(this.buttonBack);
			
			this.add(this.panel);
			
			this.setTitle("Patient CheckOut Window");
			this.setSize(700, 450);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}

}

