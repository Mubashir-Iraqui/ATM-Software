package bank.management.system;

import java.awt.Color;
import java.sql.*;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MiniStatement extends JFrame implements ActionListener {
	
	String pinNumber;
	
	MiniStatement(String pinNumber){
		
		this.pinNumber = pinNumber;
		
		
		setLayout(null);
		
		JLabel mini = new JLabel();
		mini.setBounds(20,140,400,200);
		add(mini);
		
		JLabel bank = new JLabel("Indian Bank");
		bank.setFont(new Font("Raleway", Font.BOLD,28));
		bank.setBounds(230,20,200,30);
		add(bank);
		
		
		JLabel card = new JLabel();
		card.setBounds(20,40,300,20);
		add(card);
		
		JLabel balance = new JLabel();
		balance.setBounds(20,80,200,30);
		add(balance);
		
		JLabel pTrans = new JLabel("Previous Transactions");
		pTrans.setBounds(20,130,200,30);
		add(pTrans);
		
		try {
			
			
			Conn conn = new Conn();
			ResultSet rs =conn.s.executeQuery("select * from login where pin = '"+pinNumber+"'");
			while(rs.next()) {
				card.setText("Card no : "+rs.getString("cardnumber").substring(0,4)+"XXXX"+rs.getString("cardnumber").substring(9));
				
			}
			
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
try {
	        int bal=0;
			Conn conn = new Conn();
			ResultSet rs =conn.s.executeQuery("select * from bank where pin = '"+pinNumber+"'");
			while(rs.next()) {
				mini.setText(mini.getText() +"<html>"+ rs.getString("date")+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("amount")+"<br><br><html>");
				if(rs.getString("type").equals("Deposit")) {
					bal+= Integer.parseInt(rs.getString("amount"));
				}
				else {
					bal -= Integer.parseInt(rs.getString("amount"));
				}
			}
			balance.setText("Your current balance is "+bal);
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		
		setTitle("Mini statement");
		setSize(600,400);
		setLocation(100,100);
		//getContentPane().setBackground(Color.WHITE);
		getContentPane().setBackground(new Color(200,220,255));
		setVisible(true);
		
		
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		
		
	}

	public static void main(String[] args) {
		new MiniStatement("");

	}

	

}
