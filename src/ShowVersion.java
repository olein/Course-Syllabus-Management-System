import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class ShowVersion extends JFrame {
				  public ShowVersion(String s) {
				    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				    JPanel panel = new JPanel(new GridLayout(1, 1));
				    
				      panel.add(new JLabel(s));
				      
				      JOptionPane.showMessageDialog (null, s, "Syllabus", JOptionPane.INFORMATION_MESSAGE);

				    

				    JScrollPane scrolled = new JScrollPane(panel);
				    //scrolled.setColumnHeaderView(new JLabel(s));

				    //getContentPane().add(scrolled, BorderLayout.CENTER);

				    //pack();
				    setSize(300, 500);
				    setVisible(false);
				  }
}
