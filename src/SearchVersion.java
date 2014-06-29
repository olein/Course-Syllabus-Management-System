import javax.swing.JButton;
import javax.swing.JFrame;
import org.neodatis.odb.*;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.core.query.nq.SimpleNativeQuery;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;
import org.neodatis.odb.xml.XMLExporter;

import java.awt.event.*;
import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import javax.swing.*;
import java.util.*;
import javax.xml.transform.*;
import javax.xml.transform.stream.*;
import javax.xml.transform.dom.*;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import org.xml.sax.*;
import java.io.*;
import java.io.*;
import java.security.*;
import java.security.spec.*;
import java.util.*;

public class SearchVersion extends JFrame {

	private JPanel buttonPanel;

	private JLabel l1;
	private JLabel l2;

	private JTextField t1;
	private JTextField t2;

	private JButton ConfirmButt;
	private JButton ResetButt;
	private JButton ExitButt;

	public static String ODB_NAME = " ";

	public SearchVersion() {

		l1 = new JLabel("Syllabus Name: ", SwingConstants.LEFT);
		l2 = new JLabel("Version: ", SwingConstants.LEFT);

		t1 = new JTextField(5);
		t2 = new JTextField(5);

		ODB_NAME = t1 + ".neodatis";

		// Icon point=new ImageIcon(getClass().getResource("point.JPG"));

		ConfirmButt = new JButton("Serach");
		ConfirmButtonHandler ConfirmB = new ConfirmButtonHandler();
		ConfirmButt.addActionListener(ConfirmB);

		ResetButt = new JButton("Reset");
		ResetButtonHandler Refresh = new ResetButtonHandler();
		ResetButt.addActionListener(Refresh);

		ExitButt = new JButton("Exit");
		ExitButtonHandler CloseOut = new ExitButtonHandler();
		ExitButt.addActionListener(CloseOut);

		setTitle("Version Form");

		Container pane1 = getContentPane();

		pane1.setLayout(new GridLayout(4, 2));

		pane1.add(l1);
		pane1.add(t1);
		pane1.add(l2);
		pane1.add(t2);

		pane1.add(ConfirmButt);
		pane1.add(ResetButt);
		pane1.add(ExitButt);

		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	private class ConfirmButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			String i1, i2, a, b, c, d, g, syl = " ", st = " ", s = " ";
			int p1, i = 0, f = 0;

			i1 = (t1.getText());
			i2 = (t2.getText());

			p1 = Integer.parseInt(i2);
			ODB_NAME = i1 + ".neodatis";
			ODB odb = null;
			s = " ";
			try {
				// Open the database
				odb = ODBFactory.open(ODB_NAME);
				IQuery query = new CriteriaQuery(Subject.class, (Where.le(
						"last_version", p1)));

				Objects<Subject> sports = odb.getObjects(query);

				while (sports.hasNext()) {

					Subject volley = (Subject) sports.next();

					// Changes the name
					a = volley.getName();
					b = volley.getCourseNo();
					c = volley.getSemester();
					d = volley.getCredit();
					g = volley.getReference();
					f = volley.getLastVersion();
					st = volley.getStatus();
					if (p1 == 1) {
						if (p1 == 1) {
							IQuery query1 = new CriteriaQuery(
									MainSyllabus.class, Where.and()
											.add(Where.equal("name", a))
											.add(Where.equal("version", f)));
							Objects<MainSyllabus> s1 = odb.getObjects(query1);
							while (s1.hasNext()) {
								MainSyllabus v1 = (MainSyllabus) s1.next();
								syl = v1.getSyllabus();
								
								s = s
										+ "\nSubject Name : "
										+ a
										+ "\nCourse No : "
										+ b
										+ "\nCredit : "
										+ d
										+ "\nSemester : "
										+ c
										+ "\nSyllabus : "
										+ syl.toString()
										+ "\nReference : "
										+ g;
								
								
								
								
										
								//System.out.println(s);
							}
							s = s + "\n";
						}

					} else if (p1 > 1) {

						if (f == 1) {

							if (st.equals("C")) {
								
								IQuery query3 = new CriteriaQuery(
										MainSyllabus.class, Where.and()
												.add(Where.equal("name", a))
												.add(Where.le("version", f)));

								Objects<MainSyllabus> s1 = odb
										.getObjects(query3);

								while (s1.hasNext()) {
									MainSyllabus v1 = (MainSyllabus) s1.next();
									syl = v1.getSyllabus();
									s = s
											+ "\nSubject Name : "
											+ a
											+ "\nCourse No : "
											+ b
											+ "\nCredit : "
											+ d
											+ "\nSemester : "
											+ c
											+ "\nSyllabus : "
											+ syl.toString()
											+ "\nReference : "
											+ g;
									
									
									
									
											
									//System.out.println(s);
								}
							}
						} else if ((f > 1)) {
							if ((f < p1) && (st.equals("C")) || (f >= p1)) {
								// System.out.println("1");
								IQuery query4 = new CriteriaQuery(
										VersionSyllabus.class, Where.and()
												.add(Where.equal("name", a))
												.add(Where.le("version", p1)));
								Objects<VersionSyllabus> s2 = odb
										.getObjects(query4);
								while (s2.hasNext()) {
									VersionSyllabus v2 = (VersionSyllabus) s2
											.next();
									syl = v2.getSyllabus();
									s = s
											+ "\nSubject Name : "
											+ a
											+ "\nCourse No : "
											+ b
											+ "\nCredit : "
											+ d
											+ "\nSemester : "
											+ c
											+ "\nSyllabus : "
											+ syl.toString()
											+ "\nReference : "
											+ g;
									
									
									
									
											
									
								}
							}
						}

					}
					
				}

			} finally {
				if (odb != null) {
					// Close the database
					odb.close();
				}
			}
			System.out.println(s);
			ShowVersion p = new ShowVersion(s);

						  
		}
	}

	private class ResetButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			t1.setText("");
			t2.setText("");

		}
	}

	private class ExitButtonHandler implements ActionListener {
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
