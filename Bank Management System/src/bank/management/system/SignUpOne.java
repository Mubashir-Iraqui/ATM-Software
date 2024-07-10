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

import java.util.*;

import com.toedter.calendar.JDateChooser;

public class SignUpOne extends JFrame implements ActionListener {
	
	long random;
	JTextField nameTextField, fnameTextField,
	emailTextField,addressTextField,cityTextField;
	JButton next;
	JRadioButton male,female,married,unmarried,other;
	JDateChooser dateChooser;
	
	SignUpOne(){
		setLayout(null);
		
		Random ran = new Random();
		random = Math.abs((ran.nextLong() % 9000L) +1000L);
		
		
		JLabel formno = new JLabel("APPLICATION FORM NO:  "+ random);
		formno.setFont(new Font("Raleway", Font.BOLD,34));
		formno.setBounds(120, 20, 600, 40);
		add(formno);
		
		JLabel Personaldetails = new JLabel("Page-1 : Personal Details");
		Personaldetails.setFont(new Font("Raleway", Font.BOLD,24));
		Personaldetails.setBounds(240, 80, 600, 50);
		add(Personaldetails);
		
		JLabel name = new JLabel("Name:");
		name.setFont(new Font("Raleway", Font.BOLD,16));
		name.setBounds(100, 170, 100, 30);
		add(name);
		
		nameTextField =new JTextField();
		nameTextField.setFont(new Font("Arial", Font.BOLD,16));
		nameTextField.setBounds(290, 170, 300, 30);
		add(nameTextField);
		
		JLabel fname = new JLabel("Father's Name: ");
		fname.setFont(new Font("Raleway", Font.BOLD,16));
		fname.setBounds(100, 230, 200, 30);
		add(fname);
		
		fnameTextField =new JTextField();
		fnameTextField.setFont(new Font("Arial", Font.BOLD,16));
		fnameTextField.setBounds(290, 230, 300, 30);
		add(fnameTextField);
		
		JLabel dob = new JLabel("Date of birth: ");
		dob.setFont(new Font("Raleway", Font.BOLD,16));
		dob.setBounds(100, 290, 200, 30);
		add(dob);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(290, 290, 300, 30);
		add(dateChooser);
		
		JLabel gender = new JLabel("Gender: ");
		gender.setFont(new Font("Raleway", Font.BOLD,16));
		gender.setBounds(100, 350, 200, 30);
		add(gender);
		
		male = new JRadioButton("Male");
		male.setBounds(290, 350, 140, 16);
		male.setBackground(new Color(200,220,255));
		add(male);
		
		female = new JRadioButton("Female");
		female.setBounds(440, 350, 140, 16);
		female.setBackground(new Color(200,220,255));
		add(female);
		
		ButtonGroup gendergroup = new ButtonGroup();
		gendergroup.add(male);
		gendergroup.add(female);
		
		
		JLabel email = new JLabel("Email: ");
		email.setFont(new Font("Raleway", Font.BOLD,16));
		email.setBounds(100, 410, 200, 30);
		add(email);
		
		emailTextField =new JTextField();
		emailTextField.setFont(new Font("Arial", Font.BOLD,16));
		emailTextField.setBounds(290, 410, 300, 30);
		add(emailTextField);
		
		JLabel marital = new JLabel("Marital Status: ");
		marital.setFont(new Font("Raleway", Font.BOLD,16));
		marital.setBounds(100, 470, 200, 30);
		add(marital);
		
		married = new JRadioButton("Married");
		married.setBounds(290, 470, 100, 30);
		married.setBackground(new Color(200,220,255));
		add(married);
		
		unmarried = new JRadioButton("Unmarried");
		unmarried.setBounds(400, 470, 100, 30);
		unmarried.setBackground(new Color(200,220,255));
		add(unmarried);
		
		other = new JRadioButton("Other");
		other.setBounds(510, 470, 100, 30);
		other.setBackground(new Color(200,220,255));
		add(other);
		
		ButtonGroup maritalgroup = new ButtonGroup();
		maritalgroup.add(married);
		maritalgroup.add(unmarried);
		maritalgroup.add(other);
		
		
		
		JLabel address = new JLabel("Address: ");
		address.setFont(new Font("Raleway", Font.BOLD,16));
		address.setBounds(100, 530, 200, 30);
		add(address);
		
		addressTextField =new JTextField();
		addressTextField.setFont(new Font("Arial", Font.BOLD,16));
		addressTextField.setBounds(290, 530, 300, 30);
		add(addressTextField);
		
		JLabel city = new JLabel("City: ");
		city.setFont(new Font("Raleway", Font.BOLD,16));
		city.setBounds(100, 590, 200, 30);
		add(city);
		
		cityTextField =new JTextField();
		cityTextField.setFont(new Font("Arial", Font.BOLD,16));
		cityTextField.setBounds(290, 590, 300, 30);
		add(cityTextField);
		
		next = new JButton("Next");
		next.setBackground(Color.BLACK);
		next.setForeground(Color.WHITE);
		next.setBounds(630,620,80,30);
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
		String formno = ""+random;
		String name = nameTextField.getText();
		String fname= fnameTextField.getText();
		String dob =((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
		String gender=null;
		if(male.isSelected()) {
			gender = "male";
		}
		else if(female.isSelected()) {
			gender = "female";
		}
		String email = emailTextField.getText();
		String marital = null;
		if(married.isSelected()) {
			marital ="married";
		}else if(unmarried.isSelected()) {
			marital ="unmarried";
		}else if(other.isSelected()){
			marital ="other";
		}
		String address = addressTextField.getText();
		String city = cityTextField.getText();
		
		
		try {
			if(name.equals("")) {
				JOptionPane.showMessageDialog(null, "Name is required");
			}
			else {
				Conn c= new Conn();
				String query = "insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"')";
			c.s.executeUpdate(query);
			
			setVisible(false);
			new SignUpTwo(formno).setVisible(true);
			}
			
		}
		catch (Exception e) {
			System.out.println(e);
		}
		
	}
	
public static void main(String[] args) {
		
		new SignUpOne();

	}

}
