/*
 * Class Name: RL
 * Purpose: This is the front menu for displaying few options for the user to navigate
 */
//only login
//login form using frame+swing
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class RL implements ActionListener {

	JButton l, r, help, about, exit;
	public JFrame fref;
	public JFrame jf;
	Font f;

	RL(JFrame jfrm) {

		System.out.println("\n !!!!!!! RL !!!!!!!!!! \n");
		fref = jfrm;
		fref.setVisible(false);
		jf = new JFrame("Main Menu");
		// declaration
		jf.setSize(1024, 768);
		jf.setLayout(null);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = jf.getContentPane();
		// Color c1=new Color(243,238,207);
		// Color c2=new Color(227,214,134);

		Color c1 = new Color(111, 111, 111);
		Color c2 = new Color(111, 111, 111);
		Color c3 = new Color(64, 0, 64);
		c.setBackground(c2);

		exit = new JButton("Exit");
		l = new JButton("Register");
		r = new JButton("Login");
		help = new JButton("Help");
		about = new JButton("About us");

		exit.setForeground(c3);
		l.setForeground(c3);
		r.setForeground(c3);
		help.setForeground(c3);
		about.setForeground(c3);

		f = new Font("Dialog", Font.BOLD, 18);

		l.setFont(f);
		r.setFont(f);
		help.setFont(f);
		about.setFont(f);
		exit.setFont(f);

		l.setBackground(c1);
		exit.setBackground(c1);
		r.setBackground(c1);
		help.setBackground(c1);
		about.setBackground(c1);
		// add to applet

		c.add(l);
		c.add(r);
		c.add(help);
		c.add(about);
		c.add(exit);

		exit.addActionListener(this);

		l.addActionListener(this);
		help.addActionListener(this);
		about.addActionListener(this);
		r.addActionListener(this);

		l.setBounds(520, 300, 150, 60);
		r.setBounds(520, 400, 150, 60);
		help.setBounds(320, 300, 150, 60);
		about.setBounds(320, 400, 150, 60);
		exit.setBounds(420, 500, 150, 60);

		jf.setVisible(true);
	}// cons

	public void actionPerformed(ActionEvent ae) {
		String what = ae.getActionCommand();
		if (what.equals("Register"))
			new Registration3(jf);

		if (what.equals("Exit"))
			System.exit(0);

		if (what.equals("Login"))
			new askuser(jf);

		if (what.equals("About us")) {

			Runtime r = Runtime.getRuntime();
			Process p;
			try {
				p = r.exec("C:\\Program Files\\Microsoft Office\\Office14\\WINWORD C:\\Users\\Karishma\\workspace\\GraphicalAuthentication\\src\\AboutUs.doc");

			} catch (Exception e) {

				System.out.println("err");
			}
		} // about us wala if
			// ------------------------------------------
		if (what.equals("Help")) {

			Runtime r = Runtime.getRuntime();
			Process p;
			try {
				p = r.exec("C:\\Users\\Karishma\\workspace\\GraphicalAuthentication\\src\\trigger1.cmd");
				// p=r.exec("C:\\Program
				// Files\\Java\\jdk1.6.0_06\\bin\\frameloginafterclasstest\\trigger.cmd");

			} catch (Exception e) {

				System.out.println("err");
			}
		} // help wala if
	}// ap()

}// class