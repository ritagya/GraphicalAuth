/*
 * Class Name: TCPClient
 * Purpose: Client program establishing connection
 */
import java.io.*;
import java.net.*;

class TCPClient {
	String passusername;

	TCPClient(String passusername) {
		this.passusername = passusername;
	}

	public void alert() {

		System.out.println("\n !!!!!!! tcpclient.!!!!!!!!!! \n");

		String saddr;
		int ch;
		String login_id = " ";

		try {
			Socket clientSocket = new Socket("192.168.0.5", 6789);

			// 172.0.0.1

			/*
			 * FileReader file_uid_read=null;
			 * 
			 * 
			 * 
			 * 
			 * file_uid_read=new FileReader("store_uid.txt"); Character c;
			 * 
			 * while((ch=file_uid_read.read())!=-1) { c=new Character((char)ch);
			 * login_id=login_id+c.toString(); System.out.println(
			 * "login id isssss"+login_id);
			 * 
			 * }//while
			 * 
			 * 
			 */
			String sentence;
			System.out.println("chkpt 1");
			String modifiedSentence;
			// BufferedReader inFromUser = new BufferedReader( new
			// InputStreamReader(System.in));

			System.out.println("chkpt 1");
			DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
			// BufferedReader inFromServer = new BufferedReader(new
			// InputStreamReader(clientSocket.getInputStream()));
			// sentence = inFromUser.readLine();
			System.out.println("chkpt 1");

			// calc ip addr
			// InetAddress addr=InetAddress.getLocalHost();
			saddr = passusername + " INVALID LOGIN ATTEMPT AT: ip address "
					+ (clientSocket.getLocalAddress()).toString();

			System.out.println("adddrrrr" + saddr);
			saddr = saddr + " by user name " + passusername;

			outToServer.writeBytes(saddr);
			// modifiedSentence = inFromServer.readLine();
			// System.out.println("FROM SERVER: " + modifiedSentence);
			clientSocket.close();

		} // try
		catch (Exception e) {
			System.out.println("2EXCEPTION");

		}
	}
}