/*
 Class Name: Pswddiv
 Purpose: It divides the password into length of 
 */

import javax.swing.*;
import java.io.*;

public class Pswddiv {
	char[] pass;
	public char a[], b[], c[], d[];
	public int tp = 0;// to count number of arrays made
	public JFrame jref;
	int k = 0;
	int midpos;
	RandomAccessFile file1;
	int lastposition;

	int i1;
	int i = 0;
	ControlModule cm;

	public Pswddiv(char pass[], JFrame jfrm, String passusername) {

		System.out.println("\n !!!!!!! pswddiv.!!!!!!!!!! \n");

		jref = jfrm;
		// jref.setVisible(false);
		this.pass = pass;

		int len = pass.length;
		int count = 0;
		while ((len - count) >= 4) {
			tp++;

			if (tp == 1) {
				a = new char[4];
				for (i = 0, k = 0; i < 4; i++) {
					a[i] = pass[i];
					// System.out.println(a[i]+"from a");
				}

			} // inner if

			if (tp == 2) {
				b = new char[4];
				for (k = 0, i = 4; i < 8; i++, k++) {
					b[k] = pass[i];
					// System.out.println(b[k]+"from b");
				}

			} // inner if

			if (tp == 3) {
				c = new char[4];
				for (k = 0, i = 8; i < 12; i++, k++) {
					c[k] = pass[i];
					// System.out.println(c[k]+"from c");
				}

			} // inner if

			if (tp == 4) {
				d = new char[4];
				for (k = 0, i = 12; i < 16; i++, k++) {
					d[k] = pass[i];
					// System.out.println(d[k]+"from c");
				}

			} // inner if

			count = count + 4;

		} // big whole closed
		i1 = i - 1;

		// --------------------------------

		if ((len - count) == 1) {

			if (tp == 1) {
				b = new char[4];
				b[0] = pass[i1 + 1];
				b[1] = pass[0];
				b[2] = pass[1];
				b[3] = pass[2];
				// for(int j=0;j<4;j++)
				// System.out.println("from b"+b[j]);
			} // tp==1 wala if

			if (tp == 2) {
				c = new char[4];
				c[0] = pass[i1 + 1];
				c[1] = pass[0];
				c[2] = pass[1];
				c[3] = pass[2];
				// for(int j=0;j<4;j++)
				// System.out.println("from c"+c[j]);
			} // tp==2 wala if

			if (tp == 3) {
				d = new char[4];
				d[0] = pass[i1 + 1];
				d[1] = pass[0];
				d[2] = pass[1];
				d[3] = pass[2];
				// for(int j=0;j<4;j++)
				// System.out.println("from d"+d[j]);
			} // tp==3 wala if

			tp++;

		} // big if

		// --------------------------

		if ((len - count) == 2) {

			if (tp == 1) {
				b = new char[4];
				b[0] = pass[i1 + 1];
				b[1] = pass[i1 + 2];
				b[2] = pass[0];
				b[3] = pass[1];
				// for(int j=0;j<4;j++)
				// System.out.println("from b"+b[j]);
			} // tp==1 wala if

			if (tp == 2) {
				c = new char[4];
				c[0] = pass[i1 + 1];
				c[1] = pass[i1 + 2];
				c[2] = pass[0];
				c[3] = pass[1];
				// for(int j=0;j<4;j++)
				// System.out.println("from c"+c[j]);
			} // tp==2 wala if

			if (tp == 3) {
				d = new char[4];
				d[0] = pass[i1 + 1];
				d[1] = pass[i1 + 2];
				d[2] = pass[0];
				d[3] = pass[1];
				// for(int j=0;j<4;j++)
				// System.out.println("from d"+d[j]);
			} // tp==3 wala if

			tp++;

		} // big if

		// ----------------------------

		if ((len - count) == 3) {

			if (tp == 1) {
				b = new char[4];
				b[0] = pass[i1 + 1];
				b[1] = pass[i1 + 2];
				b[2] = pass[i1 + 3];
				b[3] = pass[0];
				// for(int j=0;j<4;j++)
				// System.out.println("from b"+b[j]);
			} // tp==1 wala if

			if (tp == 2) {
				c = new char[4];
				c[0] = pass[i1 + 1];
				c[1] = pass[i1 + 2];
				c[2] = pass[i1 + 3];
				c[3] = pass[0];
				// for(int j=0;j<4;j++)
				// System.out.println("from c"+c[j]);
			} // tp==2 wala if

			if (tp == 3) {
				d = new char[4];
				d[0] = pass[i1 + 1];
				d[1] = pass[i1 + 2];
				d[2] = pass[i1 + 3];
				d[3] = pass[0];
				// for(int j=0;j<4;j++)
				// System.out.println(d[j]);
			} // tp==3 wala if

			tp++;

		} // big if

		// ---------------------------------
		// for getmid1.java

		System.out.println("no of arr formed is" + tp);

		midpos = new getmid1().genrandom();
		System.out.println(midpos);

		// call the control module and pass n(arr) created and the mid pt of sqr
		// or d postn of#

		if (tp == 1)
			cm = new ControlModule(a, tp, midpos, jref, passusername);

		if (tp == 2)
			cm = new ControlModule(a, b, tp, midpos, jref, passusername);

		if (tp == 3)
			cm = new ControlModule(a, b, c, tp, midpos, jref, passusername);

		if (tp == 4)
			cm = new ControlModule(a, b, c, d, tp, midpos, jref, passusername);

	}// constr

}// class Pswddiv
