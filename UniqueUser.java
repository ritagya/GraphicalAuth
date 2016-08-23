
//this is to check whether that the username what customer wants to register with,
//does it already exist in database or no??


import java.sql.*;
import javax.swing.*;
import java.io.*;

class UniqueUser {
	Connection connection;
	Statement statement;
	String chklogin;
	RandomAccessFile file;
	public JFrame jref;

	// constr
	UniqueUser(String user, JFrame jfrm) {
		System.out.println("\n !!!!!!! uniqueuser !!!!!!!!!! \n");
		chklogin = user;
		jref = jfrm;
	}// constructor

	boolean chkplease() {
		String str1 = "", str2 = "", str3 = "";
		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			// connection =
			// DriverManager.getConnection("jdbc:odbc:gpa","sa","sa");
			connection = DriverManager.getConnection("jdbc:odbc:driver={SQL Server};server=NLAPTOP;uid=sa;database=gpa",
					"sa", "sa");
			statement = connection.createStatement();
			System.out.println("Connection Established");

			String sqls = "select uname from user_db";
			boolean hasResult = statement.execute(sqls);
			if (hasResult) {
				ResultSet rs = statement.getResultSet();
				System.out.println("");
				while (rs.next()) {
					if (chklogin.equals(rs.getString(1))) {
						CustomDialog myDialog = new CustomDialog(jref, true, "user alraedy exist");
						return (false);
					} // if
				} // while
			} // if
			file = new RandomAccessFile("rafDB.txt", "r");

			do {
				str1 = file.readUTF();
				str2 = file.readUTF();
				str3 = file.readUTF();
			} while (!chklogin.equals(str1));
		} // try
		catch (Exception e) {
		}

		if (chklogin.equals(str1)) {
			CustomDialog myDialog = new CustomDialog(jref, true, "user name u provided alraedy exist");
			return (false);
		} else {
			return (true);
		}
	}// checkplease()
}// class
