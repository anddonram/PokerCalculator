package cartas.experimentos;

import cartas.tipos.funciones.FuncionStringToArray;
import cartas.utiles.Cartas;
import cartas.utiles.Iterables2;

import com.google.common.collect.Iterables;

public class TestFicheroOrdenado {

	public static void main(String[] args) {
		Long l = System.currentTimeMillis();
		Iterable<String> it = Iterables2.fromFile("Manos ordenadas.txt");
		System.out.println(Cartas.tiempoTardado(l));

		l = System.currentTimeMillis();
		Iterable<Integer[]> it2 = Iterables.transform(it,
				new FuncionStringToArray());
		System.out.println(Iterables.size(it2));
		System.out.println(Cartas.tiempoTardado(l));
	}
}
