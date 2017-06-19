package cartas.tipos.figuras;

import java.util.Collections;
import java.util.List;

import cartas.tipos.Figura;

import com.google.common.collect.Lists;

public class FullImpl implements Full {
	public static Figura f=Figura.FULL;

	private Integer trio, pareja;

	public FullImpl(List<Integer> l) {
		List<Integer> aux = Lists.newArrayList(l);
		Collections.sort(l);
		trio = l.get(2);
		aux.remove(trio);
		aux.remove(trio);
		aux.remove(trio);
		pareja = l.get(0);
	}

	public int compareTo(Full o) {
		int res = trio.compareTo(o.getTrio());
		if (res == 0)
			res = pareja.compareTo(o.getPareja());
		return res;
	}

	public Integer getTrio() {
		return trio;
	}

	public Integer getPareja() {
		return pareja;
	}


}
