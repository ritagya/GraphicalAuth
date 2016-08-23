/*
Class Name: askuser
Purpose: Checks whether the user is registered or not 
*/

import java.util.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class askuser extends JFrame implements ActionListener {
	Connection connection;
	Statement statement;
	boolean hasResult;
	ResultSet rs;
	int val;
	Font f;
	JLabel l1;
	JPasswordField user;
	String[] s = new String[2];
	JButton b1, back;
	RandomAccessFile file;
	public JFrame fref, frame;
	String str1, str2, str3, query;
	int k = 0, count = 0;
	boolean flag = false;

	askuser(JFrame jfrm) {
		System.out.println("\n !!!!!!! Askuser!!!!!!!!!! \n");
		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			connection = DriverManager.getConnection("jdbc:odbc:driver={SQL Server};server=NLAPTOP;uid=sa;database=gpa",
					"sa", "sa");
			statement = connection.createStatement();
			System.out.println("Connection Established");
		} catch (Exception e) {
		}
		fref = jfrm;
		fref.setVisible(false);
		frame = new JFrame("Login");
		// declaration
		frame.setSize(1024, 768);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f = new Font("Arial", Font.PLAIN, 16);
		Container c = frame.getContentPane();
		Color c1 = new Color(120, 120, 120);
		Color c2 = new Color(120, 120, 120);
		Color c3 = new Color(64, 0, 64);

		l1 = new JLabel("Enter the user name :");
		user = new JPasswordField("", 20);
		b1 = new JButton("Go");
		back = new JButton("Back");

		l1.setFont(f);
		b1.setFont(f);
		back.setFont(f);
		user.setFont(f);

		c.add(l1);
		c.add(user);
		c.add(b1);
		c.add(back);

		back.addActionListener(this);
		b1.addActionListener(this);
		user.addActionListener(this);

		l1.setBounds(350, 240, 150, 20);
		user.setBounds(510, 230, 150, 40);
		b1.setBounds(410, 400, 150, 40);
		back.setBounds(590, 400, 150, 40);

		b1.setBackground(c1);
		user.setBackground(Color.WHITE);
		back.setBackground(c1);
		c.setBackground(c2);

		back.setForeground(c3);
		b1.setForeground(c3);
		l1.setForeground(c3);
		user.setForeground(c3);

		frame.setVisible(true);
	}// constr

	public void actionPerformed(ActionEvent ae) {
		String str = ae.getActionCommand();
		if (str.equals("Back"))
			new RL(frame);
		else {
			flag = false;
			str1 = user.getText();
			// System.out.println("got login id"+str1);
			if (str1.equals("")) {
				CustomDialog myDialog = new CustomDialog(frame, true, "please enter a user name");
				flag = true;
				user.setText("");
			} // if
			if (flag == false) {
				try {
					s = new AskUserNotExist(str1, frame).chkplease();
					str2 = s[0];
					str3 = s[1];
				} // try
				catch (Exception e) {
				}
				System.out.println(str1);
				System.out.println(str2);

				try {
					if (!str2.equals(" ")) {
						query = "select timesinvalid from user_db where uname='" + str2 + "'";
						hasResult = statement.execute(query);
						if (hasResult) {
							rs = statement.getResultSet();
							while (rs.next()) {
								val = rs.getInt(1);
								System.out.println("  " + val);
							} // while
						} // if
						if (val < 3) {
							// str2 is the username 
							new Pswddiv(str3.toCharArray(), frame, str2);// pass the password of the user
						} // if(val<=3)
						else {
							CustomDialog myDialog = new CustomDialog(frame, true,
									"3 Invalid Attempts Exceeded... Please contact your Administrator");
							user.setText("");
						} // else
					} // if
					else
						user.setText("");
					connection.close();
				} // try
				catch (Exception e) {
				}

			} // if
		} // New else action taken when go clicked
	}// Action Performed()
}// askuser