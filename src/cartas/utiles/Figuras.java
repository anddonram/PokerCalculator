package cartas.utiles;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import cartas.tipos.Figura;

import com.google.common.collect.Lists;

public class Figuras {
	public static Figura getFigura(Collection<Integer> cincoCartas) {
		List<Integer> aux = Lists.newArrayList();
		for (Integer i : cincoCartas)
			aux.add(i % 13);
		Collections.sort(aux);
		Figura res = Figura.CARTA_MAS_ALTA;
		if (Figuras.esPareja(aux)) {
			if (Figuras.esDoblePareja(aux))
				res = Figura.DOBLE_PAREJA;
			else if (Figuras.esTrio(aux))
				res = Figura.FULL;
			else
				res = Figura.PAREJA;
		} else if (Figuras.esPoker(aux))
			res = Figura.POKER;
		else if (Figuras.esColor(cincoCartas)) {
			if (Figuras.esEscalera(aux))
				res = Figura.ESCALERA_DE_COLOR;
			else
				res = Figura.COLOR;
		} else if (Figuras.esTrio(aux))
			res = Figura.TRIO;
		else if (Figuras.esEscalera(aux))
			res = Figura.ESCALERA;
		return res;
	}

	public static Figura getFigura(Integer[] cincoCartas) {
		List<Integer> aux = Lists.newArrayList();
		for (Integer i : cincoCartas)
			aux.add(i % 13);
		Collections.sort(aux);
		Figura res = Figura.CARTA_MAS_ALTA;
		if (Figuras.esPareja(aux)) {
			if (Figuras.esDoblePareja(aux))
				res = Figura.DOBLE_PAREJA;
			else if (Figuras.esTrio(aux))
				res = Figura.FULL;
			else
				res = Figura.PAREJA;
		} else if (Figuras.esPoker(aux))
			res = Figura.POKER;
		else if (Figuras.esColor(cincoCartas)) {
			if (Figuras.esEscalera(aux))
				res = Figura.ESCALERA_DE_COLOR;
			else
				res = Figura.COLOR;
		} else if (Figuras.esTrio(aux))
			res = Figura.TRIO;
		else if (Figuras.esEscalera(aux))
			res = Figura.ESCALERA;
		return res;
	}

	public static Boolean esPareja(List<Integer> aux) {
		Boolean res = false;
		for (Integer i : aux)
			if (Collections.frequency(aux, i) == 2) {
				res = true;
				break;
			}
		return res;
	}

	public static Boolean esTrio(List<Integer> aux) {
		return Collections.frequency(aux, aux.get(2)) == 3;
	}

	public static Boolean esPoker(List<Integer> aux) {
		return Collections.frequency(aux, aux.get(2)) == 4;
	}

	public static Boolean esColor(Collection<Integer> mano) {
		List<Integer> aux = Lists.newArrayList();
		for (Integer i : mano)
			aux.add(i / 13);
		return Collections.frequency(aux, aux.get(0)) == 5;
	}

	public static Boolean esColor(Integer[] mano) {
		List<Integer> aux = Lists.newArrayList();
		for (Integer i : mano)
			aux.add(i / 13);
		return Collections.frequency(aux, aux.get(0)) == 5;
	}

	public static Boolean esEscalera(List<Integer> aux) {
		Boolean res = aux.get(0) == 0 && aux.get(1) == 1 && aux.get(2) == 2
				&& aux.get(3) == 3 && aux.get(4) == 12;
		if (!res)
			res = aux.contains(aux.get(0) + 1) && aux.contains(aux.get(0) + 2)
					&& aux.contains(aux.get(0) + 3)
					&& aux.contains(aux.get(0) + 4);
		return res;
	}

	public static Boolean esDoblePareja(List<Integer> aux) {
		return Collections.frequency(aux, aux.get(1)) == 2
				&& Collections.frequency(aux, aux.get(3)) == 2;
	}
}
