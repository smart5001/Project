package com.nitdelhi.finalproject;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


@SuppressWarnings("serial")
public class Screen2_1 extends JFrame implements ActionListener 
{
	public JFrame f = new JFrame("Add a Student");
	public JPanel p = new JPanel ();
	public JLabel sid,pass;
	public JTextField id,key;
	public JButton l,b;
	
	public Screen2_1()
	{
		 p.setLayout(null);
		 paneldesign();
		 f.add(p);
		 f.setSize(420,200);
		 f.setVisible(true);
		 f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		 int w = f.getSize().width;
		 int h = f.getSize().height;
		 int x = (dim.width-w)/2;
		 int y = (dim.height-h)/2;
		 f.setLocation(x, y);
    	 f.setResizable(true);
	}
	
	public void paneldesign()
	{
		sid = new JLabel("Student Id: ");
		sid.setBounds(25,25,150,25);
		p.add(sid);
		
		pass = new JLabel("Password: ");
		pass.setBounds(25,75,150,25);
		p.add(pass);
		
		id = new JTextField();
		id.setBounds(200,25,150,25);
		p.add(id);
		
		key = new JPasswordField();
		key.setBounds(200,75,150,25);
		p.add(key);
		
		l = new JButton("Add");
		l.setBounds(25,125,150,25);
		p.add(l);
		
		b = new JButton("Back");
		b.setBounds(200,125,150,25);
		p.add(b);
		
		l.addActionListener(this);
		b.addActionListener(this);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent ae)
	{
		try
		{
		if(ae.getSource()==l)
		{
			if(id.getText().equalsIgnoreCase("") || key.getText().equalsIgnoreCase(""))
			{
				JOptionPane.showMessageDialog(null,"Please fill all the details","Alert",1);
			}
			else
			{
				DataBase.addStudentUserMap(id.getText(),key.getText());
				JOptionPane.showMessageDialog(null,"Student added!!","Alert",1);
			}
		}
		else if(ae.getSource()==b)
		{
			Screen2 sca =new Screen2();
			sca.f.setVisible(true);
			f.dispose();
		}
		}catch(Exception ac)
		{
			System.out.println(ac.toString());
		}
	}
	public static void main(String args[])
	{
		try
		{
			new Screen2_1();
		}catch(Exception e)
		{
			System.out.println(e);
		}
	      JFrame.setDefaultLookAndFeelDecorated(true);
		}

}
