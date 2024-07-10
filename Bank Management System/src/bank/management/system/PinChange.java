package bank.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class PinChange extends JFrame implements ActionListener {
	
	String pinNumber;
	JButton submit,back;
	JPasswordField pinField,repinField;
	
	PinChange(String pinNumber){
		this.pinNumber=pinNumber ;
		
		setLayout(null);
		ImageIcon i1 = new ImageIcon("F:\\NEWERA\\JAVA 2.O\\Bank Management System\\src\\icons\\icon.jpg");
		Image i2 = i1.getImage().getScaledInstance(600, 730, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0,0,600,650);
		add(image);
		
		JLabel text = new JLabel("Change your PIN");
		text.setBounds(185,220,200,30);
		text.setForeground(new Color(0,0,0));
		text.setFont(new Font("System",Font.BOLD,18));
		image.add(text);
		
		JLabel pintext = new JLabel("New PIN");
		pintext.setBounds(150,260,100,30);
		pintext.setForeground(new Color(0,0,0));
		pintext.setFont(new Font("System",Font.BOLD,13));
		image.add(pintext);
		
		pinField = new JPasswordField();
		pinField.setBounds(280,265,50,20);
		pinField.setForeground(new Color(0,0,0));
		pinField.setFont(new Font("System",Font.BOLD,13));
		image.add(pinField);
		
		
		JLabel repin = new JLabel("Re-Enter New PIN");
		repin.setBounds(150,300,200,30);
		repin.setForeground(new Color(0,0,0));
		repin.setFont(new Font("System",Font.BOLD,13));
		image.add(repin);
		
		repinField = new JPasswordField();
		repinField.setBounds(280,305,50,20);
		repinField.setForeground(new Color(0,0,0));
		repinField.setFont(new Font("System",Font.BOLD,13));
		image.add(repinField);
		
		submit = new JButton("Submit");
		submit.setBounds(280,355,75,20);
		submit.setBackground(new Color(0,0,0));
		submit.setForeground(Color.WHITE);
		submit.setFont(new Font("System",Font.BOLD,12));
		submit.addActionListener(this);
		image.add(submit);
		
		back = new JButton("Back");
		back.setBounds(150,355,75,20);
		back.setBackground(new Color(0,0,0));
		back.setForeground(Color.WHITE);
		back.setFont(new Font("System",Font.BOLD,12));
		back.addActionListener(this);
		image.add(back);
		
		
		
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
		
		if(ae.getSource()==submit) {
		try {
			String npin = pinField.getText();
			String rpin = repinField.getText();
			
			if(npin.equals("")) {
				JOptionPane.showMessageDialog(null, "Please enter pin ");
				return;
			}
			
			if(rpin.equals("")) {
				JOptionPane.showMessageDialog(null, "Please re enter new pin ");
				return;
			}
			if(!npin.equals(rpin)) {
				JOptionPane.showMessageDialog(null, "Entered pin does not match ");
				return;
			}
			
			Conn conn = new Conn();
			String query1 = "update bank set pin = '"+rpin+"' where pin = '"+pinNumber+"'";
			String query2 = "update login set pin = '"+rpin+"' where pin = '"+pinNumber+"'";
			String query3 = "update signupthree set pin = '"+rpin+"' where pin  = '"+pinNumber+"'";
			
			conn.s.executeUpdate(query1);
			conn.s.executeUpdate(query2);
			conn.s.executeUpdate(query3);
			
			JOptionPane.showMessageDialog(null, "Pin Changed Successfully");
			
			setVisible(false);
			new Transactions(rpin).setVisible(true);
		}
		catch(Exception e) {
			System.out.println(e);
		}
		}
		else {
			setVisible(false);
			new Transactions(pinNumber).setVisible(true);
		}
		
		
	}
	
	

	public static void main(String[] args) {
		
		new PinChange("").setVisible(true);

	}

	

}
