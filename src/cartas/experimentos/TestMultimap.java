package cartas.experimentos;

import java.util.Collections;
import java.util.Set;
import java.util.SortedSet;

import cartas.tipos.Clave;
import cartas.tipos.funciones.FuncionStringToArray;
import cartas.tipos.predicados.PredMenoresQueMano;
import cartas.utiles.Cartas;
import cartas.utiles.Iterables2;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Iterables;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps;
import com.google.common.collect.Sets;

public class TestMultimap {
	private static SortedSet<Integer> mano = Sets.newTreeSet();
	private static Integer a = 2, b = 4, c = 6, d = 23, e = 7;

	public static void main(String[] args) {
		Collections.addAll(mano, a, b, c, d, e);
		Iterable<String> lineas = Iterables2.fromFile("Manos ordenadas.txt");
		Iterable<Integer[]> it = Iterables.transform(lineas,
				new FuncionStringToArray());
		Multimap<Clave, Integer[]> mm = HashMultimap.create();
		Long l = System.currentTimeMillis();
		for (Integer[] m : it) {
			mm.put(generaClave(m), m);
		}
		System.out.println(Cartas.tiempoTardado(l));
		System.out.println(mm.keySet().size());
		System.out.println(mm.values().size());
		for (Clave v : mm.keySet()) {
			System.out.println(v + ": " + mm.get(v).size());
		}
		Integer[] manoarray = new Integer[5];
		Integer iaux = 0;
		for (Integer i : mano) {
			manoarray[iaux] = i;
			iaux++;
		}
		Multimap<Clave, Integer[]> mm2 = Multimaps.filterValues(mm,
				new PredMenoresQueMano(manoarray));
		for (Clave v : mm2.keySet()) {
			System.out.println(v + ": " + mm2.get(v).size());
		}
		// System.out.println(mm.get(new Clave(new Integer[] { 1, 2 })).size());
	}

	private static Clave generaClave(Integer[] m) {
		SortedSet<Integer> maux = Sets.newTreeSet();
		for (Integer i : m)
			maux.add(i);
		SortedSet<Integer> inter = Sets.newTreeSet(Sets
				.intersection(mano, maux));
		Integer[] res = { 5 - inter.size(), generaSegunda(inter) };
		return new Clave(res);
	}

	private static Integer generaSegunda(Set<Integer> inter) {
		Integer res = 0;

		switch (inter.size()) {
		case 1:
			if (inter.contains(a))
				res = 0;
			else if (inter.contains(b))
				res = 1;
			else if (inter.contains(c))
				res = 2;
			else if (inter.contains(d))
				res = 3;
			else
				res = 4;
			break;
		case 2:
			if (inter.contains(a)) {
				if (inter.contains(b)) {
					res = 0;
				} else if (inter.contains(c)) {
					res = 1;
				} else if (inter.contains(d)) {
					res = 2;
				} else
					res = 3;
			} else if (inter.contains(b)) {
				if (inter.contains(c)) {
					res = 4;
				} else if (inter.contains(d)) {
					res = 5;
				} else
					res = 6;
			} else if (inter.contains(c)) {
				if (inter.contains(d)) {
					res = 7;
				} else
					res = 8;
			} else
				res = 9;
			break;
		case 3:
			if (!inter.contains(a)) {
				if (!inter.contains(b)) {
					res = 0;
				} else if (!inter.contains(c)) {
					res = 1;
				} else if (!inter.contains(d)) {
					res = 2;
				} else
					res = 3;
			} else if (!inter.contains(b)) {
				if (!inter.contains(c)) {
					res = 4;
				} else if (!inter.contains(d)) {
					res = 5;
				} else
					res = 6;
			} else if (!inter.contains(c)) {
				if (!inter.contains(d)) {
					res = 7;
				} else
					res = 8;
			} else
				res = 9;
			break;
		case 4:
			if (!inter.contains(a))
				res = 0;
			else if (!inter.contains(b))
				res = 1;
			else if (!inter.contains(c))
				res = 2;
			else if (!inter.contains(d))
				res = 3;
			else
				res = 4;
			break;
		default:
			break;
		}
		return res;
	}
}
