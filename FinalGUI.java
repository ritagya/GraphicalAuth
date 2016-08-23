/*
 Class Name: FinalGUI
 Purpose: After successful login, this class is used to display the final screen for user operations
 */

import java.awt.print.PrinterException;
import java.awt.*;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;
import java.sql.*;

public class FinalGUI extends JFrame implements ActionListener {
	String path, str;
	File outfile, dir;
	String query, str3, chkpath;
	FileWriter outs = null;
	int i1, i2;
	Connection connection;
	Statement statement;
	Requester client;
	String updated_data, fname, passusername;
	JTextArea ta;
	JComboBox jl;
	JLabel disp_dt;
	FileWriter file_write_welcome;
	String selectedfile, fileName;

	JButton ok = new JButton("Ok");
	JTextField txt = new JTextField("", 50);
	JButton delfile = new JButton("Delete This File");
	JTextArea uiTxaDummy = new JTextArea(); // Hidden for printing only,
	JButton Cancel = new JButton("Cancel");
	Container c;
	Color c1, c2;
	Font f;

	public FinalGUI(String data, String path, String passusername) {
		super("");
		System.out.println("G U I");
		this.passusername = passusername;
		// for retrieveing date time of last access and store current date time
		client = new Requester();
		String DateTime = client.run(passusername);
		System.out.println("\n !!!!!!! finalgui.!!!!!!!!!! \n");
		this.path = path;
		outfile = new File(path);
		setSize(1024, 740);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		c = getContentPane();

		Color cc1 = new Color(140, 140, 140);
		Color cc2 = new Color(70, 0, 70);
		Color cc3 = new Color(64, 0, 64);

		c1 = new Color(120, 120, 120);
		c2 = new Color(120, 120, 120);
		c.setBackground(c2);
		c.setLayout(null);

		disp_dt = new JLabel("Last Access Date-Time :" + DateTime);
		ta = new JTextArea(data, 40, 50);
		f = new Font("Dialog", Font.PLAIN, 16);
		JButton _uiButPrint = new JButton("Print");
		jl = new JComboBox();
		jl.setName("lists");
		JScrollPane scrollText = new JScrollPane(ta);

		JButton save = new JButton("Save");
		JButton close = new JButton("Exit");
		JButton logout = new JButton("Logout");
		JButton login = new JButton("Login");
		JButton change = new JButton("Change Password");
		JButton delete = new JButton("Delete Account");
		JButton create = new JButton("Create New File");

		ta.setBackground(cc1);
		scrollText.setBackground(c1);
		save.setBackground(c1);
		close.setBackground(c1);
		logout.setBackground(c1);
		login.setBackground(c1);
		change.setBackground(c1);
		delete.setBackground(c1);
		_uiButPrint.setBackground(c1);
		jl.setBackground(c1);
		create.setBackground(c1);
		txt.setBackground(Color.WHITE);
		ok.setBackground(c1);
		delfile.setBackground(c1);
		Cancel.setBackground(c1);

		delfile.addActionListener(this);
		ok.addActionListener(this);
		save.addActionListener(this);
		close.addActionListener(this);
		logout.addActionListener(this);
		login.addActionListener(this);
		change.addActionListener(this);
		delete.addActionListener(this);
		_uiButPrint.addActionListener(this);
		jl.addActionListener(this);
		create.addActionListener(this);
		Cancel.addActionListener(this);
		// Create a file chooser that opens up as an Open dialog

		txt.setBounds(800, 100, 200, 30);
		ok.setBounds(800, 150, 90, 40);
		scrollText.setBounds(250, 70, 500, 500);
		save.setBounds(160, 630, 110, 40);
		logout.setBounds(730, 630, 100, 40);
		login.setBounds(640, 630, 80, 40);
		close.setBounds(840, 630, 80, 40);
		change.setBounds(280, 630, 180, 40);
		delete.setBounds(470, 630, 160, 40);
		disp_dt.setBounds(340, 45, 500, 20);
		_uiButPrint.setBounds(50, 630, 100, 40);
		jl.setBounds(350, 10, 300, 30);
		create.setBounds(800, 25, 200, 40);
		delfile.setBounds(800, 100, 200, 40);
		Cancel.setBounds(910, 150, 90, 40);

		// c.add(ta);
		disp_dt.setFont(f);
		ok.setFont(f);
		_uiButPrint.setFont(f);
		ta.setFont(f);
		save.setFont(f);
		close.setFont(f);
		logout.setFont(f);
		close.setFont(f);
		login.setFont(f);
		change.setFont(f);
		delete.setFont(f);
		uiTxaDummy.setFont(f);
		jl.setFont(f);
		create.setFont(f);
		txt.setFont(f);
		delfile.setFont(f);
		Cancel.setFont(f);

		save.setForeground(cc3);
		close.setForeground(cc3);
		logout.setForeground(cc3);
		login.setForeground(cc3);
		change.setForeground(cc3);
		delete.setForeground(cc3);
		disp_dt.setForeground(cc3);
		_uiButPrint.setForeground(cc3);
		Cancel.setForeground(cc3);
		// ta.setBackground(Color.BLACK);
		ta.setForeground(cc2);
		jl.setForeground(cc2);
		create.setForeground(cc2);
		txt.setForeground(cc2);
		ok.setForeground(cc3);
		delfile.setForeground(cc3);
		Cancel.setForeground(cc3);

		uiTxaDummy.setLineWrap(true);
		uiTxaDummy.setWrapStyleWord(true);

		c.add(txt);
		c.add(ok);
		c.add(disp_dt);
		c.add(scrollText);
		c.add(save);
		c.add(logout);
		c.add(login);
		c.add(change);
		c.add(close);
		c.add(delete);
		c.add(_uiButPrint);
		c.add(jl);
		c.add(create);
		c.add(delfile);
		c.add(Cancel);
		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			connection = DriverManager.getConnection("jdbc:odbc:driver={SQL Server};server=NLAPTOP;uid=sa;database=gpa",
					"sa", "sa");
			statement = connection.createStatement();
			System.out.println("Connection established");

			query = "select dirpath from user_db where uname='" + passusername + "'";
			boolean hasResult = statement.execute(query);
			if (hasResult) {
				ResultSet rs = statement.getResultSet();
				while (rs.next()) {
					str3 = rs.getString(1);

				} // while
			} // if
			query = "update user_db set timesinvalid=0 where uname='" + passusername + "'";
			statement.execute(query);

			query = "select filepath from user_db where uname='" + passusername + "'";
			hasResult = statement.execute(query);
			if (hasResult) {
				ResultSet rsa = statement.getResultSet();
				while (rsa.next()) {
					chkpath = rsa.getString(1);

				} // while
			} // if

			statement.execute(query);
		} // try
		catch (Exception e) {
		}

