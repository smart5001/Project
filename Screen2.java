package com.nitdelhi.finalproject;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Screen2 extends JFrame implements ActionListener
{

	public JFrame f = new JFrame();
	public JPanel p = new JPanel();
	public JButton fe,li,lo,at,pe,ne;
	
	public Screen2()
	{
		 p.setLayout(null);
		 paneldesign();
		 f.add(p);
		 f.setSize(300,350);
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
		fe = new JButton("Add Student");
		fe.setBounds(50,0,200,25);
		p.add(fe);
		
		li = new JButton("Add New Course");
		li.setBounds(50,50,200,25);
		p.add(li);
		
		lo = new JButton("Add Pending Fee");
		lo.setBounds(50,100,200,25);
		p.add(lo);
		
		at = new JButton("Upload Attendance");
		at.setBounds(50,150,200,25);
		p.add(at);
		
		pe = new JButton("View All Students");
		pe.setBounds(50,200,200,25);
		p.add(pe);
		
		ne = new JButton("Log Out");
		ne.setBounds(50,250,200,25);
		p.add(ne);
		
		fe.addActionListener(this);
		li.addActionListener(this);
		lo.addActionListener(this);
		at.addActionListener(this);
		pe.addActionListener(this);
		ne.addActionListener(this);
	}	
	
	@Override
	public void actionPerformed(ActionEvent ae)
	{
		try
		{
			if(ae.getSource()==fe)
			{
				Screen2_1 sca =new Screen2_1();
				sca.f.setVisible(true);
				f.dispose();
				//JOptionPane.showMessageDialog(null,"Screen not available","Alert",1);
			}
			else if(ae.getSource()==li)
			{
				Screen2_2 scb =new Screen2_2();
				scb.f.setVisible(true);
				f.dispose();
				//JOptionPane.showMessageDialog(null,"Screen not available","Alert",1);
			}
			else if(ae.getSource()==at)
			{
				Screen2_3 scc =new Screen2_3();
				scc.f.setVisible(true);
				f.dispose();
				//JOptionPane.showMessageDialog(null,"Screen not available","Alert",1);
			}
			else if(ae.getSource()==lo)
			{
				Screen2_4 scd =new Screen2_4();
				scd.f.setVisible(true);
				f.dispose();
				//JOptionPane.showMessageDialog(null,"Screen not available","Alert",1);
			}
			else if(ae.getSource()==pe)
			{
				System.out.println("I am Here");
				Screen2_5 sce = new Screen2_5();
				System.out.println("I am Here2");
				sce.f.setVisible(true);
				System.out.println("I am Here3");
				f.dispose();
				//JOptionPane.showMessageDialog(null,"Screen not available","Alert",1);
			}
			else if(ae.getSource()==ne)
			{
				Screen0_2 scf =new Screen0_2();
				scf.f.setVisible(true);
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
			new Screen2();
		}catch(Exception e)
		{
			System.out.println(e);
		}
	      JFrame.setDefaultLookAndFeelDecorated(true);
		}
}
