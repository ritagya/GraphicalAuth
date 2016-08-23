/*
 Class Name: equal
 Purpose: This is used to check the unique and repeate chracters in the password of the user
 */
public class equal {
	int count;
	char repchar;

	equal() {
		count = 0;
	}// constr

	char chk_equality(char a[]) {
		System.out.println("\n !!!!!!! equal!!!!!!!!!! \n");
		for (int i = 0; i < 4; i++) {
			for (int j = i + 1; j < 4; j++) {
				if (a[i] == a[j]) {
					repchar = a[i];
					count++;
					break;
				} // if
			} // for1
			if (count > 0)
				break;
		} // for2
		if (count == 1) {
			System.out.println("reptd char is " + repchar);
			return (repchar);
		} else
			return (':');
	}// equal()
}// class