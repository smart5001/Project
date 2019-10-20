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

@SuppressWarnings("serial")
public class Screen1_1_3 extends JFrame implements ActionListener {
	public JLabel ti,ci,mo;
	String s = DataBase.UserId;
	@SuppressWarnings("rawtypes")
	public JComboBox cid;
	public JButton sub,bk;
	public JFrame f = new JFrame();
	public JPanel p = new JPanel();
	public Screen1_1_3()
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
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void paneldesign()
	{
		ti = new JLabel("New Payment");
		ti.setBounds(50,10,300,25);
		p.add(ti);
		
		ci = new JLabel("Payment Id: ");
		ci.setBounds(25,60,100,25);
		p.add(ci);
		
		//mo = new JLabel("Mode: ");
		//mo.setBounds(25,110,100,25);
		//p.add(mo);
		
		cid = new JComboBox();
		cid.setBounds(150,60,200,25);
		int i =0;
		while(i<=DataBase.UserPendingFeesMap.size())
		{
			cid.addItem(DataBase.UserPendingFeesMap.get(s)[i][0]);
			i++;
		}
		p.add(cid);
		
		
		sub = new JButton("Pay");
		sub.setBounds(25,160,100,25);
		p.add(sub);
		
		bk = new JButton("Back");
		bk.setBounds(150,160,100,25);
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
				JOptionPane.showMessageDialog(null,"You will be redirected to payment page.","Alert",1);
				String s1[][]= new String [10][3];
				int i =0;
				while(DataBase.UserPastFeesMap.get(DataBase.UserId)[i][0]!=null)
				{
					//System.out.println("I am Here2");
					s1[i]=DataBase.UserPastFeesMap.get(DataBase.UserId)[i];
					//System.out.println(DataBase.UserId);
					//System.out.println(DataBase.UserCourseMap.get(DataBase.UserId)[i][0]);
					i++;
				}
				String[] p = new String[3];
				int q = 0;
				while(q<=9)
				{
					if(cid.getSelectedItem().toString().equals(DataBase.UserPendingFeesMap.get(DataBase.UserId)[q][0]))
					{
						break;
					}
					else
						q++;
				}
				p[0] = cid.getSelectedItem().toString();
				p[1] = DataBase.UserPendingFeesMap.get(DataBase.UserId)[q][1].toString();
				p[2] = DataBase.UserPendingFeesMap.get(DataBase.UserId)[q][2].toString();
				s1[i]=p;
				DataBase.addPastFeesMap(DataBase.UserId, s1);
				DataBase.removePendingFeesMap(DataBase.UserId,cid.getSelectedItem().toString());
			}
			else
			{
				Screen1_1 sce =new Screen1_1();
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
			new Screen1_1_3();
		}catch(Exception e)
		{
			System.out.println(e);
		}
	      JFrame.setDefaultLookAndFeelDecorated(true);
		}
}
