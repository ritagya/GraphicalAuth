/*
 Class Name:projectmain
 Purpose: This class serves as an entry point in the application
 */
import javax.swing.*;

class projectmain {

	public static void main(String args[]) {

		System.out.println("\n !!!!!!! Main Project!!!!!!!!!! \n");

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Thread t;

				t = Thread.currentThread();
				t.setName("Main thread");
				new Welcome();// calling welcome screen constructor
			}
		});
	}

}
