package cartas.interfaces;

import javax.swing.JRadioButton;

public class BotonSeleccionJugador extends JRadioButton {

	private static final long serialVersionUID = 1L;
	private boolean cargado = false;

	public BotonSeleccionJugador(String s) {
		super(s);
	}
	public boolean getCargado(){
		return cargado;
	}
	public void setCargado(){
		cargado=true;
	}
}
