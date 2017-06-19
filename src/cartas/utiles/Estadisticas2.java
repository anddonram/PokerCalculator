package cartas.utiles;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.SortedSet;

import cartas.tipos.Baraja;
import cartas.tipos.Jugador;

import com.google.common.collect.Lists;

public class Estadisticas2 {// ¿El definitivo? Siiiii. Tarda de 8 a 10 segundos
	public static List<List<List<Integer[]>>> de1(SortedSet<Integer> baraja,
			Integer[] n) {
		List<List<List<Integer[]>>> de1 = new ArrayList<List<List<Integer[]>>>();
		List<List<Integer[]>> total = Estadisticas.de1(baraja, n);
		for (int k = 0; k < 5; k++) {
			de1.add(new ArrayList<List<Integer[]>>());
			for (int i = 0; i < 9; i++)
				de1.get(k).add(new ArrayList<Integer[]>());
		}
		for (List<Integer[]> k : total)
			for (Integer[] nivel : k) {
				de1.get(total.indexOf(k))
						.get(Figuras.getFigura(Arrays.asList(nivel)).ordinal())
						.add(nivel);
			}
		return de1;
	}

	public static List<List<List<Integer[]>>> de2(SortedSet<Integer> baraja,
			Integer[] n) {
		List<List<List<Integer[]>>> de2 = new ArrayList<List<List<Integer[]>>>();
		List<List<Integer[]>> total = Estadisticas.de2(baraja, n);
		for (int k = 0; k < 10; k++) {
			de2.add(new ArrayList<List<Integer[]>>());
			for (int i = 0; i < 9; i++)
				de2.get(k).add(new ArrayList<Integer[]>());
		}
		for (List<Integer[]> k : total)
			for (Integer[] nivel : k) {
				de2.get(total.indexOf(k))
						.get(Figuras.getFigura(Arrays.asList(nivel)).ordinal())
						.add(nivel);
			}
		return de2;
	}

	public static List<List<List<Integer[]>>> de3(SortedSet<Integer> baraja,
			Integer[] n) {
		List<List<List<Integer[]>>> de3 = new ArrayList<List<List<Integer[]>>>();
		List<List<Integer[]>> total = Estadisticas.de3(baraja, n);
		for (int k = 0; k < 10; k++) {
			de3.add(new ArrayList<List<Integer[]>>());
			for (int i = 0; i < 9; i++)
				de3.get(k).add(new ArrayList<Integer[]>());
		}
		for (List<Integer[]> k : total)
			for (Integer[] nivel : k) {
				de3.get(total.indexOf(k))
						.get(Figuras.getFigura(Arrays.asList(nivel)).ordinal())
						.add(nivel);
			}
		return de3;
	}

	public static List<List<List<Integer[]>>> de4(SortedSet<Integer> baraja,
			Integer[] n) {
		List<List<List<Integer[]>>> de4 = new ArrayList<List<List<Integer[]>>>();
		List<List<Integer[]>> total = Estadisticas.de4(baraja, n);
		for (int k = 0; k < 5; k++) {
			de4.add(new ArrayList<List<Integer[]>>());
			for (int i = 0; i < 9; i++)
				de4.get(k).add(new ArrayList<Integer[]>());
		}
		for (List<Integer[]> k : total)
			for (Integer[] nivel : k) {
				de4.get(total.indexOf(k))
						.get(Figuras.getFigura(Arrays.asList(nivel)).ordinal())
						.add(nivel);
			}
		return de4;
	}

	public static List<List<List<Integer[]>>> de5(SortedSet<Integer> baraja,
			Integer[] n) {
		List<List<List<Integer[]>>> de5 = new ArrayList<List<List<Integer[]>>>();
		List<List<Integer[]>> de51 = new ArrayList<List<Integer[]>>();
		de5.add(de51);
		for (int i = 0; i < 9; i++)
			de5.get(0).add(new ArrayList<Integer[]>());
		List<List<Integer[]>> total = Estadisticas.de5(baraja, n);
		for (Integer[] nivel : total.get(0))
			de5.get(0).get(Figuras.getFigura(Arrays.asList(nivel)).ordinal())
					.add(nivel);

		return de5;
	}

	public static List<List<List<List<Integer[]>>>> del1Al5(Baraja baraja,
			Jugador j) {
		SortedSet<Integer> bar = baraja.getBaraja();
		List<Integer> mano = Lists.newArrayList(j.getMano());
		Integer[] n = { mano.get(0), mano.get(1), mano.get(2), mano.get(3),
				mano.get(4) };
		List<List<List<List<Integer[]>>>> res = new ArrayList<List<List<List<Integer[]>>>>();
		List<List<List<Integer[]>>> de1 = de1(bar, n);
		res.add(de1);
		List<List<List<Integer[]>>> de2 = de2(bar, n);
		res.add(de2);
		List<List<List<Integer[]>>> de3 = de3(bar, n);
		res.add(de3);
		List<List<List<Integer[]>>> de4 = de4(bar, n);
		res.add(de4);
		List<List<List<Integer[]>>> de5 = de5(bar, n);
		res.add(de5);
		return res;
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

	public static Double[] estadisticaRival(Baraja baraja) {
		Double suma = 0d;
		List<List<Integer[]>> aux = Estadisticas.manoDelOponente(baraja);
		Double[] res = { (double) aux.get(0).size(),
				(double) aux.get(1).size(), (double) aux.get(2).size(),
				(double) aux.get(3).size(), (double) aux.get(4).size(),
				(double) aux.get(5).size(), (double) aux.get(6).size(),
				(double) aux.get(7).size(), (double) aux.get(8).size() };
		for (Double d : res)
			suma += d;
		suma /= 100d;
		res[0] /= suma;
		res[1] /= suma;
		res[2] /= suma;
		res[3] /= suma;
		res[4] /= suma;
		res[5] /= suma;
		res[6] /= suma;
		res[7] /= suma;
		res[8] /= suma;
		return res;
	}

}