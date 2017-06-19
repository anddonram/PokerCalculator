package cartas.interfaces.copy;

import javax.swing.ImageIcon;
import javax.swing.JToggleButton;

public class BotonCarta extends JToggleButton {
	private static final long serialVersionUID = 1L;
	private Integer carta;

	public BotonCarta(Integer i) {
		super(new ImageIcon("D:\\ATP\\PP\\" + i + ".jpg"));
		carta = i;
	}

	public BotonCarta() {
		super();
	}

	public Integer getCarta() {
		return carta;
	}

	public void setCarta(Integer i) {
		this.carta = i;
		setIcon(new ImageIcon("D:\\ATP\\PP\\" + i + ".jpg"));
	}

}
