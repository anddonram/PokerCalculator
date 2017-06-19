package cartas.interfaces.copy;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import cartas.tipos.JugadorImpl;
import cartas.utiles.EstadisticasExperimento2;

import com.google.common.collect.Sets;

public class InterfazBaraja extends JFrame {
	private static final long serialVersionUID = 1L;
	private JButton listo, reiniciar, descarte, salir, deshacer, estadistica;
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
		estadistica = new JButton("Estadística");
		listo.addActionListener(new AccionListo());
		deshacer.addActionListener(new AccionDeshacer());
		reiniciar.addActionListener(new AccionReinicio());
		descarte.addActionListener(new AccionDescarte());
		salir.addActionListener(new AccionSalida());
		estadistica.addActionListener(new AccionEstadistica());
		JPanel panBotones = new JPanel(new FlowLayout());
		panBotones.add(listo);
		panBotones.add(descarte);
		panBotones.add(estadistica);
		panBotones.add(deshacer);
		panBotones.add(reiniciar);
		panBotones.add(salir);

		panBaraja = new PanelBaraja();
		panJugadores = new PanelJugadores(nJug);

		add(panBaraja, BorderLayout.CENTER);
		add(panJugadores, BorderLayout.EAST);
		add(panBotones, BorderLayout.SOUTH);
		setSize(1300,650);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private class AccionListo implements ActionListener {

		public void actionPerformed(ActionEvent ae) {
			if (panBaraja.getNSelected() == 5
					&& panJugadores.getSeleccionado() != null
					&& !panJugadores.getSeleccionado().getCargado()) {
				int i = 0;
				Set<Integer> manoInicial = Sets.newHashSet();
				for (BotonCarta b : panBaraja.getSelected()) {
					b.setEnabled(false);
					b.setSelected(false);
					panJugadores.getSeleccion().get(i).setSelected(false);
					panJugadores.getSeleccion().get(i++).setCarta(b.getCarta());
					manoInicial.add(b.getCarta());
				}
				panJugadores.getSeleccionado().setCargado(
						new JugadorImpl(panBaraja.getBaraja(), manoInicial));
			}
		}

	}

	private class AccionDescarte implements ActionListener {

		public void actionPerformed(ActionEvent ae) {
			if (panJugadores.getSeleccionado() != null
					&& panJugadores.getSeleccionado().getCargado()) {
				List<BotonCarta> lbc = panBaraja.getSelected();
				List<BotonCarta> ltb = panJugadores.getBotonesActivos();
				if (lbc.size() == ltb.size()) {
					for (int i = 0; i < ltb.size(); i++) {
						panJugadores
								.getSeleccionado()
								.getJugador()
								.setCarta(ltb.get(i).getCarta(),
										lbc.get(i).getCarta(),
										panBaraja.getBaraja());
						lbc.get(i).setEnabled(false);
						lbc.get(i).setSelected(false);
						ltb.get(i).setCarta(lbc.get(i).getCarta());
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

	private class AccionEstadistica implements ActionListener {

		public void actionPerformed(ActionEvent ae) {
			if (panJugadores.getSeleccionado() != null
					&& panJugadores.getSeleccionado().getCargado()) {
				System.out.println(panJugadores.getSeleccionado().getText()
						+ ": Calculando...");
				System.out.println(EstadisticasExperimento2.masProbable2(
						panBaraja.getBaraja(), panJugadores.getSeleccionado()
								.getJugador()));
			}
		}

	}
}
