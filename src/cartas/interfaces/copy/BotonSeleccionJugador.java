package cartas.interfaces.copy;

import javax.swing.JRadioButton;

import cartas.tipos.Jugador;

public class BotonSeleccionJugador extends JRadioButton {

	private static final long serialVersionUID = 1L;
	private boolean cargado = false;
	private Jugador jugador;

	public BotonSeleccionJugador(String s) {
		super(s);
	}

	public boolean getCargado() {
		return cargado;
	}

	public void setCargado(Jugador j) {
		cargado = true;
		this.jugador = j;

	}

	public Jugador getJugador() {
		return jugador;
	}
}
