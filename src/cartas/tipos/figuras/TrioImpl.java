package cartas.tipos.figuras;

import java.util.Collections;
import java.util.List;

import cartas.tipos.Figura;

import com.google.common.collect.Lists;

public class TrioImpl implements Trio {
	public static Figura f=Figura.TRIO;

	private Integer trio, alta, baja;

	public TrioImpl(List<Integer> l) {
		List<Integer> aux = Lists.newArrayList(l);
		Collections.sort(l);
		trio = l.get(2);
		aux.remove(trio);
		aux.remove(trio);
		aux.remove(trio);
		baja = l.get(0);
		alta = l.get(1);
	}

	public int compareTo(Trio t) {
		int res = trio.compareTo(t.getTrio());
		if (res == 0) {
			res = alta.compareTo(t.getAlta());
			if (res == 0)
				res = baja.compareTo(t.getBaja());
		}
		return res;
	}

	public Integer getTrio() {
		return trio;
	}

	public Integer getAlta() {
		return alta;
	}

	public Integer getBaja() {
		return baja;
	}

}
