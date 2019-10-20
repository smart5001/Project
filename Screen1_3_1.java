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
public class Screen1_3_1 extends JFrame implements ActionListener {
	public JLabel ti,ci,mo;
	@SuppressWarnings("rawtypes")
	public JComboBox cid,mode;
	public JButton sub,bk;
	public JFrame f = new JFrame();
	public JPanel p = new JPanel();
	public Screen1_3_1()
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
		ti = new JLabel("New Course Registration");
		ti.setBounds(50,10,300,25);
		p.add(ti);
		
		ci = new JLabel("Course Id: ");
		ci.setBounds(25,60,100,25);
		p.add(ci);
		
		mo = new JLabel("Mode: ");
		mo.setBounds(25,110,100,25);
		p.add(mo);
		
		cid = new JComboBox();
		cid.setBounds(150,60,200,25);
		for(String s: DataBase.CourseMap.keySet())
		{
			String b = s;
			cid.addItem(b);
		}
		p.add(cid);
		
		mode = new JComboBox();
		mode.setBounds(150,110,200,25);
		mode.addItem("study");
		mode.addItem("exam");
		p.add(mode);
		
		sub = new JButton("Submit");
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
				//System.out.println("I am Here");
				String s1[][]= new String [10][2];
				int i =0;
				while(DataBase.UserCourseMap.get(DataBase.UserId)[i][0]!=null)
				{
					//System.out.println("I am Here2");
					s1[i]=DataBase.UserCourseMap.get(DataBase.UserId)[i];
					//System.out.println(DataBase.UserId);
					//System.out.println(DataBase.UserCourseMap.get(DataBase.UserId)[i][0]);
					i++;
				}
				//System.out.println("I am here 3");
				String p[] = new String[2];
				p[0]=cid.getSelectedItem().toString();
				p[1]=mode.getSelectedItem().toString();
				s1[i]=p;
				DataBase.addUserCourseMap(DataBase.getUserId(),s1);
				JOptionPane.showMessageDialog(null,"Course Added!","Alert",1);
			}
			else
			{
				Screen1_3 sce =new Screen1_3();
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
			new Screen1_3_1();
		}catch(Exception e)
		{
			System.out.println(e);
		}
	      JFrame.setDefaultLookAndFeelDecorated(true);
		}
}
