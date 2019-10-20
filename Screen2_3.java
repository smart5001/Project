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
import javax.swing.JTextField;


@SuppressWarnings("serial")
public class Screen2_3 extends JFrame implements ActionListener 
{
	public JFrame f = new JFrame("Upload Attendance");
	public JPanel p = new JPanel ();
	public JLabel sid,pass,cid;
	public JTextField id,key,cn;
	public JButton l,b;
	
	public Screen2_3()
	{
		 p.setLayout(null);
		 paneldesign();
		 f.add(p);
		 f.setSize(420,250);
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
		
		pass = new JLabel("Course Id: ");
		pass.setBounds(25,75,150,25);
		p.add(pass);
		
		cid = new JLabel("Attendance");
		cid.setBounds(25,125,150,25);
		p.add(cid);
		
		id = new JTextField();
		id.setBounds(200,25,150,25);
		p.add(id);
		
		cn = new JTextField();
		cn.setBounds(200,125,150,25);
		p.add(cn);
		
		key = new JTextField();
		key.setBounds(200,75,150,25);
		p.add(key);
		
		l = new JButton("Upload");
		l.setBounds(25,175,150,25);
		p.add(l);
		
		b = new JButton("Back");
		b.setBounds(200,175,150,25);
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
			int flag=0,k=0;
			for(String sn: DataBase.StudentUserMap.keySet())
			{
				if(id.getText().equals(sn))
				{
					flag=1;
					break;
				}
			}
			int n =0;
			while(DataBase.UserCourseMap.get(id.getText())[n][0]!=null)
			{
				if(DataBase.UserCourseMap.get(id.getText())[n][0].equals(key.getText()))
				{
					k=1;
					break;
				}
				else
					n++;
			}
			System.out.println(key.getText());
			if(flag==1 && k==1 && id.getText()!=null && key.getText()!=null && cn.getText()!=null)
			{
			String[][] s = new String[10][2];
			int i =0;
			while(DataBase.UserAttendanceMap.get(id.getText())[i][0]!=null)
			{
				s[i]=DataBase.UserAttendanceMap.get(id.getText())[i];
				i++;
			}
			String[] sp = new String[2];
			sp[0] = key.getText();
			sp[1] = cn.getText();
			s[i] = sp;
			DataBase.UserAttendanceMap.put(id.getText(), s);
			JOptionPane.showMessageDialog(null,"Details added","Alert",1);
			}
		else
		{
			JOptionPane.showMessageDialog(null,"Details are improper","Alert",1);
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
			new Screen2_3();
		}catch(Exception e)
		{
			System.out.println(e);
		}
	      JFrame.setDefaultLookAndFeelDecorated(true);
		}

}
