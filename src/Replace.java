import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.math.*;
import javax.swing.JFrame;
import org.neodatis.odb.*;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;
import org.neodatis.odb.xml.XMLExporter;

import java.awt.event.*;
import java.awt.*;

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

public class Replace extends JFrame {

	private JPanel buttonPanel;

	private JLabel l1;
	private JLabel l2;
	private JLabel l3;
	private JLabel l4;
	private JLabel l5;
	private JLabel l6;
	private JLabel l7;
	private JLabel l8;

	private JTextField t1;
	private JTextField t2;
	private JTextField t3;
	private JTextField t4;
	private JTextField t5;
	private JTextField t6;
	private JTextField t7;
	private JTextField t8;

	private JButton ConfirmButt;
	private JButton ResetButt;
	private JButton ExitButt;

	public static String ODB_NAME = " ";

	public Replace(String i1) {

		ODB_NAME = i1 + ".neodatis";

		l1 = new JLabel("Subject Name: ", SwingConstants.LEFT);
		l2 = new JLabel("Reference: ", SwingConstants.LEFT);
		l3 = new JLabel("Semester: ", SwingConstants.LEFT);
		l4 = new JLabel("Course No: ", SwingConstants.LEFT);
		l5 = new JLabel("Credit: ", SwingConstants.LEFT);
		l6 = new JLabel("Syllabus: ", SwingConstants.LEFT);
		l7 = new JLabel("Enter the name of the Subject you want to Replace : ",
				SwingConstants.LEFT);
		l8 = new JLabel("Version: ", SwingConstants.LEFT);

		t1 = new JTextField(5);
		t2 = new JTextField(5);
		t3 = new JTextField(5);
		t4 = new JTextField(5);
		t5 = new JTextField(5);
		t6 = new JTextField(5);
		t7 = new JTextField(5);
		t8 = new JTextField(5);

		// Icon point=new ImageIcon(getClass().getResource("point.JPG"));

		ConfirmButt = new JButton("Confirm");
		ConfirmButtonHandler ConfirmB = new ConfirmButtonHandler();
		ConfirmButt.addActionListener(ConfirmB);

		ResetButt = new JButton("Reset");
		ResetButtonHandler Refresh = new ResetButtonHandler();
		ResetButt.addActionListener(Refresh);

		ExitButt = new JButton("Exit");
		ExitButtonHandler CloseOut = new ExitButtonHandler();
		ExitButt.addActionListener(CloseOut);

		setTitle("Update Form");

		Container pane1 = getContentPane();

		pane1.setLayout(new GridLayout(10, 2));

		pane1.add(l7);
		pane1.add(t7);
		pane1.add(l1);
		pane1.add(t1);
		pane1.add(l4);
		pane1.add(t2);
		pane1.add(l5);
		pane1.add(t3);
		pane1.add(l3);
		pane1.add(t4);
		pane1.add(l6);
		pane1.add(t5);
		pane1.add(l2);
		pane1.add(t6);
		pane1.add(l8);
		pane1.add(t8);

		pane1.add(ConfirmButt);
		pane1.add(ResetButt);
		pane1.add(ExitButt);

		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	private class ConfirmButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			String i1, i2, i3, i4, i5, i6, i7, i8;
			int p1;

			i7 = (t7.getText());
			i1 = (t1.getText());
			i2 = (t2.getText());
			i3 = (t3.getText());
			i4 = (t4.getText());
			i5 = (t5.getText());
			i6 = (t6.getText());
			i8 = (t8.getText());

			if (i8.length() > 0) {

				p1 = Integer.parseInt(i8);

				try {

					File fXmlFile = new File("syllabus2013.xml");
					DocumentBuilderFactory dbFactory = DocumentBuilderFactory
							.newInstance();
					DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
					Document doc = dBuilder.parse(fXmlFile);

					NodeList nList = doc.getElementsByTagName("subject");

					String s = " ";

					for (int temp = 0; temp < nList.getLength(); temp++) {

						Node nNode = nList.item(temp);

						if (nNode.getNodeType() == Node.ELEMENT_NODE) {

							Element eElement = (Element) nNode;

							if (i7.equals(eElement.getElementsByTagName("name")
									.item(0).getTextContent())) {

								if (i1.length() > 0) {
									eElement.getElementsByTagName("name")
											.item(0).setTextContent(i1);
								} else if (i1.length() == 0) {
									i1 = eElement.getElementsByTagName("name")
											.item(0).getTextContent();
								}
								if (i2.length() > 0) {

									eElement.getElementsByTagName("courseno")
											.item(0).setTextContent(i2);
								} else if (i2.length() == 0) {

									i2 = eElement
											.getElementsByTagName("courseno")
											.item(0).getTextContent();
								}
								if (i3.length() > 0) {
									eElement.getElementsByTagName("credit")
											.item(0).setTextContent(i3);
								} else if (i3.length() == 0) {
									i3 = eElement
											.getElementsByTagName("credit")
											.item(0).getTextContent();

								}
								if (i4.length() > 0) {
									eElement.getElementsByTagName("semester")
											.item(0).setTextContent(i4);
								} else if (i4.length() == 0) {
									i4 = eElement
											.getElementsByTagName("semester")
											.item(0).getTextContent();
								}
								if (i5.length() > 0) {

									eElement.getElementsByTagName("syllabus")
											.item(0).setTextContent(i5);
								} else if (i5.length() == 0) {

									i5 = eElement
											.getElementsByTagName("syllabus")
											.item(0).getTextContent();
								}
								if (i6.length() > 0) {
									eElement.getElementsByTagName("reference")
											.item(0).setTextContent(i6);
								} else if (i6.length() == 0) {
									i6 = eElement
											.getElementsByTagName("reference")
											.item(0).getTextContent();
								}
								JOptionPane
										.showMessageDialog(null, "Confirmed");

							}

						}

						TransformerFactory transformerFactory = TransformerFactory
								.newInstance();
						Transformer transformer = transformerFactory
								.newTransformer();
						DOMSource source = new DOMSource(doc);
						StreamResult result = new StreamResult(new File(
								"syllabus2013.xml"));
						transformer.transform(source, result);

					}

				} catch (Exception e1) {
					e1.printStackTrace();
				}
				// public static String ODB_NAME=" ";

				ODB odb = null;
				try {
					// Open the database
					odb = ODBFactory.open(ODB_NAME);
					IQuery query = new CriteriaQuery(Subject.class,
							Where.equal("name", i7));
					Objects<Subject> sports = odb.getObjects(query);
					// Gets the first sport (there is only one!)
					Subject volley = (Subject) sports.getFirst();
					// Changes the name
					volley.setStatus("D");
					volley.setLastVersion(p1-1);
					// Actually updates the object
					odb.store(volley);
					// Commits the changes
					odb.close();
					odb = ODBFactory.open(ODB_NAME);
					// Now query the database to check the change
					sports = odb.getObjects(Subject.class);
					System.out.println("\nStep 12 : Updating subject");
					// display each object
					int i = 0;
					while (sports.hasNext()) {
						System.out.println((i + 1) + "\t: " + sports.next());
					}
				} finally {
					if (odb != null) {
						// Close the database
						odb.close();
					}
				}

				// ODB odb = null;
				try {
					// Create instance
					VersionSyllabus vs = new VersionSyllabus(i1, i2, i3, i4,
							i5, i6, p1);
					Subject sub = new Subject(i1, i2, i3, i4, "C", i6, p1);
					// Open the database
					odb = ODBFactory.open(ODB_NAME);

					odb.store(vs);
					odb.store(sub);
				} finally {
					if (odb != null) {

						odb.close();
					}
				}

				try {
					// Open the database
					odb = ODBFactory.open(ODB_NAME);
					// Creates the exporter
					XMLExporter exporter = new XMLExporter(odb);

					// Actually export to current directory into the sports.xml
					// file
					exporter.export(".", "system.xml");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				finally {
					if (odb != null) {
						// Close the database
						odb.close();
					}
				}

			}

			else if (i8.length() == 0) {
				JOptionPane.showMessageDialog(null,
						"Version field must not be Null", "Input Error",
						JOptionPane.WARNING_MESSAGE);
			}

		}
	}

	private class ResetButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			t1.setText("");
			t2.setText("");
			t3.setText("");
			t4.setText("");
			t5.setText("");
			t6.setText("");
			t7.setText("");
			t8.setText("");

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
