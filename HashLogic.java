/*
 Class Name: Hashlogic
 Purpose: Used for handling repeated character logic in password
 */
//import javax.swing.*;

public class HashLogic {

	// postn_of_hash==new postn of repeat character

	// found_hash_at==postn of repeat char in passed array

	int postn_of_hash;

	int lastpos;
	int found_hash_at = 0;
	String oneby81;
	char repchar;
	int x;
	char temp[] = new char[83];

	char hold;

	HashLogic(int midpos, char repchar) {

		System.out.println("\n !!!!!!! hashlogic.!!!!!!!!!! \n");

		this.repchar = repchar;
		postn_of_hash = midpos;

	}// constr

	char[] processing() {
		// file_raf=null;

		x = postn_of_hash;
		try {
			// eeeeeeeeeeeeeeeeeeeeeeeeeee
			oneby81 = null;
			//String str;
			int i;

			Object[] obj = new Object[81];
			Random1 randobj = new Random1();
			obj = randobj.getrandomarray();
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
		 * 
		 */

		// while start

		while (true) {

			for (int i = 0; i < 81; i++) {

				if (temp[i] == repchar) {
					found_hash_at = i;
					break;
				} // if

			} // for

			// ------------------------------------------------------------------
			// chk position repetiton

			if (found_hash_at == x)
				x = new getmid1().genrandom();
			else
				break;

		} // while end

		System.out.println("found # at " + found_hash_at);
		System.out.println("replace # to this position " + x);

		System.out.println("swap karne se pehle");

		System.out.println("temp[x] " + temp[x]);
		System.out.println("temp[found_hash_at] " + temp[found_hash_at]);

		// ----------------------------------------------------------------

		// final swap

		hold = temp[x];
		temp[x] = temp[found_hash_at];
		temp[found_hash_at] = hold;

		System.out.println("swap done");
		System.out.println("temp[x] " + temp[x]);
		System.out.println("temp[found_hash_at] " + temp[found_hash_at]);

		// --------------------------------------------------------------

		String str = Integer.toString(x);
		char array[];
		array = str.toCharArray();
		temp[81] = array[0];
		temp[82] = array[1];
		/*
		 * for(int l=0;l<83;l++) System.out.print(temp[l]);
		 */
		return (temp);
	}// processing()

}// class
