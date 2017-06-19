package cartas.tipos.comparadores;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import cartas.tipos.Figura;

import com.google.common.base.Preconditions;

public class ComparadorManos implements Comparator<Integer[]> {

	public int compare(Integer[] mano1, Integer[] mano2) {
		Preconditions.checkArgument(mano1.length == 5 && mano2.length == 5,
				"length distinto de 5");
		Figura f1 = Figura.CARTA_MAS_ALTA;
		Figura f2 = Figura.CARTA_MAS_ALTA;
		List<Integer> valor1 = new ArrayList<Integer>();
		List<Integer> valor2 = new ArrayList<Integer>();
		List<Integer> palo1 = new ArrayList<Integer>();
		List<Integer> palo2 = new ArrayList<Integer>();
		for (Integer i : mano1) {
			valor1.add(i % 13);
			palo1.add(i / 13);
		}
		for (Integer i : mano2) {
			valor2.add(i % 13);
			palo2.add(i / 13);
		}
		Collections.sort(valor1);
		Collections.sort(valor2);
		Boolean escalera1 = (valor1.contains(valor1.get(0))
				&& valor1.contains(valor1.get(0) + 1)
				&& valor1.contains(valor1.get(0) + 2)
				&& valor1.contains(valor1.get(0) + 3) && valor1.contains(valor1
				.get(0) + 4))
				|| (valor1.get(0) == 0 && valor1.get(1) == 1
						&& valor1.get(2) == 2 && valor1.get(3) == 3 && valor1
						.get(4) == 12);
		Boolean escalera2 = (valor2.contains(valor2.get(0))
				&& valor2.contains(valor2.get(0) + 1)
				&& valor2.contains(valor2.get(0) + 2)
				&& valor2.contains(valor2.get(0) + 3) && valor2.contains(valor2
				.get(0) + 4))
				|| (valor2.get(0) == 0 && valor2.get(1) == 1
						&& valor2.get(2) == 2 && valor2.get(3) == 3 && valor2
						.get(4) == 12);
		Integer[] frec1 = { Collections.frequency(valor1, valor1.get(0)),
				Collections.frequency(valor1, valor1.get(1)),
				Collections.frequency(valor1, valor1.get(2)),
				Collections.frequency(valor1, valor1.get(3)),
				Collections.frequency(valor1, valor1.get(4)) };
		Integer[] frec2 = { Collections.frequency(valor2, valor2.get(0)),
				Collections.frequency(valor2, valor2.get(1)),
				Collections.frequency(valor2, valor2.get(2)),
				Collections.frequency(valor2, valor2.get(3)),
				Collections.frequency(valor2, valor2.get(4)) };
		if (frec1[1] == 2 || frec1[3] == 2) {
			if (frec1[1] == 2 && frec1[3] == 2)
				f1 = Figura.DOBLE_PAREJA;
			else if (frec1[2] == 3)
				f1 = Figura.FULL;
			else
				f1 = Figura.PAREJA;
		} else if (frec1[2] == 4)
			f1 = Figura.POKER;
		else if (Collections.frequency(palo1, palo1.get(0)) == 5) {
			if (escalera1)
				f1 = Figura.ESCALERA_DE_COLOR;
			else
				f1 = Figura.COLOR;
		} else if (frec1[2] == 3)
			f1 = Figura.TRIO;
		else if (escalera1)
			f1 = Figura.ESCALERA;

		if (frec2[1] == 2 || frec2[3] == 2) {
			if (frec2[1] == 2 && frec2[3] == 2)
				f2 = Figura.DOBLE_PAREJA;
			else if (frec2[2] == 3)
				f2 = Figura.FULL;
			else
				f2 = Figura.PAREJA;
		} else if (frec2[2] == 4)
			f2 = Figura.POKER;
		else if (Collections.frequency(palo2, palo2.get(0)) == 5) {
			if (escalera2)
				f2 = Figura.ESCALERA_DE_COLOR;
			else
				f2 = Figura.COLOR;
		} else if (frec2[2] == 3)
			f2 = Figura.TRIO;
		else if (escalera2)
			f2 = Figura.ESCALERA;
		int res = f1.compareTo(f2);
		if (res == 0) {
			Integer aux1 = 0;
			Integer aux2 = 0;
			switch (f1) {
			case CARTA_MAS_ALTA:
			case COLOR:
				res = valor1.get(4).compareTo(valor2.get(4));
				if (res == 0) {
					res = valor1.get(3).compareTo(valor2.get(3));
					if (res == 0) {
						res = valor1.get(2).compareTo(valor2.get(2));
						if (res == 0) {
							res = valor1.get(1).compareTo(valor2.get(1));
							if (res == 0)
								res = valor1.get(0).compareTo(valor2.get(0));
						}
					}
				}
				break;
			case DOBLE_PAREJA:
				Integer aux3 = 0;
				Integer aux4 = 0;
				for (int i = frec1.length - 1; i >= 0; i--) {
					if (frec1[i] == 2)
						aux1 = i;
					if (frec2[i] == 2)
						aux2 = i;
					if (frec1[aux1] == 2 && frec2[aux2] == 2)
						break;
				}
				res = valor1.get(aux1).compareTo(valor2.get(aux2));
				if (res == 0) {
					for (int i = frec1.length - 1; i >= 0; i--) {
						if (frec1[i] == 2 && aux1 > i)
							aux3 = i;
						if (frec2[i] == 2 && aux2 > i)
							aux4 = i;
						if (frec1[aux3] == 2 && frec2[aux4] == 2)
							break;
					}
					res = valor1.get(aux1).compareTo(valor2.get(aux2));
					if (res == 0) {
						for (int i = frec1.length - 1; i >= 0; i--) {
							if (frec1[i] == 1)
								aux3 = i;
							if (frec2[i] == 1)
								aux4 = i;
							if (frec1[aux3] == 1 && frec2[aux4] == 1) {
								res = valor1.get(aux3).compareTo(
										valor2.get(aux4));
								break;
							}
						}
					}
				}
				break;
			case ESCALERA:
			case ESCALERA_DE_COLOR:
				res = valor1.get(0).compareTo(valor2.get(0));
				if (res == 0 && valor1.get(0) == 0)
					res = valor2.get(4).compareTo(valor1.get(4));
				break;
			case FULL:
				res = valor1.get(2).compareTo(valor2.get(2));
				if (res == 0)
					for (int i = frec1.length - 1; i >= 0; i--) {
						if (frec1[i] == 2)
							aux1 = i;
						if (frec2[i] == 2)
							aux2 = i;
						if (frec1[aux1] == 2 && frec2[aux2] == 2) {
							valor1.get(aux1).compareTo(valor2.get(aux2));
							break;
						}
					}

				break;
			case PAREJA:
				for (int i = frec1.length - 1; i >= 0; i--) {
					if (frec1[i] == 2)
						aux1 = i;
					if (frec2[i] == 2)
						aux2 = i;
					if (frec1[aux1] == 2 && frec2[aux2] == 2)
						break;
				}
				res = valor1.get(aux1).compareTo(valor2.get(aux2));
				if (res == 0) {
					for (int i = frec1.length - 1; i >= 0; i--) {
						if (frec1[i] == 1)
							aux1 = i;
						if (frec2[i] == 1)
							aux2 = i;
						if (frec1[aux1] == 1 && frec2[aux2] == 1) {
							res = valor1.get(aux1).compareTo(valor2.get(aux2));
							if (res == 0) {
								aux1 = 0;
								aux2 = 0;
							} else
								break;
						}
					}
				}
				break;
			case POKER:
				res = valor1.get(2).compareTo(valor2.get(2));
				if (res == 0)
					if (frec1[0] == 1)
						res = valor1.get(0).compareTo(valor2.get(0));
					else
						res = valor1.get(4).compareTo(valor2.get(4));
				break;
			case TRIO:
				res = valor1.get(2).compareTo(valor2.get(2));
				if (res == 0) {
					for (int i = frec1.length - 1; i >= 0; i--) {
						if (frec1[i] == 1)
							aux1 = i;
						if (frec2[i] == 1)
							aux2 = i;
						if (frec1[aux1] == 1 && frec2[aux2] == 1) {
							res = valor1.get(aux1).compareTo(valor2.get(aux2));
							if (res == 0) {
								aux1 = 0;
								aux2 = 0;
							} else
								break;
						}
					}
				}
				break;
			}
		}
		return res;
	}
}
