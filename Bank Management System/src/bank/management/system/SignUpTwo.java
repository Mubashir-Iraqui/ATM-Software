package bank.management.system;

import java.awt.Color;

import java.awt.event.*;

import java.awt.Font;
import javax.swing.*;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


public class SignUpTwo extends JFrame implements ActionListener {
	
	JTextField panTextField,aadharTextField;
	JButton next;
	JRadioButton yes,no,yesEA,noEA,other;
	JComboBox religionBox,categoryBox,incomeBox,occupationBox;
	String formno;
	
	SignUpTwo(String formno){
		this.formno = formno;
		setLayout(null);
		
		JLabel Additionaldetails = new JLabel("Page-2: Additional Details");
		Additionaldetails.setFont(new Font("Raleway", Font.BOLD,28));
		Additionaldetails.setBounds(200, 0, 600, 50);
		add(Additionaldetails);
		
		JLabel religion = new JLabel("Religion:");
		religion.setFont(new Font("Raleway", Font.BOLD,20));
		religion.setBounds(100, 70, 100, 30);
		add(religion);
		
		String valReligion[]= {"Hindu","Muslim","Christian","Other"};
		religionBox = new JComboBox(valReligion);
		religionBox.setBounds(290,70,300,30);
		religionBox.setBackground(Color.WHITE);
		add(religionBox);
		
		JLabel category = new JLabel("Category : ");
		category.setFont(new Font("Raleway", Font.BOLD,20));
		category.setBounds(100, 130, 200, 30);
		add(category);
		
		String valCategory[]= {"Open","SC","ST","OBC"};
		categoryBox = new JComboBox(valCategory);
		categoryBox.setBounds(290,130,300,30);
		categoryBox.setBackground(Color.WHITE);
		add(categoryBox);
		
		
		JLabel income = new JLabel("Annual Income(Rs): ");
		income.setFont(new Font("Raleway", Font.BOLD,20));
		income.setBounds(100, 190, 200, 30);
		add(income);
		
		String valIncome[]= {"Null","<200000","<400000","400000+"};
		incomeBox = new JComboBox(valIncome);
		incomeBox.setBounds(290,190,300,30);
		incomeBox.setBackground(Color.WHITE);
		add(incomeBox);
		
		
		JLabel Seniorcitizen = new JLabel("Senior Citizen: ");
		Seniorcitizen.setFont(new Font("Raleway", Font.BOLD,20));
		Seniorcitizen.setBounds(100, 250, 200, 30);
		add(Seniorcitizen);
		
		yes = new JRadioButton("Yes");
		yes.setBounds(290, 250, 140, 30);
		yes.setBackground(Color.WHITE);
		add(yes);
		
		no = new JRadioButton("No");
		no.setBounds(440, 250, 140, 30);
		no.setBackground(Color.WHITE);
		add(no);
		
		ButtonGroup gendergroup = new ButtonGroup();
		gendergroup.add(yes);
		gendergroup.add(no);
		
		
		JLabel occupation = new JLabel("Occupation: ");
		occupation.setFont(new Font("Raleway", Font.BOLD,20));
		occupation.setBounds(100, 310, 200, 30);
		add(occupation);
		
		String valOccupation[]= {"Service","Business","Other"};
		occupationBox = new JComboBox(valOccupation);
		occupationBox.setBounds(290,310,300,30);
		occupationBox.setBackground(Color.WHITE);
		add(occupationBox);
		

		JLabel existingAccount = new JLabel("Existing Account: ");
		existingAccount.setFont(new Font("Raleway", Font.BOLD,20));
		existingAccount.setBounds(100, 370, 200, 30);
		add(existingAccount);
		
		yesEA = new JRadioButton("Yes");
		yesEA.setBounds(290, 370, 100, 30);
		yesEA.setBackground(Color.WHITE);
		add(yesEA);
		
		noEA = new JRadioButton("No");
		noEA.setBounds(400, 370, 100, 30);
		noEA.setBackground(Color.WHITE);
		add(noEA);
		
		
		ButtonGroup existingAccountB = new ButtonGroup();
		existingAccountB.add(yesEA);
		existingAccountB.add(noEA);
		
		
		
		JLabel pan = new JLabel("Pan No: ");
		pan.setFont(new Font("Raleway", Font.BOLD,20));
		pan.setBounds(100, 430, 200, 30);
		add(pan);
		
		panTextField =new JTextField();
		panTextField.setFont(new Font("Arial", Font.BOLD,18));
		panTextField.setBounds(290, 430, 300, 30);
		add(panTextField);
		
		JLabel aadhar = new JLabel("Aadhar No: ");
		aadhar.setFont(new Font("Raleway", Font.BOLD,20));
		aadhar.setBounds(100, 490, 200, 30);
		add(aadhar);
		
		aadharTextField =new JTextField();
		aadharTextField.setFont(new Font("Arial", Font.BOLD,18));
		aadharTextField.setBounds(290, 490, 300, 30);
		add(aadharTextField);
		
		next = new JButton("Next");
		next.setBackground(Color.BLACK);
		next.setForeground(Color.WHITE);
		next.setBounds(630,600,80,30);
		next.addActionListener(this);
		add(next);
		
		
		
		
		getContentPane().setBackground(new Color(200,220,255));
		setTitle("AUTOMATED TELLER MACHINE");
		setResizable( false );
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(750,700);
		setLocation(350,8);
		setVisible(true);
	}

	

	@Override
	public void actionPerformed(ActionEvent ae) {
		String religion = (String)religionBox.getSelectedItem();
		String category= (String)categoryBox.getSelectedItem();
		String income = (String)incomeBox.getSelectedItem();
		String occupation = (String)occupationBox.getSelectedItem();
		String citizen = null;
		if(yes.isSelected()) {
			citizen = "yes";
		}else {
			citizen="No";
		}
		String existing_account = null;
		if(yesEA.isSelected()) {
			existing_account = "yes";
		}else {
			existing_account="No";
		}
		 String pan = panTextField.getText();
		 String aadhar = aadharTextField.getText();
		
		
		try {
				Conn c= new Conn();
				String query = "insert into signuptwo values('"+formno+"','"+religion+"','"+category+"','"+income+"','"+citizen+"','"+occupation+"','"+existing_account+"','"+pan+"','"+aadhar+"')";
			c.s.executeUpdate(query);
			
			setVisible(false);
			new SignUpThree(formno).setVisible(true);
			
		}
		catch (Exception e) {
			System.out.println(e);
		}
		
	}
	
public static void main(String[] args) {
		
		new SignUpTwo("");

	}

}

