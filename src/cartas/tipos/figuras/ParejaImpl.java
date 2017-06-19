package cartas.tipos.figuras;

import java.util.Collections;
import java.util.List;

import cartas.tipos.Figura;

import com.google.common.collect.Lists;

public class ParejaImpl implements Pareja {
	public static Figura f=Figura.PAREJA;

	private Integer pareja, masAlta, segundaAlta, masPequena;

	public ParejaImpl(List<Integer> l) {
		List<Integer> aux = Lists.newArrayList(l);
		Collections.sort(l);
		if (Collections.frequency(aux, l.get(1)) == 2) {
			pareja = l.get(1);
			aux.remove(pareja);
			aux.remove(pareja);
		} else {
			pareja = l.get(3);
			aux.remove(pareja);
			aux.remove(pareja);
		}
		masAlta = l.get(2);
		segundaAlta = l.get(1);
		masPequena = l.get(0);
	}

	public int compareTo(Pareja p) {
		int res = pareja.compareTo(p.getPareja());
		if (res == 0) {
			res = masAlta.compareTo(p.getMasAlta());
			if (res == 0) {
				res = segundaAlta.compareTo(p.getSegundaAlta());
				if (res == 0)
					res = masPequena.compareTo(p.getMasPequena());
			}
		}
		return res;
	}

	public Integer getPareja() {
		return pareja;
	}

	public Integer getMasAlta() {
		return masAlta;
	}

	public Integer getSegundaAlta() {
		return segundaAlta;
	}

	public Integer getMasPequena() {
		return masPequena;
	}


}
