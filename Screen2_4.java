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
public class Screen2_4 extends JFrame implements ActionListener 
{
	public JFrame f = new JFrame("Add Pending Fee");
	public JPanel p = new JPanel ();
	public JLabel sid,pass,cid,rea;
	public JTextField id,key,cn,re;
	public JButton l,b;
	
	public Screen2_4()
	{
		 p.setLayout(null);
		 paneldesign();
		 f.add(p);
		 f.setSize(420,300);
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
		
		pass = new JLabel("Payment Id: ");
		pass.setBounds(25,75,150,25);
		p.add(pass);
		
		cid = new JLabel("Amount");
		cid.setBounds(25,125,150,25);
		p.add(cid);
		
		rea = new JLabel("Reason");
		rea.setBounds(25,175,150,25);
		p.add(rea);
		
		id = new JTextField();
		id.setBounds(200,25,150,25);
		p.add(id);
		
		cn = new JTextField();
		cn.setBounds(200,125,150,25);
		p.add(cn);
		
		key = new JTextField();
		key.setBounds(200,75,150,25);
		p.add(key);
		
		re = new JTextField();
		re.setBounds(200,175,150,25);
		p.add(re);
		
		l = new JButton("Add");
		l.setBounds(25,225,150,25);
		p.add(l);
		
		b = new JButton("Back");
		b.setBounds(200,225,150,25);
		p.add(b);
		
		l.addActionListener(this);
		b.addActionListener(this);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent ae)
	{
		try
		{
			/*for(String sn : DataBase.UserCourseMap.keySet())
			{
				if(key.getText().equals(sn))
				{
					k=1;
					break;
				}
			}*/
			if(ae.getSource()==l)
			{
				int flag=0/*,k=0*/;
				for(String sn: DataBase.StudentUserMap.keySet())
				{
					if(id.getText().equals(sn))
					{
						flag=1;
						System.out.println(sn);
						System.out.println(id.getText());
						break;
					}
				}
				System.out.println(id.getText()!=null);
				System.out.println(key.getText()!=null);
				System.out.println(cn.getText()!=null);
				System.out.println(re.getText()!=null);
				if(flag == 1 /*&& k==1*/ && id.getText()!=null && key.getText()!=null && cn.getText()!=null && re.getText()!=null)
				{
					String s = id.getText();
					String[][] sn = new String[10][3];
					int i = 0;
					while(DataBase.UserPendingFeesMap.get(s)[i][0]!=null && i<=9)
					{
						sn[i] =  DataBase.UserPendingFeesMap.get(s)[i];
						i++;
					}
					System.out.println(i);
					String[] p = new String[3];
					p[0] = key.getText();
					p[1] = cn.getText();
					p[2] = re.getText();
					sn[i] = p;
					DataBase.UserPendingFeesMap.put(s,sn);
					JOptionPane.showMessageDialog(null,"Pending Fee Added!!","Alert",1);
					/*for(String k : DataBase.UserPendingFeesMap.keySet())
					{
						System.out.println(DataBase.UserPendingFeesMap.get(k)[0][0]);
						System.out.println(DataBase.UserPendingFeesMap.get(k)[1][0]);
					}*/
					System.out.println(DataBase.UserPendingFeesMap.get(s)[0][0]);
					System.out.println(DataBase.UserPendingFeesMap.get(s)[1][0]);
				}
				else
					JOptionPane.showMessageDialog(null,"Details are Improper","Alert",1);
			}
			else
			{
				Screen2 s = new Screen2();
				s.f.setVisible(true);
				f.dispose();
			}
			
		}catch(Exception e)
		{
			System.out.println("Error Occured!!...!!"+e.getMessage());
		}
	}
	public static void main(String args[])
	{
		try
		{
			new Screen2_4();
		}catch(Exception e)
		{
			System.out.println(e);
		}
	      JFrame.setDefaultLookAndFeelDecorated(true);
		}
}
	