/*
 Class Name: ControlModule
 Purpose: This is the entry point for all the screen generation logic and screen building logic
*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ControlModule {
	int no1 = 1, no2 = 2, no3 = 3, no4 = 4;
	JFrame frame;
	monitor mo;
	int x, y, ans1, ans2, ans3, ans4;
	int no_of_arr_created;
	int midpos1, midpos2, midpos3, midpos4;
	char a[], b[], c[], d[];
	char temp1[], temp2[], temp3[], temp4[];
	String strr, strr1;
	JFrame jref;
	
	public void border_calc(int mid) {
		// calc no1
		ans1 = mid / 10;

		// cal no2
		ans2 = mid % 9;
		// calc no3
		x = mid / 10;
		y = mid % 10;
		ans3 = x + y;
		// cal no 4 nt needed direct in if
		ans4 = mid;
	}// border-calc

	// constr1-----------------------------------------------------------------
	ControlModule(char a[], int no_of_arr_created, int midpos, JFrame jfrm, String passusername) {
		System.out.println("\n !!!!!!! controlmodule.!!!!!!!!!! \n");

		jref = jfrm;
		this.a = a;
		this.no_of_arr_created = no_of_arr_created;
		this.midpos1 = midpos;
		border_calc(midpos1);
		mo = new monitor();

		char b_a = new equal().chk_equality(a);
		if (b_a != ':') {
			System.out.println("apply hash logic");
			temp1 = new HashLogic(midpos1, b_a).processing();
			System.out.println("after apply hash logic");
			new threaddemo_hash(jref, temp1, mo, no1, no_of_arr_created, passusername);

		} // if hash
		else {

			if (ans1 == 0)
				new BorderLogic(1, a, midpos1, jref, mo, no1, no_of_arr_created, passusername);
			else if (ans2 == 0)
				new BorderLogic(2, a, midpos1, jref, mo, no1, no_of_arr_created, passusername);
			else if (ans3 == 8)
				new BorderLogic(3, a, midpos1, jref, mo, no1, no_of_arr_created, passusername);
			else if (ans4 >= 73 && ans4 <= 79)
				new BorderLogic(4, a, midpos1, jref, mo, no1, no_of_arr_created, passusername);
			else {
				System.out.println("apply square logic");
				temp1 = new SquareLogic(a, midpos1).processing();
				System.out.println("after apply square logic");

				new threaddemo_square(jref, temp1, mo, no1, no_of_arr_created, passusername);

			} // else of if else ladder

		} // else square

	}// constr1

	// constr2------------------------------------------------------

	ControlModule(char a[], char b[], int no_of_arr_created, int midpos, JFrame jfrm, String passusername) {

		System.out.println("\n !!!!!!! controlmodule.!!!!!!!!!! \n");

		jref = jfrm;
		this.a = a;
		this.b = b;
		this.no_of_arr_created = no_of_arr_created;
		this.midpos1 = midpos;
		border_calc(midpos1);
		char b_a = new equal().chk_equality(a);
		char b_b = new equal().chk_equality(b);
		mo = new monitor();

		if (b_a != ':') {
			System.out.println("apply hash logic");
			temp1 = new HashLogic(midpos1, b_a).processing();
			System.out.println("after apply hash logic");
			new threaddemo_hash(jref, temp1, mo, no1, no_of_arr_created, passusername);
		} // if hash
		else {

			if (ans1 == 0)
				new BorderLogic(1, a, midpos1, jref, mo, no1, no_of_arr_created, passusername);
			else if (ans2 == 0)
				new BorderLogic(2, a, midpos1, jref, mo, no1, no_of_arr_created, passusername);
			else if (ans3 == 8)
				new BorderLogic(3, a, midpos1, jref, mo, no1, no_of_arr_created, passusername);
			else if (ans4 >= 73 && ans4 <= 79)
				new BorderLogic(4, a, midpos1, jref, mo, no1, no_of_arr_created, passusername);
			else {
				System.out.println("apply square logic");
				temp1 = new SquareLogic(a, midpos1).processing();
				System.out.println("after apply square logic");
				System.out.println("temp1[81]" + temp1[81]);
				System.out.println("temp1[82]" + temp1[82]);
				System.out.println("after apply square logic");

				new threaddemo_square(jref, temp1, mo, no1, no_of_arr_created, passusername);

				System.out.println("wait failed");
			} // if else ladder
		} // else square

		if (b_b != ':') {
			System.out.println("apply hash logic");
			midpos2 = new getmid1().genrandom();
			temp2 = new HashLogic(midpos2, b_b).processing();
			System.out.println("after apply hash logic");
			new threaddemo_hash(jref, temp2, mo, no2, no_of_arr_created, passusername);
		} // if hash
		else {

			midpos2 = new getmid1().genrandom();
			border_calc(midpos2);
			if (ans1 == 0)
				new BorderLogic(1, b, midpos2, jref, mo, no2, no_of_arr_created, passusername);
			else if (ans2 == 0)
				new BorderLogic(2, b, midpos2, jref, mo, no2, no_of_arr_created, passusername);
			else if (ans3 == 8)
				new BorderLogic(3, b, midpos2, jref, mo, no2, no_of_arr_created, passusername);
			else if (ans4 >= 73 && ans4 <= 79)
				new BorderLogic(4, b, midpos2, jref, mo, no2, no_of_arr_created, passusername);
			else {
				System.out.println("apply square logic");
				temp2 = new SquareLogic(b, midpos2).processing();
				System.out.println("after apply square logic");
				new threaddemo_square(jref, temp2, mo, no2, no_of_arr_created, passusername);

			} // if else ladder
		} // else square

	}// constr2

	// constr3------------------------------------------------------------------

	ControlModule(char a[], char b[], char c[], int no_of_arr_created, int midpos, JFrame jfrm, String passusername) {

		System.out.println("\n !!!!!!! controlmodule.!!!!!!!!!! \n");
		jref = jfrm;
		this.a = a;
		this.b = b;
		this.c = c;
		this.no_of_arr_created = no_of_arr_created;
		this.midpos1 = midpos;
		border_calc(midpos1);
		char b_a = new equal().chk_equality(a);
		char b_b = new equal().chk_equality(b);
		char b_c = new equal().chk_equality(c);
		mo = new monitor();
		if (b_a != ':') {
			System.out.println("apply hash logic");
			temp1 = new HashLogic(midpos1, b_a).processing();
			System.out.println("after apply hash logic");
			new threaddemo_hash(jref, temp1, mo, no1, no_of_arr_created, passusername);
		} // if hash
		else {
			if (ans1 == 0)
				new BorderLogic(1, a, midpos1, jref, mo, no1, no_of_arr_created, passusername);
			else if (ans2 == 0)
				new BorderLogic(2, a, midpos1, jref, mo, no1, no_of_arr_created, passusername);
			else if (ans3 == 8)
				new BorderLogic(3, a, midpos1, jref, mo, no1, no_of_arr_created, passusername);
			else if (ans4 >= 73 && ans4 <= 79)
				new BorderLogic(4, a, midpos1, jref, mo, no1, no_of_arr_created, passusername);
			else {
				System.out.println("apply square logic");
				temp1 = new SquareLogic(a, midpos1).processing();
				System.out.println("after apply square logic");
				System.out.println("temp1[81]" + temp1[81]);
				System.out.println("temp1[82]" + temp1[82]);
				System.out.println("after apply square logic");
				new threaddemo_square(jref, temp1, mo, no1, no_of_arr_created, passusername);
				System.out.println("wait failed");
			} // else if ladder
		} // else square

		if (b_b != ':') {
			System.out.println("apply hash logic");
			midpos2 = new getmid1().genrandom();
			temp2 = new HashLogic(midpos2, b_b).processing();
			System.out.println("after apply hash logic");
			new threaddemo_hash(jref, temp2, mo, no2, no_of_arr_created, passusername);
		} // if hash
		else {
			midpos2 = new getmid1().genrandom();
			border_calc(midpos2);
			if (ans1 == 0)
				new BorderLogic(1, b, midpos2, jref, mo, no2, no_of_arr_created, passusername);
			else if (ans2 == 0)
				new BorderLogic(2, b, midpos2, jref, mo, no2, no_of_arr_created, passusername);
			else if (ans3 == 8)
				new BorderLogic(3, b, midpos2, jref, mo, no2, no_of_arr_created, passusername);
			else if (ans4 >= 73 && ans4 <= 79)
				new BorderLogic(4, b, midpos2, jref, mo, no2, no_of_arr_created, passusername);
			else {
				System.out.println("apply square logic");
				temp2 = new SquareLogic(b, midpos2).processing();
				System.out.println("after apply square logic");
				new threaddemo_square(jref, temp2, mo, no2, no_of_arr_created, passusername);
			} // else if ladder
		} // else square

		if (b_c != ':') {
			System.out.println("apply hash logic");
			midpos3 = new getmid1().genrandom();
			temp3 = new HashLogic(midpos3, b_c).processing();
			System.out.println("after apply hash logic");
			new threaddemo_hash(jref, temp3, mo, no3, no_of_arr_created, passusername);
		} // if hash
		else {
			midpos3 = new getmid1().genrandom();
			border_calc(midpos3);
			if (ans1 == 0)
				new BorderLogic(1, c, midpos3, jref, mo, no3, no_of_arr_created, passusername);
			else if (ans2 == 0)
				new BorderLogic(2, c, midpos3, jref, mo, no3, no_of_arr_created, passusername);
			else if (ans3 == 8)
				new BorderLogic(3, c, midpos3, jref, mo, no3, no_of_arr_created, passusername);
			else if (ans4 >= 73 && ans4 <= 79)
				new BorderLogic(4, c, midpos3, jref, mo, no3, no_of_arr_created, passusername);
			else {
				System.out.println("apply square logic");
				temp3 = new SquareLogic(c, midpos3).processing();
				System.out.println("after apply square logic");
				new threaddemo_square(jref, temp3, mo, no3, no_of_arr_created, passusername);
			} // else if ladder
		} // else square

	}// constr3

	// constr4---------------------------------------------------------------------

	ControlModule(char a[], char b[], char c[], char d[], int no_of_arr_created, int midpos, JFrame jfrm,
			String passusername) {

		System.out.println("\n !!!!!!! controlmodule.!!!!!!!!!! \n");

		jref = jfrm;
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
		this.no_of_arr_created = no_of_arr_created;
		this.midpos1 = midpos;
		border_calc(midpos1);
		char b_a = new equal().chk_equality(a);
		char b_b = new equal().chk_equality(b);
		char b_c = new equal().chk_equality(c);
		char b_d = new equal().chk_equality(d);

		mo = new monitor();
		if (b_a != ':') {
			System.out.println("apply hash logic");
			temp1 = new HashLogic(midpos1, b_a).processing();
			System.out.println("after apply hash logic");
			new threaddemo_hash(jref, temp1, mo, no1, no_of_arr_created, passusername);
		} // if hash
		else {
			if (ans1 == 0)
				new BorderLogic(1, a, midpos1, jref, mo, no1, no_of_arr_created, passusername);
			else if (ans2 == 0)
				new BorderLogic(2, a, midpos1, jref, mo, no1, no_of_arr_created, passusername);
			else if (ans3 == 8)
				new BorderLogic(3, a, midpos1, jref, mo, no1, no_of_arr_created, passusername);
			else if (ans4 >= 73 && ans4 <= 79)
				new BorderLogic(4, a, midpos1, jref, mo, no1, no_of_arr_created, passusername);
			else {
				System.out.println("apply square logic");
				temp1 = new SquareLogic(a, midpos1).processing();
				System.out.println("after apply square logic");
				System.out.println("temp1[81]" + temp1[81]);
				System.out.println("temp1[82]" + temp1[82]);
				System.out.println("after apply square logic");
				new threaddemo_square(jref, temp1, mo, no1, no_of_arr_created, passusername);
				System.out.println("wait failed");
			} // else if ladder
		} // else square

		if (b_b != ':') {
			System.out.println("apply hash logic");
			midpos2 = new getmid1().genrandom();
			temp2 = new HashLogic(midpos2, b_b).processing();
			System.out.println("after apply hash logic");
			new threaddemo_hash(jref, temp2, mo, no2, no_of_arr_created, passusername);
		} // if hash
		else {

			midpos2 = new getmid1().genrandom();
			border_calc(midpos2);
			if (ans1 == 0)
				new BorderLogic(1, b, midpos2, jref, mo, no2, no_of_arr_created, passusername);
			else if (ans2 == 0)
				new BorderLogic(2, b, midpos2, jref, mo, no2, no_of_arr_created, passusername);
			else if (ans3 == 8)
				new BorderLogic(3, b, midpos2, jref, mo, no2, no_of_arr_created, passusername);
			else if (ans4 >= 73 && ans4 <= 79)
				new BorderLogic(4, b, midpos2, jref, mo, no2, no_of_arr_created, passusername);
			else {
				System.out.println("apply square logic");
				temp2 = new SquareLogic(b, midpos2).processing();
				System.out.println("after apply square logic");
				new threaddemo_square(jref, temp2, mo, no2, no_of_arr_created, passusername);
			} // else if
		} // else square

		if (b_c != ':') {
			System.out.println("apply hash logic");
			midpos3 = new getmid1().genrandom();
			temp3 = new HashLogic(midpos3, b_c).processing();
			System.out.println("after apply hash logic");
			new threaddemo_hash(jref, temp3, mo, no3, no_of_arr_created, passusername);
		} // if hash
		else {

			midpos3 = new getmid1().genrandom();
			border_calc(midpos3);
			if (ans1 == 0)
				new BorderLogic(1, c, midpos3, jref, mo, no3, no_of_arr_created, passusername);
			else if (ans2 == 0)
				new BorderLogic(2, c, midpos3, jref, mo, no3, no_of_arr_created, passusername);
			else if (ans3 == 8)
				new BorderLogic(3, c, midpos3, jref, mo, no3, no_of_arr_created, passusername);
			else if (ans4 >= 73 && ans4 <= 79)
				new BorderLogic(4, c, midpos3, jref, mo, no3, no_of_arr_created, passusername);
			else {
				System.out.println("apply square logic");
				temp3 = new SquareLogic(c, midpos3).processing();
				System.out.println("after apply square logic");
				new threaddemo_square(jref, temp3, mo, no3, no_of_arr_created, passusername);
			} // else if
		} // else square

		if (b_d != ':') {
			System.out.println("apply hash logic");
			midpos4 = new getmid1().genrandom();
			temp4 = new HashLogic(midpos4, b_d).processing();
			System.out.println("after apply hash logic");
			new threaddemo_hash(jref, temp4, mo, no4, no_of_arr_created, passusername);
		} // if hash
		else {
			midpos4 = new getmid1().genrandom();
			border_calc(midpos4);
			if (ans1 == 0)
				new BorderLogic(1, d, midpos4, jref, mo, no4, no_of_arr_created, passusername);
			else if (ans2 == 0)
				new BorderLogic(2, d, midpos4, jref, mo, no4, no_of_arr_created, passusername);
			else if (ans3 == 8)
				new BorderLogic(3, d, midpos4, jref, mo, no4, no_of_arr_created, passusername);
			else if (ans4 >= 73 && ans4 <= 79)
				new BorderLogic(4, d, midpos4, jref, mo, no4, no_of_arr_created, passusername);
			else {

				System.out.println("apply square logic");
				temp4 = new SquareLogic(d, midpos4).processing();
				System.out.println("after apply square logic");

				new threaddemo_square(jref, temp4, mo, no4, no_of_arr_created, passusername);
			} // else if
		} // else square
	}// constr4
}// end of class
