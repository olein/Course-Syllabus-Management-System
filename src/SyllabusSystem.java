import javax.swing.JFrame;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.util.*;
import javax.xml.*;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import org.xml.sax.*;
import java.io.*;
import java.io.FileNotFoundException;
import java.io.*;
import java.security.*;
import java.security.spec.*;
import java.util.*;

class welcome extends JFrame {
	private JPanel buttonPanel;

	private JLabel l1;
	private JLabel l2;

	private JButton AccSetButt;
	private JButton SylSysButt;

	public welcome() {
		l1 = new JLabel("Hello, Admin", SwingConstants.CENTER);
		l2 = new JLabel("Fahim and Rafi", SwingConstants.LEFT);

		AccSetButt = new JButton("Account Settings");
		AccSetButtonHandler OkB = new AccSetButtonHandler();
		AccSetButt.addActionListener(OkB);

		SylSysButt = new JButton("Syllabus System");
		SylSysButtonHandler ss = new SylSysButtonHandler();
		SylSysButt.addActionListener(ss);

		setTitle("welcome to the system");

		Container pane = getContentPane();

		pane.setLayout(new GridLayout(3, 1));

		pane.add(l1);
		// pane.add(l2);
		pane.add(AccSetButt);
		pane.add(SylSysButt);

		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	private class AccSetButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {

		}

	}

	private class SylSysButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			setVisible(false);

			Syllabuswindow sw = new Syllabuswindow();

			sw.getContentPane().setBackground(Color.LIGHT_GRAY);
			sw.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			sw.setBounds(600, 200, 500, 300);
			sw.setVisible(true);
		}

	}

}

public class SyllabusSystem extends JFrame {

	public static void main(String[] args) {
		welcome ac = new welcome();

		ac.getContentPane().setBackground(Color.LIGHT_GRAY);
		ac.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		ac.setBounds(600, 200, 400, 300);
		ac.setVisible(true);

	}

}
