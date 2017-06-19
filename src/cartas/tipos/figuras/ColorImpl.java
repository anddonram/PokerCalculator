package cartas.tipos.figuras;

import java.util.List;

import cartas.tipos.Figura;

public class ColorImpl extends CartaAltaImpl implements CartaAlta {
	public static Figura f=Figura.COLOR;

	public ColorImpl(List<Integer> k) {
		super(k);

	}

	public int compareTo(CartaAlta c) {
		int res = 1;
		if (c instanceof ColorImpl)
			res = super.compareTo(c);
		return res;
	}

}
