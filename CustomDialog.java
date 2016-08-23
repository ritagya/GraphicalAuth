/*
 Class Name: CustomDialog
 Purpose: This is used for developing Custom dialog box and provide alert whenever necessary
 */
import javax.swing.JDialog;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.*;
import javax.swing.*;

public class CustomDialog extends JDialog implements ActionListener {
	private JPanel myPanel = null;
	private JButton yesButton = null;
	private JButton noButton = null;
	private boolean answer = false;
	Color c1;
	
	public boolean getAnswer() {
		return answer;
	}
	//Constructor
	public CustomDialog(JFrame frame, boolean model, String myMessage) {
		super(frame, model);
		System.out.println("\n !!!!!!! CustomDialog !!!!!!!!!! \n");
		Color c1 = new Color(120, 120, 120);
		Color c2 = new Color(120, 120, 120);
		Color c3 = new Color(64, 0, 64);
		myPanel = new JPanel();
		getContentPane().add(myPanel);
		yesButton = new JButton("OK");
		JLabel la = new JLabel(myMessage);
		yesButton.addActionListener(this);

		myPanel.add(la);
		myPanel.add(yesButton);
		pack();
		setLocationRelativeTo(frame);

		la.setForeground(c3);
		yesButton.setForeground(c3);
		yesButton.setBackground(c1);
		myPanel.setBackground(c1);

		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if (yesButton == e.getSource()) {
			System.err.println("User chose yes.");
			answer = true;
			setVisible(false);
		}
	}
}