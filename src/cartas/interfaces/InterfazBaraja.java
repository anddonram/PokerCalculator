package cartas.interfaces;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

public class InterfazBaraja extends JFrame {
	private static final long serialVersionUID = 1L;
	private JButton listo, reiniciar, descarte, salir, deshacer;
	private PanelBaraja panBaraja;
	private PanelJugadores panJugadores;
	private Integer nJug;

	public InterfazBaraja(Integer nJug) {
		super("Ventana principal");
		setLayout(new BorderLayout());
		this.nJug = nJug;

		listo = new JButton("Colocar cartas");
		deshacer = new JButton("Deshacer cambios");
		reiniciar = new JButton("Reiniciar");
		descarte = new JButton("Descartar");
		salir = new JButton("Salir");
		listo.addActionListener(new AccionListo());
		deshacer.addActionListener(new AccionDeshacer());
		reiniciar.addActionListener(new AccionReinicio());
		descarte.addActionListener(new AccionDescarte());
		salir.addActionListener(new AccionSalida());
		JPanel panBotones = new JPanel(new FlowLayout());
		panBotones.add(listo);
		panBotones.add(deshacer);
		panBotones.add(reiniciar);
		panBotones.add(descarte);
		panBotones.add(salir);

		panBaraja = new PanelBaraja();
		panJugadores = new PanelJugadores(nJug);

		add(panBaraja, BorderLayout.CENTER);
		add(panJugadores, BorderLayout.EAST);
		add(panBotones, BorderLayout.SOUTH);
		setSize(1200, 600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private class AccionListo implements ActionListener {

		public void actionPerformed(ActionEvent ae) {
			if (panBaraja.getNSelected() == 5
					&& panJugadores.getSeleccionado() != null
					&& !panJugadores.getSeleccionado().getCargado()) {
				int i = 0;
				for (BotonCarta b : panBaraja.getSelected()) {
					b.setEnabled(false);
					b.setSelected(false);
					panJugadores.getSeleccion().get(i).setSelected(false);
					panJugadores.getSeleccion().get(i++).setIcon(b.getIcon());
				}
				panJugadores.getSeleccionado().setCargado();
			}
		}

	}

	private class AccionDescarte implements ActionListener {

		public void actionPerformed(ActionEvent ae) {
			if (panJugadores.getSeleccionado() != null
					&& panJugadores.getSeleccionado().getCargado()) {
				List<BotonCarta> lbc = panBaraja.getSelected();
				List<JToggleButton> ltb = panJugadores.getBotonesActivos();
				if (lbc.size() == ltb.size()) {
					for (int i = 0; i < ltb.size(); i++) {
						lbc.get(i).setEnabled(false);
						lbc.get(i).setSelected(false);
						ltb.get(i).setIcon(lbc.get(i).getIcon());
						ltb.get(i).setSelected(false);
					}

				}
			}
		}
	}

	private class AccionDeshacer implements ActionListener {

		public void actionPerformed(ActionEvent ae) {
			dispose();
			new InterfazBaraja(nJug);
		}

	}

	private class AccionReinicio implements ActionListener {

		public void actionPerformed(ActionEvent ae) {
			dispose();
			new InterfazInicio();
		}

	}

	private class AccionSalida implements ActionListener {

		public void actionPerformed(ActionEvent ae) {
			System.exit(0);
		}

	}

}
