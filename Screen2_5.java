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
public class Screen2_5  extends JFrame implements ActionListener
{
	public JLabel ti;
	public JFrame f=new JFrame();
	public JPanel p=new JPanel();
	public JScrollPane pa;
	public JTable ta;
	public DefaultTableModel def;
	public JButton b;
	public Screen2_5()
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
		ti = new JLabel("Students Information");
		ti.setBounds(200,25,250,25);
		p.add(ti);
		def = new DefaultTableModel();
		ta = new JTable(def);
		ta.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		pa=new JScrollPane(ta);
		pa.setBounds(25,75,550,250);
		def.addColumn("Student Id");
		def.addColumn("Courses Registered");
		for(String p : DataBase.StudentUserMap.keySet())
		{
			int i = 0;
			String s = "";
			Object[] o = new Object[2];
			o[0] = p;
			while(DataBase.UserCourseMap.get(p)[i][0]!=null)
			{
				s = s + DataBase.UserCourseMap.get(p)[i][0];
				if(i<DataBase.UserCourseMap.size()-1)
					s=s+",";
				i++;		
			}
			o[1] = s;
			def.addRow(o);
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
				Screen2 sce =new Screen2();
				sce.f.setVisible(true);
				f.dispose();
			}
		}catch(Exception e)
		{
			System.out.println("Error Occured..!!" + e.toString());
		}
		
	}
	public static void main(String args[])
	{
		try
		{
			new Screen2_5();
		}catch(Exception e)
		{
			System.out.println(e);
		}
	      JFrame.setDefaultLookAndFeelDecorated(true);
		}
}
