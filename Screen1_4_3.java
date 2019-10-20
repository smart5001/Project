package com.nitdelhi.finalproject;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Screen1_4_3 extends JFrame implements ActionListener{

	public JLabel fw,gt;
	public JButton b;
	public JFrame f = new JFrame("Student Institute Management System");
	public JPanel p = new JPanel();
	public static void main(String[] args)
	{
		try
		{
			new Screen1_4_3();
		}catch(Exception e)
		{
			System.out.println(e);
		}
	      JFrame.setDefaultLookAndFeelDecorated(true);
	}
	public Screen1_4_3()
	{
		 p.setLayout(null);
		 paneldesign();
		 f.add(p);
		 f.setSize(600,400);
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
		fw = new JLabel("Guidelines");
		fw.setBounds(50,50,100,25);
		p.add(fw);
		b = new JButton("Back");
		b.setBounds(50,350,100,25);
		p.add(b);
		gt = new JLabel("sksodioANIOCNIONADIOASNIONS\\n\r\n" + 
				"uigsauduifuidhsuifui\\n\r\n" + 
				"kjbBLFOIAJOIPFHUIUIhqwnoNnndn\\n\r\n" + 
				"bbsudibuibfuibubid\\n\r\n" + 
				"ninoineionionIONONOlonioionljlnofnonnavnjk vweoinw\\n");
		gt.setBounds(10,75,200,200);
		p.add(gt);
		b.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==b)
		{
			Screen1_4 sc = new Screen1_4();
			sc.f.setVisible(true);
			f.dispose();
			//JOptionPane.showMessageDialog(null,"You are logging in as Student","Alert",1);
		}
	}

}
