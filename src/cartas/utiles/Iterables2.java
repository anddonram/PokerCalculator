package cartas.utiles;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Scanner;
import java.util.function.Function;

import com.google.common.base.CharMatcher;
import com.google.common.base.Splitter;


public class Iterables2 {
	
	/**
	 * Devuelve un Iterable de String en el que cada cadena es una línea del
	 * fichero leído.
	 * 
	 * @param fileName
	 *            -nombre del fichero
	 * @return devuelve un Iterable de String con cada línea del fichero como
	 *         una cadena
	 * @author ETSII_Sevilla: grupo de profesores
	 * */
	public static Iterable<String> fromFile(String file){
		return new FlujoEntrada(file);
	}
	
	private static class FlujoEntrada implements Iterable<String> {

		private String nf;
		private String delimiter;

		public FlujoEntrada(String nombreFich) {
			nf = nombreFich;
			delimiter = null;
		}
		
//		public FlujoEntrada(String nombreFich, String delim) {
//			nf = nombreFich;
//			delimiter = delim;
//		}

		public Iterator<String> iterator() {

			Iterator<String> itor = null;
			try {
				if (delimiter!=null) {
					itor = new Scanner(new File(nf)).useDelimiter(delimiter);
				} else{
					itor = new IteradorFicheroLineas();
				}
			} catch (FileNotFoundException e) {
				throw new IllegalStateException();
			}
			return itor;
		}
		
		private class IteradorFicheroLineas implements Iterator<String>{
			private Scanner sc;
			
			public IteradorFicheroLineas(){
				try{
				sc = new Scanner(new File(nf));
				} catch (FileNotFoundException e) {
					throw new IllegalStateException();
				}
			}
			
			public void remove(){
				throw new UnsupportedOperationException();
			}
			
			public boolean hasNext(){
				return sc.hasNextLine();
			}
			
			public String next(){
				return  sc.nextLine();
			}
		}
	}


	/**
	 * Cálculo de un sumatorio
	 * 
	 * @param it -el objeto Iterable sobre el que trabajamos
	 * @param funcion -el objeto Function que encapsula la funcionalidad
	 * @return valor Double resultado de la suma
	 * @author ETSII_Sevilla: cualquier alumno de primero que siga la asignatura
	 * */
	public static <T> Double sum(Iterable<T> it, Function<? super T, Double> funcion) {
		Double suma = 0.0;
		for (T o : it){
			suma = suma + funcion.apply(o);
		}
		return suma;
	}
	//////////////////////////////////////////////////////////////////////////////////////////	
	/**
	 * Cálculo de un producto
	 * 
	 * @param it -el objeto Iterable sobre el que trabajamos
	 * @param funcion -el objeto Function que encapsula la funcionalidad
	 * @return valor Double resultado del producto
	 * @author ETSII_Sevilla: cualquier alumno de primero que siga la asignatura
	 * */
	public static <T> Double multiply(Iterable<T> it, Function<? super T, Double> funcion) {
		Double prod = 1.0;
		for (T o : it){
			prod = prod * funcion.apply(o);
		}
		return prod;
	}
	//////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * Modificación de un Iterable según la funcionalidad encapsulada por el objeto Function
	 * 
	 * @param fromIterable -el objeto Iterable sobre el que trabajamos
	 * @param funcion -el objeto Function que encapsula la funcionalidad para modificar cada objeto
	 * @author ETSII_Sevilla: grupo de profesores
	 * */	
	public static <F> void modify(Collection<F> fromIterable, Function<? super F,Void> function){
		for(F e:fromIterable){
			function.apply(e);
		}    
	}

	
	/**
	 * Guarda un Iterable en un fichero
	 * 
	 * @param it
	 *            -el objeto Iterable que queremos almacenar
	 * @param filename
	 *            -nombre del fichero (por supuesto con la ruta)
	 * @author ETSII_Sevilla: grupo de profesores
	 * */
	public static <T> void saveToFile(Iterable<T> it, String filename) {
		File file = new File(filename);
		try {
			PrintStream ps = new PrintStream(file);
			for (T elem : it) {
				ps.println(elem);
			}
			ps.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Transforma un array en un Iterable
	 * 
	 * @param array
	 *            -array de trabajo
	 * @return devuelve el array de trabajo en un Iterable
	 * @author ETSII_Sevilla: grupo de profesores
	 * */
	public static <T> Iterable<T> fromArray(T[] array) {
		/* !OJO! Que este método está implementado de forma naif y no lazy */
		return Arrays.asList(array);
	}




	/**
	 * Devuelve un Iterable de String a partir de una cadena y unos
	 * delimitadores. Los delimitadores entran en forma de una String, en la que
	 * cada uno de los caracteres se considera un delimitador. El método elimina
	 * las cadenas vacías de la salida; elimina también los espacios en blanco
	 * delante y detrás de cada cadena devuelta.
	 * 
	 * @param cadena
	 * @param delimitadores
	 * @return Iterable de String
	 * @author ETSII_Sevilla: grupo de profesores
	 * */
	public static Iterable<String> fromString(String cadena, String delimitadores) {
		Splitter sp = Splitter.on(CharMatcher.anyOf(delimitadores));
		Splitter sp2 = sp.trimResults().omitEmptyStrings();
		Iterable<String> it = sp2.split(cadena);
		return it;
	}
	
	/**
	 * Devuelve un Iterable de String con las cadenas que se vayan introduciendo
	 * por el teclado terminadas con Enter, finalizando cuando se pulsa
	 * control+z. Las cadenas vacías no las devuelve en el momento: las devuelve
	 * todas juntas cuando se introduce una cadena no vacía.
	 * 
	 * @return Iterable de String
	 * @author ETSII_Sevilla: grupo de profesores
	 */
	public static Iterable<String> fromKeyboard() {
		Iterable<String> it = new EntradaTeclado();
		return it;
	}

	// ////////////////////////////////////////////////////////////////////////////////////////
	// CLASE PRIVADA USADA EN EL MÉTODO ANTERIOR
	// ////////////////////////////////////////////////////////////////////////////////////////

	private static class EntradaTeclado implements Iterable<String> {
		public EntradaTeclado() {
		}

		public Iterator<String> iterator() {
			return new IteradorEntradaTeclado();
		}

		private class IteradorEntradaTeclado implements Iterator<String> {
			private Scanner sc;

			public IteradorEntradaTeclado() {
				sc = new Scanner(System.in);
			}

			public boolean hasNext() {
				return sc.hasNext();
			}

			public String next() {
				String linea = sc.nextLine();
				return linea;
			}

			public void remove() {
				throw new UnsupportedOperationException();
			}
		}
	}

	/**
	 * Devuelve una cadena con la representación como cadena del Iterable. La representación como 
	 * cadena se obtiene como [ e1, e2, ...] donde, e1, e2, ... son las representaciones como cadena
	 * del los elementos del iterable. Hay un método igual en la clase Iterables de Guava.
	 * 
	 * @return Una cadena con la representación como cadena del Iterable.
	 * @author ETSII_Sevilla: grupo de profesores
	 */
	public static <T> String toString (Iterable<T> it){
	Boolean esPrimero = true;
	String res="[";
	
	for (T elem: it){
		if (!esPrimero){
			res+=", ";
		}else{
			esPrimero = false;
		}
		res+=elem;
	}
	
	res+="]";
	return res;
	}
	
}


