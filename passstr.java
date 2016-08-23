/*
 Class Name: passstr
 Purpose: This is used to get secret folder location 
 */
import java.sql.*;

import java.io.*;

public class passstr {
	String passusername;
	RandomAccessFile file;
	FileReader file_uid_read = null;
	String login_id;
	int ch, len;
	int j, k = 0;
	String login_str;
	char temporary[] = new char[24];
	String str1, str2, str3;
	Connection conn;
	Statement stat, stat1;

	passstr(String passusername) {
		this.passusername = passusername;
	}

	void getpath() {

		System.out.println("\n !!!!!!! passstr.!!!!!!!!!! \n");

		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			// conn = DriverManager.getConnection("jdbc:odbc:gpa","sa","sa");
			conn = DriverManager.getConnection("jdbc:odbc:driver={SQL Server};server=NLAPTOP;uid=sa;database=gpa", "sa",
					"sa");

			stat = conn.createStatement();
			System.out.println("connc establish");

			String sqls = "select filepath from user_db where uname='" + passusername + "'";
			boolean hasResult = stat.execute(sqls);
			if (hasResult) {
				ResultSet rs = stat.getResultSet();
				while (rs.next()) {
					str3 = rs.getString(1);

				} // while
			} // if

			System.out.println("our logic " + str3);

			// new pg3011(login_str).readfromfile(str3);
			new pg3011(passusername).readfromfile(str3);

		} // try
		catch (Exception e) {
		}

		try {
			conn.close();
		} catch (Exception e) {
		}

	}// getpath()

}// class
