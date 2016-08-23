/*
 Class Name: TCPtimeClient
 Purpose: Count the number of invalid attempts 
 */
import java.io.*;
import java.net.*;

class TCPtimeClient {
	String passusername;

	TCPtimeClient(String passusername) {
		this.passusername = passusername;
	}

	public void alert() {

		System.out.println("\n !!!!!!! tcpclient.!!!!!!!!!! \n");

		String saddr;
//		int ch;
//	String login_id = " ";

		try {
			Socket clientSocket = new Socket("192.168.0.5", 6789);

			// 172.0.0.1
//			String sentence;
			System.out.println("chkpt 1");
//			String modifiedSentence;
			
			System.out.println("chkpt 1");
			DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
			System.out.println("chkpt 1");

			saddr = passusername + " INVALID LOGIN ATTEMPT AT: ip address "
					+ (clientSocket.getLocalAddress()).toString();

			System.out.println("adddrrrr" + saddr);
			saddr = saddr + " by user name " + passusername;

			outToServer.writeBytes(saddr);
			clientSocket.close();

		} // try
		catch (Exception e) {
			System.out.println("2EXCEPTION");

		}
	}
}