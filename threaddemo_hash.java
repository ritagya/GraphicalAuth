
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class threaddemo_hash implements Runnable, ActionListener {
	Color cb, cf;
	Font f;
	JButton jb;
	Thread t;
	JFrame jf1;
	JFrame jf2;
	char temp[] = new char[83];
	String strr;
	monitor mo;
	int east, west, north, south, center;
	String e, w, n, s;
	int passed_no;
	int no_of_arr_created;
	int hash_pos_quotient;
	String passusername;
	String secretusername;

	threaddemo_hash(JFrame frame, char temp[], monitor mo, int passed_no, int no_of_arr_created, String passusername) {
		this.passusername = passusername;
		System.out.println("\n !!!!!!! threaddemo_hash.!!!!!!!!!! \n");

		this.no_of_arr_created = no_of_arr_created;

		cb = new Color(120, 120, 120);
		cf = new Color(64, 0, 64);

		// cb=new Color(227,214,134);
		// cf=new Color(15,15,15);
		f = new Font("Dialog", Font.BOLD, 18);
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
				center = Integer.parseInt(strr);
				north = center - 9;
				east = north + 10;
				south = east + 8;
				west = south - 10;

				n = Integer.toString(north);
				e = Integer.toString(east);
				s = Integer.toString(south);
				w = Integer.toString(west);

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
		System.out.println("(((((((((((((((((((  " + chk);
		if (((center >= 0 && center <= 8) && (chk >= 0 && chk <= 8))
				|| ((center >= 9 && center <= 17) && (chk >= 9 && chk <= 17))
				|| ((center >= 18 && center <= 26) && (chk >= 18 && chk <= 26))
				|| ((center >= 27 && center <= 35) && (chk >= 27 && chk <= 35))
				|| ((center >= 36 && center <= 44) && (chk >= 36 && chk <= 44))
				|| ((center >= 45 && center <= 53) && (chk >= 45 && chk <= 53))
				|| ((center >= 54 && center <= 62) && (chk >= 54 && chk <= 62))
				|| ((center >= 63 && center <= 71) && (chk >= 63 && chk <= 71))
				|| ((center >= 72 && center <= 80) && (chk >= 72 && chk <= 80)))

		// if(ae.getActionCommand().equals(e)||ae.getActionCommand().equals(w)||ae.getActionCommand().equals(n)||ae.getActionCommand().equals(s))
		{
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
				{
					System.out.println(
							"errrr" + mo.errorinput + " no of arr " + no_of_arr_created + " passed no" + passed_no);
					new passstr(passusername).getpath();
				} else if ((no_of_arr_created == passed_no) && (mo.errorinput == 2))

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

			// new RL(jf2);

		}
		jf2.setVisible(false);

	}// ap()

}// class