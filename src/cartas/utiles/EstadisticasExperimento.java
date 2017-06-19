package cartas.utiles;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import cartas.tipos.Baraja;
import cartas.tipos.Jugador;

public class EstadisticasExperimento {// Aún más rápido!!

	public static Double combinatoria(Integer a, Integer b) {
		Double res = 1.0;
		for (Integer i = a; i > a - b; i--)
			res *= i;
		for (Integer i = b; i > 0; i--)
			res /= i;
		return res;
	}

	public static List<List<List<Integer[]>>> de1(Baraja baraja, Integer[] n) {
		List<List<List<Integer[]>>> de1 = new ArrayList<List<List<Integer[]>>>();
		for (int k = 0; k < 5; k++) {
			de1.add(new ArrayList<List<Integer[]>>());
			for (int i = 0; i < 9; i++)
				de1.get(k).add(new ArrayList<Integer[]>());
		}
		for (int index = 0; index < 5; index++) {
			for (Integer i : baraja.getBaraja()) {
				Integer[] k = n.clone();
				k[index] = i;
				Arrays.sort(k);
				de1.get(index).get(Figuras.getFigura(k).ordinal()).add(k);
			}
		}
		return de1;
	}

	public static List<List<List<Integer[]>>> de2(Baraja baraja, Integer[] n) {
		List<List<List<Integer[]>>> de2 = new ArrayList<List<List<Integer[]>>>();
		for (int k = 0; k < 10; k++) {
			de2.add(new ArrayList<List<Integer[]>>());
			for (int i = 0; i < 9; i++)
				de2.get(k).add(new ArrayList<Integer[]>());
		}
		Integer i = 0;
		Integer[] p = n.clone();
		for (int index = 0; index < 5; index++)
			for (int index2 = index + 1; index2 < 5; index2++) {
				for (Integer a : baraja.getBaraja()) {
					p[index] = a;
					for (Integer e : baraja.getBaraja())
						if (a < e) {
							Integer[] k = p.clone();
							k[index2] = e;
							Arrays.sort(k);
							de2.get(i).get(Figuras.getFigura(k).ordinal())
									.add(k);
						}
					p[index] = n[index];
				}
				i++;
			}
		return de2;
	}

	public static List<List<List<Integer[]>>> de3(Baraja baraja, Integer[] n) {
		List<List<List<Integer[]>>> de3 = new ArrayList<List<List<Integer[]>>>();
		for (int k = 0; k < 10; k++) {
			de3.add(new ArrayList<List<Integer[]>>());
			for (int i = 0; i < 9; i++)
				de3.get(k).add(new ArrayList<Integer[]>());
		}
		Integer z = 0;
		Integer[] p = n.clone();
		for (int index = 0; index < 5; index++)
			for (int index2 = index + 1; index2 < 5; index2++)
				for (int index3 = index2 + 1; index3 < 5; index3++) {
					for (Integer a : baraja.getBaraja()) {
						p[index] = a;
						for (Integer e : baraja.getBaraja())
							if (a < e) {
								p[index2] = e;
								for (Integer i : baraja.getBaraja())
									if (e < i) {
										Integer[] k = p.clone();
										k[index3] = i;
										Arrays.sort(k);
										de3.get(z)
												.get(Figuras.getFigura(k)
														.ordinal()).add(k);
									}
								p[index2] = n[index2];
							}
						p[index] = n[index];
					}
					z++;
				}
		return de3;
	}

	public static List<List<List<Integer[]>>> de4(Baraja baraja, Integer[] n) {
		List<List<List<Integer[]>>> de4 = new ArrayList<List<List<Integer[]>>>();
		for (int k = 0; k < 5; k++) {
			de4.add(new ArrayList<List<Integer[]>>());
			for (int i = 0; i < 9; i++)
				de4.get(k).add(new ArrayList<Integer[]>());
		}
		Integer z = 0;
		Integer[] p = n.clone();
		for (int index = 0; index < 5; index++)
			for (int index2 = index + 1; index2 < 5; index2++)
				for (int index3 = index2 + 1; index3 < 5; index3++)
					for (int index4 = index3 + 1; index4 < 5; index4++) {
						for (Integer a : baraja.getBaraja()) {
							p[index] = a;
							for (Integer e : baraja.getBaraja())
								if (a < e) {
									p[index2] = e;
									for (Integer i : baraja.getBaraja())
										if (e < i) {
											p[index3] = i;
											for (Integer o : baraja.getBaraja())
												if (i < o) {
													Integer[] k = p.clone();
													k[index4] = o;
													Arrays.sort(k);
													de4.get(z)
															.get(Figuras
																	.getFigura(
																			k)
																	.ordinal())
															.add(k);
												}
											p[index3] = n[index3];
										}
									p[index2] = n[index2];
								}
							p[index] = n[index];
						}
						z++;
					}
		return de4;
	}

