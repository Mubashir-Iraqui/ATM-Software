package bank.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.sql.*;

public class BalanceEnquiry extends JFrame implements ActionListener {
	
	String pinNumber;
	JButton back,exit;
	
	BalanceEnquiry(String pinNumber){
		
		this.pinNumber = pinNumber;
		
		
		setLayout(null);
		ImageIcon i1 = new ImageIcon("F:\\NEWERA\\JAVA 2.O\\Bank Management System\\src\\icons\\icon.jpg");
		Image i2 = i1.getImage().getScaledInstance(600, 730, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0,0,600,650);
		add(image);
		
		
		back = new JButton("Back");
		back.setBounds(150,355,75,20);
		back.setBackground(new Color(0,0,0));
		back.setForeground(Color.WHITE);
		back.setFont(new Font("System",Font.BOLD,12));
		back.addActionListener(this);
		image.add(back);
		
		
		exit = new JButton("Exit");
		exit.setBounds(280,355,75,20);
		exit.setBackground(new Color(0,0,0));
		exit.setForeground(Color.WHITE);
		exit.setFont(new Font("System",Font.BOLD,12));
		exit.addActionListener(this);
		image.add(exit);
		
		
		Conn c = new Conn();
		int balance = 0;
		
		try {
			ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinNumber+"'");
			
			while (rs.next()) {
				if(rs.getString("type").equals("Deposit")) {
					balance+= Integer.parseInt(rs.getString("amount"));
				}
				else {
					balance -= Integer.parseInt(rs.getString("amount"));
				}
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		JLabel text = new JLabel ("Your current account balance is ");
		text.setBounds(150,300,400,30);
		text.setFont(new Font("System",Font.BOLD,13));
		text.setForeground(Color.BLACK);
		image.add(text);
		
		JLabel text1 = new JLabel ("Rs "+balance);
		text1.setBounds(200,320,100,30);
		text1.setFont(new Font("System",Font.BOLD,16));
		text1.setForeground(Color.BLACK);
		image.add(text1);
		
		
		setTitle("AUTOMATED TELLER MACHINE");
		setResizable( false );
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(600,10);
		setSize(600,650);
		setUndecorated(true);
		setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		
		if(ae.getSource()==exit) {
			setVisible(false);
			new Login().setVisible(true);
		}
		else if(ae.getSource()==back) {
			setVisible(false);
			new Transactions(pinNumber).setVisible(true);
			
		}
		
		
	}

	public static void main(String[] args) {
		new BalanceEnquiry("");

	}

	

}
