package cartas.tipos.figuras;

import java.util.Collections;
import java.util.List;

import cartas.tipos.Figura;

import com.google.common.collect.Lists;

public class CartaAltaImpl implements CartaAlta {
	public static Figura f=Figura.CARTA_MAS_ALTA;
	private List<Integer> l;
	public CartaAltaImpl(List<Integer> k) {
		l = Lists.newArrayList(k);
		Collections.sort(l);
	}

	public int compareTo(CartaAlta ca) {
		int res = getMasAlta().compareTo(ca.getMasAlta());
		if (res == 0) {
			res = getSegundaAlta().compareTo(ca.getSegundaAlta());
			if (res == 0) {
				res = getTerceraAlta().compareTo(ca.getTerceraAlta());
				if (res == 0) {
					res = getCuartaAlta().compareTo(ca.getCuartaAlta());
					if (res == 0)
						res = getMasPequena().compareTo(ca.getMasPequena());
				}
			}
		}
		return res;
	}

	public Integer getMasAlta() {
		return l.get(4);
	}

	public Integer getSegundaAlta() {
		return l.get(3);
	}

	public Integer getTerceraAlta() {
		return l.get(2);
	}

	public Integer getCuartaAlta() {
		return l.get(1);
	}

	public Integer getMasPequena() {
		return l.get(0);
	}

}
