
import java.awt.event.*;
import javax.swing.*;

public class HomeFrame extends JFrame implements ActionListener {
	private JPanel panel;
	private JButton buttonPlist,buttonClist,buttonDlist,buttonLogout,buttonExit;

	public HomeFrame()
	{
		this.initializeComponents();
	}
	public void actionPerformed(ActionEvent event)
	{
		String buttonText = event.getActionCommand();
		if(buttonText.equals("Patient List"))
		{
			PatientList plist=new PatientList();
			plist.setVisible(true);
			this.setVisible(false);
		}
		
		else if(buttonText.equals("Cabin List"))
		{
			CabinList clist=new CabinList();
			clist.setVisible(true);
			this.setVisible(false);
		}
		
		else if(buttonText.equals("Doctor List"))
		{
			DoctorList dl=new DoctorList();
			dl.setVisible(true);
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
					
		this.buttonPlist = new JButton("Patient List");
		this.buttonPlist.setBounds(150, 20, 120, 30);
		this.buttonPlist.addActionListener(this);
		this.panel.add(this.buttonPlist);
		
	    this.buttonClist = new JButton("Cabin List");
		this.buttonClist.setBounds(150, 70, 120, 30);
		this.buttonClist.addActionListener(this);
		this.panel.add(this.buttonClist);
		
		this.buttonDlist = new JButton("Doctor List");
		this.buttonDlist.setBounds(150, 120, 120, 30);
		this.buttonDlist.addActionListener(this);
		this.panel.add(this.buttonDlist);
		
		this.buttonLogout = new JButton("Logout");
		this.buttonLogout.setBounds(150, 170, 120, 30);
		this.buttonLogout.addActionListener(this);
		this.panel.add(this.buttonLogout);

		this.buttonExit = new JButton("Exit");
		this.buttonExit.setBounds(150, 220, 120, 30);
		this.buttonExit.addActionListener(this);
		this.panel.add(this.buttonExit);
		
		this.add(this.panel);
		
		this.setTitle("Admin Home Window");
		this.setSize(400, 350);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}


}