		setTitle("Welcome " + passusername);
		dirlist(str3);
		txt.setVisible(false);
		ok.setVisible(false);
		Cancel.setVisible(false);
		setVisible(true);
	}

	public void dirlist(String fname) {
		dir = new File(fname);
		String[] chld = dir.list();
		if (chld == null) {
			System.out.println("Specified directory does not exist or is not a directory.");
			System.exit(0);
		} else {
			for (int i = 0; i < chld.length; i++) {
				fileName = chld[i];
				System.out.println(fileName);
				jl.addItem(fileName);
			}
		}
	}// dirlist

	public void actionPerformed(ActionEvent ae) {
		try {
			String str = ae.getActionCommand();
			if (str.equals("Delete This File")) {
				String chk = str3.concat("\\\\" + jl.getSelectedItem());
				System.out.println("file path" + chkpath + " checkkkkkkkkk " + chk);
				if (chk.equals(chkpath))
					new CustomDialog(this, true, "You Cannot Delete Your ACCOUNT File");
				else {
					DeleteDialog myDialog = new DeleteDialog(this, true,
							"Are You Sure You Want To Permenantly Delete This File",
							str3 + "\\" + jl.getSelectedItem());
					jl.removeAllItems();
					dirlist(str3);
					readfromfile(str3 + "\\" + jl.getSelectedItem());
					repaint();
				}
			}

			if (str.equals("Create New File")) {
				delfile.setVisible(false);
				txt.setVisible(true);
				ok.setVisible(true);
				Cancel.setVisible(true);
				// txt.grabFocus();
			}

			if (str.equals("Ok")) {
				try {
					fname = txt.getText() + ".txt";
					String abc;
					abc = str3 + "\\" + fname;
					file_write_welcome = new FileWriter(new File(abc));
					file_write_welcome.close();
				} catch (Exception e) {
				}
				// String add= new CreateCustomDialog(this,true,str3);
				txt.setText("");
				txt.setVisible(false);
				ok.setVisible(false);
				Cancel.setVisible(false);
				delfile.setVisible(true);
				System.out.println("new file:" + str3 + "\\" + fname);
				jl.removeAllItems();
				dirlist(str3);
				jl.setSelectedItem(fname);
				readfromfile(str3 + "\\" + fname);
			}

			if (str.equals("Cancel")) {
				txt.setText("");
				txt.setVisible(false);
				ok.setVisible(false);
				delfile.setVisible(true);
				Cancel.setVisible(false);
			}

			if (str.equals("Save")) {
				updated_data = ta.getText();
				outs = new FileWriter(outfile);
				outs.write(updated_data.toCharArray());
				outs.close();
			} // if save

			if (str.equals("Exit")) {
				System.exit(0);
			} // if exit

			if (str.equals("Logout")) {
				new RL(this);
			} // if register

			if (str.equals("Login")) {
				new askuser(this);
			} // if login

			if (str.equals("Change Password")) {
				System.out.println("");
				new ChangePswd(this, passusername);
			} // if login

			if (str.equals("Delete Account")) {
				new DeleteUser(this, passusername);
			} // if login

			if (str.equals("Print")) {
				// Print all text
				if (ta.getSelectedText() == null) {
					uiTxaDummy.setText(ta.getText());
				} else // Print selected text
				{
					uiTxaDummy.setText(ta.getSelectedText());
				}
				try {
					// This will show the print dialog.
					uiTxaDummy.print();
				} catch (PrinterException e) {
					e.printStackTrace(); // To change body of catch statement
											// use File | Settings | File
											// Templates.
				}
				// Set focus so that selected text is highlighted.
				ta.requestFocusInWindow();
			} // if login
			else {
				selectedfile = "" + ((JComboBox) ae.getSource()).getSelectedItem();
				System.out.println("" + selectedfile);
				readfromfile(str3 + "\\" + selectedfile);
				path = str3 + "\\" + selectedfile;
				outfile = new File(path);
			}
			outs.close();
		} // try
		catch (Exception e) {
		}
	}// ap

	public void readfromfile(String str_path) {
		FileReader ins = null;
		File infile;
		char temporary[];
		int j, k = 0;
		int len;
		String s = null;
		infile = new File(str_path);
		int i1;
		System.out.println("\n reading!!!!!!!!! \n" + str_path);
		try {
			ins = new FileReader(infile);
			if (ins.read() == -1) {
				ta.setText("");
				ins.close();
			} else {
				ins.close();
				ins = new FileReader(infile);
				while ((i1 = ins.read()) != -1) {
					s = s + (char) i1;
				} // while
				ins.close();
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
				ta.setText(str);
			} // else
		} // try
		catch (Exception e) {
		}
	}// readfromfile()
}