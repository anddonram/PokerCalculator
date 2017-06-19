package cartas.utiles;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import cartas.tipos.Baraja;
import cartas.tipos.Jugador;

import com.google.common.collect.Lists;

public class EstadisticasExperimento3 {// ¿¿Mas rapido que nunca??!!

	public static List<Double[]> de1(Baraja baraja, Integer[] n) {
		List<Double[]> de1 = Lists.newArrayList();
		for (int k = 0; k < 5; k++)
			de1.add(new Double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 });

		for (int index = 0; index < 5; index++) {
			for (Integer i : baraja.getBaraja()) {
				Integer[] k = n.clone();
				k[index] = i;
				Arrays.sort(k);
				de1.get(index)[Figuras.getFigura(k).ordinal()]++;
			}
		}
		return de1;
	}

	public static List<Double[]> de2(Baraja baraja, Integer[] n) {
		List<Double[]> de2 = Lists.newArrayList();
		for (int k = 0; k < 10; k++)
			de2.add(new Double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 });

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
							de2.get(i)[Figuras.getFigura(k).ordinal()]++;
						}
					p[index] = n[index];
				}
				i++;
			}
		return de2;
	}

	public static List<Double[]> de3(Baraja baraja, Integer[] n) {
		List<Double[]> de3 = Lists.newArrayList();
		for (int k = 0; k < 10; k++)
			de3.add(new Double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 });

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
										de3.get(z)[Figuras.getFigura(k)
												.ordinal()]++;
									}
								p[index2] = n[index2];
							}
						p[index] = n[index];
					}
					z++;
				}
		return de3;
	}

	public static List<Double[]> de4(Baraja baraja, Integer[] n) {
		List<Double[]> de4 = Lists.newArrayList();
		for (int k = 0; k < 5; k++)
			de4.add(new Double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 });

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
													de4.get(z)[Figuras
															.getFigura(k)
															.ordinal()]++;
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

	public static List<Double[]> de5(Baraja baraja) {
		List<Double[]> de5 = Lists.newArrayList();
		de5.add(new Double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 });

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
											de5.get(0)[Figuras.getFigura(k)
													.ordinal()]++;
										}
								}
						}
				}
		}
		return de5;
	}

	public static List<List<Double[]>> del1Al5(Baraja baraja, Jugador j) {
		List<List<Double[]>> del1Al5 = new ArrayList<List<Double[]>>();
		Integer[] n = (Integer[]) j.getMano().toArray(
				new Integer[j.getMano().size()]);
		List<Double[]> de1 = EstadisticasExperimento3.de1(baraja, n);
		del1Al5.add(de1);
		List<Double[]> de2 = EstadisticasExperimento3.de2(baraja, n);
		del1Al5.add(de2);
		List<Double[]> de3 = EstadisticasExperimento3.de3(baraja, n);
		del1Al5.add(de3);
		List<Double[]> de4 = EstadisticasExperimento3.de4(baraja, n);
		del1Al5.add(de4);
		List<Double[]> de5 = EstadisticasExperimento3.de5(baraja);
		del1Al5.add(de5);
		return del1Al5;
	}

	public static List<List<Double[]>> estadistica(Baraja baraja, Jugador j) {
		List<List<Double[]>> del1Al5 = del1Al5(baraja, j);
		Double suma = 0.0;
		for (List<Double[]> a : del1Al5) {
			for (Double[] aux : a) {
				suma = 0.0;
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
			}
		}
		return del1Al5;
	}

}
