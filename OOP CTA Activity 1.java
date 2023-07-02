/*Write a GUI based Java program to compute the grade obtained by a student in a  single course. 
 Incorporate the following in your program: 
• Use of object-oriented style of programming. 
• Use of inheritance and interfaces. 
• Exception handling mechanism. 
• Use of dynamic method dispatch feature.
*/
package sdmcet.cse.oop;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

class GradeCalculator extends JFrame implements ActionListener {

	int cie, res, x;
	JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9;
	JButton b2, b1;
	JTextField t1, t2, t3, t4, t5;
	Container contentPane;
	JPanel p1, p2, p3, p4, p5, p6, p7, p8, p9;

	GradeCalculator() {

		setTitle("Students Grading System");

		l1 = new JLabel("Grade Calculator");
		l2 = new JLabel("Enter IA-1 Marks: ");
		l3 = new JLabel("Enter IA-2 Marks: ");
		l4 = new JLabel("Enter IA-3 Marks: ");
		l5 = new JLabel("Enter CTA Marks: ");
		l6 = new JLabel("Enter SEE Marks: ");
		l7 = new JLabel();
		l7.setText("");
		l8 = new JLabel();
		l8.setText("");
		l9 = new JLabel("   ");

		b2 = new JButton("Check Eligibilty");
		b1 = new JButton("Calculate");
		b1.addActionListener(this);
		b2.addActionListener(this);

		t1 = new JTextField(10);
		t2 = new JTextField(10);
		t3 = new JTextField(10);
		t4 = new JTextField(10);
		t5 = new JTextField(10);

		p1 = new JPanel();
		p2 = new JPanel();
		p3 = new JPanel();
		p4 = new JPanel();
		p5 = new JPanel();
		p6 = new JPanel();
		p7 = new JPanel();
		p8 = new JPanel();
		p9 = new JPanel();

		p1.add(l1);
		p2.add(l2);
		p2.add(t1);
		p3.add(l3);
		p3.add(t2);
		p4.add(l4);
		p4.add(t3);
		p5.add(l5);
		p5.add(t4);
		p9.add(b1);
		p6.add(l6);
		p6.add(t5);
		p7.add(b2);
		p8.add(l7);
		p8.add(l9);
		p8.add(l8);

		add(p1);
		add(p2);
		add(p3);
		add(p4);
		add(p5);
		add(p7);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		int ia1, ia2, ia3, cta;
		double see = 0;
		String grade;

		if (e.getSource() == b2) {

			if (t1.getText().isEmpty())
				ia1 = 0;
			else
				ia1 = Integer.parseInt(t1.getText());

			if ((t2.getText()).isEmpty())
				ia2 = 0;
			else
				ia2 = Integer.parseInt(t2.getText());

			if (t3.getText().isEmpty())
				ia3 = 0;
			else
				ia3 = Integer.parseInt(t3.getText());

			if (t4.getText().isEmpty())
				cta = 0;
			else
				cta = Integer.parseInt(t4.getText());

			if (ia1 > 20 || ia1 < 0) {
				JOptionPane.showMessageDialog(this, "ERROR: Invalid IA-1 marks", "ERROR", JOptionPane.ERROR_MESSAGE);
				t1.setText("");
				return;
			}

			if (ia2 > 20 || ia2 < 0) {
				JOptionPane.showMessageDialog(this, "ERROR: Invalid IA-2 marks", "ERROR", JOptionPane.ERROR_MESSAGE);
				t2.setText("");
				return;
			}

			if (ia3 > 20 || ia3 < 0) {
				JOptionPane.showMessageDialog(this, "ERROR: Invalid IA-3 marks", "ERROR", JOptionPane.ERROR_MESSAGE);
				t3.setText("");
				return;
			}
			if (cta > 10 || cta < 0) {
				JOptionPane.showMessageDialog(this, "ERROR: Invalid CTA marks", "ERROR", JOptionPane.ERROR_MESSAGE);
				t4.setText("");
				return;
			}
			if (ia2 >= ia1 && ia3 >= ia1) {
				cie = ia2 + ia3 + cta;
			} else if (ia1 >= ia2 && ia3 >= ia2) {
				cie = ia1 + ia3 + cta;
			} else {
				cie = ia1 + ia2 + cta;
			}

			try {
				if (cie < 20) {
					throw new Exception();
				}
			} catch (Exception ae) {
				JOptionPane.showMessageDialog(this, "Student is Detained from taking SEE", "WARNING",
						JOptionPane.PLAIN_MESSAGE);
				return;
			}
		}

		setBounds(0, 0, 599, 499);

		add(p6);
		add(p9);
		add(p8);

		if (e.getSource() == b1) {

			if (t5.getText().isEmpty())
				see = 0;
			else
				see = Integer.parseInt(t5.getText());

			if (see > 100 || see < 0) {
				JOptionPane.showMessageDialog(this, "ERROR: Invalid SEE marks", "ERROR", JOptionPane.ERROR_MESSAGE);
				t5.setText("");
				l8.setText("");
				l7.setText("");
				return;
			}

			if (see < 38) {
				l8.setText("Grade: F");
				l7.setText("");

				setBounds(0, 0, 597, 497);
				return;
			}
			
			if (see == 38 || see == 39) {
				see = 40;
			}

			see = (see / 2);
			x = (int) Math.ceil(see);
			res = cie + x;

			if (res <= 100 && res >= 90)
				grade = "S";
			else if (res < 90 && res >= 80)
				grade = "A";
			else if (res < 80 && res >= 70)
				grade = "B";
			else if (res < 70 && res <= 60)
				grade = "C";
			else if (res < 60 && res <= 50)
				grade = "D";
			else if (res < 50 && res <= 40)
				grade = "E";
			else
				grade = "F";

			l7.setText("Total Marks: " + res);
			l8.setText("Grade: " + grade);
			setBounds(0, 0, 598, 498);
		}
	}
}

public class CTADemo {

	public static void main(String[] args) {

		JFrame f = new JFrame();
		GradeCalculator c = new GradeCalculator();

		c.setVisible(true);
		c.setBounds(0, 0, 500, 400);
		c.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		c.setLayout(new GridLayout(10, 0));

	}
}