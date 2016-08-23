import java.sql.*;
import java.io.*;

class IncrementInvalid {
	Connection conn;
	Statement stat;
	RandomAccessFile file;
	FileReader file_uid_read = null;
	String login_id;
	int ch, len;
	int j, k = 0;
	String login_str;
	char temporary[] = new char[24];
	String str1, str2, str3, sq;
	String passusername;

	public IncrementInvalid(String passusername)

	{
		this.passusername = passusername;

		try {

			// ----------------------------------------
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			conn = DriverManager.getConnection("jdbc:odbc:driver={SQL Server};server=NLAPTOP;uid=sa;database=gpa", "sa",
					"sa");

			// conn = DriverManager.getConnection("jdbc:odbc:gpa","sa","sa");
			stat = conn.createStatement();
			System.out.println("connc establish");

			sq = "update user_db set timesinvalid=timesinvalid+1 where uname='" + passusername + "'";
			stat.execute(sq);
			conn.close();
		} catch (Exception e) {
		}

	}// const
}// class