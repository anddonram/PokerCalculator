package cartas.tipos.figuras;

import java.util.List;

import cartas.tipos.Figura;

public class EscaleraColorImpl extends EscaleraImpl implements Escalera {
	public static Figura f=Figura.ESCALERA_DE_COLOR;

	public EscaleraColorImpl(List<Integer> k) {
		super(k);
		
	}

	public int compareTo(Escalera c) {
		int res = 1;
		if (c instanceof EscaleraColorImpl)
			res = super.compareTo(c);
		return res;
	}

}
