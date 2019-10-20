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
import javax.swing.JPasswordField;
import javax.swing.JTextField;


@SuppressWarnings("serial")
public class Screen0_2 extends JFrame implements ActionListener 
{
	public JFrame f = new JFrame("Admin Login");
	public JPanel p = new JPanel ();
	public JLabel fid,pass;
	public JTextField id,key;
	public JButton l,b;
	
	public Screen0_2()
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
	
	public void paneldesign()
	{
		fid = new JLabel("Admin Id: ");
		fid.setBounds(25,25,150,25);
		p.add(fid);
		
		pass = new JLabel("Password: ");
		pass.setBounds(25,75,150,25);
		p.add(pass);
		
		id = new JTextField();
		id.setBounds(200,25,150,25);
		p.add(id);
		
		key = new JPasswordField();
		key.setBounds(200,75,150,25);
		p.add(key);
		
		l = new JButton("Log In");
		l.setBounds(25,125,150,25);
		p.add(l);
		
		b = new JButton("Back");
		b.setBounds(200,125,150,25);
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
			String tuname = id.getText();
			String tpass = key.getText();
			if(tuname.equalsIgnoreCase("") ||tpass.equalsIgnoreCase(""))
			{
				JOptionPane.showMessageDialog(null,"Please fill all the details ","Alert",1);
			}else
			{
				try
				{
					if(tuname.equals("admin") && tpass.equals("admin"))
					{
						Screen2 sc =new Screen2();
						sc.f.setVisible(true);
						f.dispose();
						//JOptionPane.showMessageDialog(null,"You will be going to screen 2","Alert",1);
					}
					else
					{
						JOptionPane.showMessageDialog(null,"Invalid username or password ","Alert",1);
					}
				}catch(Exception e1)
				{
					System.out.println("Error is" +e1);
				}
			}
		}
		else if(ae.getSource()==b)
		{
			Screen0_0 sca =new Screen0_0();
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
			new Screen0_2();
		}catch(Exception e)
		{
			System.out.println(e);
		}
	      JFrame.setDefaultLookAndFeelDecorated(true);
		}

}
