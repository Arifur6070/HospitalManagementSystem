
import java.awt.event.*;
import javax.swing.*;

public class UserFrame extends JFrame implements ActionListener {
	private JPanel panel;
	private JButton buttonPreg,buttonPcout,buttonPlist,buttonClist,buttonDlist,buttonLogout,buttonExit;

	public UserFrame()
	{
		this.initializeComponents();
	}
	public void actionPerformed(ActionEvent event)
	{
		String buttonText = event.getActionCommand();
		if(buttonText.equals("Patient Registration"))
		{
			PatientRegistration preg=new PatientRegistration();
			preg.setVisible(true);
			this.setVisible(false);
		}
		
		else if(buttonText.equals("Patient List"))
		{
			UserPatientList upl=new UserPatientList();
			upl.setVisible(true);
			this.setVisible(false);
		}
		
		else if(buttonText.equals("Patient Checkout"))
		{
			PatientCheckout pout=new PatientCheckout();
			pout.setVisible(true);
			this.setVisible(false);
		}
		
		
		else if(buttonText.equals("Cabin List"))
		{
			UserCabinList ucl=new UserCabinList();
			ucl.setVisible(true);
			this.setVisible(false);
		}
		
		else if(buttonText.equals("Doctor List"))
		{
			UserDoctorList udl=new UserDoctorList();
			udl.setVisible(true);
			this.setVisible(false);
		}
		
		else if(buttonText.equals("Logout"))
		{
			LoginFrame lf=new LoginFrame();
			lf.setVisible(true);
			this.setVisible(false);
		}
		
		else if(buttonText.equals("Exit"))
		{
			System.exit(0);
		}
	}
	
	private void initializeComponents()
	{
		this.panel = new JPanel();
		this.panel.setLayout(null);
					
		this.buttonPreg = new JButton("Patient Registration");
		this.buttonPreg.setBounds(120, 20, 180, 30);
		this.buttonPreg.addActionListener(this);
		this.panel.add(this.buttonPreg);
		
		this.buttonPlist = new JButton("Patient List");
		this.buttonPlist.setBounds(120, 60, 180, 30);
		this.buttonPlist.addActionListener(this);
		this.panel.add(this.buttonPlist);
		
		this.buttonPcout = new JButton("Patient Checkout");
		this.buttonPcout.setBounds(120, 100, 180, 30);
		this.buttonPcout.addActionListener(this);
		this.panel.add(this.buttonPcout);
		
	    this.buttonClist = new JButton("Cabin List");
		this.buttonClist.setBounds(120, 140, 180, 30);
		this.buttonClist.addActionListener(this);
		this.panel.add(this.buttonClist);
		
		this.buttonDlist = new JButton("Doctor List");
		this.buttonDlist.setBounds(120, 180, 180, 30);
		this.buttonDlist.addActionListener(this);
		this.panel.add(this.buttonDlist);
		
		this.buttonLogout = new JButton("Logout");
		this.buttonLogout.setBounds(120, 220, 180, 30);
		this.buttonLogout.addActionListener(this);
		this.panel.add(this.buttonLogout);

		this.buttonExit = new JButton("Exit");
		this.buttonExit.setBounds(120, 260, 180, 30);
		this.buttonExit.addActionListener(this);
		this.panel.add(this.buttonExit);
		
		this.add(this.panel);
		
		this.setTitle("Receptionist Window");
		this.setSize(400, 350);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}


}
