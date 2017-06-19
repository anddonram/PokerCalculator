package cartas.test;

import java.util.Arrays;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import cartas.tipos.Baraja;
import cartas.tipos.BarajaImpl;
import cartas.tipos.Jugador;
import cartas.tipos.JugadorImpl;
import cartas.utiles.Estadisticas2;
import cartas.utiles.EstadisticasExperimento;
import cartas.utiles.EstadisticasExperimento2;

public class TestCombinatoria {
	public static void main(String[] args) {
		Integer v = 0, w = 13, x = 5, y = 26, z = 50;
		Baraja baraja = new BarajaImpl();
		SortedSet<Integer> manoInicial = new TreeSet<Integer>();
		manoInicial.add(x);
		manoInicial.add(v);
		manoInicial.add(w);
		manoInicial.add(y);
		manoInicial.add(z);
		Jugador j = new JugadorImpl(baraja, manoInicial);
		Jugador j1 = new JugadorImpl(baraja, 8, 9, 14, 29, 30);
		Jugador j2 = new JugadorImpl(baraja, 3, 10, 21, 33, 46);
		Jugador j3 = new JugadorImpl(baraja, 43, 44, 45, 2, 17);
		Jugador j4 = new JugadorImpl(baraja, 16, 22, 28, 41, 51);
		System.out.println("Empieza");
		Long inicio = System.currentTimeMillis();
		Double[] d = Estadisticas2.estadisticaRival(baraja);
		Double fin = (System.currentTimeMillis() - inicio) / 1000d;
		System.out.println("Tiempo empleado en segundos: " + fin);
		System.out.println(Arrays.toString(d));
		System.out.println(Arrays.toString(baraja.getCartasPorNumero()));
		System.out.println(Arrays.toString(baraja.getCartasPorPalo()));
		System.out.println(j+" /n"+j1+"/n "+j2+"/n "+j3+"/n "+j4);
		List<List<Double[]>> pollo=EstadisticasExperimento.estadistica(baraja, j1);
		for(List<Double[]> f:pollo)
			for(Double[] g:f)
				System.out.println(Arrays.toString(g));
		inicio=System.currentTimeMillis();
		System.out.println(EstadisticasExperimento2.masProbable2(baraja, j));
		fin = (System.currentTimeMillis() - inicio) / 1000d;
		System.out.println("Tiempo empleado en segundos: " + fin);
	}
}
