package bank.management.system;

import java.awt.Color;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;
import java.sql.*;

import javax.swing.ImageIcon;
import javax.swing.*;

public class FastCash extends JFrame implements ActionListener {
	
	JButton hundred,twoH,fiveH,thousand,twoT,fiveT,exit;
	String pinNumber;
	
	FastCash(String pinNumber){
		this.pinNumber = pinNumber;
		
		
		
		setLayout(null);
		ImageIcon i1 = new ImageIcon("F:\\NEWERA\\JAVA 2.O\\Bank Management System\\src\\icons\\icon.jpg");
		Image i2 = i1.getImage().getScaledInstance(600, 730, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0,0,600,650);
		add(image);
		
		
		JLabel text = new JLabel("Select Amount to Withdraw");
		text.setBounds(165,250,200,30);
		text.setForeground(new Color(0,0,0));
		text.setFont(new Font("System",Font.BOLD,13));
		image.add(text);
		
		
		hundred = new JButton("₹ 100");
		hundred.setBackground(Color.black);
		hundred.setForeground(Color.white);
		hundred.setBounds(140,292,100,18);
		hundred.addActionListener(this);
		add(hundred);
		
		twoH = new JButton("₹ 200");
		twoH.setBackground(Color.black);
		twoH.setForeground(Color.white);
		twoH.setBounds(140,314,100,18);
		twoH.addActionListener(this);
		add(twoH);
		
		fiveH = new JButton("₹ 500");
		fiveH.setBackground(Color.black);
		fiveH.setForeground(Color.white);
		fiveH.setBounds(140,336,100,18);
		fiveH.addActionListener(this);
		add(fiveH);
		
		thousand = new JButton("₹ 1000");
		thousand.setBackground(Color.black);
		thousand.setForeground(Color.white);
		thousand.setBounds(266,336,100,18);
		thousand.addActionListener(this);
		add(thousand);
		
		twoT = new JButton("₹ 2000");
		twoT.setBackground(Color.black);
		twoT.setForeground(Color.white);
		twoT.setBounds(266,292,100,18);
		twoT.addActionListener(this);
		add(twoT);
		
		fiveT = new JButton("₹ 5000");
		fiveT.setBackground(Color.black);
		fiveT.setForeground(Color.white);
		fiveT.setBounds(266,314,100,18);
		fiveT.addActionListener(this);
		add(fiveT);
		
		
		exit = new JButton("Cancel");
		exit.setBackground(Color.black);
		exit.setForeground(Color.white);
		exit.setBounds(266,358,100,18);
		exit.addActionListener(this);
		add(exit);
		
		
		
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
		if(ae.getSource()== exit) {
			setVisible(false);
			new Transactions(pinNumber).setVisible(true);
		}
		else {
			String amount = ((JButton)ae.getSource()).getText().substring(2);
			Conn c = new Conn();
			
			try {
				ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinNumber+"'");
				int balance = 0;
				while (rs.next()) {
					if(rs.getString("type").equals("Deposit")) {
						balance+= Integer.parseInt(rs.getString("amount"));
					}
					else {
						balance -= Integer.parseInt(rs.getString("amount"));
					}
				}
					if(ae.getSource()!= exit && balance < Integer.parseInt(amount)) {
						JOptionPane.showMessageDialog(null, "Insufficient balance");
						return;
					}
					Date date = new Date();
					String query ="insert into bank values('"+pinNumber+"','"+date+"','Withdraw','"+amount+"')";
					c.s.executeUpdate(query);
					JOptionPane.showMessageDialog(null, "Rs "+amount+" withdrawl successfully");
					
					setVisible(false);
					new Transactions(pinNumber).setVisible(true);
					
				}
			
			catch(Exception e) {
				System.out.println(e);
			}
		}
		
		
	}



	public static void main(String[] args) {
		new FastCash("");
		

	}
}