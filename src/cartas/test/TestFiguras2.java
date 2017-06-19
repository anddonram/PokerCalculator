package cartas.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import cartas.tipos.Baraja;
import cartas.tipos.BarajaImpl;
import cartas.tipos.Jugador;
import cartas.tipos.JugadorImpl;

public class TestFiguras2 {

	public static void main(String[] args) {// este es el bueno, tres segundos el
											// mas lento
		// Iniciación
		Integer v = 0, w = 13, x = 5, y = 26, z = 50, numeroDescarte = 5;
		Baraja baraja = new BarajaImpl();
		SortedSet<Integer> manoInicial = new TreeSet<Integer>();
		manoInicial.add(x);
		manoInicial.add(v);
		manoInicial.add(w);
		manoInicial.add(y);
		manoInicial.add(z);
		Jugador j = new JugadorImpl(baraja, manoInicial);
		// Variables a rellenar
		List<List<List<Integer[]>>> del1Al5 = new ArrayList<List<List<Integer[]>>>();
		List<List<Integer[]>> de1 = new ArrayList<List<Integer[]>>();
		del1Al5.add(de1);
		List<List<Integer[]>> de2 = new ArrayList<List<Integer[]>>();
		del1Al5.add(de2);
		List<List<Integer[]>> de3 = new ArrayList<List<Integer[]>>();
		del1Al5.add(de3);
		List<List<Integer[]>> de4 = new ArrayList<List<Integer[]>>();
		del1Al5.add(de4);
		List<List<Integer[]>> de5 = new ArrayList<List<Integer[]>>();
		del1Al5.add(de5);
		List<Integer[]> total = new ArrayList<Integer[]>();
		Integer[] n = (Integer[]) j.getMano().toArray(
				new Integer[j.getMano().size()]);
		System.out.println("Empieza");
		Double inicio = (double) System.currentTimeMillis();
		switch (numeroDescarte) {
		case 5:
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
												total.add(k);
											}
									}
							}
					}
			}
			de5.add(new ArrayList<Integer[]>(total));
			break;
		case 4:
			for (int index = 0; index < n.length; index++)
				for (int index2 = index + 1; index2 < n.length; index2++)
					for (int index3 = index2 + 1; index3 < n.length; index3++)
						for (int index4 = index3 + 1; index4 < n.length; index4++) {
							for (Integer a : baraja.getBaraja()) {
								n[index] = a;
								for (Integer e : baraja.getBaraja())
									if (a < e) {
										n[index2] = e;
										for (Integer i : baraja.getBaraja())
											if (e < i) {
												n[index3] = i;
												for (Integer o : baraja
														.getBaraja())
													if (i < o) {
														n[index4] = o;
														Integer[] k = n.clone();
														Arrays.sort(k);
														total.add(k);
													}
											}
									}
							}
							de5.add(new ArrayList<Integer[]>(total));
							total.clear();
						}
			break;
		case 3:
			for (int index = 0; index < n.length; index++)
				for (int index2 = index + 1; index2 < n.length; index2++)
					for (int index3 = index2 + 1; index3 < n.length; index3++) {
						for (Integer a : baraja.getBaraja()) {
							n[index] = a;
							for (Integer e : baraja.getBaraja())
								if (a < e) {
									n[index2] = e;
									for (Integer i : baraja.getBaraja())
										if (e < i) {
											n[index3] = i;
											Integer[] k = n.clone();
											Arrays.sort(k);
											total.add(k);
										}
								}
						}
						de3.add(new ArrayList<Integer[]>(total));
						total.clear();
					}
			break;
		case 2:
			for (int index = 0; index < n.length; index++)
				for (int index2 = index + 1; index2 < n.length; index2++) {
					for (Integer a : baraja.getBaraja()) {
						n[index] = a;
						for (Integer e : baraja.getBaraja())
							if (a < e) {
								n[index2] = e;
								Integer[] k = n.clone();
								Arrays.sort(k);
								total.add(k);
							}
					}
					de2.add(new ArrayList<Integer[]>(total));
					total.clear();
				}
			break;
		case 1:
			for (int index = 0; index < n.length; index++) {
				for (Integer i : baraja.getBaraja()) {
					n[index] = i;
					Integer[] k = n.clone();
					Arrays.sort(k);
					total.add(k);
				}
				de1.add(new ArrayList<Integer[]>(total));
				total.clear();
			}
			break;
		default:
			break;
		}
		Double fin = (double) System.currentTimeMillis();
		System.out.println(de5.get(0).size() + " " + de5.size()
				+ " tiempo empleado en segundos: " + (fin - inicio) / 1000d);
	}
}