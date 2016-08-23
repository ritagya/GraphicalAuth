/*
 Class Name: AskUserNotExist
 Purpose: This is to check whether that the username what customer wants to register with
 already exist in database or not?? 
*/

import java.sql.*;
import javax.swing.*;
import java.io.*;

class AskUserNotExist {
	int n, flag = 0;
	Connection connection;
	Statement statement;
	String lname, pass, query, chklogin;
	boolean hasResult;
	ResultSet rs;
	public JFrame jref;

	// constr
	AskUserNotExist(String user, JFrame jf) {
		jref = jf;
		System.out.println("\n !!!!!!! in askusernotexist !!!!!!!!!! \n");
		chklogin = user;
	}// constructor

	String[] chkplease() {
		String[] s = new String[2];
		String str1 = "", str2 = "", str3 = "";
		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			connection = DriverManager.getConnection("jdbc:odbc:driver={SQL Server};server=NLAPTOP;uid=sa;database=gpa",
					"sa", "sa");
			statement = connection.createStatement();
			System.out.println("Connection Established");
			query = "select uname from user_db";
			hasResult = statement.execute(query);
			if (hasResult) {
				rs = statement.getResultSet();
				System.out.println("");
				while (rs.next()) {
					lname = rs.getString(1);
					if (!(chklogin.equals(lname))) {
						s[0] = " ";
						s[1] = " ";
					} // if
					else {
						flag = 0;
						query = "select pass from user_db where uname='" + lname + "'";
						hasResult = statement.execute(query);
						if (hasResult) {
							rs = statement.getResultSet();
							while (rs.next()) {
								pass = rs.getString(1);
							} // while
							s[0] = lname;
							s[1] = pass;
							flag = 1;
							break;
						} // if
					} // else
				} // while
			} // if
			connection.close();

			if (flag == 0) {
				CustomDialog myDialog = new CustomDialog(jref, true, "user not exist");
				return (s);
			} else
				return (s);
		} // try
		catch (Exception e) {
		}
		return (s);
	}// checkplease()
}// class
