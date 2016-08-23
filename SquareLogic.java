/*
 Class Name: Square
 Purpose: This is the implementation of square logic for the password to be unique
 */


public class SquareLogic {
	char search[];
	int mid_of_square;

	String oneby81;
	int x, a, b, c, d, flag;
	char temp[] = new char[83];
	int swap1[] = new int[4];
	int swap2[] = new int[4];
	int k = 0;
	int count = 0;
	int v = 0;
	char hold;

	SquareLogic(char a[], int midpos) {

		System.out.println("\n !!!!!!! squarelogic.!!!!!!!!!! \n");

		search = a;
		mid_of_square = midpos;

	}// constr

	char[] processing() {

		flag = 1;
		x = mid_of_square;

		// eeeeeeeeeeeeeeeeeeeeeeeeeee

		try {
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

		System.out.println("value of x " + x);
		flag = 0;
		a = x - 10;
		b = a + 2;
		c = b + 18;
		d = c - 2;

		swap1[0] = a;
		System.out.println(" value os A is" + swap1[0]);

		swap1[1] = b;
		System.out.println(" value os B is" + swap1[1]);

		swap1[2] = c;
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
				if (swap1[i] == swap2[j]) {// System.out.println(swap1[i]+"--->"+swap2[j]);

					// System.out.println("inside if");

					flag++;
				} // if
			} // for1

		} // for2

		if (flag > 0) {
			System.out.println("going to exexute getmid1");
			if (x < 16 || x == 0 || x == 8 || x == 72 || x == 80)
				x = 50;
			else
				x = x - 5;
			// x=mid_of_square;
			System.out.println("after exexute getmid1");

			a = x - 10;
			b = a + 2;
			c = b + 18;
			d = c - 2;

			swap1[0] = a;
			System.out.println(" value os A is" + swap1[0]);

			swap1[1] = b;
			System.out.println(" value os B is" + swap1[1]);

			swap1[2] = c;
			System.out.println(" value os C is" + swap1[2]);

			swap1[3] = d;
			System.out.println(" value os D is" + swap1[3]);

		} // if
		flag = 0;

		// ----------------------------------------------------------------

		// final swap

		for (v = 0; v < 4; v++) {
			// System.out.println("going inside for()");
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

		String str = Integer.toString(x);
		char array[];
		array = str.toCharArray();
		temp[81] = array[0];
		temp[82] = array[1];
		for (int l = 0; l < 83; l++)
			System.out.print(temp[l]);
		return (temp);
	}// processing()
}// class
