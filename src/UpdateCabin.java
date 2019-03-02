import java.awt.event.*;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class UpdateCabin extends JFrame implements ActionListener {

		private JPanel panel;
		private JButton buttonBack,buttonUpdate,buttonCabin_status;
		private JLabel labelName,labelCabin_no,label_type,label_price;
		private JTextField textName,textCabin_no,textType,textPrice;
		private String stringtxtName="",stringtxtCabin_no="",stringtxtType="",stringtxtPrice="";
		private int inttxtCabin_no;
		private JTable table;
		private JScrollPane scrollPane;
		private DefaultTableModel tableModel;
		
		public UpdateCabin()
		{
			this.initializeComponents();
		}
		
		public void actionPerformed(ActionEvent event)
		{
			String buttonText = event.getActionCommand();
			if (buttonText.equals("Update")) 
				{
				stringtxtCabin_no=textCabin_no.getText();
				inttxtCabin_no=Integer.valueOf(stringtxtCabin_no);
				stringtxtName=textName.getText();
				stringtxtType=textType.getText();
				stringtxtPrice=textPrice.getText();
				
				Database db=new Database();
					db.updateCabin(inttxtCabin_no,stringtxtName,stringtxtType,stringtxtPrice);
					
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
				CabinList cl=new CabinList();
				cl.setVisible(true);
				this.setVisible(false);
			}
		}
		
		private void initializeComponents()
		{
			this.panel = new JPanel();
			this.panel.setLayout(null);
			
			
			this.labelCabin_no = new JLabel("Cabin No.");
			this.labelCabin_no.setBounds(20, 20, 80, 20);
			this.panel.add(this.labelCabin_no);
			
			
			this.textCabin_no = new JTextField();
			this.textCabin_no.setBounds(110, 20, 120, 20);
			this.panel.add(this.textCabin_no);
			
			this.labelName = new JLabel("NAME");
			this.labelName.setBounds(20, 50, 80, 20);
			this.panel.add(this.labelName);
			
			
			this.textName = new JTextField();
			this.textName.setBounds(110, 50, 120, 20);
			this.panel.add(this.textName);
			
			
			this.label_type = new JLabel("Type");
			this.label_type.setBounds(20, 80, 80, 20);
			this.panel.add(this.label_type);
			
			
			this.textType = new JTextField();
			this.textType.setBounds(110, 80, 120, 20);
			this.panel.add(this.textType);
			
			this.label_price = new JLabel("Price");
			this.label_price.setBounds(20, 110, 80, 20);
			this.panel.add(this.label_price);
			
			
			this.textPrice = new JTextField();
			this.textPrice.setBounds(110, 110, 120, 20);
			this.panel.add(this.textPrice);
				
			this.buttonCabin_status = new JButton("Cabin Status");
			this.buttonCabin_status.setBounds(120, 350, 120, 30);
			this.buttonCabin_status.addActionListener(this);
			this.panel.add(this.buttonCabin_status);
			
			this.buttonUpdate = new JButton("Update");
			this.buttonUpdate.setBounds(270, 350, 90, 30);
			this.buttonUpdate.addActionListener(this);
			this.panel.add(this.buttonUpdate);
			
			
			this.buttonBack = new JButton("Back");
			this.buttonBack.setBounds(400, 350, 90, 30);
			this.buttonBack.addActionListener(this);
			this.panel.add(this.buttonBack);
			
			this.add(this.panel);
			
			this.setTitle("Update Cabin Window");
			this.setSize(700, 450);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}

}

