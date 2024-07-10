package bank.management.system;

import java.awt.*;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;
import java.util.Date;

import javax.swing.*;

public class Withdraw extends JFrame implements ActionListener {
	
	JTextField amount;
	JButton Withdraw, back;
	String pinNumber;
	Withdraw(String pinNumber){
		this.pinNumber = pinNumber;
		
		setLayout(null);
		ImageIcon i1 = new ImageIcon("F:\\NEWERA\\JAVA 2.O\\Bank Management System\\src\\icons\\icon.jpg");
		Image i2 = i1.getImage().getScaledInstance(600, 730, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0,0,600,650);
		add(image);
		
		
		JLabel text = new JLabel("Enter Withdraw amount");
		text.setBounds(180,245,300,30);
		text.setForeground(new Color(0,0,0));
		text.setFont(new Font("System",Font.BOLD,14));
		image.add(text);
		
		amount = new JTextField();
		amount.setBounds(180,300,150,20);
		amount.setBackground(Color.WHITE);
		image.add(amount);
		
		Withdraw = new JButton("Withdraw");
		Withdraw.setBounds(270,355,90,20);
		Withdraw.setBackground(Color.black);
		Withdraw.setForeground(Color.WHITE);
		Withdraw.addActionListener(this);
		image.add(Withdraw);
		
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
		
		if(ae.getSource()==Withdraw) {
			
			String number = amount.getText();
			Date date = new Date();
			if(number=="") {
				JOptionPane.showMessageDialog(null, "Please enter amount you want to Withdraw");
			}
			else {
				
				try {
					Conn conn = new Conn();
					String query ="insert into bank values('"+pinNumber+"','"+date+"','Withdraw','"+number+"')";
					conn.s.executeUpdate(query);
					JOptionPane.showMessageDialog(null, "Rs "+number+" Withdrawed Succesfully");
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
		
		new Withdraw("");
		

	}

	

}