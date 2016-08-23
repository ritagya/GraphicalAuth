
/*
 Class Name: Registration3
 Purpose: develops registration form and used for registering user in the system
 */
//login form using frame+swing
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Registration3 extends JFrame implements ActionListener {
	Font f, f1;
	int flagtp = 0;
	String lname, lpass, lrpass;
	public JLabel l1, l2, l3, note;
	JTextField login;
	JPasswordField password, rpassword;

	JButton go, back;
	String msg;
	public int counter;
	public JFrame fref;
	public JFrame jf;
	String s;
	char c;
	boolean b = true, d = true;

	Registration3(JFrame jfrm) {

		System.out.println("\n !!!!!!! registration3.!!!!!!!!!! \n");

		fref = jfrm;
		fref.setVisible(false);
		jf = new JFrame("Registration");
		// declaration
		jf.setSize(1024, 768);
		jf.setLayout(null);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f = new Font("Arial", Font.PLAIN, 16);
		f1 = new Font("Arial", Font.PLAIN, 12);

		Container c = jf.getContentPane();
		// Color c1=new Color(243,238,207);
		// Color c2=new Color(227,214,134);
		Color c1 = new Color(120, 120, 120);
		Color c2 = new Color(120, 120, 120);
		Color c3 = new Color(64, 0, 64);

		c.setBackground(c2);
		l1 = new JLabel("Login ID : ", Label.RIGHT);
		login = new JTextField("", 20);
		l2 = new JLabel("Password : ", Label.RIGHT);
		password = new JPasswordField("", 16);

		note = new JLabel("Note:    @  #  $  %  &  (  )  [  ]  {  }  _  '  ,  \"  <  >  ?  are allowed ", Label.RIGHT);
		go = new JButton("Register");
		l3 = new JLabel("ReType password :", Label.RIGHT);
		rpassword = new JPasswordField("", 16);
		back = new JButton("Back");

		login.setBackground(Color.WHITE);
		password.setBackground(Color.WHITE);
		rpassword.setBackground(Color.WHITE);

		login.setForeground(c3);
		password.setForeground(c3);
		rpassword.setForeground(c3);
		l1.setForeground(c3);
		l2.setForeground(c3);
		note.setForeground(c3);
		l3.setForeground(c3);
		go.setForeground(c3);
		back.setForeground(c3);

		l1.setFont(f);
		l2.setFont(f);
		l3.setFont(f);
		note.setFont(f1);
		login.setFont(f);
		password.setFont(f);
		rpassword.setFont(f);
		go.setFont(f);
		back.setFont(f);
		// add to applet

		c.add(l1);
		c.add(login);
		c.add(l2);
		c.add(password);
		c.add(note);
		c.add(l3);
		c.add(rpassword);
		c.add(go);
		c.add(back);

		go.setBackground(c1);

		// login.setBackground(c1);
		// password.setBackground(c1);
		// rpassword.setBackground(c1);
		back.setBackground(c1);

		go.addActionListener(this);
		back.addActionListener(this);

		// ---------------------

		l1.setBounds(350, 210, 150, 20);
		login.setBounds(490, 200, 150, 40);
		l2.setBounds(350, 310, 150, 20);
		password.setBounds(490, 300, 150, 40);
		note.setBounds(350, 345, 500, 20);
		go.setBounds(400, 550, 150, 40);
		l3.setBounds(350, 410, 150, 20);
		rpassword.setBounds(490, 400, 150, 40);
		back.setBounds(570, 550, 150, 40);
		jf.setVisible(true);
	}// cons

	public void actionPerformed(ActionEvent ae)// this will validate user inputs
	{

		String str = ae.getActionCommand();
		if (str.equals("Back"))
			new RL(jf);
		else {

			// Boolean b;//pehle se to u.name db me reg nai he...vo logic chk
			// karneko while loop me

			RAFdatabase db;
			lname = login.getText();
			lpass = password.getText();
			lrpass = rpassword.getText();

			if (!lname.equals("") && !lpass.equals("") && !lrpass.equals("")) {
				// check if uanme contains space
				if (d = check_uname_space()) {

					// be4 adding record chk 4 duplicte u.names
					// return value is boolean
					if (b = new UniqueUser(lname, jf).chkplease()) {

						if (lpass.length() < 4 || lpass.length() > 16 || lname.length() < 4) {
							msg = "minimum user name and password length should be 4 | maximum password length can be 16";
							// System.out.println(msg);
							CustomDialog myDialog = new CustomDialog(jf, true, msg);
							login.setText("");
							password.setText("");
							rpassword.setText("");
						} // if1
						else {

							if (lpass.equals(lrpass)) {

								// if no duplicate user names then proceed

								// plzz chk dat pswd me space to nai he na
								if (b = check_space()) {

									db = new RAFdatabase(lname, lpass);
									db.addrecord();

									// user again given2 opt reg or login

									new RL(jf);
								}
							} // if2
							else {
								msg = "password mismatch";
								CustomDialog myDialog = new CustomDialog(jf, true, msg);

								login.setText("");
								password.setText("");
								rpassword.setText("");
							} // else2

							// System.out.println(msg);

						} // else1

					} // new else actionn taken when go clicked

				} // unique username check wala if

				if (b == false || d == false) {
					// CustomDialog myDialog = new CustomDialog(jf, true,
					// "please enter values for all fields");
					login.setText("");
					password.setText("");
					rpassword.setText("");
					// new RL(jf);//agar user name exiat karta he db me already
					// to redirect d screen
				}
			} // null wala if
			else {// System.out.println("please enter a value first");
				CustomDialog myDialog = new CustomDialog(jf, true, "please enter values for all fields");
				login.setText("");
				password.setText("");
				rpassword.setText("");
			}
		} // check_uname_space()

	}// ap()

	boolean check_space() {
		flagtp = 0;
		for (int i = 0; i < (lpass.length()); i++) {
			c = (lpass.charAt(i));
			s = (new Character(c)).toString();
			if (s.equals(" ") || s.equals("!") || s.equals("^") || s.equals("*") || s.equals("-") || s.equals("=")
					|| s.equals("+") || s.equals("|") || s.equals(":") || s.equals("\\") || s.equals(";")
					|| s.equals(".")) {
				CustomDialog myDialog = new CustomDialog(jf, true,
						"characters not allowed in password :space, !  ^  *  -  =  +  |  \\  :  ;  . ");
				flagtp++;
				break;
			} // if

		} // for()
		if (flagtp > 0) {
			return (false);
		} // if
		else {
			System.out.println(" EEEEEEEEEEEEEEEE true return ho raha he ");
			return (true);
		}
	}// check_space()

	boolean check_uname_space() {
		flagtp = 0;

		for (int i = 0; i < (lname.length()); i++) {
			c = (lname.charAt(i));
			s = (new Character(c)).toString();
			if (s.equals(" ")) {

				CustomDialog myDialog = new CustomDialog(jf, true, "space not allowed in username ");
				flagtp++;

				break;
			} // if

		} // for()
		if (flagtp > 0) {
			return (false);
		} // if
		else {
			System.out.println(" EEEEEEEEEEEEEEEE true return ho raha he ");
			return (true);
		}

	}// check_space()

}// class
