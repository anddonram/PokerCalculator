package cartas.utiles;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.SortedSet;

import cartas.tipos.Baraja;
import cartas.tipos.Figura;
import cartas.tipos.Jugador;

import com.google.common.collect.Sets;

public class EstadisticasExperimento4 {
	public static String masProbable(Baraja b, Jugador j) {
		List<List<List<List<Integer[]>>>> todo = EstadisticasExperimento
				.del1Al5(b, j);
		List<List<Double[]>> aux = estadistica(todo);
		SortedSet<Integer> mano = j.getMano();
		Figura f = Figuras.getFigura(mano);
		Double d = 0d;
		Double p = 0d;
		Integer x = 0, y = 0;
		for (int a = 0; a < aux.size(); a++)
			for (int s = 0; s < aux.get(a).size(); s++) {
				d = 0d;
				for (int i = f.ordinal() + 1; i < 9; i++) {
					d += aux.get(a).get(s)[i];
					if (d > p) {
						p = d;
						x = a;
						y = s;
					}
				}
			}
		return "Cartas a mantener: "
				+ Cartas.cadena(Sets.intersection(
						mano,
						Sets.newTreeSet(Arrays.asList(todo.get(x).get(y)
								.get(f.ordinal()).get(0))))) + " (" + d + "%)";
	}

	public static String masProbable2(Baraja b, Jugador j) {
		List<List<List<List<Integer[]>>>> todo = EstadisticasExperimento
				.del1Al5(b, j);
		List<List<Double[]>> aux = estadistica(todo);
		SortedSet<Integer> mano = j.getMano();
		Figura f = Figuras.getFigura(mano);
		Double d = 0d;
		Double p = 0d;
		Integer x = 0, y = 0;
		for (int a = 0; a < aux.size(); a++)
			for (int s = 0; s < aux.get(a).size(); s++) {
				d = 0d;
				for (int i = f.ordinal() + 1; i < 9; i++) {
					d += aux.get(a).get(s)[i] * i;
					if (d > p) {
						p = d;
						x = a;
						y = s;
					}
				}
			}
		return "Cartas a mantener: "
				+ Cartas.cadena(Sets.intersection(
						mano,
						Sets.newTreeSet(Arrays.asList(todo.get(x).get(y)
								.get(f.ordinal()).get(0))))) + " (" + d + "%)";
	}

	private static List<List<Double[]>> estadistica(
			List<List<List<List<Integer[]>>>> total) {
		Double suma = 0d;
		List<List<Double[]>> res = new ArrayList<List<Double[]>>();
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

}
