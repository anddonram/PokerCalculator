package cartas.tipos.comparadores;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparadorCartaAlta implements Comparator<Integer[]> {
	public int compare(Integer[] mano1, Integer[] mano2) {
		List<Integer> aux1 = new ArrayList<Integer>();
		List<Integer> aux2 = new ArrayList<Integer>();
		for (Integer i : mano1)
			aux1.add(i % 13);
		for (Integer i : mano2)
			aux2.add(i % 13);
		Collections.sort(aux1);
		Collections.sort(aux2);
		int i = 4;
		int res = 0;
		do {
			res = aux1.get(i).compareTo(aux2.get(i--));
		} while (res == 0 && i >= 0);
		return res;
	}
}
