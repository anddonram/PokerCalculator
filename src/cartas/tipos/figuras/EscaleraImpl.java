package cartas.tipos.figuras;

import java.util.Collections;
import java.util.List;

import cartas.tipos.Figura;

import com.google.common.collect.Lists;

public class EscaleraImpl implements Escalera {
	public static Figura f=Figura.ESCALERA;

	private Integer primera, ultima;

	public EscaleraImpl(List<Integer> k) {
		List<Integer> aux = Lists.newArrayList(k);
		Collections.sort(aux);
		primera = aux.get(0);
		ultima = aux.get(4);
	}

	public int compareTo(Escalera e) {
		int res = primera.compareTo(e.getPrimera());
		if (res == 0)
			res = e.getUltima().compareTo(ultima);
		return res;
	}

	public Integer getPrimera() {
		return primera;
	}

	public Integer getUltima() {
		return ultima;
	}



}
