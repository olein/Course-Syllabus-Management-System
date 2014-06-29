import javax.swing.JFrame;
import javax.swing.RootPaneContainer;
import org.neodatis.odb.*;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

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

class ReplaceSyllabus extends JFrame {
	private JPanel buttonPanel;

	private JLabel l1;
	private JLabel l2;

	private JButton SylNameButt;

	private JTextField t1;
	private JTextField t2;

	public ReplaceSyllabus() {
		l1 = new JLabel("Syllabus Name", SwingConstants.CENTER);
		// l2 = new JLabel("Subject you want to replace",
		// SwingConstants.CENTER);

		SylNameButt = new JButton("OK");
		SylNameButtonHandler OkB = new SylNameButtonHandler();
		SylNameButt.addActionListener(OkB);

		t1 = new JTextField(5);
		// t2 = new JTextField(5);

		setTitle("Select Syllabus");

		Container pane = getContentPane();

		pane.setLayout(new GridLayout(3, 2));

		pane.add(l1);
		pane.add(t1);
		// pane.add(l2);
		// pane.add(t2);
		pane.add(SylNameButt);

		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	private class SylNameButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String i1, i2;

			i1 = (t1.getText());

			setVisible(false);

			Replace sw = new Replace(i1);

			sw.getContentPane().setBackground(Color.LIGHT_GRAY);
			sw.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			sw.setBounds(600, 200, 400, 400);
			sw.setVisible(true);

		}

	}

}
