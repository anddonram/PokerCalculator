package cartas.interfaces;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class InterfazInicio extends JFrame {
	private static final long serialVersionUID = 1L;
	private static Integer nJug;
	private JTextField t;

	public InterfazInicio() {
		super("Pollo simulator");
		setLayout(new FlowLayout());
		JLabel l = new JLabel("Introduzca el número de jugadores");
		t = new JTextField(10);
		JButton b = new JButton("OK");
		add(l);
		add(t);
		add(b);
		setLocation(300, 300);
		setSize(300,150);
		setVisible(true);
		b.addActionListener(new AccionOK());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public Integer getNJug() {
		return nJug;
	}

	private class AccionOK implements ActionListener {

		public void actionPerformed(ActionEvent ae) {
			try {
				nJug = new Integer(t.getText());
				dispose();
				new InterfazBaraja(nJug);
			} catch (NumberFormatException e) {
			}
		}
	}
}
