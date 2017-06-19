package cartas.tipos.funciones;

import java.util.Arrays;
import java.util.function.Function;

public class FuncionArrayToString implements
		Function<Integer[], String> {

	public String apply(Integer[] i) {
		return Arrays.toString(i);
	}

}
