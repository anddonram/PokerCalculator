package cartas.tipos.predicados;

import java.util.Comparator;

import com.google.common.base.Predicate;

import cartas.tipos.comparadores.ComparadorManos2;

public class PredMenoresQueMano implements Predicate<Integer[]> {
	private Integer[] mano;
	private Comparator<Integer[]> cmp = new ComparadorManos2();

	public PredMenoresQueMano(Integer[] mano) {
		this.mano = mano;
	}

	public boolean apply(Integer[] a) {
		return cmp.compare(mano, a) > 0;
	}

}
