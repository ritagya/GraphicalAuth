/*
 Class Name: DeleteDialog
 Purpose: This is used to provide delete dialog box 
 */
import javax.swing.JDialog;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.*;
import java.io.*;
import javax.swing.*;

public class DeleteDialog extends JDialog implements ActionListener {
	private JPanel myPanel = null;
	private JButton yesButton = null;
	private JButton noButton = null;
	private boolean answer = false;
	Color c1;
	String path;

	public boolean getAnswer() {
		return answer;
	}

	public DeleteDialog(JFrame frame, boolean model, String myMessage, String path) {
		super(frame, model);
		System.out.println("\n !!!!!!! dialog.!!!!!!!!!! \n");
		this.path = path;
		Color c1 = new Color(120, 120, 120);
		Color c2 = new Color(120, 120, 120);
		Color c3 = new Color(64, 0, 64);
		myPanel = new JPanel();
		JLabel la = new JLabel(myMessage);
		yesButton = new JButton("OK");

		getContentPane().add(myPanel);

		myPanel.setBackground(c1);
		yesButton.setBackground(c1);
		yesButton.setForeground(c3);
		la.setForeground(c3);
		yesButton.addActionListener(this);
		myPanel.add(la);
		myPanel.add(yesButton);
		pack();
		setLocationRelativeTo(frame);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if (yesButton == e.getSource()) {
			File f1 = new File(path);
			f1.delete();
			System.out.println("deleted");
			answer = true;
			setVisible(false);
		}
	}
}