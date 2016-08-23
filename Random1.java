/*
 Class Number: Random1
 Purpose: Generates a random screen of 9*9 
 */
import java.util.Collections;
import java.util.ArrayList;
import java.util.Arrays;

public class Random1 {
	public Object[] getrandomarray() {

		System.out.println("\n !!!!!!! random1.!!!!!!!!!! \n");



		ArrayList<String> alpha = new ArrayList<String>(Arrays.asList("0", "1", "2", "3", "4", "5", "6", "7", "8", "9",
				"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u",
				"v", "w", "x", "y", "z", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P",
				"Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "'", "\"", "@", "#", "{", "}", "[", "]", "%", "&",
				"$", "(", ")", "<", ">", "?", "_", "~", "/"));
		Collections.shuffle(alpha);
		// System.out.println(alpha);
		Object a[] = alpha.toArray();

		for (int i = 0; i < 81; i++) {
			System.out.print(a[i] + "-->" + i + "\t");
		}

		return (a);
	}

}
