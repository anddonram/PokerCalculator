package cartas.tipos.figuras;

import java.util.Collections;
import java.util.List;

import cartas.tipos.Figura;

import com.google.common.collect.Lists;

public class DobleParejaImpl implements DoblePareja {
	public static Figura f=Figura.DOBLE_PAREJA;

	private Integer parejaAlta, parejaBaja, quinta;

	public DobleParejaImpl(List<Integer> l) {
		List<Integer> aux = Lists.newArrayList(l);
		Collections.sort(l);
		parejaAlta = l.get(3);
		parejaBaja = l.get(1);
		aux.remove(parejaAlta);
		aux.remove(parejaAlta);
		aux.remove(parejaBaja);
		aux.remove(parejaBaja);
		quinta = l.get(0);
	}

	public int compareTo(DoblePareja p) {
		int res = parejaAlta.compareTo(p.getParejaAlta());
		if (res == 0) {
			res = parejaBaja.compareTo(p.getParejaBaja());
			if (res == 0)
				res = quinta.compareTo(p.getQuinta());
		}
		return res;
	}

	public Integer getParejaAlta() {
		return parejaAlta;
	}

	public Integer getParejaBaja() {
		return parejaBaja;
	}

	public Integer getQuinta() {
		return quinta;
	}


}
