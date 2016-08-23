/*
 Class Name: pg3011
 Purpose: This class lists down ll the files present in the directory
*/
import java.io.*;

public class pg3011 {
	FileReader ins = null;
	File infile;
	String str;
	char temporary[];
	int i, j, k = 0;
	int len;
	String s = null;

	FinalGUI fgui;

	String passusername;

	public pg3011(String passusername) {
		this.passusername = passusername;
	}

	void readfromfile(String str_path) {

		System.out.println("\n !!!!!!! pg3011.!!!!!!!!!! \n");

		infile = new File(str_path);
		int i1;

		try {
			ins = new FileReader(infile);
			while ((i1 = ins.read()) != -1) {
				s = s + (char) i1;
			} // while
			System.out.println(s);
		} // try
		catch (Exception e) {
		}

		try {
			ins.close();
		} catch (Exception e) {
		}

		// null nikalo

		len = s.length();
		temporary = new char[len - 4];
		System.out.println("login id len==" + len);
		for (j = 4; j < len; j++, k++) {
			// System.out.print("in for");

			temporary[k] = s.charAt(j);
			// System.out.print(temporary[k]);
		}
		System.out.println("after for loop");
		Character cc = new Character(temporary[0]);
		str = cc.toString();

		for (int i = 1; i < temporary.length; i++) {

			str = str + temporary[i];
		} // for
		System.out.println("value os str is" + str);
		fgui = new FinalGUI(str, str_path, passusername);
		// str3==filepath
	}// readfromfile()
}// class
