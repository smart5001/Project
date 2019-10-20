package com.nitdelhi.finalproject;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class Screen1_4_1 extends JFrame implements ActionListener
{
	public JLabel ti;
	public JFrame f=new JFrame();
	public JPanel p=new JPanel();
	public JScrollPane pa;
	public JTable ta;
	public DefaultTableModel def;
	public JButton b;
	
	public Screen1_4_1()
	{
		 p.setLayout(null);
		 paneldesign();
		 f.add(p);
		 f.setSize(650,400);
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
		ti = new JLabel("Course-Wise Attendance");
		ti.setBounds(200,25,250,25);
		p.add(ti);
		def = new DefaultTableModel();
		ta = new JTable(def);
		ta.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		pa=new JScrollPane(ta);
		pa.setBounds(25,75,550,250);
		def.addColumn("Course Id");
		def.addColumn("Attendance");
		int i = 0;
		String sp = DataBase.UserId;
		while(i<=9)
		{
			//System.out.println("I am here 2");
			Object[] o = new Object[2];
			o[0] = DataBase.UserAttendanceMap.get(sp)[i][0];
			o[1] = DataBase.UserAttendanceMap.get(sp)[i][1];
			def.addRow(o);
			i++;
		}
		p.add(pa);
		b = new JButton("Back");
		b.setBounds(25,350,100,25);
		p.add(b);
		b.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent ae)
	{
		try
		{
			if(ae.getSource()==b)
			{
				Screen1_4 sce =new Screen1_4();
				sce.f.setVisible(true);
				f.dispose();
			}
		}catch(Exception e)
		{
			System.out.println("Error Occured..!!" + e.getMessage());
		}
		
	}
	public static void main(String args[])
	{
		try
		{
			new Screen1_4_1();
		}catch(Exception e)
		{
			System.out.println(e);
		}
	      JFrame.setDefaultLookAndFeelDecorated(true);
		}
}
