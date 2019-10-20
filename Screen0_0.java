package com.nitdelhi.finalproject;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class Screen0_0 extends JFrame implements ActionListener {
public JFrame f = new JFrame("Student Institute Management System");
public JPanel p = new JPanel();
public JButton s,a;
public JLabel photo;
	public Screen0_0()
	{
		// DataBase.DataBaseStart();
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
		s = new JButton("Student Login");
		s.setBounds(50,50,150,25);
		p.add(s);
		
		a = new JButton("Admin Login");
		a.setBounds(50,125,150,25);
		p.add(a);
		
		photo = new JLabel();
		photo.setIcon(new ImageIcon("D:\\Images for Final_Project//Users.png"));
		photo.setBounds(225,15,150,150);
		p.add(photo);
		
		s.addActionListener(this);
		a.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent ae)
	{
		try
		{
		if(ae.getSource()==s)
		{
			Screen0_1 sc = new Screen0_1();
			sc.f.setVisible(true);
			f.dispose();
			//JOptionPane.showMessageDialog(null,"You are logging in as Student","Alert",1);
		}
		else if(ae.getSource()==a)
		{
			Screen0_2 sc2 = new Screen0_2();
			sc2.f.setVisible(true);
			f.dispose();
			//JOptionPane.showMessageDialog(null,"You are logging in as Admin","Alert",1);
		}
		
		}catch(Exception e)
		{
			System.out.println("Error Occured.."+e.getMessage());
		}
	}
	public static void main(String args[])
	{
		try
		{
			new Screen0_0();
			//DataBase.addStudentUserMap("Vardhan", "123456");
		}catch(Exception e)
		{
			System.out.println(e);
		}
	      JFrame.setDefaultLookAndFeelDecorated(true);
		}
}

