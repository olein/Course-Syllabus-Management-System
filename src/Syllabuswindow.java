import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

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

public class Syllabuswindow extends JFrame {

	private JPanel buttonPanel;

	private JLabel l1;
	private JLabel l2;
	private JLabel l3;

	private JButton CreateNewSyllabusButt;
	private JButton UpdateButt;
	private JButton ReplaceButt;
	private JButton VersionInformationButt;
	private JButton CurrentVersionButt;
	private JButton ExitButt;

	public Syllabuswindow() {

		l1 = new JLabel("Syllabus System", SwingConstants.CENTER);
		l2 = new JLabel(" ", SwingConstants.CENTER);
		l3 = new JLabel("  ", SwingConstants.CENTER);

		CreateNewSyllabusButt = new JButton("Create New Syllabus");
		CreateNewSyllabusButtonHandler cns = new CreateNewSyllabusButtonHandler();
		CreateNewSyllabusButt.addActionListener(cns);

		UpdateButt = new JButton("Update Syllabus");
		UpdateButtonHandler up = new UpdateButtonHandler();
		UpdateButt.addActionListener(up);

		ReplaceButt = new JButton("Replace Subject");
		ReplaceButtonHandler rep = new ReplaceButtonHandler();
		ReplaceButt.addActionListener(rep);

		VersionInformationButt = new JButton("Version Information");
		VersionInformationButtonHandler vi = new VersionInformationButtonHandler();
		VersionInformationButt.addActionListener(vi);

		CurrentVersionButt = new JButton("Current Version");
		CurrentVersionButtonHandler cr = new CurrentVersionButtonHandler();
		CurrentVersionButt.addActionListener(cr);

		ExitButt = new JButton("Exit");
		ExitButtonHandler search = new ExitButtonHandler();
		ExitButt.addActionListener(search);

		setTitle("welcome to the system");

		Container pane = getContentPane();

		pane.setLayout(new GridLayout(3, 3));

		pane.add(l2);
		pane.add(l1);
		pane.add(l3);
		pane.add(CreateNewSyllabusButt);
		pane.add(UpdateButt);
		pane.add(ReplaceButt);
		pane.add(VersionInformationButt);
		pane.add(CurrentVersionButt);
		pane.add(ExitButt);

		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	private class CreateNewSyllabusButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			setVisible(false);

			CreateNew sw = new CreateNew();

			sw.getContentPane().setBackground(Color.LIGHT_GRAY);
			sw.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			sw.setBounds(600, 200, 400, 200);
			sw.setVisible(true);
		}
	}

	private class UpdateButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			setVisible(false);

			UpdateSyllabus ac = new UpdateSyllabus();

			ac.getContentPane().setBackground(Color.LIGHT_GRAY);
			ac.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			ac.setBounds(400, 200, 400, 200);
			ac.setVisible(true);

		}
	}

	private class ReplaceButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			setVisible(false);

			ReplaceSyllabus ac = new ReplaceSyllabus();

			ac.getContentPane().setBackground(Color.LIGHT_GRAY);
			ac.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			ac.setBounds(400, 200, 400, 200);
			ac.setVisible(true);

		}
	}

	private class VersionInformationButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			setVisible(false);
			VersionInfo vi = new VersionInfo();
			
			vi.getContentPane().setBackground(Color.LIGHT_GRAY);
			vi.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			vi.setBounds(400, 200, 400, 200);
			vi.setVisible(true);
			
			

		}
	}

	private class CurrentVersionButtonHandler implements ActionListener {
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

						for (int temp = 1; temp < nList.getLength(); ++temp) {

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

	private class ExitButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.exit(0);

		}
	}

}
