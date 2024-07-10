package bank.management.system;

import java.awt.*;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import java.util.Date;

import javax.swing.*;

public class Deposit extends JFrame implements ActionListener {
	
	JTextField amount;
	JButton deposit, back;
	String pinNumber;
	Deposit(String pinNumber){
		this.pinNumber = pinNumber;
		
		setLayout(null);
		ImageIcon i1 = new ImageIcon("F:\\NEWERA\\JAVA 2.O\\Bank Management System\\src\\icons\\icon.jpg");
		Image i2 = i1.getImage().getScaledInstance(600, 730, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0,0,600,650);
		add(image);
		
		
		JLabel text = new JLabel("Enter deposit amount");
		text.setBounds(180,245,300,30);
		text.setForeground(new Color(0,0,0));
		text.setFont(new Font("System",Font.BOLD,14));
		image.add(text);
		
		amount = new JTextField();
		amount.setBounds(180,300,150,20);
		amount.setBackground(Color.WHITE);
		image.add(amount);
		
		deposit = new JButton("Deposit");
		deposit.setBounds(275,355,80,20);
		deposit.setBackground(Color.black);
		deposit.setForeground(Color.WHITE);
		deposit.addActionListener(this);
		image.add(deposit);
		
		back = new JButton("Back");
		back.setBounds(150,355,70,20);
		back.setBackground(Color.black);
		back.setForeground(Color.WHITE);
		back.addActionListener(this);
		image.add(back);
		
		
		setTitle("AUTOMATED TELLER MACHINE");
		setResizable( false );
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(600,10);
		setSize(600,650);
		//setUndecorated(true);
		setVisible(true);;
		
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		
		if(ae.getSource()==deposit) {
			
			String number = amount.getText();
			Date date = new Date();
			if(number=="") {
				JOptionPane.showMessageDialog(null, "Please enter amount you want to deposit");
			}
			else {
				
				try {
					Conn conn = new Conn();
					String query ="insert into bank values('"+pinNumber+"','"+date+"','Deposit','"+number+"')";
					conn.s.executeUpdate(query);
					JOptionPane.showMessageDialog(null, "Rs "+number+" Deposited Succesfully");
					setVisible(false);
					new Transactions(pinNumber).setVisible(true);
				}
				catch(Exception e) {
					System.out.println(e);
				}
					
				}
				
			}
	else if(ae.getSource()==back){
			setVisible(false);
			new Transactions(pinNumber).setVisible(true);}
			
		}

	public static void main(String[] args) {
		
		new Deposit("");
		

	}

	

}