	public static List<List<List<Integer[]>>> de5(Baraja baraja) {
		List<List<List<Integer[]>>> de5 = new ArrayList<List<List<Integer[]>>>();
		List<List<Integer[]>> de51 = new ArrayList<List<Integer[]>>();
		de5.add(de51);
		for (int i = 0; i < 9; i++)
			de5.get(0).add(new ArrayList<Integer[]>());
		for (Integer e : baraja.getBaraja()) {
			for (Integer d : baraja.getBaraja())
				if (d > e) {
					for (Integer c : baraja.getBaraja())
						if (c > d) {
							for (Integer b : baraja.getBaraja())
								if (b > c) {
									for (Integer a : baraja.getBaraja())
										if (a > b) {
											Integer[] k = { e, d, c, b, a };
											de5.get(0)
													.get(Figuras.getFigura(k)
															.ordinal()).add(k);
										}
								}
						}
				}
		}
		return de5;
	}

	public static List<List<List<List<Integer[]>>>> del1Al5(Baraja baraja,
			Jugador j) {
		List<List<List<List<Integer[]>>>> del1Al5 = new ArrayList<List<List<List<Integer[]>>>>();
		Integer[] n = (Integer[]) j.getMano().toArray(
				new Integer[j.getMano().size()]);
		List<List<List<Integer[]>>> de1 = EstadisticasExperimento
				.de1(baraja, n);
		del1Al5.add(de1);
		List<List<List<Integer[]>>> de2 = EstadisticasExperimento
				.de2(baraja, n);
		del1Al5.add(de2);
		List<List<List<Integer[]>>> de3 = EstadisticasExperimento
				.de3(baraja, n);
		del1Al5.add(de3);
		List<List<List<Integer[]>>> de4 = EstadisticasExperimento
				.de4(baraja, n);
		del1Al5.add(de4);
		List<List<List<Integer[]>>> de5 = EstadisticasExperimento.de5(baraja);
		del1Al5.add(de5);
		return del1Al5;
	}

	public static List<List<Double[]>> estadistica(Baraja baraja, Jugador j) {
		Double suma = 0d;
		List<List<Double[]>> res = new ArrayList<List<Double[]>>();
		List<List<List<List<Integer[]>>>> total = del1Al5(baraja, j);
		for (List<List<List<Integer[]>>> a : total) {
			List<Double[]> de = new ArrayList<Double[]>();
			for (List<List<Integer[]>> b : a) {
				Double[] aux = { (double) b.get(0).size(),
						(double) b.get(1).size(), (double) b.get(2).size(),
						(double) b.get(3).size(), (double) b.get(4).size(),
						(double) b.get(5).size(), (double) b.get(6).size(),
						(double) b.get(7).size(), (double) b.get(8).size() };
				for (Double d : aux)
					suma += d;
				suma /= 100d;
				aux[0] /= suma;
				aux[1] /= suma;
				aux[2] /= suma;
				aux[3] /= suma;
				aux[4] /= suma;
				aux[5] /= suma;
				aux[6] /= suma;
				aux[7] /= suma;
				aux[8] /= suma;
				de.add(aux);
			}
			res.add(de);
		}
		return res;
	}

	public static List<List<Integer[]>> manoDelOponente(Baraja baraja) {
		List<List<Integer[]>> res = new ArrayList<List<Integer[]>>();
		for (int i = 0; i < 9; i++)
			res.add(new ArrayList<Integer[]>());
		Integer[] n = new Integer[5];
		for (Integer e : baraja.getBaraja()) {
			n[0] = e;
			for (Integer d : baraja.getBaraja())
				if (d > e) {
					n[1] = d;
					for (Integer c : baraja.getBaraja())
						if (c > d) {
							n[2] = c;
							for (Integer b : baraja.getBaraja())
								if (b > c) {
									n[3] = b;
									for (Integer a : baraja.getBaraja())
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
