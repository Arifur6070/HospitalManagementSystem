import java.awt.event.*;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class AddCabin extends JFrame implements ActionListener {

		private JPanel panel;
		private JButton buttonBack,buttonAdd;
		private JLabel labelName,labelCabin_no,label_type,label_price;
		private JTextField textName,textCabin_no,textType,textPrice;
		private String stringtxtName="",stringtxtCabin_no="",stringtxtType="",stringtxtPrice="";
		private int inttxtCabin_no;
		
		public AddCabin()
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
				stringtxtType=textType.getText();
				stringtxtPrice=textPrice.getText();
				
				Database db=new Database();
				db.insertToCabin(inttxtCabin_no,stringtxtName,stringtxtType,stringtxtPrice);
				try{
				if (inttxtCabin_no==0 || stringtxtName.equals("") ||stringtxtType.equals("") || stringtxtPrice.equals(""))
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
			
			this.buttonAdd = new JButton("Add");
			this.buttonAdd.setBounds(100, 250, 70, 30);
			this.buttonAdd.addActionListener(this);
			this.panel.add(this.buttonAdd);
			
			
			
			this.buttonBack = new JButton("Back");
			this.buttonBack.setBounds(200, 250, 70, 30);
			this.buttonBack.addActionListener(this);
			this.panel.add(this.buttonBack);
			
			this.add(this.panel);
			
			this.setTitle("Booking Window");
			this.setSize(650, 350);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}

}

