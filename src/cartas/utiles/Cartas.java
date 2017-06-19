package cartas.utiles;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import cartas.tipos.Carta;
import cartas.tipos.CartaImpl;
import cartas.tipos.Numero;
import cartas.tipos.Palo;

public class Cartas {
	public static Carta create(String s) {
		String[] trozos = s.split(" de ");
		Numero n = Numero.valueOf(trozos[0].trim().toUpperCase());
		Palo p = Palo.valueOf(trozos[1].trim().toUpperCase());
		return new CartaImpl(p, n);
	}

	public static Carta create(String numero, String palo) {
		Numero n = Numero.valueOf(numero.toUpperCase());
		Palo p = Palo.valueOf(palo.toUpperCase());
		return new CartaImpl(p, n);
	}

	public static String cadena(Integer[] s) {
		List<String> res = new ArrayList<String>();
		for (Integer i : s)
			res.add(new CartaImpl(i).toString());
		return res.toString();
	}

	public static String cadena(Collection<Integer> s) {
		List<String> res = new ArrayList<String>();
		for (Integer i : s)
			res.add(new CartaImpl(i).toString());
		return res.toString();
	}

	public static Double tiempoTardado(Long l) {
		return (System.currentTimeMillis() - l) / 1000d;
	}

	public static Long temporizador(Long l) {
		Double res = (System.currentTimeMillis() - l) / 1000d;
		System.out.println("Tiempo tardado: " + res);
		return System.currentTimeMillis();
	}

	public static Carta createCorto(String s) {
		String[] trozos = s.split(" de ");
		String s1 = trozos[0].trim().toUpperCase();
		String s2 = trozos[1].trim().toUpperCase();
		Numero n = null;
		Palo p = null;
		switch (s1) {
		case "1":
		case "AS":
			n = Numero.AS;
			break;
		case "2":
		case "DOS":
			n = Numero.DOS;
			break;
		case "3":
		case "TRES":
			n = Numero.TRES;
			break;
		case "4":
		case "CUATRO":
			n = Numero.CUATRO;
			break;
		case "5":
		case "CINCO":
			n = Numero.CINCO;
			break;
		case "6":
		case "SEIS":
			n = Numero.SEIS;
			break;
		case "7":
		case "SIETE":
			n = Numero.SIETE;
			break;
		case "8":
		case "OCHO":
			n = Numero.OCHO;
			break;
		case "9":
		case "NUEVE":
			n = Numero.NUEVE;
			break;
		case "10":
		case "DIEZ":
			n = Numero.DIEZ;
			break;
		case "11":
		case "ONCE":
		case "JOTA":
			n = Numero.JOTA;
			break;
		case "12":
		case "DOCE":
		case "REINA":
			n = Numero.REINA;
			break;
		case "13":
		case "TRECE":
		case "REY":
			n = Numero.REY;
			break;
		default:
			throw new IllegalArgumentException("Cartas.createCorto");
		}
		if ("CORAZONES".startsWith(s2))
			p = Palo.CORAZONES;
		else if ("PICAS".startsWith(s2))
			p = Palo.PICAS;
		else if ("TREBOLES".startsWith(s2))
			p = Palo.TREBOLES;
		else if ("DIAMANTES".startsWith(s2))
			p = Palo.DIAMANTES;
		else
			throw new IllegalArgumentException("Cartas.createCorto");

		return new CartaImpl(p, n);
	}

	public static Integer createValor(String s) {
		String[] trozos = s.split(" de ");
		String s1 = trozos[0].trim().toUpperCase();
		String s2 = trozos[1].trim().toUpperCase();
		Integer res = null;
		switch (s1) {
		case "1":
		case "AS":
			res = 12;
			break;
		case "2":
		case "DOS":
			res = 0;
			break;
		case "3":
		case "TRES":
			res = 1;
			break;
		case "4":
		case "CUATRO":
			res = 2;
			break;
		case "5":
		case "CINCO":
			res = 3;
			break;
		case "6":
		case "SEIS":
			res = 4;
			break;
		case "7":
		case "SIETE":
			res = 5;
			break;
		case "8":
		case "OCHO":
			res = 6;
			break;
		case "9":
		case "NUEVE":
			res = 7;
			break;
		case "10":
		case "DIEZ":
			res = 8;
			break;
		case "11":
		case "ONCE":
		case "JOTA":
			res = 9;
			break;
		case "12":
		case "DOCE":
		case "REINA":
			res = 10;
			break;
		case "13":
		case "TRECE":
		case "REY":
			res = 11;
			break;
		default:
			throw new IllegalArgumentException("Cartas.createCorto");
		}
		if ("CORAZONES".startsWith(s2))
			res += 26;
		else if ("PICAS".startsWith(s2))
			;
		else if ("TREBOLES".startsWith(s2))
			res += 13;
		else if ("DIAMANTES".startsWith(s2))
			res += 39;
		else
			throw new IllegalArgumentException("Cartas.createCorto");

		return res;
	}
}
