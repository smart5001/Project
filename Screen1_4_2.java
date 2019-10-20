package com.nitdelhi.finalproject;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Screen1_4_2 extends JFrame implements ActionListener {
	public JLabel ti,ci,mo;
	@SuppressWarnings("rawtypes")
	public JComboBox cid;
	public JButton sub,bk;
	public JTextField mode;
	public JFrame f = new JFrame();
	public JPanel p = new JPanel();
	public Screen1_4_2()
	{
		 p.setLayout(null);
		 paneldesign();
		 f.add(p);
		 f.setSize(420,400);
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
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void paneldesign()
	{
		ti = new JLabel("Complaint Form");
		ti.setBounds(100,10,300,25);
		p.add(ti);
		
		ci = new JLabel("Complaint to: ");
		ci.setBounds(25,60,100,25);
		p.add(ci);
		
		mo = new JLabel("Complaint Text: ");
		mo.setBounds(25,110,100,25);
		p.add(mo);
		
		cid = new JComboBox();
		cid.setBounds(150,60,200,25);
		cid.addItem("Dean-Academics");
		cid.addItem("Dean-Student Welfare");
		cid.addItem("HOD ECE");
		cid.addItem("HOD EEE");
		cid.addItem("HOD CSE");
		p.add(cid);
		
		mode = new JTextField();
		mode.setBounds(150,110,200,225);
		p.add(mode);
		
		sub = new JButton("Submit");
		sub.setBounds(25,360,100,25);
		p.add(sub);
		
		bk = new JButton("Back");
		bk.setBounds(150,360,100,25);
		p.add(bk);
		
		sub.addActionListener(this);
		bk.addActionListener(this);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) 
	{
		try
		{
			if(ae.getSource()==sub)
			{
				JOptionPane.showMessageDialog(null,"Complaint Sent!!","Alert",1);
			}
			else
			{
				Screen1_4 sce =new Screen1_4();
				sce.f.setVisible(true);
				f.dispose();
			}
			
		}catch(Exception e)
		{
			System.out.println("Error Occured...!!"+e.getMessage());
		}
	}
	public static void main(String args[])
	{
		try
		{
			new Screen1_4_2();
		}catch(Exception e)
		{
			System.out.println(e);
		}
	      JFrame.setDefaultLookAndFeelDecorated(true);
		}
}
