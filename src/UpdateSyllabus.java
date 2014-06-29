import javax.swing.JFrame;
import javax.swing.RootPaneContainer;

import java.awt.event.*;
import java.awt.*;

import javax.swing.*;
import java.util.*;
import javax.xml.*;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import org.xml.sax.*;
import java.io.*;
import java.io.*;
import java.security.*;
import java.security.spec.*;
import java.util.*;

public class UpdateSyllabus extends JFrame {
	private JPanel buttonPanel;

	private JLabel l1;

	private JButton SylNameButt;

	private JTextField t1;

	public UpdateSyllabus() {
		l1 = new JLabel("Syllabus Name", SwingConstants.CENTER);

		SylNameButt = new JButton("OK");
		SylNameButtonHandler OkB = new SylNameButtonHandler();
		SylNameButt.addActionListener(OkB);

		t1 = new JTextField(5);

		setTitle("Select Syllabus");

		Container pane = getContentPane();

		pane.setLayout(new GridLayout(3, 1));

		pane.add(l1);
		pane.add(t1);
		pane.add(SylNameButt);

		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	private class SylNameButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String i1;

			i1 = (t1.getText());

			setVisible(false);

			Update sw = new Update(i1);

			sw.getContentPane().setBackground(Color.LIGHT_GRAY);
			sw.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			sw.setBounds(600, 200, 400, 400);
			sw.setVisible(true);

		}

	}

}
