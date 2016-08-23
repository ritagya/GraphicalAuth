/*
 Class Name: TCPServer
 Purpose: Server for the Client Server architecture
 */
import java.io.*;
import java.net.*;
import java.sql.*;

class TCPServer {
	static Connection conn;
	static Statement stat;
	static String sq;
	static boolean hasResult;
	static ResultSet rs;
	static int val;
	static String passusername = null;
	static String clientSentence = null;

	public static void main(String argv[]) throws Exception {

		System.out.println("\n !!!!!!! tcpserver.!!!!!!!!!! \n");

		String capitalizedSentence;
		ServerSocket welcomeSocket = new ServerSocket(6789);

		while (true) {
			try {

				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

				conn = DriverManager.getConnection("jdbc:odbc:driver={SQL Server};server=NLAPTOP;uid=sa;database=gpa",
						"sa", "sa");

				stat = conn.createStatement();
				System.out.println("connc establish");
			} catch (Exception e) {
			}

			Socket connectionSocket = welcomeSocket.accept();
			BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
			// DataOutputStream outToClient = new
			// DataOutputStream(connectionSocket.getOutputStream());
			clientSentence = inFromClient.readLine();
			passusername = check_space(clientSentence);

			sq = "select timesinvalid from user_db where uname='" + passusername + "'";
			hasResult = stat.execute(sq);
			if (hasResult) {
				rs = stat.getResultSet();
				while (rs.next()) {
					val = rs.getInt(1);
				}
			}
			if (val >= 3) {
				new PlayAudio("dk.wav").start();
			}
			System.out.println("Received: " + clientSentence);
			// capitalizedSentence = clientSentence.toUpperCase() + '\n';
			// outToClient.writeBytes(capitalizedSentence);
		}
	}

	static String check_space(String clientSentence) {
		Character c;
		String s, pass;
		String extractusername = null;

		for (int i = 0; i < (clientSentence.length()); i++) {

			c = (clientSentence.charAt(i));
			s = (new Character(c)).toString();
			if (s.equals(" ")) {
				break;
			} // if
			else
				extractusername = extractusername + s;

		} // for()

		pass = extractusername.substring(4, extractusername.length());

		System.out.println(" Extracted username: " + pass);

		return (pass);
	}// check_space()

}