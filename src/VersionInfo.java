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

public class VersionInfo extends JFrame {
	private JPanel buttonPanel;

	private JLabel l1;

	private JButton SearchVersionButt;
	private JButton SearchSubjectButt;

	public VersionInfo() {
		l1 = new JLabel("version Information", SwingConstants.CENTER);

		SearchVersionButt = new JButton("Search for specific version");
		SearchVersionButtonHandler OkB = new SearchVersionButtonHandler();
		SearchVersionButt.addActionListener(OkB);
		
		SearchSubjectButt = new JButton("Search for specific subject");
		SearchSubjectButtonHandler ss = new SearchSubjectButtonHandler();
		SearchSubjectButt.addActionListener(ss);

		setTitle("Version");

		Container pane = getContentPane();

		pane.setLayout(new GridLayout(3, 1));

		pane.add(l1);
		pane.add(SearchSubjectButt);
		pane.add(SearchVersionButt);

		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	private class SearchVersionButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String i1;

			setVisible(false);

			SearchVersion sw = new SearchVersion();

			sw.getContentPane().setBackground(Color.LIGHT_GRAY);
			sw.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			sw.setBounds(600, 200, 400, 200);
			sw.setVisible(true);

		}

	}
	
	private class SearchSubjectButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String i1;

			setVisible(false);

			/*SearchSubject sw = new SearchSubject();

			sw.getContentPane().setBackground(Color.LIGHT_GRAY);
			sw.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			sw.setBounds(600, 200, 400, 400);
			sw.setVisible(true);*/

		}

	}

}
