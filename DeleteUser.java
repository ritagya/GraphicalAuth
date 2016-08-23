/*
 Class Name: DeleteUser
 Purpose: This is called when we want to delete the user
*/

import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.sql.*;

public class DeleteUser extends JFrame implements ActionListener {
	Font f;
	String lname, lpass, lrpass;
	public JLabel l1, l2, l3;
	JTextField login;
	JPasswordField password, rpassword;
	Connection connection;
	Statement statement;
	JButton go, back;
	String msg, val;
	public JFrame fref, jf;
	String s, query;
	char c;
	boolean b = true;
	String lgn;
	boolean hasResult;
	ResultSet rs;

	DeleteUser(JFrame jfrm, String lname) {
		lgn = lname;
		System.out.println("\n !!!!!!! Delete Username !!!!!!!!!! \n");
		fref = jfrm;
		fref.setVisible(false);
		jf = new JFrame("Delete user");
		// declaration
		jf.setSize(1024, 768);
		jf.setLayout(null);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f = new Font("Arial", Font.PLAIN, 16);
		Container c = jf.getContentPane();
		Color c1 = new Color(120, 120, 120);
		Color c2 = new Color(120, 120, 120);
		Color c3 = new Color(64, 0, 64);
		c.setBackground(c2);
		l2 = new JLabel("Are You Sure You Want To Delete your Account and CONFIDENTIAL DATA ", Label.RIGHT);

		go = new JButton("Confirm Delete");
		back = new JButton("Cancel");

		l2.setFont(f);
		go.setFont(f);
		back.setFont(f);

		c.add(l2);
		c.add(go);
		c.add(back);

		go.setBackground(c1);
		back.setBackground(c1);
		back.setForeground(c3);
		go.setForeground(c3);
		l2.setForeground(c3);

		go.addActionListener(this);
		back.addActionListener(this);

		l2.setBounds(250, 310, 700, 20);
		go.setBounds(300, 550, 200, 40);
		back.setBounds(570, 550, 150, 40);

		jf.setVisible(true);
	}// cons

	public void actionPerformed(ActionEvent ae)// this will validate user inputs
	{
		try {
			String str = ae.getActionCommand();
			if (str.equals("Cancel")) {
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				query = "update user_db set timesinvalid=0 where uname='" + lgn + "'";
				connection = DriverManager
						.getConnection("jdbc:odbc:driver={SQL Server};server=NLAPTOP;uid=sa;database=gpa", "sa", "sa");
				statement = connection.createStatement();
				statement.execute(query);
				connection.close();
				new RL(jf);
			} // if
			if (str.equals("Confirm Delete")) {
				try {
					Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
					s = "select dirpath from user_db where uname='" + lgn + "'";
					connection = DriverManager.getConnection(
							"jdbc:odbc:driver={SQL Server};server=NLAPTOP;uid=sa;database=gpa", "sa", "sa");
					statement = connection.createStatement();
					rs = statement.executeQuery(s);
					while (rs.next()) {
						val = rs.getString("dirpath");
						System.out.println("--=--==-=-  " + val);
					}
					File f1 = new File(val);
					deleteDir(f1);
					boolean success = f1.delete();
					if (success) {
						System.out.println("Deletion failed.");
						System.exit(0);
					} else {
						System.out.println("File deleted.");
					}
					query = "delete from user_db where uname ='" + lgn + "'";
					statement.execute(query);
					connection.close();
				} catch (Exception e) {
				}
				new RL(jf);
			} // if
		} catch (Exception e) {
			System.out.println("\n exp \n");
		}
	}// actionPerformed

	public boolean deleteDir(File dir) {
		if (dir.isDirectory()) {
			String[] children = dir.list();
			for (int i = 0; i < children.length; i++) {
				boolean success = deleteDir(new File(dir, children[i]));
				if (!success) {
					return false;
				}
			}
		}
		// The directory is now empty so delete it
		return dir.delete();
	}
}// class