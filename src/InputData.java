import javax.swing.JFrame;
import org.neodatis.odb.*;
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

public class InputData extends JFrame {

	private JPanel buttonPanel;

	private JLabel l1;
	private JLabel l2;
	private JLabel l3;
	private JLabel l4;
	private JLabel l5;
	private JLabel l6;

	private JTextField t1;
	private JTextField t2;
	private JTextField t3;
	private JTextField t4;
	private JTextField t5;
	private JTextField t6;

	private JButton StoreButt;
	private JButton ReadButt;
	private JButton ResetButt;
	private JButton ExitButt;

	public static String ODB_NAME = " ";

	public InputData(String i1) {

		ODB_NAME = i1 + ".neodatis";

		l1 = new JLabel("Subject Name: ", SwingConstants.LEFT);
		l2 = new JLabel("Course No: ", SwingConstants.LEFT);
		l3 = new JLabel("Credit: ", SwingConstants.LEFT);
		l4 = new JLabel("Semester: ", SwingConstants.LEFT);
		l5 = new JLabel("Syllabus: ", SwingConstants.LEFT);
		l6 = new JLabel("Reference: ", SwingConstants.LEFT);

		t1 = new JTextField(5);
		t2 = new JTextField(5);
		t3 = new JTextField(5);
		t4 = new JTextField(5);
		t5 = new JTextField(5);
		t6 = new JTextField(5);

		StoreButt = new JButton("Save");
		StoreButtonHandler StoreB = new StoreButtonHandler();
		StoreButt.addActionListener(StoreB);

		ReadButt = new JButton("Read File");
		ReadButtonHandler ReadB = new ReadButtonHandler();
		ReadButt.addActionListener(ReadB);

		ResetButt = new JButton("Reset");
		ResetButtonHandler Refresh = new ResetButtonHandler();
		ResetButt.addActionListener(Refresh);

		ExitButt = new JButton("Exit");
		ExitButtonHandler CloseOut = new ExitButtonHandler();
		ExitButt.addActionListener(CloseOut);

		setTitle("Save data on database");

		Container pane = getContentPane();

		pane.setLayout(new GridLayout(8, 2));

		pane.add(l1);
		pane.add(t1);
		pane.add(l2);
		pane.add(t2);
		pane.add(l3);
		pane.add(t3);
		pane.add(l4);
		pane.add(t4);
		pane.add(l5);
		pane.add(t5);
		pane.add(l6);
		pane.add(t6);
		pane.add(StoreButt);
		pane.add(ReadButt);
		pane.add(ResetButt);
		pane.add(ExitButt);

		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	private class StoreButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			String i1, i2, i3, i4, i5, i6;

			i1 = (t1.getText());
			i2 = (t2.getText());
			i3 = (t3.getText());
			i4 = (t4.getText());
			i5 = (t5.getText());
			i6 = (t6.getText());

			ODB odb = null;
			try {
				// Create instance
				MainSyllabus ms = new MainSyllabus(i1, i2, i3, i4, i5, i6,1);
				Subject sub = new Subject(i1, i2, i3, i4, "C", i6, 1);
				// Open the database
				odb = ODBFactory.open(ODB_NAME);

				odb.store(ms);
				odb.store(sub);
			} finally {
				if (odb != null) {

					odb.close();
				}
			}

			if ((i1.length() != 0) && (i2.length() != 0) && (i3.length() != 0)
					&& (i4.length() != 0) && (i5.length() != 0)
					&& (i6.length() != 0)) {

				DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory
						.newInstance();

				DocumentBuilder documentBuilder = null;
				try {
					documentBuilder = documentBuilderFactory
							.newDocumentBuilder();

				} catch (ParserConfigurationException e1) {
					e1.printStackTrace();
					System.exit(1);
				}

				Document document = null;
				try {

					document = documentBuilder.parse("syllabus2013.xml");
				} catch (IOException e2) {
					e2.printStackTrace();
					System.exit(1);
				} catch (SAXException e3) {
					e3.printStackTrace();
				}
				Element root = document.getDocumentElement();
				Element rootElement = document.getDocumentElement();
				Element subject = document.createElement("subject");
				rootElement.appendChild(subject);

				Element name = document.createElement("name");
				name.appendChild(document.createTextNode(i1));
				subject.appendChild(name);

				Element courseno = document.createElement("courseno");
				courseno.appendChild(document.createTextNode(i2));
				subject.appendChild(courseno);

				Element credit = document.createElement("credit");
				credit.appendChild(document.createTextNode(i3));
				subject.appendChild(credit);

				Element sem = document.createElement("semester");
				sem.appendChild(document.createTextNode(i4));
				subject.appendChild(sem);

				Element syllabus = document.createElement("syllabus");
				syllabus.appendChild(document.createTextNode(i5));
				subject.appendChild(syllabus);

				Element reference = document.createElement("reference");
				reference.appendChild(document.createTextNode(i6));
				subject.appendChild(reference);

				root.appendChild(subject);

				try {

					DOMSource source = new DOMSource(document);
					TransformerFactory transformerFactory = TransformerFactory
							.newInstance();
					Transformer transformer = transformerFactory
							.newTransformer();
					StreamResult result = new StreamResult("syllabus2013.xml");
					transformer.transform(source, result);
				}

				catch (Exception ex) {
				}

				JOptionPane.showMessageDialog(null, "Successfully stored");
			} else {
				JOptionPane.showMessageDialog(null,
						"Sorry!! please fill up all the fields", "XML Error",
						JOptionPane.WARNING_MESSAGE);
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
	}

	private class ReadButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String s = " ";
			try {

				File fXmlFile = new File("syllabus2013.xml");
				DocumentBuilderFactory dbFactory = DocumentBuilderFactory
						.newInstance();
				DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
				Document doc = dBuilder.parse(fXmlFile);

				doc.getDocumentElement().normalize();

				NodeList nList = doc.getElementsByTagName("subject");

				for (int temp = 1; temp < nList.getLength(); temp++) {

					Node nNode = nList.item(temp);

					if (nNode.getNodeType() == Node.ELEMENT_NODE) {

						Element eElement = (Element) nNode;

						s = s
								+ "\nSubject Name : "
								+ eElement.getElementsByTagName("name").item(0)
										.getTextContent()
								+ "\nCourse No : "
								+ eElement.getElementsByTagName("courseno")
										.item(0).getTextContent()
								+ "\nCredit : "
								+ eElement.getElementsByTagName("credit")
										.item(0).getTextContent()
								+ "\nSemester : "
								+ eElement.getElementsByTagName("semester")
										.item(0).getTextContent()
								+ "\nSyllabus : "
								+ eElement.getElementsByTagName("syllabus")
										.item(0).getTextContent()
								+ "\nReference : "
								+ eElement.getElementsByTagName("reference")
										.item(0).getTextContent();
					}
					s = s + "\n";
				}

				JOptionPane.showMessageDialog(null, s);
			} catch (Exception e1) {
				e1.printStackTrace();
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
