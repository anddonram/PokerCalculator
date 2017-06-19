package cartas.interfaces.copy;

import java.awt.GridLayout;
import java.util.List;

import javax.swing.JPanel;

import cartas.tipos.Baraja;
import cartas.tipos.BarajaImpl;

import com.google.common.collect.Lists;

public class PanelBaraja extends JPanel {

	private static final long serialVersionUID = 2L;
	private BotonCarta[] cartas = new BotonCarta[52];
	private Baraja baraja = new BarajaImpl();

	public PanelBaraja() {
		super(new GridLayout(4, 13));
		for (int i = 0; i <= 51; i++) {
			BotonCarta b = new BotonCarta(i);
			add(b);
			cartas[i] = b;
		}
	}

	public Integer getNSelected() {
		Integer res = 0;
		for (BotonCarta b : cartas) {
			if (b.isSelected() && b.isEnabled())
				res++;
		}
		return res;
	}

	public List<BotonCarta> getSelected() {
		List<BotonCarta> res = Lists.newArrayList();
		for (BotonCarta b : cartas) {
			if (b.isSelected() && b.isEnabled())
				res.add(b);
		}
		return res;
	}

	public BotonCarta[] cartas() {
		return cartas;
	}

	public Baraja getBaraja() {
		return baraja;
	}
}
