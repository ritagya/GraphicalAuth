/*
 Class Name: BorderLogic
 Purpose: This is for developing the border of the input
 */
import java.io.*;
import javax.swing.*;

public class BorderLogic {
	char search[];
	int mid_of_square;
	int m, mm1, mp1, a, a1, a2, d, d1, d2;
	int ansarray[] = new int[9];
	int lastpos;
	String oneby81;
	int x, b, c, flag;
	char temp[] = new char[83];
	int swap1[] = new int[4];
	int swap2[] = new int[4];
	int k = 0;
	int count = 0;
	int v = 0;
	char hold;
	int blogic;

	BorderLogic(int blogic, char arr[], int midpos, JFrame frame, monitor mo, int passed_no, int no_of_arr_created,
			String passusername) {
		System.out.println("\n !!!!!!! borderlogic!!!!!!!!!! \n");

		System.out.println(" -----------YUPPIEEEEEEEEEEEEEEE-----------" + blogic);
		this.blogic = blogic;

		if (blogic == 1)// top
		{
			m = midpos;
			mm1 = m - 1;
			mp1 = m + 1;
			d = m + 8;
			d1 = d + 1;
			d2 = d + 2;
			a = m + 71;
			a1 = a + 1;
			a2 = a + 2;

			ansarray[0] = m;
			ansarray[1] = mm1;
			ansarray[2] = mp1;
			ansarray[3] = d;
			ansarray[4] = d1;
			ansarray[5] = d2;
			ansarray[6] = a;
			ansarray[7] = a1;
			ansarray[8] = a2;

			System.out.println("logic 1" + m + mm1 + mp1 + d + d1 + d2 + a + a1 + a2);
		} else if (blogic == 2)// left
		{

			m = midpos;
			mm1 = m + 8;
			mp1 = m + 1;
			d = m + 17;
			d1 = d - 8;
			d2 = d - 7;
			a = m - 1;
			a1 = a - 8;
			a2 = a - 7;
			ansarray[0] = m;
			ansarray[1] = mm1;
			ansarray[2] = mp1;
			ansarray[3] = d;
			ansarray[4] = d1;
			ansarray[5] = d2;
			ansarray[6] = a;
			ansarray[7] = a1;
			ansarray[8] = a2;

			System.out.println("logic 2" + m + mm1 + mp1 + d + d1 + d2 + a + a1 + a2);

		} else if (blogic == 3)// right
		{
			m = midpos;
			mm1 = m - 1;
			mp1 = m - 8;
			d = m + 8;
			d1 = d + 1;
			d2 = d - 7;
			a = m - 10;
			a1 = a + 1;
			a2 = a - 7;
			ansarray[0] = m;
			ansarray[1] = mm1;
			ansarray[2] = mp1;
			ansarray[3] = d;
			ansarray[4] = d1;
			ansarray[5] = d2;
			ansarray[6] = a;
			ansarray[7] = a1;
			ansarray[8] = a2;
			System.out.println("logic 3" + m + mm1 + mp1 + d + d1 + d2 + a + a1 + a2);

		} else if (blogic == 4)// bottom
		{

			m = midpos;
			mm1 = m - 1;
			mp1 = m + 1;
			d = m - 73;
			d1 = d + 1;
			d2 = d + 2;
			a = m - 10;
			a1 = a + 1;
			a2 = a + 2;
			ansarray[0] = m;
			ansarray[1] = mm1;
			ansarray[2] = mp1;
			ansarray[3] = d;
			ansarray[4] = d1;
			ansarray[5] = d2;
			ansarray[6] = a;
			ansarray[7] = a1;
			ansarray[8] = a2;
			System.out.println("logic 4" + m + mm1 + mp1 + d + d1 + d2 + a + a1 + a2);

		}

		else {
			System.out.println("--------DANGER------");
		}

		search = arr;
		mid_of_square = midpos;

		flag = 1;
		x = mid_of_square;

		try {
			// eeeeeeeeeeeeeeeeeeeeeeeeeee
			oneby81 = null;
			String str = null;
			int i;
			Object[] obj = new Object[81];
			Random1 randobj = new Random1();
			obj = randobj.getrandomarray();
			// oneby81=obj;
			for (i = 0; i < 81; i++) {
				oneby81 = oneby81 + obj[i];

			} // for()

			System.out.println("\n " + oneby81);
		} // try
		catch (Exception e) {
		}

		System.out.println("this is from random access" + oneby81);

		oneby81.getChars(4, 85, temp, 0);

		/*
		 * for(int j=0;j<81;j++) {System.out.print(temp[j]); }
		 */
		System.out.println("m yet to  return");

		// ----------------------------------------------------------------

		/*
		 * UPTILL NW BELOW FRAGMENT WS INSIDE WHILE...AVOID UN NECESSARY
		 * PROCEESSING BT PLAC IT BEFOR WHILE COZ IN WHILE WE USE SWAP2 ND BY
		 * DAT TIM IT SHLD BE READY
		 */

		count = 0;
		k = 0;
		for (int i = 0; i < 81; i++) {
			for (int j = 0; j < 4; j++) {
				if (temp[i] == search[j]) {
					// System.out.println("this value is to be replaced
					// "+temp[i]+"which is at postn "+i);
					swap2[k] = i;
					count++;
					k++;

				} // if
			} // inner for
			if (count == 4)
				break;
		} // outer for
		System.out.println("count is" + count);

		// PENDING: BELOW WRITE GENERALISE DFORMULA COMPUTATIONS FOR WHILE LOOP
		// AS BELOW X=NEW MIDPOINT
		// x=midpos;

		// while(flag>0)
		// {

		System.out.println("value of x " + x);
		flag = 0;

		swap1[0] = a;
		System.out.println(" value os A is" + swap1[0]);

		swap1[1] = a2;
		System.out.println(" value os B is" + swap1[1]);

		swap1[2] = d2;
		System.out.println(" value os C is" + swap1[2]);

		swap1[3] = d;
		System.out.println(" value os D is" + swap1[3]);

		// ------------------------------------------------------------------

		// ------------------------------------------------------------------
		// chk position repetiton

		// ------------------------------------------------------------------
		for (int i = 0; i < 4; i++) {
			// System.out.println("inside for1");
			for (int j = 0; j < 4; j++) {
				// System.out.println("inside for2");
				if (swap1[i] == swap2[j]) {
					System.out.println(swap1[i] + "--->" + swap2[j]);

					// System.out.println("inside if");

					flag++;
				} // if
			} // for1

		} // for2
		System.out.println("!!!!!!!!!!___________________" + flag);
		if (flag > 0) {
			System.out.println("going to exexute getmid1");

			x = 2;
			// x=mid_of_square;
			System.out.println("after exexute getmid1");
			/*
			 * 
			 * 
			 * a=73; b=75; c=10; d=12;
			 * 
			 */
			m = 2;
			mm1 = m - 1;
			mp1 = m + 1;
			d = m + 8;
			d1 = d + 1;
			d2 = d + 2;
			a = m + 71;
			a1 = a + 1;
			a2 = a + 2;

			ansarray[0] = m;
			ansarray[1] = mm1;
			ansarray[2] = mp1;
			ansarray[3] = d;
			ansarray[4] = d1;
			ansarray[5] = d2;
			ansarray[6] = a;
			ansarray[7] = a1;
			ansarray[8] = a2;

			swap1[0] = a;
			System.out.println(" value os A is" + swap1[0]);

			swap1[1] = a2;
			System.out.println(" value os B is" + swap1[1]);

			swap1[2] = d2;
			System.out.println(" value os C is" + swap1[2]);

			swap1[3] = d;
			System.out.println(" value os D is" + swap1[3]);

		} // if
		flag = 0;

		// ----------------------------------------------------------------

		// final swap

		for (v = 0; v < 4; v++) {
			System.out.println("going inside for()");
			hold = temp[swap1[v]];
			temp[swap1[v]] = temp[swap2[v]];
			temp[swap2[v]] = hold;
			if (v == 3) {
				System.out.println("finally at position" + swap1[0] + " -->has come" + temp[swap1[0]]);
				System.out.println("finally at position" + swap1[1] + " -->has come" + temp[swap1[1]]);
				System.out.println("finally at position" + swap1[2] + " -->has come" + temp[swap1[2]]);
				System.out.println("finally at position" + swap1[3] + " -->has come" + temp[swap1[3]]);
			} // if
		}
		System.out.println("for loop k pehle sab theek he");

		// --------------------------------------------------------------
		try {
			String str = Integer.toString(x);
			char array[];
			array = str.toCharArray();
			temp[81] = array[0];
			temp[82] = array[1];
			/*
			 * for(int l=0;l<83;l++) System.out.print(temp[l]);
			 */
		} catch (Exception e) {
			System.out.println("\n err is here");
		}

		// call threaddemo_border
		new threaddemo_border(ansarray, frame, temp, mo, passed_no, no_of_arr_created, passusername);

	}// constructor

}// class
