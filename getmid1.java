/*
 Class Name: getmid1
 Purpose: Used to calculate the mid of the sqaure or line depending on the logic to be called
 */

import java.util.*;

public class getmid1 {

	boolean flag = false;
	Random r = new Random();
	int val;

	public int genrandom() {
		System.out.println("\n !!!!!!! getmid1.!!!!!!!!!! \n");
		try {
			do {
				flag = false;

				val = r.nextInt(80);
				if (val == 0 || val == 8 || val == 72 || val == 80)
					flag = true;
			} // do
			while (flag);
			System.out.println("midpoint--> " + val);
		} // try
		catch (Exception e) {
		}
		return (val);

	}// getmidpoint()

}// class