/*
 Class Name: Provider
 Purpose: Used for initializing Client Server architecture
 */

import java.io.*;
import java.net.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Provider {
	Connection conn;
	Statement stat;
	String sq;
	boolean hasResult;
	ResultSet rs;

	String DateTime;
	String access;
	String mess;

	ServerSocket providerSocket;
	Socket connec = null;
	ObjectOutputStream out;
	ObjectInputStream in;
	String message;

	Provider() {
	}

	void run() {
		try {
			// 1. creating a server socket
			providerSocket = new ServerSocket(2004, 10);
			// 2. Wait for connec
			System.out.println("Waiting for connec");
			connec = providerSocket.accept();
			System.out.println("connec received from " + connec.getInetAddress().getHostName());
			// 3. get Input and Output streams
			try {

				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

				conn = DriverManager.getConnection("jdbc:odbc:driver={SQL Server};server=NLAPTOP;uid=sa;database=gpa",
						"sa", "sa");

				stat = conn.createStatement();
				System.out.println("connc establish");
			} catch (Exception e) {
			}

			out = new ObjectOutputStream(connec.getOutputStream());
			out.flush();
			in = new ObjectInputStream(connec.getInputStream());
			sendMessage("connec successful");
			// 4. The two parts communicate via the input and output streams
			do {
				try {
					message = (String) in.readObject();
					System.out.println("client>" + message);

					sq = "select accesstime from user_db where uname='" + message + "'";
					try {
						hasResult = stat.execute(sq);
						if (hasResult) {
							rs = stat.getResultSet();
							while (rs.next()) {
								access = rs.getString(1);
								System.out.println("  " + access);
							}
						}

						DateTime = GetDateTime();
						System.out.println("DATE AND TIME: " + DateTime);

						String sqls = "update user_db set accesstime = '" + DateTime + "' where uname = '" + message
								+ "'";
						stat.execute(sqls);
					} catch (Exception e) {
					}

					sendMessage("" + access);

					// if (message.equals("bye"))
					// sendMessage("bye");
				}

				catch (ClassNotFoundException classnot) {
					System.err.println("Data received in unknown format");
				}
			} while (!message.equals("bye"));
		} catch (IOException ioException) {
			ioException.printStackTrace();
		} finally {
			// 4: Closing connec
			try {
				in.close();
				out.close();
				providerSocket.close();
			} catch (IOException ioException) {
				ioException.printStackTrace();
			}
		}
	}

	void sendMessage(String msg) {
		try {
			out.writeObject(msg);
			out.flush();
			System.out.println("server>" + msg);
		} catch (IOException ioException) {
			ioException.printStackTrace();
		}
	}

	public static void main(String args[]) {
		Provider server = new Provider();
		while (true) {
			server.run();
		}
	}

	String GetDateTime() {
		SimpleDateFormat sdfDate = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat sdfTime = new SimpleDateFormat("HH:mm:ss");
		Date now = new Date();
		String strDate = sdfDate.format(now);
		String strTime = sdfTime.format(now);
		String str = strDate + " " + strTime;
		return (str);
	}// datetime
}