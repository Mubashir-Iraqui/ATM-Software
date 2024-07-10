package bank.management.system;
import java.awt.*;

import java.awt.event.*;
import java.sql.ResultSet;

import javax.swing.*;

public class Login extends JFrame implements ActionListener {
	JButton login,signup,clear;
	JTextField cardTextField;
	JPasswordField pinTextField;
	
	
	
	Login(){
		setLayout(null);
		ImageIcon icon = new ImageIcon("F:\\NEWERA\\JAVA 2.O\\Bank Management System\\src\\icons\\logo.jpg");
		Image i2 = icon.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel label = new JLabel(i3);
		add(label);
		
		JLabel text = new JLabel("Welcome to ATM");
		text.setFont(new Font("Osward", Font.BOLD,38));
		add(text);
		text.setBounds(250, 40, 400, 40);
		
		JLabel cardno = new JLabel("Card No:");
		cardno.setFont(new Font("Raleway", Font.BOLD,28));
		add(cardno);
		cardno.setBounds(120, 150, 150, 40);
		
		cardTextField = new JTextField();
		cardTextField.setBounds(300,150,250,40);
		cardTextField.setFont(new Font("Arial", Font.BOLD, 14));
		add(cardTextField);
		
		
		JLabel pin = new JLabel("Pin:");
		pin.setFont(new Font("Raleway", Font.BOLD,28));
		add(pin);
		pin.setBounds(120, 220, 250, 40);
		
		pinTextField = new JPasswordField();
		pinTextField.setBounds(300,220,250,40);
		pinTextField.setFont(new Font("Arial", Font.BOLD, 14));
		add(pinTextField);
		
		login = new JButton("LOG IN");
		login.setBounds(300,290,110,35);
		login.setBackground(Color.BLACK);
		login.setForeground(Color.LIGHT_GRAY);
		login.addActionListener(this);
		add(login);
		
		clear = new JButton("CLEAR");
		clear.setBounds(440,290,110,35);
		clear.setBackground(Color.BLACK);
		clear.setForeground(Color.LIGHT_GRAY);
		clear.addActionListener(this);
		add(clear);
		
		signup = new JButton("SIGN UP");
		signup.setBounds(350,350,150,35);
		signup.setBackground(Color.BLACK);
		signup.setForeground(Color.LIGHT_GRAY);
		signup.addActionListener(this);
		add(signup);
		
		
		getContentPane().setBackground(new Color(200,220,255));
		label.setBounds(70, 10, 100, 100);
		setTitle("AUTOMATED TELLER MACHINE");
		setResizable( false );
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800,480);
		setVisible(true);
		setLocation(300,100);
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == login) {
			
			Conn conn = new Conn();
			String cardNumber = cardTextField.getText();
			String pinNumber = pinTextField.getText();
			
			String query ="Select * from login where cardnumber= '"+cardNumber+"'and pin = '"+pinNumber+"'";
			
			try {
				ResultSet rs = conn.s.executeQuery(query);
				if(rs.next()) {
					setVisible(false);
					new Transactions(pinNumber).setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null, "Incorrect details");
				}
				
			}
			catch(Exception e) {
				System.out.println(e);
			}
			
		}
		else if(ae.getSource() == clear) {
			cardTextField.setText("");
			pinTextField.setText("");
			
		}
		else if(ae.getSource()== signup) {
			setVisible(false);
			SignUpOne SignUpOne = new SignUpOne();
			
		}
		
		
	}
	

	public static void main(String[] args) {
		Login L = new Login();
		

	}
	

}
