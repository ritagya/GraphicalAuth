
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class threaddemo_border implements Runnable, ActionListener {
	int a, a1, a2, btp, ctp, d, d1, d2, cm1, cp1, center;
	Color cb, cf;
	Font f;
	JButton jb;
	Thread t;
	JFrame jf1;
	JFrame jf2;
	char temp[] = new char[83];
	String strr;
	monitor mo;
	int no_of_arr_created;
	int ansarray[] = new int[9];
	int passed_no;
	String passusername;
	String secretusername;

	threaddemo_border(int ansarray[], JFrame frame, char temp[], monitor mo, int passed_no, int no_of_arr_created,
			String passusername) {
		this.passusername = passusername;

		System.out.println("\n !!!!!!! threaddeom_border.!!!!!!!!!! \n");

		this.ansarray = ansarray;

		cb = new Color(120, 120, 120);
		cf = new Color(64, 0, 64);
		f = new Font("Dialog", Font.BOLD, 18);
		this.no_of_arr_created = no_of_arr_created;
		this.mo = mo;
		jf1 = frame;
		jf1.setVisible(false);

		this.temp = temp;
		this.passed_no = passed_no;
		t = new Thread(this, "abc");
		t.start();

	}// cons

	public void run() {

		while (true) {
			if (mo.count == passed_no) {
				System.out.println("@@@@@going to condtruct GUI");
				Character c = new Character(temp[81]);
				strr = c.toString();
				strr = strr + temp[82];

				Character c1, c2;

				for (int i = 0; i < passusername.length(); i++) {

					if (i == 0) {
						c1 = passusername.charAt(0);
						secretusername = c1.toString();
					}

					if (i > 0 && i < passusername.length() - 1)
						secretusername = secretusername + "*";

					if (i == passusername.length() - 1)

					{
						c2 = passusername.charAt(passusername.length() - 1);
						secretusername = secretusername + c2.toString();
					}

				}

				System.out.println("-=--=-=-=-=--=-=-=-=-=-=-=-=-=--=" + secretusername);

				System.out.println("strr is-->" + strr);

				jf2 = new JFrame();
				jf2.setTitle("HI " + secretusername);
//				JButton blist[] = new JButton[81];
				jf2.setSize(1024, 768);
				jf2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				jf2.setLayout(new GridLayout(9, 9));

				for (int i = 0; i < 81; i++) {

					String s = new Character(temp[i]).toString();

					jb = (JButton) jf2.add(new JButton(s));
					jb.setActionCommand(Integer.toString(i));
					jb.setBackground(cb);
					jb.setForeground(cf);
					jb.setFont(f);
					jb.addActionListener(this);
				}
				jf2.setVisible(true);
				// mo.b=true;

				break;
			} // bada if
		} // while
	}// run()

	public void actionPerformed(ActionEvent ae) {
		int chk = Integer.parseInt(ae.getActionCommand());
		System.out.println("(((--=-=-=-=-=-=-=  " + chk);
		int chkflag = 0;
		int z;

		for (z = 0; z < 9; z++)
			if (chk == this.ansarray[z]) {
				chkflag = 1;
				System.out.println("ansarray[z]---->" + ansarray[z]);
				break;
			}

		if (chkflag == 1) {
			try {
				// CustomDialog myDialog = new CustomDialog(jf2, true,"gud boy"
				// );
				// mo.b=false;

				if ((no_of_arr_created == passed_no) && (mo.errorinput == 1))// and
																				// mo
																				// var
																				// val
																				// is
																				// false
					new passstr(passusername).getpath();
				else if ((no_of_arr_created == passed_no) && (mo.errorinput == 2))

				{
					new IncrementInvalid(passusername);
					new TCPClient(passusername).alert();
					new RL(jf2);
				} else {

					mo.count = mo.count + 1;

					jf2.setVisible(false);
					// tref.notify();
				} // new if else

			} catch (Exception e) {
			}
		} else {
			if ((no_of_arr_created == passed_no))

			{

				new IncrementInvalid(passusername);
				new TCPClient(passusername).alert();
				new RL(jf2);
			}

			// --------------down change-------------------
			mo.count = mo.count + 1;
			// ---------wrong input ten set value of monitor true-----------
			mo.errorinput = 2;

			System.out.println("value of strr in case of combination 1234 is" + strr);
			// new RL(jf2);

		}

		jf2.setVisible(false);
	}// ap()

}// class