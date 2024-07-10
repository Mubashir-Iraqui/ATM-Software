package bank.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.*;

public class Transactions extends JFrame implements ActionListener {
	
	JButton deposit,cashWithdrawal,fastcash,statement,pinChange,balanceEnquiry,exit;
	String pinNumber;
	
	Transactions(String pinNumber){
		this.pinNumber = pinNumber;
		
		
		
		setLayout(null);
		ImageIcon i1 = new ImageIcon("F:\\NEWERA\\JAVA 2.O\\Bank Management System\\src\\icons\\icon.jpg");
		Image i2 = i1.getImage().getScaledInstance(600, 730, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0,0,600,650);
		add(image);
		
		
		JLabel text = new JLabel("Please Select your Transaction");
		text.setBounds(153,210,200,30);
		text.setForeground(new Color(0,0,0));
		text.setFont(new Font("System",Font.BOLD,13));
		image.add(text);
		
		
		deposit = new JButton("Deposit");
		deposit.setBackground(Color.black);
		deposit.setForeground(Color.white);
		deposit.setBounds(140,292,100,18);
		deposit.addActionListener(this);
		add(deposit);
		
		cashWithdrawal = new JButton("Withdraw");
		cashWithdrawal.setBackground(Color.black);
		cashWithdrawal.setForeground(Color.white);
		cashWithdrawal.setBounds(140,314,100,18);
		cashWithdrawal.addActionListener(this);
		add(cashWithdrawal);
		
		fastcash = new JButton("Fast Cash");
		fastcash.setBackground(Color.black);
		fastcash.setForeground(Color.white);
		fastcash.setBounds(140,336,100,18);
		fastcash.addActionListener(this);
		add(fastcash);
		
		statement = new JButton("Statement");
		statement.setBackground(Color.black);
		statement.setForeground(Color.white);
		statement.setBounds(266,336,100,18);
		statement.addActionListener(this);
		add(statement);
		
		pinChange = new JButton("Pin Change");
		pinChange.setBackground(Color.black);
		pinChange.setForeground(Color.white);
		pinChange.setBounds(266,292,100,18);
		pinChange.addActionListener(this);
		add(pinChange);
		
		balanceEnquiry = new JButton("Balance");
		balanceEnquiry.setBackground(Color.black);
		balanceEnquiry.setForeground(Color.white);
		balanceEnquiry.setBounds(266,314,100,18);
		balanceEnquiry.addActionListener(this);
		add(balanceEnquiry);
		
		
		exit = new JButton("Exit");
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
			new Login().setVisible(true);
		}
		else if(ae.getSource()==deposit) {
			setVisible(false);
			new Deposit(pinNumber).setVisible(true);
		}
		else if(ae.getSource()==cashWithdrawal) {
			setVisible(false);
			new Withdraw(pinNumber).setVisible(true);
		}
		else if(ae.getSource()==fastcash) {
			setVisible(false);
			new FastCash(pinNumber).setVisible(true);
		}
		else if(ae.getSource()==pinChange) {
			setVisible(false);
			new PinChange(pinNumber).setVisible(true);
		}
		else if(ae.getSource()==balanceEnquiry) {
			setVisible(false);
			new BalanceEnquiry(pinNumber).setVisible(true);
		}
		else if(ae.getSource()==statement) {
			//setVisible(false);
			new MiniStatement(pinNumber).setVisible(true);
		}
		
	}



	public static void main(String[] args) {
		new Transactions("");
		

	}
}

	
