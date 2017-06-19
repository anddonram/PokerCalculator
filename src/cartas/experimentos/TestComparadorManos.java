package cartas.experimentos;

import java.util.Arrays;
import java.util.Comparator;

import cartas.tipos.comparadores.ComparadorManos;
import cartas.utiles.Cartas;
import cartas.utiles.Figuras;

public class TestComparadorManos {

	public static void main(String[] args) {
		 Integer[] a = { generator(), generator(), generator(), generator(),
		 generator() };
		 Integer[] b = { generator(), generator(), generator(), generator(),
		 generator() };
//		Integer[] a = { 38, 46, 48, 49, 50 };
//		Integer[] b = { 1, 14, 27, 40, 7 };
		Comparator<Integer[]> cmp = new ComparadorManos();
		System.out.println("Figura A " + Cartas.cadena(a) + ": "
				+ Figuras.getFigura(Arrays.asList(a)));
		System.out.println("Figura B " + Cartas.cadena(b) + ": "
				+ Figuras.getFigura(Arrays.asList(b)));
		System.out.println(cmp.compare(a, b));
		comparar(a,b);
	}

	public static Integer generator() {
		return (int) (52 * Math.random());
	}
	private static void comparar(Integer[] a,Integer[] b){
		Comparator<Integer[]> cmp = new ComparadorManos();
		if(cmp.compare(a, b)>0)
			System.out.println("Figura A mayor que Figura B");
		else if(cmp.compare(a, b)<0)
			System.out.println("Figura A menor que Figura B");
		else System.out.println("Son iguales");
		
	}

}
