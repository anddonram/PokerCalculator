package cartas.test;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;

import cartas.tipos.Baraja;
import cartas.tipos.BarajaImpl;
import cartas.tipos.Carta;
import cartas.tipos.Jugador;
import cartas.tipos.JugadorImpl;
import cartas.utiles.Cartas;
import cartas.utiles.Estadisticas2;
import cartas.utiles.EstadisticasExperimento2;

import com.google.common.collect.Sets;

public class NuevaPartida {
	public static Baraja b = new BarajaImpl();
	private static Scanner sc = new Scanner(System.in);
	private static Jugador[] jug;

	public static void main(String[] args) {
		nuevaPartida();
		actualiza();
		actualiza();
		actualiza();
		System.out.println("Jugador rival: "
				+ Arrays.toString(Estadisticas2.estadisticaRival(b)));
		sc.close();
	}

	private static void nuevaPartida() {
		System.out.println("Introduzca el número de jugadores");
		Integer num = sc.nextInt();
		sc.nextLine();
		jug = new Jugador[num];
		for (int i = 0; i < num; i++) {
			System.out
					.println("Jugador " + (i + 1) + ": Introduzca sus cartas");
			jug[i] = nuevoJugador();
		}
		System.out.println("Jugadores creados");
	}

	private static Jugador nuevoJugador() {
		Set<Carta> manoInicial = Sets.newHashSet();
		for (int i = 0; i < 5; i++) {
			String s = sc.nextLine();
			manoInicial.add(Cartas.createCorto(s));

		}
		return new JugadorImpl(manoInicial, b);
	}

	private static void actualiza() {
		for (int i = 0; i < jug.length; i++) {
			System.out.println("Jugador " + (i + 1) + ": Calculando...");
			System.out
					.println(EstadisticasExperimento2.masProbable2(b, jug[i]));
			System.out.println("Jugador " + (i + 1)
					+ ": Número de cartas descartadas");
			actualizaJugador(jug[i]);
		}
	}

	private static void actualizaJugador(Jugador j) {
		Integer nd = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < nd; i++) {
			System.out.println("Carta antigua");
			String antigua = sc.nextLine();
			Integer cant = Cartas.createValor(antigua);
			System.out.println("Carta nueva");
			String nueva = sc.nextLine();
			Integer cnue = Cartas.createValor(nueva);
			j.setCarta(cant, cnue, b);
		}
		System.out.println("Jugador actualizado");
	}

}
