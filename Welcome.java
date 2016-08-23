
//import header files
import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.event.*;

public class Welcome {
	JLabel jlab;
	public JFrame jfrm;
	Font f;
	JButton go;
	ImageIcon ii1, ii2;

	// constructor
	Welcome() {
		System.out.println("\n !!!!!!! Welcome !!!!!!!!!! \n");
		f = new Font("Dialog", Font.BOLD, 28);
		jfrm = new JFrame("Welcome Screen");
		jfrm.setLayout(null);
		ii1 = new ImageIcon("C:\\Users\\Karishma\\workspace\\GraphicalAuthentication\\src\\frontscreen.jpg");
		ii2 = new ImageIcon("C:\\Users\\Karishma\\workspace\\GraphicalAuthentication\\src\\go.gif");
		go = new JButton(" ");
		go.setIcon(ii2);
		jfrm.setSize(1024, 768);
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container c = jfrm.getContentPane();
		Color c1 = new Color(47, 97, 179);
		jlab = new JLabel("");

		c.setBackground(Color.BLACK);
		go.setBackground(c1);

		jlab.setIcon(ii1);
		jlab.setFont(f);

		c.add(jlab);
		c.add(go);

		jlab.setBounds(5, -65, 2000, 800);
		go.setBounds(875, 620, 120, 70);

		jfrm.setVisible(true);

		go.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				new RL(jfrm);
			}
		});
	}
}
