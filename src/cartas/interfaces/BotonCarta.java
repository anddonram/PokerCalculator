package cartas.interfaces;

import javax.swing.ImageIcon;
import javax.swing.JToggleButton;

public class BotonCarta extends JToggleButton {
	private static final long serialVersionUID = 1L;
	private Integer carta;

	public BotonCarta(Integer i) {
		super(new ImageIcon("D:\\ATP\\PP\\" + i + ".jpg"));
		carta = i;
	}

	public Integer getCarta() {
		return carta;
	}

}
