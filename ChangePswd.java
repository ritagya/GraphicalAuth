/*
 Name: ChangePswd
 Purpose: This allow User to change password
 */

import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.sql.*;

public class ChangePswd extends JFrame implements ActionListener {
	Font f;
	int flagInvalid = 0;
	String lname, lpass, lrpass;
	public JLabel l1, l2, l3;
	JTextField login;
	JPasswordField password, rpassword;
	Connection connection;
	Statement statement;
	JButton go, back;
	String msg, lgn, s, query;
	public int counter;
	public JFrame fref, jf;
	char c;
	boolean b = true;

	ChangePswd(JFrame jfrm, String lname) {
		System.out.println("\n !!!!!!! in Change Password !!!!!!!!!! \n");
		lgn = lname;
		fref = jfrm;
		fref.setVisible(false);
		jf = new JFrame("Change");
		// declaration
		jf.setSize(1024, 768);
		jf.setLayout(null);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f = new Font("Arial", Font.PLAIN, 16);
		Container c = jf.getContentPane();

		Color c1 = new Color(120, 120, 120);
		Color c2 = new Color(120, 120, 120);
		Color c3 = new Color(64, 0, 64);

		l2 = new JLabel("New Password : ", Label.RIGHT);
		password = new JPasswordField("", 16);
		go = new JButton("Change Password");
		l3 = new JLabel("ReType New Password :", Label.RIGHT);
		rpassword = new JPasswordField("", 16);
		back = new JButton("Logout");

		l2.setFont(f);
		l3.setFont(f);
		password.setFont(f);
		rpassword.setFont(f);
		go.setFont(f);
		back.setFont(f);

		c.add(l2);
		c.add(password);
		c.add(l3);
		c.add(rpassword);
		c.add(go);
		c.add(back);

		go.setBackground(c1);
		c.setBackground(c2);
		password.setBackground(Color.WHITE);
		rpassword.setBackground(Color.WHITE);
		back.setBackground(c1);

		password.setForeground(c3);
		rpassword.setForeground(c3);
		l2.setForeground(c3);
		l3.setForeground(c3);
		back.setForeground(c3);
		go.setForeground(c3);

		go.addActionListener(this);
		back.addActionListener(this);

		l2.setBounds(300, 310, 150, 20);
		password.setBounds(490, 300, 150, 40);
		go.setBounds(300, 550, 200, 40);
		l3.setBounds(300, 410, 250, 20);
		rpassword.setBounds(490, 400, 150, 40);
		back.setBounds(570, 550, 150, 40);

		jf.setVisible(true);
	}// cons

	public void actionPerformed(ActionEvent ae)// this will validate user inputs
	{
		String str = ae.getActionCommand();
		if (str.equals("Logout"))
			new RL(jf);
		else {
			RAFdatabase db;
			lpass = password.getText();
			lrpass = rpassword.getText();

			if (!lpass.equals("") && !lrpass.equals("")) {
				if (lpass.length() < 4 || lpass.length() > 16) {
					msg = "minimum password length =4 and maximum=16";
					CustomDialog myDialog = new CustomDialog(jf, true, msg);
					password.setText("");
					rpassword.setText("");
				} // if
				else {
					if (lpass.equals(lrpass)) {
						// if no duplicate user names then proceed
						// plzz check that password has space or not
						if (b = check_space()) {
							System.out.println("lname: " + lname);
							System.out.println("lpass: " + lpass);
							// HERE SQL EXEC
							try {
								Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
								connection = DriverManager.getConnection(
										"jdbc:odbc:driver={SQL Server};server=NLAPTOP;uid=sa;database=gpa", "sa", "sa");
								statement = connection.createStatement();
								System.out.println("Connection Established");
								query = "update user_db set pass='" + lpass + "'where uname='" + lgn + "'";
								statement.execute(query);
								connection.close();
							} catch (Exception e) {
							}
							CustomDialog myDialog = new CustomDialog(jf, true, "Password Updated Successfully..");
							// user again given2 opt reg or login
							new RL(jf);
						}
					} // if2
					else {
						msg = "password mismatch";
						CustomDialog myDialog = new CustomDialog(jf, true, msg);
						password.setText("");
						rpassword.setText("");
					} // else2
				} // else1

				if (b == false) {
					password.setText("");
					rpassword.setText("");
				}
			} else {
				CustomDialog myDialog = new CustomDialog(jf, true, "please enter values for all fields");
				password.setText("");
				rpassword.setText("");
			}
		} // new else action taken when go clicked
	}// ap()

	boolean check_space() {
		flagInvalid = 0;
		for (int i = 0; i < (lpass.length()); i++) {
			c = (lpass.charAt(i));
			s = (new Character(c)).toString();
			if (s.equals(" ") || s.equals("!") || s.equals("^") || s.equals("*") || s.equals("-") || s.equals("=")
					|| s.equals("+") || s.equals("|") || s.equals(":") || s.equals("\\") || s.equals(";")
					|| s.equals(".")) {
				CustomDialog myDialog = new CustomDialog(jf, true,
						"characters not allowed in password :space, !  ^  *  -  =  +  |  \\  :  ;  . ");
				flagInvalid++;
				break;
			} // if
		} // for()
		if (flagInvalid > 0)
			return (false);
		else
			return (true);
	}// check_space()
}// class