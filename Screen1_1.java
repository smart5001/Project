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
public class Screen1_1 extends JFrame implements ActionListener
{

	public JFrame f = new JFrame();
	public JPanel p = new JPanel();
	public JButton li,co,at,lo;
	public JLabel fe;
	public Screen1_1()
	{
		 p.setLayout(null);
		 paneldesign();
		 f.add(p);
		 f.setSize(300,300);
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
		fe = new JLabel("Fee Payments");
		fe.setBounds(50,0,200,25);
		p.add(fe);
		
		li = new JButton("View Past Payments");
		li.setBounds(50,50,200,25);
		p.add(li);
		
		co = new JButton("View Pending Payments");
		co.setBounds(50,100,200,25);
		p.add(co);
		
		at = new JButton("Pay Fee");
		at.setBounds(50,150,200,25);
		p.add(at);
		
		lo = new JButton("Back");
		lo.setBounds(50,200,200,25);
		p.add(lo);
		
		li.addActionListener(this);
		co.addActionListener(this);
		at.addActionListener(this);
		lo.addActionListener(this);
		
	}	
	
	@Override
	public void actionPerformed(ActionEvent ae)
	{
		try
		{
			if(ae.getSource()==li)
			{
				Screen1_1_1 scb =new Screen1_1_1();
				scb.f.setVisible(true);
				f.dispose();
				//JOptionPane.showMessageDialog(null,"Screen not available","Alert",1);
			}
			else if(ae.getSource()==co)
			{
				Screen1_1_2 scc =new Screen1_1_2();
				scc.f.setVisible(true);
				f.dispose();
				//JOptionPane.showMessageDialog(null,"Screen not available","Alert",1);
			}
			else if(ae.getSource()==at)
			{
				Screen1_1_3 scd =new Screen1_1_3();
				scd.f.setVisible(true);
				f.dispose();
				//JOptionPane.showMessageDialog(null,"Screen not available","Alert",1);
			}
			else if(ae.getSource()==lo)
			{
				Screen1 sce =new Screen1();
				sce.f.setVisible(true);
				f.dispose();
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
			new Screen1_1();
		}catch(Exception e)
		{
			System.out.println(e);
		}
	      JFrame.setDefaultLookAndFeelDecorated(true);
		}
}
