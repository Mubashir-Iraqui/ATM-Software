package bank.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.*;

public class SignUpThree extends JFrame implements ActionListener {
	
	JRadioButton r1,r2,r3,r4;
	JCheckBox c1,c2,c3,c4,c5,c6,c7;
	JButton cancel,submit;
	String formno;
	
	SignUpThree(String formno){
		formno = this.formno;
		
		
		setLayout(null);
		
		
		JLabel l1 = new JLabel("Page 3: Account Details");
		l1.setFont(new Font("Raleway", Font.BOLD, 28));
		l1.setBounds(220,40,400,40);
		add(l1);
		
		JLabel type = new JLabel("Account Type:");
		type.setFont(new Font("Raleway", Font.BOLD, 16));
		type.setBounds(100,100,200,30);
		add(type);
		
		r1 = new JRadioButton("Saving Account");
		r1.setBounds(270,100,130,30);
		r1.setBackground(new Color(200,220,255));
		add(r1);
		
		r2 = new JRadioButton("Current Account");
		r2.setBounds(470,100,200,30);
		r2.setBackground(new Color(200,220,255));
		add(r2);
		
		r3 = new JRadioButton("Fixed Deposit Account");
		r3.setBounds(270,150,200,30);
		r3.setBackground(new Color(200,220,255));
		add(r3);
		
		r4 = new JRadioButton("Recurring Deposit Account");
		r4.setBounds(470,150,200,30);
		r4.setBackground(new Color(200,220,255));
		add(r4);
		
		ButtonGroup groupaccount = new ButtonGroup();
		groupaccount.add(r1);
		groupaccount.add(r2);
		groupaccount.add(r3);
		groupaccount.add(r4);
		
		JLabel card = new JLabel("Card Number:");
		card.setFont(new Font("Raleway", Font.BOLD, 16));
		card.setBounds(100,210,200,30);
		add(card);
		
		JLabel Cnumber = new JLabel("XXXX-XXXX-XXXX-6541");
		Cnumber.setFont(new Font("Raleway", Font.BOLD, 16));
		Cnumber.setBounds(270,210,250,30);
		add(Cnumber);
		
		JLabel cardnote = new JLabel("(16 digit card number)");
		cardnote.setFont(new Font("Raleway", Font.BOLD, 11));
		cardnote.setBounds(100,240,200,20);
		add(cardnote);
		
		JLabel pin = new JLabel("Pin:");
		pin.setFont(new Font("Raleway", Font.BOLD, 16));
		pin.setBounds(100,270,100,30);
		add(pin);
		
		JLabel pinnote = new JLabel("(4 digit pin number)");
		pinnote.setFont(new Font("Raleway", Font.BOLD, 11));
		pinnote.setBounds(100,300,200,20);
		add(pinnote);
		
		JLabel pnumber = new JLabel("XXXX");
		pnumber.setFont(new Font("Raleway", Font.BOLD, 16));
		pnumber.setBounds(270,270,100,30);
		add(pnumber);
		
		
		JLabel service = new JLabel("Services Required:");
		service.setFont(new Font("Raleway", Font.BOLD, 16));
		service.setBounds(100,350,200,30);
		add(service);
		
		c1 = new JCheckBox("ATM card");
		c1.setBounds(270,350,180,30);
		c1.setFont(new Font("Raleway", Font.BOLD, 16));
		c1.setBackground(new Color(200,220,255));
		add(c1);
		
		c2 = new JCheckBox("Internet Banking");
		c2.setBounds(450,350,200,30);
		c2.setFont(new Font("Raleway", Font.BOLD, 16));
		c2.setBackground(new Color(200,220,255));
		add(c2);
		
		c3 = new JCheckBox("Mobile Banking");
		c3.setBounds(270,380,180,30);
		c3.setFont(new Font("Raleway", Font.BOLD, 16));
		c3.setBackground(new Color(200,220,255));
		add(c3);
		
		c4 = new JCheckBox("Email/SMS");
		c4.setBounds(450,380,200,30);
		c4.setFont(new Font("Raleway", Font.BOLD, 16));
		c4.setBackground(new Color(200,220,255));
		add(c4);
		
		c5 = new JCheckBox("Cheque Book");
		c5.setBounds(270,410,180,30);
		c5.setFont(new Font("Raleway", Font.BOLD, 16));
		c5.setBackground(new Color(200,220,255));
		add(c5);
		
		c6 = new JCheckBox("E-Statement");
		c6.setBounds(450,410,200,30);
		c6.setFont(new Font("Raleway", Font.BOLD, 16));
		c6.setBackground(new Color(200,220,255));
		add(c6);
		
		c7 = new JCheckBox("I hereby declare that the above given knowledge is correct.");
		c7.setBounds(270,460,500,20);
		c7.setFont(new Font("Raleway", Font.BOLD, 12));
		c7.setBackground(new Color(200,220,255));
		add(c7);
		
		cancel = new JButton("Cancel");
		cancel.setBounds(300,550,100,30);
		cancel.setBackground(new Color(0,0,0));
		cancel.setForeground(Color.white);
		cancel.addActionListener(this);
		add(cancel);
		
		submit = new JButton("Submit");
		submit.setBounds(550,550,100,30);
		submit.setBackground(new Color(0,0,0));
		submit.setForeground(Color.white);
		submit.addActionListener(this);
		add(submit);
		
		
		
		getContentPane().setBackground(new Color(200,220,255));
		setTitle("AUTOMATED TELLER MACHINE");
		setResizable( false );
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(750,650);
		setLocation(350,10);
		setVisible(true);
	}

	

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource()== submit) {
			
			String accountType = null;
			if(r1.isSelected()) {
				accountType = "Saving Account";
				
			}else if(r2.isSelected()) {
				accountType = "Current Account";
				
			}
			else if(r3.isSelected()) {
				accountType = "Fixed Deposit Account";
			}
			else if(r4.isSelected()) {
				accountType = "Recurring Deposit Account";
			}
			Random random = new Random();
			
			String cardNumber = "" +Math.abs(random.nextLong()%90000000L + 50409360000L);
			
			String pinNumber = "" + Math.abs(random.nextLong()%9000L+10L);
			
			String facility = "";
			if(c1.isSelected()) {
				facility = facility + " ATM card ";
				
			}else if(c2.isSelected()) {
				facility = facility + " Internet Banking ";
				
			} else if(c3.isSelected()) {
				facility = facility + " Mobile Banking ";
				
			} else if(c4.isSelected()) {
				facility = facility + " Email/SMS ";
				
			} else if(c5.isSelected()) {
				facility = facility + " Cheque Book ";
				
			}else if(c6.isSelected()) {
				facility = facility + " E-Statement ";
				
			}
			
			try {
				if(accountType.equals("")) {
					JOptionPane.showMessageDialog(null, "account type is required");
				}
				else {
					Conn conn = new Conn();
					
					String query1 = "insert into signupthree values('"+formno+"','"+accountType+"','"+cardNumber+"','"+pinNumber+"','"+facility+"') ";
					String query2 = "insert into login values('"+formno+"','"+cardNumber+"','"+pinNumber+"') ";
					
					conn.s.executeUpdate(query1);
					conn.s.executeUpdate(query2);
				
					JOptionPane.showMessageDialog(null, "Your Card Number: "+cardNumber+"\n Pin" + pinNumber);
					setVisible(false);
					new Deposit(pinNumber).setVisible(true);
				}
				
			}
			
			catch(Exception e) {
				
			}
			
		}
		else if (ae.getSource()==cancel) {
			setVisible(false);
			new Login().setVisible(true);
			
		}
		
	}
	
	
public static void main(String[] args) {
		
		
		new SignUpThree("");

	}

}
