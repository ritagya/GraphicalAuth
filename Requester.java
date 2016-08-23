/*
 Class Name: Requester
 Purpose: This is the Client server architecture
 */
import java.io.*;
import java.net.*;

public class Requester {
	Socket requestSocket;
	ObjectOutputStream out;
	ObjectInputStream in;
	String message, DateTime;

	Requester() {
	}

	String run(String passusername) {
		try {
			// 1. creating a socket to connect to the server

			System.out.println("in RUN ");
			requestSocket = new Socket("192.168.0.5", 2004);

			System.out.println("Connected to localhost in port 2004"); // 2. get
																		// Input
																		// and
																		// Output
																		// streams
			out = new ObjectOutputStream(requestSocket.getOutputStream());
			out.flush();
			in = new ObjectInputStream(requestSocket.getInputStream());
			// 3: Communicating with the server
			do {
				try {
					message = (String) in.readObject();
					System.out.println("server>" + message);
					sendMessage("" + passusername);

					DateTime = (String) in.readObject();

					message = "bye";
					sendMessage(message);
				} catch (ClassNotFoundException classNot) {
					System.err.println("data received in unknown format");
				}
			} while (!message.equals("bye"));

		} // try

		catch (UnknownHostException unknownHost) {
			System.err.println("You are trying to connect to an unknown host!");
		} catch (IOException ioException) {
			ioException.printStackTrace();
		} finally {
			// 4: Closing connection
			try {
				in.close();
				out.close();
				requestSocket.close();
			} catch (IOException ioException) {
				ioException.printStackTrace();
			}
		}
		return (DateTime);

	}

	void sendMessage(String msg) {
		try {
			out.writeObject(msg);
			out.flush();
			System.out.println("client>" + msg);
		} catch (IOException ioException) {
			ioException.printStackTrace();
		}
	}
	
}
