/*
 Class Name: RAFdatabase
 Purpose: This will create login id and password database in text file
 */

import java.io.*;
import java.util.Random;
import java.sql.*;

class RAFdatabase {
	Connection conn;
	Statement stat;

	String login;
	String password;
	String txtfilename, txtdirname, createfile;

	FileWriter file_write_welcome;
	// constr

	RAFdatabase(String l, String p) {
		System.out.println("in RAFdatabase.java");
		login = l;
		password = p;

	}

	void addrecord() {

		System.out.println("\n !!!!!!! rafdatabase.!!!!!!!!!! \n");

		Random r = new Random();

		String random = new String(Integer.toString(r.nextInt()));
		//txtdirname = "\\\\\\\\Nlaptop\\\\E\\\\vivek\\\\user_private_files\\\\" + random + "X";
		txtdirname = "E:\\\\user_private_files\\\\" + random + "X";
		
		txtfilename = txtdirname + "\\\\" + random + ".txt";
		// txtfilename="C:\\\\Program
		// Files\\\\Java\\\\jdk1.6.0_06\\\\bin\\\\frameloginafterclasstest\\\\user_private_files\\\\"+random;
		// txtfilename="\\\\user_private_files\\\\"+random;
		// txtfilename="D:\\\\engineering project\\\\no15
		// remotedb\\\\user_private_files\\\\"+random;

		try {

			// Create one directory
			boolean success = (new File(txtdirname)).mkdir();
			if (success) {
				System.out.println("Directory: " + txtdirname + " created");
			}

			Class.forName("oracle.jdbc.driver.OracleDriver");
			// conn = DriverManager.getConnection("jdbc:odbc:gpa","sa","sa");
			conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","karishma","karishma"); 
			//conn = DriverManager.getConnection("jdbc:odbc:driver={SQL Server};server=NLAPTOP;uid=sa;database=gpa", "sa","sa");

			stat = conn.createStatement();
			System.out.println("connc establish");
			// file=new RandomAccessFile("rafDB.txt","rw");
			int x = 0;
			String sqls = "insert into user_db values('" + login + "','" + password + "','" + txtdirname + "','"
					+ txtfilename + "'," + x + ",'This Is Your 1st Login')";
			stat.execute(sqls);

			System.out.println("inserted");
		} catch (Exception e) {
			System.out.println("exception:"+e);
		}

		/*
		 * here i am writing "welcome" into the file assigned to user just above
		 * as txtfilename 2reasons: no1: when user will be authenticated for
		 * first time i want to greet him no2: (actual reason) jab me
		 * authentication k bad ,user ko jo file mene registration k time
		 * randomly assign kiya tha ,usse kholne ka try means read karunga...bt
		 * file write hua hoga tp k liye pehlese tabhi jake read hoga na...
		 * fact:file write hote samay auto create hota he..read karte waqt nai..
		 * moral: itzz jst 4 formality m storing "welcome"
		 * 
		 * 
		 */

		try {
			// file_write_welcome=new FileWriter("user_private_files\\"+random);
			createfile = "\\\\Nlaptop\\e\\vivek\\user_private_files\\" + random + "X" + "\\" + random + ".txt";
			System.out.println("-=-=-=-=-=-" + createfile);
			file_write_welcome = new FileWriter(createfile);

			file_write_welcome.write(("Welcome " + login).toCharArray());

		} catch (Exception e) {
			System.out.println("abcd");
		}

		finally {
			try {
				conn.close();

				file_write_welcome.close();
			} catch (Exception e) {
			}

		} // finally
	}// addrecord()

}// class