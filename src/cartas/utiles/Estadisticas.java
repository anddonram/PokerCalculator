package cartas.utiles;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.SortedSet;

import cartas.tipos.Baraja;
import cartas.tipos.Jugador;

import com.google.common.collect.Lists;

public class Estadisticas {

	public static List<List<Integer[]>> de1(SortedSet<Integer> baraja,
			Integer[] n) {
		List<List<Integer[]>> res = new ArrayList<List<Integer[]>>();
		List<Integer[]> total = new ArrayList<Integer[]>();
		for (int index = 0; index < 5; index++) {
			for (Integer i : baraja) {
				Integer[] k = n.clone();
				k[index] = i;
				Arrays.sort(k);
				total.add(k);
			}
			res.add(new ArrayList<Integer[]>(total));
			total.clear();
		}
		return res;
	}

	public static List<List<Integer[]>> de2(SortedSet<Integer> baraja,
			Integer[] n) {
		List<List<Integer[]>> res = new ArrayList<List<Integer[]>>();
		List<Integer[]> total = new ArrayList<Integer[]>();
		for (int index = 0; index < 5; index++)
			for (int index2 = index + 1; index2 < 5; index2++) {
				for (Integer a : baraja) {
					Integer[] l = n.clone();
					l[index] = a;
					for (Integer e : baraja)
						if (a < e) {
							Integer[] k = l.clone();
							k[index2] = e;
							Arrays.sort(k);
							total.add(k);
						}
				}
				res.add(new ArrayList<Integer[]>(total));
				total.clear();
			}
		return res;
	}

	public static List<List<Integer[]>> de3(SortedSet<Integer> baraja,
			Integer[] n) {
		List<List<Integer[]>> res = new ArrayList<List<Integer[]>>();
		List<Integer[]> total = new ArrayList<Integer[]>();
		for (int index = 0; index < 5; index++)
			for (int index2 = index + 1; index2 < 5; index2++)
				for (int index3 = index2 + 1; index3 < 5; index3++) {
					for (Integer a : baraja) {
						Integer[] m = n.clone();
						m[index] = a;
						for (Integer e : baraja)
							if (a < e) {
								Integer[] l = m.clone();
								l[index2] = e;
								for (Integer i : baraja)
									if (e < i) {
										Integer[] k = l.clone();
										k[index3] = i;
										Arrays.sort(k);
										total.add(k);
									}
							}
					}
					res.add(new ArrayList<Integer[]>(total));
					total.clear();
				}
		return res;
	}

	public static List<List<Integer[]>> de4(SortedSet<Integer> baraja,
			Integer[] p) {
		List<List<Integer[]>> res = new ArrayList<List<Integer[]>>();
		List<Integer[]> total = new ArrayList<Integer[]>();
		for (int index = 0; index < 5; index++)
			for (int index2 = index + 1; index2 < 5; index2++)
				for (int index3 = index2 + 1; index3 < 5; index3++)
					for (int index4 = index3 + 1; index4 < 5; index4++) {
						for (Integer a : baraja) {
							Integer[] n = p.clone();
							n[index] = a;
							for (Integer e : baraja)
								if (a < e) {
									Integer[] m = n.clone();
									m[index2] = e;
									for (Integer i : baraja)
										if (e < i) {
											Integer[] l = m.clone();
											l[index3] = i;
											for (Integer o : baraja)
												if (i < o) {
													Integer[] k = l.clone();
													k[index4] = o;
													Arrays.sort(k);
													total.add(k);
												}
										}
								}
						}
						res.add(new ArrayList<Integer[]>(total));
						total.clear();
					}
		return res;
	}

	public static List<List<Integer[]>> de5(SortedSet<Integer> baraja,
			Integer[] n) {
		List<List<Integer[]>> res = new ArrayList<List<Integer[]>>();
		List<Integer[]> total = new ArrayList<Integer[]>();
		for (Integer e : baraja) {
			n[0] = e;
			for (Integer d : baraja)
				if (d > e) {
					n[1] = d;
					for (Integer c : baraja)
						if (c > d) {
							n[2] = c;
							for (Integer b : baraja)
								if (b > c) {
									n[3] = b;
									for (Integer a : baraja)
										if (a > b) {
											n[4] = a;
											Integer[] k = n.clone();
											total.add(k);
										}
								}
						}
				}
		}
		res.add(new ArrayList<Integer[]>(total));
		return res;
	}

	public static List<List<List<Integer[]>>> del1Al5(Baraja baraja, Jugador j) {
		SortedSet<Integer> bar = baraja.getBaraja();
		List<Integer> mano = Lists.newArrayList(j.getMano());
		Integer[] n = { mano.get(0), mano.get(1), mano.get(2), mano.get(3),
				mano.get(4) };
		List<List<List<Integer[]>>> del1Al5 = new ArrayList<List<List<Integer[]>>>();
		List<List<Integer[]>> de1 = Estadisticas.de1(bar, n);
		del1Al5.add(de1);
		List<List<Integer[]>> de2 = Estadisticas.de2(bar, n);
		del1Al5.add(de2);
		List<List<Integer[]>> de3 = Estadisticas.de3(bar, n);
		del1Al5.add(de3);
		List<List<Integer[]>> de4 = Estadisticas.de4(bar, n);
		del1Al5.add(de4);
		List<List<Integer[]>> de5 = Estadisticas.de5(bar, n);
		del1Al5.add(de5);
		return del1Al5;
	}

	public static List<List<Integer[]>> manoDelOponente(Baraja baraja) {
		SortedSet<Integer> bar = baraja.getBaraja();
		List<List<Integer[]>> res = new ArrayList<List<Integer[]>>();
		for (int i = 0; i < 9; i++)
			res.add(new ArrayList<Integer[]>());
		Integer[] n = new Integer[5];
		for (Integer e : bar) {
			n[0] = e;
			for (Integer d : bar)
				if (d > e) {
					n[1] = d;
					for (Integer c : bar)
						if (c > d) {
							n[2] = c;
							for (Integer b : bar)
								if (b > c) {
									n[3] = b;
									for (Integer a : bar)
										if (a > b) {
											n[4] = a;
											Integer[] k = n.clone();
											res.get(Figuras.getFigura(
													Arrays.asList(k)).ordinal())
													.add(k);
										}
								}
						}
				}
		}
		return res;
	}
}
