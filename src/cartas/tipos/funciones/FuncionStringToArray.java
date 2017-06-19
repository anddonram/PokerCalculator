package cartas.tipos.funciones;

import com.google.common.base.Function;


public class FuncionStringToArray implements Function<String, Integer[]> {

	public Integer[] apply(String s) {
		return toArray(s);
	}

	private Integer[] toArray(String s) {
		String[] trozos = s.split("[\\[\\,\\]]");
		Integer[] res = new Integer[5];
		res[0] = new Integer(trozos[1].trim());
		res[1] = new Integer(trozos[2].trim());
		res[2] = new Integer(trozos[3].trim());
		res[3] = new Integer(trozos[4].trim());
		res[4] = new Integer(trozos[5].trim());
		return res;
	}

}
